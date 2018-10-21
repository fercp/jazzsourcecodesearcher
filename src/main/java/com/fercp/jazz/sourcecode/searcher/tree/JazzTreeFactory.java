package com.fercp.jazz.sourcecode.searcher.tree;

import com.fercp.jazz.sourcecode.searcher.connection.JazzConnection;
import com.fercp.jazz.sourcecode.searcher.explorer.*;
import com.fercp.jazz.sourcecode.searcher.item.FileSystemItem;
import com.fercp.jazz.sourcecode.searcher.item.JazzItem;
import com.fercp.jazz.sourcecode.searcher.item.ProcessAreaItem;
import com.ibm.team.repository.common.ItemNotFoundException;
import com.ibm.team.repository.common.TeamRepositoryException;
import com.ibm.team.scm.client.IConfiguration;
import com.ibm.team.scm.common.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 12.11.2012 14:53
 * @see
 */
public class JazzTreeFactory {
    private JazzConnection connection;
    private ExecutorService executorService;

    public JazzTreeFactory(JazzConnection connection, int threadCount) {
        executorService = Executors.newFixedThreadPool(threadCount);
        this.connection = connection;
    }

    private Future<Tree<JazzItem>> runAsThread(final Tree<JazzItem> jazzTree, final FileSystemItem parent, final FileSystemExplorer fileSystemExplorer) {
        return executorService.submit(new Callable<Tree<JazzItem>>() {

            public Tree<JazzItem> call() throws Exception {
                return createFileSystem(jazzTree, parent, fileSystemExplorer);
            }
        });
    }

    public Tree<JazzItem> produceTree() {
        return produceTree(null);
    }

    public Tree<JazzItem> produceTree(String projectArea) {
        Tree<JazzItem> jazzTree = new Tree<JazzItem>(new ProcessAreaItem(null));

        for (Tree<JazzItem> processArea : addLeafToTree(jazzTree, new ProcessAreaExplorer(connection,projectArea))) {
            for (Tree<JazzItem> stream : addLeafToTree(processArea, new StreamExplorer(connection))) {
                for (final Tree<JazzItem> component : addLeafToTree(stream, new ComponentExplorer(connection))) {
                    IComponent componentItem = (IComponent) component.getRoot().getItem();
                    IWorkspace workspaceItem = (IWorkspace) stream.getRoot().getItem();
                    IConfiguration configuration = getConfiguration(workspaceItem, componentItem);

                    final FileSystemExplorer fileSystemExplorer = new FileSystemExplorer(configuration);
                    try {
                        IVersionable rootFolder = configuration.fetchCompleteItem(componentItem.getRootFolder(), null);
                       /* String path = processArea.getRoot() + ":" +
                                stream.getRoot() + ":" +
                                component.getRoot() + ":" +
                                rootFolder.getName();*/

                        final FileSystemItem fileSystemItem = new FileSystemItem(rootFolder);
                        fileSystemItem.setName("/");
                        fileSystemItem.setPath(rootFolder.getName());
                        runAsThread(component, fileSystemItem, fileSystemExplorer);

                    } catch (TeamRepositoryException e) {
                        e.printStackTrace();
                    }

                }
            }

        }

        executorService.shutdown();
        try {
            while (!executorService.awaitTermination(10, TimeUnit.SECONDS)) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return jazzTree;
    }

    private IConfiguration getConfiguration(IWorkspace workspace, IComponent component) {
        try {
            return connection.getWorkspaceConnection(workspace, null).configuration(component);
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
        } catch (ComponentNotInWorkspaceException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Tree<JazzItem>> addLeafToTree(Tree<JazzItem> parent, JazzExplorer explorer) {
        List<JazzItem> itemList = explorer.findItems(parent.getRoot());
        List<Tree<JazzItem>> treeList = new ArrayList<Tree<JazzItem>>();
        if (itemList != null)
            for (JazzItem item : itemList) {
                Tree<JazzItem> subTree = new Tree<JazzItem>(item);
                parent.addLeaf(subTree);
                treeList.add(subTree);
            }
        return treeList;
    }

    private Tree<JazzItem> createFileSystem(Tree<JazzItem> tree, FileSystemItem parent, FileSystemExplorer explorer) {
        Tree<JazzItem> fileTree = new Tree<JazzItem>(parent);
        tree.addLeaf(fileTree);

        if (parent.getItem() instanceof IFolderHandle) {
            List<FileSystemItem> files = explorer.findItems(parent);
            for (FileSystemItem file : files) {
                file.setPath(parent.getPath() + "/" + file.toString());
                createFileSystem(fileTree, file, explorer);
            }
        }
        return fileTree;
    }

}
