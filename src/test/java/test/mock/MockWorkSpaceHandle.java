package test.mock;

import com.ibm.team.repository.common.*;
import com.ibm.team.scm.common.IWorkspace;
import com.ibm.team.scm.common.dto.IReadScope;

import java.util.Date;
import java.util.Map;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 08.11.2012 16:59
 * @see
 */
public class MockWorkSpaceHandle implements IWorkspace {

    private String name;

    public MockWorkSpaceHandle(String name) {
        this.name = name;
    }

    @Override
    public IAuditableHandle getOwner() {
        return new MockProjectArea("project");  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isStream() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isPublic() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isPrivate() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IAuditableHandle getProcessAreaScope() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IReadScope getReadScope() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Map<String, String> getProperties() {
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
