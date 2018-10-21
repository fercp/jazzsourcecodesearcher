package com.fercp.jazz.sourcecode.searcher.explorer;

import com.fercp.jazz.sourcecode.searcher.item.WorkspaceItem;
import com.ibm.team.repository.common.TeamRepositoryException;
import com.ibm.team.scm.client.IWorkspaceConnection;
import com.ibm.team.scm.common.IComponent;
import com.ibm.team.scm.common.IComponentHandle;
import com.fercp.jazz.sourcecode.searcher.connection.JazzConnection;
import com.fercp.jazz.sourcecode.searcher.item.ComponentItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 08.11.2012 17:25
 * @see
 */
public class ComponentExplorer implements JazzExplorer<ComponentItem, WorkspaceItem> {
    private JazzConnection connection;


    public ComponentExplorer(JazzConnection connection) {
        this.connection = connection;
    }

    @Override
    public List<ComponentItem> findItems(WorkspaceItem stream) {
        List<ComponentItem> componentItems = new ArrayList<ComponentItem>();
        try {
            IWorkspaceConnection workspaceConnection = connection.getWorkspaceConnection(stream.getItem(), monitor);
            List<IComponentHandle> componentHandles = workspaceConnection.getComponents();
            for (IComponentHandle componentHandle : componentHandles) {
                ArrayList<String> properties = new ArrayList<String>(2);
                properties.add("name");
                properties.add("rootFolder");
                IComponent component = (IComponent) connection.fetchCompleteItem(componentHandle, properties);
                componentItems.add(new ComponentItem(component, stream));
            }
        } catch (TeamRepositoryException e) {
            e.printStackTrace();
        }

        return componentItems;
    }


}
