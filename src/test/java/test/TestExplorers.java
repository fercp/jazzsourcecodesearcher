package test;

import com.fercp.jazz.sourcecode.searcher.explorer.*;
import com.ibm.team.repository.common.IItem;
import com.ibm.team.repository.common.IItemHandle;
import com.ibm.team.scm.client.IWorkspaceConnection;
import com.ibm.team.scm.client.IWorkspaceManager;
import com.ibm.team.scm.common.IWorkspaceHandle;
import com.fercp.jazz.sourcecode.searcher.connection.JazzConnection;
import com.fercp.jazz.sourcecode.searcher.item.FileSystemItem;
import com.fercp.jazz.sourcecode.searcher.item.JazzItem;
import com.fercp.jazz.sourcecode.searcher.item.ProcessAreaItem;
import com.fercp.jazz.sourcecode.searcher.item.WorkspaceItem;
import org.eclipse.core.runtime.IProgressMonitor;
import org.junit.Test;
import test.mock.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 08.11.2012 12:40
 * @see
 */
public class TestExplorers {
    private String name;
    private JazzExplorer explorer;
    private JazzConnection connection;

    private void check(JazzItem parent) {
        List<JazzItem> itemList = explorer.findItems(parent);
        assertEquals(1, itemList.size());
        IItemHandle item = connection.fetchCompleteItem(itemList.get(0).getItem(), asList("name"));
        try {
            Method getName = item.getClass().getMethod("getName");
            String itemName = (String) getName.invoke(item);
            assertEquals(name, itemName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testProjectAreaExplorer() {
        name = "project";
        connection = new JazzConnection() {
            public Object getClientLibrary(Class clazz) {
                return new MockProcessItemService();
            }

            public IItem fetchCompleteItem(IItemHandle itemHandle, List properties) {
                return new MockProjectArea(name);
            }
        };

        explorer = new ProcessAreaExplorer(connection,null);
        check(null);
    }

    @Test
    public void testStreamExplorer() {
        name = "stream";
        connection = new JazzConnection() {
            public IWorkspaceManager getWorkspaceManager() {
                return new MockWorkSpaceManager();
            }

            public IItem fetchCompleteItem(IItemHandle itemHandle, List properties) {
                return new MockWorkSpaceHandle(name);
            }
        };
        ProcessAreaItem processAreaItem = new ProcessAreaItem(new MockProjectArea("project"));
        explorer = new StreamExplorer(connection);
        check(processAreaItem);
    }

    @Test
    public void testComponentExplorer() {
        name = "component";
        connection = new JazzConnection() {
            public IWorkspaceManager getWorkspaceManager() {
                return new MockWorkSpaceManager();
            }

            public IItem fetchCompleteItem(IItemHandle itemHandle, List properties) {
                return new MockComponentHandle(name);
            }

            public IWorkspaceConnection getWorkspaceConnection(IWorkspaceHandle workspaceHandle, IProgressMonitor monitor) {
                return new MockWorkspaceConnection(null);
            }

        };
        WorkspaceItem workspaceItem = new WorkspaceItem(new MockWorkSpaceHandle("stream"));
        explorer = new ComponentExplorer(connection);
        check(workspaceItem);
    }

    @Test
    public void testFileSystemExplorer() {
        name = "folder";
        connection = new JazzConnection() {

            public IWorkspaceManager getWorkspaceManager() {
                return new MockWorkSpaceManager();
            }

            public IItem fetchCompleteItem(IItemHandle itemHandle, List properties) {
                return new MockFolderHandle(name);
            }
        };

        Map folders = new HashMap();
        folders.put("mock", new MockFolderHandle(name));
        MockConfiguration configuration = new MockConfiguration(folders);
        explorer = new FileSystemExplorer(configuration);
        check(new FileSystemItem(new MockFolderHandle("folder")));
    }

    @Test
    public void testNull(){
        Calendar.getInstance().getTime();
    }
}


