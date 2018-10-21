package com.fercp.jazz.sourcecode.searcher.explorer;

import com.fercp.jazz.sourcecode.searcher.connection.JazzConnection;
import com.fercp.jazz.sourcecode.searcher.item.ProcessAreaItem;
import com.ibm.team.process.client.IProcessItemService;
import com.ibm.team.process.common.IProjectArea;
import com.ibm.team.process.common.IProjectAreaHandle;
import com.ibm.team.repository.common.TeamRepositoryException;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 08.11.2012 13:42
 * @see
 */
public class ProcessAreaExplorer implements JazzExplorer<ProcessAreaItem, ProcessAreaItem> {

    private JazzConnection connection;
    private String projectAreaName;

    public ProcessAreaExplorer(JazzConnection connection,String projectAreaName) {
        this.connection = connection;
        this.projectAreaName=projectAreaName;
    }


    @Override
    public final List<ProcessAreaItem> findItems(ProcessAreaItem parentProcessArea) {
        IProcessItemService processService = (IProcessItemService) connection.getClientLibrary(IProcessItemService.class);
        try {
            List<IProjectAreaHandle> projectAreaHandles = processService.findAllProjectAreas(null, monitor);

            List<ProcessAreaItem> processAreaItems = new ArrayList<ProcessAreaItem>(projectAreaHandles.size());
            for (IProjectAreaHandle projectAreaHandle : projectAreaHandles) {
                IProjectArea projectArea = (IProjectArea) connection.fetchCompleteItem(projectAreaHandle, asList("name"));
                if(projectAreaName==null||projectArea.getName().equals(projectAreaName)){
                   processAreaItems.add(new ProcessAreaItem(projectArea));
                }
            }
            return processAreaItems;
        } catch (TeamRepositoryException e) {
            e.printStackTrace();
        }
        return null;
    }
}
