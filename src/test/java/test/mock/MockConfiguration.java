package test.mock;

import com.ibm.team.repository.client.ITeamRepository;
import com.ibm.team.repository.common.TeamRepositoryException;
import com.ibm.team.scm.client.IConfiguration;
import com.ibm.team.scm.common.*;
import com.ibm.team.scm.common.dto.IAncestorReport;
import org.eclipse.core.runtime.IProgressMonitor;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 09.11.2012 14:35
 * @see
 */
public class MockConfiguration implements IConfiguration {
    private boolean firstTime = true;
    private Map folders;

    public MockConfiguration(Map folders) {
        this.folders = folders;
    }

    @Override
    public ITeamRepository teamRepository() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isLive() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IComponentHandle component() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isAvailable(IProgressMonitor monitor) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IFolderHandle rootFolderHandle(IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Map childEntries(IFolderHandle iFolderHandle, IProgressMonitor monitor) throws TeamRepositoryException {
        if (!firstTime)
            return new HashMap();
        firstTime = false;
        return folders;
    }

    @Override
    public Map childEntriesForRoot(IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List childEntries(List list, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List locateAncestors(List list, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List determineAncestorsInHistory(List list, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IVersionableHandle resolvePath(IFolderHandle iFolderHandle, String[] strings, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IFolder partialRootFolder(Collection collection, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IVersionable fetchPartialItem(IVersionableHandle iVersionableHandle, Collection collection, IProgressMonitor monitor) throws TeamRepositoryException {
        return (IVersionable) iVersionableHandle;
    }

    @Override
    public List fetchPartialItems(List list, Collection collection, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IFolder completeRootFolder(IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IVersionable fetchCompleteItem(IVersionableHandle iVersionableHandle, IProgressMonitor monitor) throws TeamRepositoryException {
        return (IVersionable) iVersionableHandle;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List fetchCompleteItems(List list, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<IAncestorReport> fetchAncestorsByName(String s, IProgressMonitor monitor) throws TeamRepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
