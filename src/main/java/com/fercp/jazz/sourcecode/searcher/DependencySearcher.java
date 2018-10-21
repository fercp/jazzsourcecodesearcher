package com.fercp.jazz.sourcecode.searcher;

import com.fercp.jazz.sourcecode.searcher.connection.JazzConnection;
import com.fercp.jazz.sourcecode.searcher.item.FileSystemItem;
import com.fercp.jazz.sourcecode.searcher.item.JazzItem;
import com.fercp.jazz.sourcecode.searcher.tree.JazzTreeFactory;
import com.fercp.jazz.sourcecode.searcher.tree.JazzTreeSearcher;
import com.fercp.jazz.sourcecode.searcher.tree.Tree;
import com.ibm.team.repository.common.TeamRepositoryException;

import java.io.*;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 14.02.2013 09:04
 * @see
 */
public class DependencySearcher {
    private static String userCode;
    private static String password;
    private static String jazzUrl;
    private static String projectArea;


    private static void readParameters(){
        ResourceBundle resourceBundle=ResourceBundle.getBundle("RtcBundle");
        userCode=resourceBundle.getString("userCode");
        password=resourceBundle.getString("password");
        jazzUrl=resourceBundle.getString("jazzUrl");
        projectArea=resourceBundle.getString("projectArea");
    }

    public static void main(String[] args) throws IOException, TeamRepositoryException {
        readParameters();
        long start = System.currentTimeMillis();
        System.out.println("Starting : "+ userCode+" "+password+" "+jazzUrl);
        JazzConnection connection = new JazzConnection(userCode, password, jazzUrl);
        connection.connect();
        JazzTreeFactory factory = new JazzTreeFactory(connection, 20);
        Tree<JazzItem> jazzTree = factory.produceTree();
        for(Tree<JazzItem> tree:jazzTree.getLeafs())
            if(projectArea.equals(tree.getRoot().toString())){
                jazzTree=tree;
                break;
            }


        FileInputStream fstream = new FileInputStream(args[0]);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        JazzTreeSearcher searcher = new JazzTreeSearcher(20, connection.getContentManager());
        while ((strLine = br.readLine()) != null)   {
            String keyWord=strLine.split(":")[0];
            String extension=strLine.split(":")[1];
            List<FileSystemItem> files = searcher.findKeyword(jazzTree, keyWord, extension);
            for (FileSystemItem file : files)
                System.out.println(keyWord+'\t'+file.getPath());
        }
        in.close();

    }
}
