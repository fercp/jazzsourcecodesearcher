package test.mock;

import com.ibm.team.repository.common.*;
import com.ibm.team.scm.common.IBaselineHandle;
import com.ibm.team.scm.common.IComponent;
import com.ibm.team.scm.common.IFolderHandle;

import java.util.Date;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 09.11.2012 09:13
 * @see
 */
public class MockComponentHandle implements IComponent {
    private String name;

    public MockComponentHandle(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IFolderHandle getRootFolder() {
        IFolderHandle folderHandle = new MockFolderHandle("folder");
        return folderHandle;
    }

    @Override
    public IBaselineHandle getInitialBaseline() {
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
    public boolean sameStateId(IItemHandle itemHandle) {
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
    public boolean sameItemId(IItemHandle itemHandle) {
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
