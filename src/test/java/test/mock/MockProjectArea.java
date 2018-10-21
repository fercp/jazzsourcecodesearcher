package test.mock;

import com.ibm.team.process.common.*;
import com.ibm.team.repository.common.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 08.11.2012 15:25
 * @see
 */
public class MockProjectArea implements IProjectArea {
    private String name;

    public MockProjectArea(String name) {
        this.name = name;
    }

    @Override
    public boolean isInitialized() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void markInitialized() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProcessDefinitionHandle getProcessDefinition() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setProcessDefinition(IProcessDefinitionHandle iProcessDefinitionHandle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List getTeamAreas() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ITeamAreaHierarchy getTeamAreaHierarchy() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ITeamAreaHierarchy getTeamAreaHierarchySnapshot() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IDevelopmentLineHandle[] getDevelopmentLines() {
        return new IDevelopmentLineHandle[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IDevelopmentLineHandle getProjectDevelopmentLine() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setProjectDevelopmentLine(IDevelopmentLineHandle iDevelopmentLineHandle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addDevelopmentLine(IDevelopmentLineHandle iDevelopmentLineHandle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setDevelopmentLines(IDevelopmentLineHandle[] iDevelopmentLineHandles) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IIterationTypeHandle[] getIterationTypes() {
        return new IIterationTypeHandle[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setIterationTypes(IIterationTypeHandle[] iIterationTypeHandles) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addIterationType(IIterationTypeHandle iIterationTypeHandle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeIterationType(IIterationTypeHandle iIterationTypeHandle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IReadAccessListHandle getReadAccessList() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProjectLinkHandle[] getProjectLinks() {
        return new IProjectLinkHandle[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addProjectLink(IProjectLinkHandle iProjectLinkHandle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeProjectLink(IProjectLinkHandle iProjectLinkHandle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setProjectLinks(IProjectLinkHandle[] iProjectLinkHandles) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getOwningApplicationKey() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setOwningApplicationKey(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String s) {
        this.name = s;
    }

    @Override
    public IDescription getDescription() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IContributorHandle[] getMembers() {
        return new IContributorHandle[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasMember(IContributorHandle iContributorHandle) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addMember(IContributorHandle iContributorHandle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeMember(IContributorHandle iContributorHandle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeAllMembers() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ITeamData getTeamData() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProjectAreaHandle getProjectArea() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IContributorHandle[] getAdministrators() {
        return new IContributorHandle[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasAdministrator(IContributorHandle iContributorHandle) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addAdministrator(IContributorHandle iContributorHandle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeAdministrator(IContributorHandle iContributorHandle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAdministrators(IContributorHandle[] iContributorHandles) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getProcessName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setProcessName(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getProcessSummary() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setProcessSummary(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getProcessContentPath() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setProcessContentPath(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Map getProcessData() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isArchived() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setArchived(boolean b) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProcessAttachmentHandle[] getAttachments() {
        return new IProcessAttachmentHandle[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addAttachment(IProcessAttachmentHandle iProcessAttachmentHandle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeAttachment(IProcessAttachmentHandle iProcessAttachmentHandle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAttachments(IProcessAttachmentHandle[] iProcessAttachmentHandles) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getProcessItemType() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getPropertyName(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IAuditableHandle getPredecessorState() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IAuditableHandle getMergePredecessorState() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isNewItem() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasHistory() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IContributorHandle getModifiedBy() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Date modified() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isComplete() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isPropertySet(String s) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isWorkingCopy() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IItem getWorkingCopy() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IItemHandle getItemHandle() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IItemHandle getStateHandle() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UUID getContextId() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setContextId(UUID uuid) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UUID getItemId() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasStateId() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UUID getStateId() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean sameStateId(IItemHandle iItemHandle) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IItemType getItemType() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getOrigin() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isImmutable() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void makeImmutable() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void protect() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean sameItemId(IItemHandle iItemHandle) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasFullState() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IItem getFullState() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isAuditable() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isUnmanaged() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isSimple() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getAdapter(Class aClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long size() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
