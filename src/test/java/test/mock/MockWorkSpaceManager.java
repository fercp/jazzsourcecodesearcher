package test.mock;

import com.ibm.team.links.common.ILink;
import com.ibm.team.process.common.IProcessAreaHandle;
import com.ibm.team.repository.client.ITeamRepository;
import com.ibm.team.repository.client.util.IListener;
import com.ibm.team.repository.common.IAuditableHandle;
import com.ibm.team.repository.common.IContributorHandle;
import com.ibm.team.repository.common.TeamRepositoryException;
import com.ibm.team.repository.common.query.IItemQuery;
import com.ibm.team.repository.common.query.IItemQueryPage;
import com.ibm.team.scm.client.*;
import com.ibm.team.scm.client.content.IVersionedContentManager;
import com.ibm.team.scm.common.*;
import com.ibm.team.scm.common.dto.*;
import com.ibm.team.scm.common.internal.dto.CreateLinksResult;
import org.eclipse.core.runtime.IProgressMonitor;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 08.11.2012 16:43
 * @see
 */
public class MockWorkSpaceManager implements IWorkspaceManager {
    @Override
    public ITeamRepository teamRepository() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IVersionableManager versionableManager() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List knownWorkspaceConnections() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List knownBaselineConnections() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List knownComponents() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IWorkspaceConnection getWorkspaceConnection(IWorkspaceHandle iWorkspaceHandle, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<? extends IWorkspaceConnection> getWorkspaceConnections(List<? extends IWorkspaceHandle> iWorkspaceHandles, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IBaselineConnection getBaselineConnection(IBaselineHandle iBaselineHandle, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IBaselineConnection getBaselineConnection(IBaseline iBaseline, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IWorkspaceConnection copyWorkspace(IAuditableHandle iAuditableHandle, IWorkspaceConnection iWorkspaceConnection, String s, String s1, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IWorkspaceConnection createWorkspace(IContributorHandle iContributorHandle, String s, String s1, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IWorkspaceConnection createWorkspace(IContributorHandle iContributorHandle, String s, String s1, IWorkspaceConnection iWorkspaceConnection, IWorkspaceConnection iWorkspaceConnection1, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IWorkspaceConnection createWorkspace(IContributorHandle iContributorHandle, String s, String s1, IBaselineSetHandle iBaselineSetHandle, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IWorkspaceConnection createStream(IProcessAreaHandle iProcessAreaHandle, String s, String s1, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findWorkspaceDeliverRelationships(IWorkspaceHandle iWorkspaceHandle, IAuditableHandle iAuditableHandle, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findWorkspaceAcceptRelationships(IWorkspaceHandle iWorkspaceHandle, IAuditableHandle iAuditableHandle, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IItemQueryPage findWorkspacesByName(String s, boolean b, boolean b1, boolean b2, int i, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public java.util.List<com.ibm.team.scm.common.IWorkspaceHandle> findWorkspaces(com.ibm.team.scm.common.dto.IWorkspaceSearchCriteria criteria, int maximumExpectedResults, org.eclipse.core.runtime.IProgressMonitor monitor) throws com.ibm.team.repository.common.TeamRepositoryException {
        IWorkspaceHandle workspaceHandle = new MockWorkSpaceHandle("stream");
        return asList(workspaceHandle);
    }

    @Override
    public List<IWorkspaceHandle> findWorkspacesContainingChangeset(IChangeSetHandle iChangeSetHandle, IWorkspaceSearchCriteria iWorkspaceSearchCriteria, int i, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<IWorkspaceHandle> findWorkspacesContainingComponent(IComponentHandle iComponentHandle, IWorkspaceSearchCriteria iWorkspaceSearchCriteria, int i, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IItemQueryPage fetchNextPage(IItemQueryPage iItemQueryPage, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findItems(IItemQuery iItemQuery, Object[] objects) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findItems(IItemQuery iItemQuery, Object[] objects, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteWorkspace(IWorkspaceHandle iWorkspaceHandle, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IBaselineSetHandle safelyDeleteStream(IWorkspaceHandle iWorkspaceHandle, IWorkspaceConnection iWorkspaceConnection, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setComment(IChangeSetHandle iChangeSetHandle, String s, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setName(IBaselineSetHandle iBaselineSetHandle, String s, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setComment(IBaselineSetHandle iBaselineSetHandle, String s, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findComponents(String s, IAuditableHandle iAuditableHandle, boolean b, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<IComponentHandle> findComponents(IComponentSearchCriteria iComponentSearchCriteria, int i, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<IAuditableHandle> findOwnersForComponents(List<? extends IComponentHandle> iComponentHandles, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Visibility> findVisibilityForComponents(List<? extends IComponentHandle> iComponentHandles, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<IReadScope> findReadScopeForComponents(List<? extends IComponentHandle> iComponentHandles, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findBaselineSets(String s, IProcessAreaHandle iProcessAreaHandle, boolean b, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findBaselineSets(IBaselineSetSearchCriteria iBaselineSetSearchCriteria, int i, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IComponent createComponent(String s, IAuditableHandle iAuditableHandle, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void renameComponent(IComponentHandle iComponentHandle, String s, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setComponentOwnerAndVisibility(IComponentHandle iComponentHandle, IAuditableHandle iAuditableHandle, IReadScope iReadScope, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setComponentOwner(IComponentHandle iComponentHandle, IAuditableHandle iAuditableHandle, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setComponentVisibility(IComponentHandle iComponentHandle, Visibility visibility, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findAllWorkspaces(IAuditableHandle iAuditableHandle, String s, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set findAllWorkspaceNames(IAuditableHandle iAuditableHandle, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<String> findAllComponentNames(IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findAllBaselines(IComponentHandle iComponentHandle, String s, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<IBaselineHandle> findBaselines(IBaselineSearchCriteria iBaselineSearchCriteria, int i, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<IChangeSetLinkSummary> getChangeSetLinkSummary(Collection<? extends IChangeSetHandle> iChangeSetHandles, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public CreateLinksResult createLinks(String s, IWorkspaceHandle iWorkspaceHandle, IChangeSetHandle iChangeSetHandle, List<URI> uris, List<String> strings, List<String> strings1, List<String> strings2, boolean b, boolean b1, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteLinks(List<ILink> iLinks, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<IChangeSetHandle> findChangeSets(IChangeSetSearchCriteria iChangeSetSearchCriteria, int i, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void refreshWorkspaceConnections(Collection<IWorkspaceConnection> iWorkspaceConnections, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IVersionableLockOperationFactory lockOperationFactory() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void applyLockOperations(Collection<IVersionableLockOperation> iVersionableLockOperations, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<IStreamLockReport> getLocks() throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ILockSearchResult findLocks(ILockSearchCriteria iLockSearchCriteria, int i, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean sameRepository(IConnection iConnection) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<IChangeSetHandle> suspendedChangeSets() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<IChangeSetHandle> suspendedChangeSets(IComponentHandle iComponentHandle) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeSuspended(Collection collection, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<IChangeSetHandle> transferChangeSetsFromRemoteRepository(List<IChangeSetHandle> iChangeSetHandles, ITeamRepository iTeamRepository, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IChangeHistorySyncReport compareBaselineSets(IBaselineSetHandle iBaselineSetHandle, IBaselineSetHandle iBaselineSetHandle1, List<IComponentHandle> iComponentHandles, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IUpdateReport compareBaselineSetConfigurations(IBaselineSetHandle iBaselineSetHandle, IBaselineSetHandle iBaselineSetHandle1, List<IComponentHandle> iComponentHandles, IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void refresh(IProgressMonitor iProgressMonitor) throws TeamRepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IVersionedContentManager getSCMContentManager() {
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
