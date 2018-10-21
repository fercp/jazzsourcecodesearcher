package com.fercp.jazz.sourcecode.searcher.tree;

import com.fercp.jazz.sourcecode.searcher.item.JazzItem;
import com.fercp.jazz.sourcecode.searcher.item.WorkspaceItem;
import com.ibm.team.filesystem.client.IFileContentManager;
import com.ibm.team.filesystem.common.IFileItem;
import com.ibm.team.filesystem.common.IFileItemHandle;
import com.ibm.team.repository.common.TeamRepositoryException;
import com.ibm.team.scm.common.IFolderHandle;
import com.fercp.jazz.sourcecode.searcher.item.FileSystemItem;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 07.01.2013 10:22
 * @see
 */
public class JazzTreeFileDownloader {
    private final String destinationDirectory;
    private final Tree<JazzItem> tree;
    private final List<String> streams;
    private final IFileContentManager contentManager;

    public JazzTreeFileDownloader(String destinationDirectory,Tree<JazzItem> tree, List<String> streams,IFileContentManager contentManager) {
        this.destinationDirectory = destinationDirectory;
        this.tree = tree;
        this.streams = streams;
        this.contentManager = contentManager;
    }



    public void download() throws IOException, TeamRepositoryException {
        if(createDirectory("")){
           cleanDirectory();
           downloadFiles(tree);
        }
    }

    private void downloadFiles(Tree<JazzItem> rtcTree) throws IOException, TeamRepositoryException {
        JazzItem root=rtcTree.getRoot();
        if(root instanceof WorkspaceItem && streams.indexOf(root.toString())<0)
           return;
        if(root.getItem() instanceof IFolderHandle){
           createDirectory(((FileSystemItem)root).getPath());
        }else if(root.getItem() instanceof IFileItemHandle){
            retrieveFileFromSCM(((FileSystemItem) root));
        }
        if(rtcTree.getLeafs()!=null){
            for(Tree<JazzItem> subtree:rtcTree.getLeafs()){
                downloadFiles(subtree);
            }
        }
    }

    private void retrieveFileFromSCM(FileSystemItem file) throws TeamRepositoryException, IOException {
        List properties = asList("content");
        IFileItem fileItem = (IFileItem) file.getConfiguration().fetchPartialItem(file.getItem(), properties, null);
        InputStream is = contentManager.retrieveContentStream(
                (IFileItemHandle) file.getItem(), fileItem.getContent(), null);
        BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String strLine;
        File copy=new File(destinationDirectory+"/"+file.getPath());
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(copy), Charset.forName("UTF-8")));
        while ((strLine = br.readLine()) != null) {
              writer.write(strLine);
              writer.newLine();
        }
        writer.close();
        br.close();
    }

    private void cleanDirectory() throws IOException {
        Runtime.getRuntime().exec("rm -rf "+destinationDirectory+"/*");
    }

    private boolean createDirectory(String subDirectory){
        File directory=new File(destinationDirectory+"/"+subDirectory);
        if(!directory.exists()){
            if(!directory.mkdir())
                return false;
        }
        return true;
    }
}
