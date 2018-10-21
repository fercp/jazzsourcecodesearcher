package test.mock;

import com.ibm.team.process.client.IClientProcess;
import com.ibm.team.process.client.IProcessItemService;
import com.ibm.team.process.client.workingcopies.IWorkingCopyManager;
import com.ibm.team.process.common.*;
import com.ibm.team.process.common.advice.IOperationReport;
import com.ibm.team.process.common.advice.ProcessRunnable;
import com.ibm.team.process.common.advice.TeamOperationCanceledException;
import com.ibm.team.repository.client.ITeamRepository;
import com.ibm.team.repository.common.IContributor;
import com.ibm.team.repository.common.TeamRepositoryException;
import org.eclipse.core.runtime.IProgressMonitor;

import java.net.URI;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 08.11.2012 15:24
 * @see
 */
public class MockProcessItemService implements IProcessItemService {
    @Override
    public ITeamRepository getTeamRepository() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IWorkingCopyManager getWorkingCopyManager() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProjectArea createProjectArea() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ITeamArea createTeamArea() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProcessDefinition createProcessDefinition() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProcessDomainDefinition createProcessDomainDefinition() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IDevelopmentLine createDevelopmentLine() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IIteration createIteration() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IIterationType createIterationType() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProcessAttachment createProcessAttachment() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProcessItem getMutableCopy(IProcessItem iProcessItem) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IIteration[] getCurrentIterations(IDevelopmentLineHandle iDevelopmentLineHandle, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return new IIteration[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProcessAttachment getProcessAttachment(IProcessContainerHandle iProcessContainerHandle, String s, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findAllProjectAreas(Collection collection, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        MockProjectArea projectArea = new MockProjectArea("project");
        return asList(projectArea);
    }

    @Override
    public List findAllProcessDefinitions(Collection collection, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProcessDefinition findProcessDefinition(String s, Collection collection, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProcessItem save(IProcessItem iProcessItem, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProcessItem[] save(IProcessItem[] iProcessItems, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return new IProcessItem[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(IProcessItemHandle iProcessItemHandle, boolean b, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProjectArea initialize(IProjectArea iProjectArea, IProgressMonitor iProgressMonitor) throws TeamRepositoryException, TeamOperationCanceledException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void archiveProcessItem(IProcessItem iProcessItem, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findTeamAreaHierarchies(IContributor iContributor, IProcessAreaHandle iProcessAreaHandle, Collection collection, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findTeamAreas(IContributor iContributor, IProjectAreaHandle iProjectAreaHandle, Collection collection, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findProcessAreas(IContributor iContributor, IProjectAreaHandle iProjectAreaHandle, Collection collection, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List fetchCompleteIterationStructure(IProjectAreaHandle iProjectAreaHandle, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findAdministratorsFor(IProcessAreaHandle iProcessAreaHandle, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProcessDefinition[] deployPredefinedProcessDefinitions(String[] strings, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return new IProcessDefinition[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean isProjectAreaUpdateable(IProjectArea iProjectArea, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProjectArea[] updateProjectAreas(IProjectAreaHandle[] iProjectAreaHandles, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return new IProjectArea[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProjectArea[] getUpdateableProjectAreas(IProjectAreaHandle[] iProjectAreaHandles, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return new IProjectArea[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProjectArea[] getAllProcessProviders(IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return new IProjectArea[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IClientProcess getClientProcess(IProcessArea iProcessArea, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProcessArea findProcessArea(URI uri, Collection collection, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IDevelopmentLine getDevelopmentLine(IProcessArea iProcessArea, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IOperationReport execute(ProcessRunnable processRunnable, String s, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
