package test;

import com.fercp.jazz.sourcecode.searcher.tree.*;
import com.ibm.team.process.common.IProcessAreaHandle;
import com.ibm.team.repository.common.IItem;
import com.ibm.team.repository.common.IItemHandle;
import com.ibm.team.scm.client.IWorkspaceConnection;
import com.ibm.team.scm.client.IWorkspaceManager;
import com.ibm.team.scm.common.IComponentHandle;
import com.ibm.team.scm.common.IWorkspaceHandle;
import com.fercp.jazz.sourcecode.searcher.connection.JazzConnection;
import com.fercp.jazz.sourcecode.searcher.gui.RTCSearch;
import com.fercp.jazz.sourcecode.searcher.gui.RTCTreeModel;
import com.fercp.jazz.sourcecode.searcher.item.JazzItem;
import org.eclipse.core.runtime.IProgressMonitor;
import org.junit.Test;
import test.mock.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertNotNull;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 12.11.2012 14:50
 * @see
 */
public class TestJazzTree {
    @Test
    public void testProduceJazzTree() {
        JazzConnection connection = new JazzConnection() {

            public IWorkspaceConnection getWorkspaceConnection(IWorkspaceHandle workspaceHandle, IProgressMonitor monitor) {
                Map folders = new HashMap();
                folders.put("folder", new MockFolderHandle("folder"));
                return new MockWorkspaceConnection(new MockConfiguration(folders));
            }

            public IWorkspaceManager getWorkspaceManager() {
                return new MockWorkSpaceManager();
            }

            public Object getClientLibrary(Class clazz) {
                return new MockProcessItemService();
            }

            public IItem fetchCompleteItem(IItemHandle itemHandle, List properties) {
                if (itemHandle instanceof IProcessAreaHandle)
                    return new MockProjectArea("processArea");
                if (itemHandle instanceof IWorkspaceHandle)
                    return new MockWorkSpaceHandle("workspace");
                if (itemHandle instanceof IComponentHandle)
                    return new MockComponentHandle("component");
                return new MockFolderHandle("folder");
            }
        };

        JazzTreeFactory factory = new JazzTreeFactory(connection, 10);
        Tree<JazzItem> jazzTree = factory.produceTree();
        assertNotNull(jazzTree);
        TreeParser parser = new StringParser();
        System.out.println(parser.parse(jazzTree));
        JFrame frame = new JFrame("RTCSearch");
        RTCTreeModel model=new RTCTreeModel(jazzTree);
        JazzTreeSearcher searcher=new JazzTreeSearcher(200,null);
        frame.setContentPane(new RTCSearch(model,searcher,connection.getContentManager()).getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
