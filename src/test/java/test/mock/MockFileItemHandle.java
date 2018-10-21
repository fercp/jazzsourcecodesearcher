package test.mock;

import com.ibm.team.filesystem.common.IFileContent;
import com.ibm.team.filesystem.common.IFileItem;
import com.ibm.team.repository.common.*;
import com.ibm.team.scm.common.IFolderHandle;
import org.eclipse.core.runtime.IStatus;

import java.util.Date;
import java.util.Map;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 15.11.2012 16:30
 * @see
 */
public class MockFileItemHandle implements IFileItem {
    private String name;

    public MockFileItemHandle(String name) {
        this.name = name;
    }

    @Override
    public String getContentType() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setContentType(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IFileContent getContent() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setContent(IFileContent iFileContent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isExecutable() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setExecutable(boolean b) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Date getFileTimestamp() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setFileTimestamp(Date date) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return name;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setName(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IFolderHandle getParent() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setParent(IFolderHandle iFolderHandle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Map<String, String> getUserProperties() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String setUserProperty(String s, String s1) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String removeUserProperty(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IStatus validate() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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
    public boolean equals(Object o) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long size() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
