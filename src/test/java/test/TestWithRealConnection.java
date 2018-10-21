package test;

import com.ibm.team.repository.common.TeamRepositoryException;
import com.fercp.jazz.sourcecode.searcher.item.FileSystemItem;
import com.fercp.jazz.sourcecode.searcher.item.JazzItem;
import com.fercp.jazz.sourcecode.searcher.tree.JazzTreeFactory;
import com.fercp.jazz.sourcecode.searcher.tree.JazzTreeSearcher;
import com.fercp.jazz.sourcecode.searcher.tree.Tree;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 08.11.2012 11:39
 * @see
 */
public class TestWithRealConnection extends TestJazzSourceCodeSearcher {
    @Test
    public void testOpenConnection() {
        assertTrue(connection.connect());
    }

    @Test
    public void testFindFiles() throws IOException, TeamRepositoryException {
        long start = System.currentTimeMillis();
        connection.connect();
        JazzTreeFactory factory = new JazzTreeFactory(connection, 20);
        Tree<JazzItem> jazzTree = factory.produceTree();
        long end = System.currentTimeMillis();
        long seconds = (end - start) / 1000;
        System.out.println(seconds);
        assertNotNull(jazzTree);

     /*   TreeParser<JazzItem> parser=new StringParser<JazzItem>();
        for(Tree<JazzItem> tree:jazzTree.getLeafs())
            if("Harmoni_2".equals(tree.getRoot().toString())){
                JazzTreeFileDownloader fileDownloader=new JazzTreeFileDownloader("/Users/ferhatcapar/ykbwork/sonar",tree, Arrays.asList("HMN_CDM_CustomerManagement_BE_TEST"),connection.getContentManager());
                fileDownloader.download();
            }      */

        for(Tree<JazzItem> tree:jazzTree.getLeafs())
            if("Harmoni_2".equals(tree.getRoot().toString())){
                jazzTree=tree;
                break;
            }

        ResourceBundle resourceBundle=ResourceBundle.getBundle("sarp");
        for(String key:resourceBundle.keySet()){
           JazzTreeSearcher searcher2 = new JazzTreeSearcher(20, connection.getContentManager());
           List<FileSystemItem> files = searcher2.findKeyword(jazzTree, key, resourceBundle.getString(key));
           for (FileSystemItem file : files)
               System.out.println(key+"---"+file.getPath());
        }

        end = System.currentTimeMillis();
        seconds = (end - start) / 1000;
        System.out.println(seconds);

    }


    public static void main(String[] args) {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("UnusedObjects");
        for(String key:resourceBundle.keySet())
            System.out.println(key);
    }
}
