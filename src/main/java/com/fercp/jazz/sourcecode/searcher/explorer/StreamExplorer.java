package com.fercp.jazz.sourcecode.searcher.explorer;

import com.fercp.jazz.sourcecode.searcher.item.ProcessAreaItem;
import com.fercp.jazz.sourcecode.searcher.item.WorkspaceItem;
import com.ibm.team.process.common.IProjectArea;
import com.ibm.team.process.common.ITeamAreaHandle;
import com.ibm.team.repository.common.TeamRepositoryException;
import com.ibm.team.scm.client.IWorkspaceManager;
import com.ibm.team.scm.common.IWorkspace;
import com.ibm.team.scm.common.IWorkspaceHandle;
import com.ibm.team.scm.common.dto.IWorkspaceSearchCriteria;
import com.ibm.team.scm.common.internal.dto.WorkspaceSearchCriteria;
import com.fercp.jazz.sourcecode.searcher.connection.JazzConnection;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 08.11.2012 15:50
 * @see
 */
public class StreamExplorer implements JazzExplorer<WorkspaceItem, ProcessAreaItem> {
    private JazzConnection connection;


    public StreamExplorer(JazzConnection connection) {
        this.connection = connection;
    }

    @Override
    public final List<WorkspaceItem> findItems(ProcessAreaItem processAreaItem) {
        IWorkspaceManager wm = connection.getWorkspaceManager();
        IWorkspaceSearchCriteria wsSearchCriteria = WorkspaceSearchCriteria.FACTORY.newInstance();
        wsSearchCriteria.setKind(IWorkspaceSearchCriteria.STREAMS);
        wsSearchCriteria.getFilterByOwnerOptional().add(processAreaItem.getItem());
        IProjectArea projectArea=(IProjectArea)processAreaItem.getItem();
        List<ITeamAreaHandle> teamAreas=projectArea.getTeamAreas();
        for(ITeamAreaHandle teamAreaHandle:teamAreas)
           wsSearchCriteria.getFilterByOwnerOptional().add(teamAreaHandle);

        try {
            List<IWorkspaceHandle> workspaceHandles = wm.findWorkspaces(wsSearchCriteria, Integer.MAX_VALUE, null);
            List<WorkspaceItem> workspaceItems = new ArrayList<WorkspaceItem>(workspaceHandles.size());
            for (IWorkspaceHandle workspaceHandle : workspaceHandles) {
                IWorkspace workspace = (IWorkspace) connection.fetchCompleteItem(workspaceHandle, asList("name"));
                workspaceItems.add(new WorkspaceItem(workspace));
            }
            return workspaceItems;
        } catch (TeamRepositoryException e) {
            e.printStackTrace();
        }

        return null;
    }
}
