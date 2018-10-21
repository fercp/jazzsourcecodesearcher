package test;

import com.ibm.team.process.common.IProcessAreaHandle;
import com.ibm.team.repository.common.IItem;
import com.ibm.team.repository.common.IItemHandle;
import com.ibm.team.scm.client.IWorkspaceConnection;
import com.ibm.team.scm.client.IWorkspaceManager;
import com.ibm.team.scm.common.IComponentHandle;
import com.ibm.team.scm.common.IFolderHandle;
import com.ibm.team.scm.common.IWorkspaceHandle;
import com.fercp.jazz.sourcecode.searcher.connection.JazzConnection;
import com.fercp.jazz.sourcecode.searcher.item.JazzItem;
import com.fercp.jazz.sourcecode.searcher.tree.JazzTreeFactory;
import com.fercp.jazz.sourcecode.searcher.tree.Tree;
import org.eclipse.core.runtime.IProgressMonitor;
import org.junit.Test;
import test.mock.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 15.11.2012 16:13
 * @see
 */
public class TestFindFiles {
    @Test
    public void findFiles() {
        JazzConnection connection = new JazzConnection() {

            public IWorkspaceConnection getWorkspaceConnection(IWorkspaceHandle workspaceHandle, IProgressMonitor monitor) {
                Map folders = new HashMap();
                folders.put("file", new MockFileItemHandle("file.hbm.xml"));
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
                if (itemHandle instanceof IFolderHandle)
                    return new MockFolderHandle("folder");
                return new MockFileItemHandle("file.hbm.xml");
            }
        };
        JazzTreeFactory factory = new JazzTreeFactory(connection, 10);
        Tree<JazzItem> jazzTree = factory.produceTree();

    }
}
