package com.fercp.jazz.sourcecode.searcher.tree;

import com.fercp.jazz.sourcecode.searcher.item.FileSystemItem;
import com.fercp.jazz.sourcecode.searcher.item.JazzItem;
import com.ibm.team.filesystem.client.IFileContentManager;
import com.ibm.team.filesystem.common.IFileItem;
import com.ibm.team.filesystem.common.IFileItemHandle;
import com.ibm.team.repository.common.TeamRepositoryException;
import com.fercp.jazz.sourcecode.searcher.item.ComponentItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.util.Arrays.asList;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 15.11.2012 16:16
 * @see
 */
public class JazzTreeSearcher {
    private final static String CONTENT = "content";
    private ExecutorService executorService;
    private IFileContentManager contentManager;


    public JazzTreeSearcher(int threadCount, IFileContentManager contentManager) {
        executorService = Executors.newFixedThreadPool(threadCount);
        this.contentManager = contentManager;
    }

    public Tree<JazzItem> findKeywordAndCollectAsTree(Tree<JazzItem> jazzTree, String keyword, String fileExtension) {
        Tree<JazzItem> path=new Tree<JazzItem>(jazzTree.getRoot());
        List<Future<Tree<JazzItem>>> tasks=new ArrayList<Future<Tree<JazzItem>>>();
        for(Tree<JazzItem> leaf:jazzTree.getLeafs())
            tasks.add(collectAsTree(leaf,keyword,fileExtension));
        for(Future<Tree<JazzItem>> task:tasks){
            Tree<JazzItem> tree= null;
            try {
                tree = task.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            if(tree!=null)
                path.addLeaf(tree);
        }
        return path;
    }

    public List<FileSystemItem> findKeyword(Tree<JazzItem> jazzTree, String keyword, String fileExtension) {
        List<Tree<JazzItem>> components = findComponents(jazzTree);
        List<Future<List<FileSystemItem>>> tasks = new ArrayList<Future<List<FileSystemItem>>>();
        List<FileSystemItem> searchResult = new ArrayList<FileSystemItem>();
        for (Tree<JazzItem> component : components) {
            tasks.add(runAsThread(component, keyword, fileExtension));
        }

        for (Future<List<FileSystemItem>> task : tasks) {
            try {
                searchResult.addAll(task.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        try {
            while (!executorService.awaitTermination(10, TimeUnit.SECONDS)) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return searchResult;
    }

    private List<Tree<JazzItem>> findComponents(Tree<JazzItem> jazzTree) {
        List<Tree<JazzItem>> components = new ArrayList<Tree<JazzItem>>();
        if (jazzTree != null) {
            JazzItem item = jazzTree.getRoot();
            if (isComponent(item))
                components.add(jazzTree);
            else if (jazzTree.getLeafs() != null)
                for (Tree<JazzItem> leaf : jazzTree.getLeafs()) {
                    components.addAll(findComponents(leaf));
                }
        }
        return components;
    }

    private Future<List<FileSystemItem>> runAsThread(final Tree<JazzItem> jazzTree, final String keyword, final String fileExtension) {
        return executorService.submit(new Callable<List<FileSystemItem>>() {
            @Override
            public List<FileSystemItem> call() throws Exception {
                List<FileSystemItem> files = findFilesByExtension(jazzTree, fileExtension);
                List<FileSystemItem> searchResult = new ArrayList<FileSystemItem>();

                for (FileSystemItem file : files) {
                    if (isFileContainsKeyword(file, keyword))
                        searchResult.add(file);
                }
                return searchResult;
            }
        });

    }

    private Future<Tree<JazzItem>> collectAsTree(final Tree<JazzItem> jazzTree, final String keyword, final String fileExtension) {
        return executorService.submit(new Callable<Tree<JazzItem>>() {
            @Override
            public Tree<JazzItem> call() throws Exception {
                return findPath(jazzTree,keyword,fileExtension);
            }
        });

    }

    private Tree<JazzItem> findPath(Tree<JazzItem> tree,String keyword,String extension){
        if (tree != null) {
            if (isFile(tree.getRoot())) {
                FileSystemItem file = (FileSystemItem) tree.getRoot();
                if (file.toString().toUpperCase().endsWith(extension.toUpperCase())&&isFileContainsKeyword(file, keyword))
                    return tree;
            }else if(!tree.getLeafs().isEmpty()){
                Tree<JazzItem> path=new Tree<JazzItem>(tree.getRoot());
                for(Tree<JazzItem> leaf:tree.getLeafs()){
                    Tree<JazzItem> subPath=findPath(leaf,keyword,extension);
                    if(subPath!=null)
                       path.addLeaf(subPath);
                }
                if(!path.getLeafs().isEmpty())
                    return path;
            }
        }
        return null;
    }

    private boolean isFileContainsKeyword(FileSystemItem file, String keyword) {
        List properties = asList(CONTENT);
        try {
            IFileItem fileItem = (IFileItem) file.getConfiguration().fetchPartialItem(file.getItem(), properties, null);
            InputStream is = contentManager.retrieveContentStream(
                    (IFileItemHandle) file.getItem(), fileItem.getContent(), null);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(is));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                if (strLine.toUpperCase().contains(keyword.toUpperCase())) {
                    br.close();
                    return true;
                }

            }
            br.close();
        } catch (IOException e) {
          //  e.printStackTrace();
        } catch (TeamRepositoryException e) {
          //  e.printStackTrace();
        }
        return false;
    }

    private List<FileSystemItem> findFilesByExtension(Tree<JazzItem> tree, String extension) {
        List<FileSystemItem> files = new ArrayList<FileSystemItem>();
        if (tree != null) {
            if (isFile(tree.getRoot())) {
                FileSystemItem file = (FileSystemItem) tree.getRoot();
                if (file.toString().toUpperCase().endsWith(extension.toUpperCase()))
                    files.add(file);
            } else if (tree.getLeafs() != null)
                for (Tree<JazzItem> leaf : tree.getLeafs())
                    files.addAll(findFilesByExtension(leaf, extension));
        }
        return files;
    }

    private boolean isComponent(JazzItem item) {
        return item != null && (item instanceof ComponentItem);
    }

    private boolean isFile(JazzItem item) {
        return item != null && (item instanceof FileSystemItem) && (item.getItem() instanceof IFileItemHandle);
    }
}
