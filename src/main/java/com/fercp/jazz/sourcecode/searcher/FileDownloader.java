package com.fercp.jazz.sourcecode.searcher;

import com.fercp.jazz.sourcecode.searcher.item.JazzItem;
import com.fercp.jazz.sourcecode.searcher.tree.JazzTreeFileDownloader;
import com.ibm.team.repository.common.TeamRepositoryException;
import com.fercp.jazz.sourcecode.searcher.connection.JazzConnection;
import com.fercp.jazz.sourcecode.searcher.tree.JazzTreeFactory;
import com.fercp.jazz.sourcecode.searcher.tree.Tree;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 07.01.2013 13:27
 * @see
 */
public class FileDownloader {
    private static String userCode;
    private static String password;
    private static String jazzUrl;
    private static String directory;
    private static String projectArea;
    private static List<String> streams;

    private static void readParameters(){
        ResourceBundle resourceBundle=ResourceBundle.getBundle("RtcBundle");
        userCode=resourceBundle.getString("userCode");
        password=resourceBundle.getString("password");
        jazzUrl=resourceBundle.getString("jazzUrl");
        directory=resourceBundle.getString("directory");
        projectArea=resourceBundle.getString("projectArea");
        streams=Arrays.asList(resourceBundle.getString("streams").split(","));
    }

    public static void main(String[] args) throws IOException, TeamRepositoryException {
        readParameters();
        String repositoryAddress = jazzUrl;
        JazzConnection connection=new JazzConnection(userCode, password, repositoryAddress);
        connection.connect();
        JazzTreeFactory factory = new JazzTreeFactory(connection, 20);
        Tree<JazzItem> jazzTree = factory.produceTree(projectArea);
        for(Tree<JazzItem> tree:jazzTree.getLeafs())
            if(projectArea.equals(tree.getRoot().toString())){
                JazzTreeFileDownloader fileDownloader=new JazzTreeFileDownloader(directory,tree, streams,connection.getContentManager());
                fileDownloader.download();
                break;
            }
    }
}
