package test.mock;

import com.ibm.team.process.common.IProcessAreaHandle;
import com.ibm.team.repository.client.ITeamRepository;
import com.ibm.team.repository.client.util.IListener;
import com.ibm.team.repository.common.IAuditableHandle;
import com.ibm.team.repository.common.ItemNotFoundException;
import com.ibm.team.repository.common.TeamRepositoryException;
import com.ibm.team.scm.client.*;
import com.ibm.team.scm.common.*;
import com.ibm.team.scm.common.dto.*;
import org.eclipse.core.runtime.IProgressMonitor;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 09.11.2012 09:52
 * @see
 */
public class MockWorkspaceConnection implements IWorkspaceConnection {
    IConfiguration configurationItem;

    public MockWorkspaceConnection(IConfiguration configurationItem) {
        this.configurationItem = configurationItem;
    }

    @Override
    public List activeChangeSets() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List activeChangeSets(IComponentHandle iComponentHandle) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IConfigurationOpFactory configurationOpFactory() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IChangeSetHandle createChangeSet(IComponentHandle iComponentHandle, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IChangeSetHandle createChangeSet(IComponentHandle iComponentHandle, String s, boolean b, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void closeChangeSets(Collection collection, IProgressMonitor monitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void ensureClosed(Collection collection, IProgressMonitor monitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport moveFoldersBetweenComponents(IComponentHandle iComponentHandle, IComponentHandle iComponentHandle1, IFolderHandle[] iFolderHandles, IFolderHandle[] iFolderHandles1, String s, String s1, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport accept(int i, IWorkspaceConnection iWorkspaceConnection, IChangeHistorySyncReport iChangeHistorySyncReport, List list, List list1, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport accept(int i, List list, ITeamRepository iTeamRepository, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport resume(int i, List<IChangeSetHandle> iChangeSetHandles, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<IComponentLockReport> deliver(IWorkspaceConnection iWorkspaceConnection, IChangeHistorySyncReport iChangeHistorySyncReport, List list, List list1, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport harmonizeHistory(IWorkspaceConnection iWorkspaceConnection, IComponentHandle iComponentHandle, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport commit(IChangeSetHandle iChangeSetHandle, Collection collection, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport commit(List<IChangeSetHandle> iChangeSetHandles, List<Collection<? extends IConfigurationOp>> collections, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void relocateChanges(List<? extends IChangeSetHandle> iChangeSetHandles, List<? extends IVersionableHandle> iVersionableHandles, List<? extends IChangeSetHandle> iChangeSetHandles1, IProgressMonitor monitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<IBaseline> getMostRecentBaselinesAffecting(IComponentHandle iComponentHandle, List<? extends IFolderHandle> iFolderHandles, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void initializeMostRecentBaselinesAffecting(IComponentHandle iComponentHandle, List<? extends IBaselineHandle> iBaselineHandles, List<? extends IFolderHandle> iFolderHandles, IProgressMonitor monitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport conflictReport(IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport conflictReport() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport conflictReport(IComponentHandle iComponentHandle) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getDescription() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IAuditableHandle getOwner() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ISyncTime getVTime() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isStream() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProcessAreaHandle getProcessArea(IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IWorkspace getResolvedWorkspace() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IChangeHistory changeHistory(IComponentHandle iComponentHandle) throws ItemNotFoundException, ComponentNotInWorkspaceException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List getComponents() throws TeamRepositoryException {
        return asList(new MockComponentHandle(null));  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<IComponentHandle> getUnreadableComponents() throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IConfiguration configuration(IComponentHandle iComponentHandle) throws ItemNotFoundException, ComponentNotInWorkspaceException {
        return configurationItem;
    }

    @Override
    public void setName(String s, IProgressMonitor monitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setDescription(String s, IProgressMonitor monitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setOwner(IAuditableHandle iAuditableHandle, IProgressMonitor monitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport addComponent(IComponentHandle iComponentHandle, IBaselineConnection iBaselineConnection, boolean b, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport addComponent(IComponentHandle iComponentHandle, IFlowNodeConnection iFlowNodeConnection, boolean b, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport addComponent(IComponentHandle iComponentHandle, boolean b, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport replaceComponent(IComponentHandle iComponentHandle, IConnection iConnection, boolean b, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport replaceComponent(IComponentHandle iComponentHandle, IConnection iConnection, boolean b, boolean b1, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport replaceComponents(List list, List list1, List<Boolean> booleans, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport replaceComponents(List list, List list1, List<Boolean> booleans, boolean b, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport dropComponent(IComponentHandle iComponentHandle, boolean b, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IChangeHistorySyncReport compareTo(IFlowNodeConnection iFlowNodeConnection, int i, List list, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IChangeHistorySyncReport compareToBaseline(IBaselineHandle iBaselineHandle, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IHistoricBaselineIterator getBaselinesInHistory(IComponentHandle iComponentHandle, int i, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IHistoricBaselineIterator getMergedBaselineHistory(IComponentHandle iComponentHandle, int i, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List getBaselineSets(IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IBaselineSetHandle cloneRemoteBaselineSet(IBaselineSetHandle iBaselineSetHandle, ITeamRepository iTeamRepository, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addBaselineSet(IBaselineSetHandle iBaselineSetHandle, IProgressMonitor monitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeBaselineSet(IBaselineSetHandle iBaselineSetHandle, IProgressMonitor monitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IFlowTable getFlowTable() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setFlowTable(IFlowTable iFlowTable, IProgressMonitor monitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ICurrentComponentInfo getComponentInfo(IComponentHandle iComponentHandle) throws ComponentNotInWorkspaceException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<? extends ICurrentComponentInfo> getComponentsInfo() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List getPastComponentInfos(IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List getComponentAuditTrail(IComponentHandle iComponentHandle, long l, long l1, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IComponentOpFactory componentOpFactory() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport applyComponentOperations(List list, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport applyComponentOperations(List list, boolean b, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport applyComponentOperations(List list, boolean b, ISynchronizationInfo iSynchronizationInfo, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport applyComponentOperationsWithoutBackupBaselines(List list, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List getComponentsContainingVersionable(IVersionableHandle iVersionableHandle, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport compareConfigurations(IFlowNodeConnection iFlowNodeConnection, List<? extends IComponentHandle> iComponentHandles, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<IChangeSetFlowReport> findChangeSetsInFlows(Collection<IChangeSetHandle> iChangeSetHandles, int i, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ILockSearchResult getLocksInFlows(IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ILockSearchResult getLocks(IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport suspend(Collection collection, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<IChangeSetHandle> suspendedChangeSets(IComponentHandle iComponentHandle) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<IChangeSetHandle> suspendedChangeSets() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeSuspended(Collection collection, IProgressMonitor monitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setCurrentChangeSet(IChangeSetHandle iChangeSetHandle, IProgressMonitor monitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void unsetCurrentChangeSet(IComponentHandle iComponentHandle, IProgressMonitor monitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IChangeSetHandle getCurrentChangeSet(IComponentHandle iComponentHandle) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport discardChangeSets(boolean b, Collection collection, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IBaselineConnection createBaseline(IComponentHandle iComponentHandle, String s, String s1, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IBaselineSetHandle createBaselineSet(Collection collection, String s, String s1, boolean b, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List retrieveComponentStateSummaries(IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void refresh(IProgressMonitor monitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Visibility getVisibility() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IReadScope getReadScope() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setVisibility(Visibility visibility, IProgressMonitor monitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IWorkspaceConfiguration configuration() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getAdapter(Class aClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setOwnerAndVisibility(IAuditableHandle iAuditableHandle, IReadScope iReadScope, IProgressMonitor monitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ITeamRepository teamRepository() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean sameRepository(IConnection iConnection) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IContextHandle getContextHandle() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasChangeSets(List list, IProgressMonitor monitor) throws TeamRepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List changeSetsInHistory(List list, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addGenericListener(Object o, IListener iListener) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeGenericListener(Object o, IListener iListener) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void purgeGenericListener(IListener iListener) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
