package com.fercp.jazz.sourcecode.searcher.connection;

import com.ibm.team.filesystem.client.FileSystemCore;
import com.ibm.team.filesystem.client.IFileContentManager;
import com.ibm.team.repository.client.ITeamRepository;
import com.ibm.team.repository.client.TeamPlatform;
import com.ibm.team.repository.common.IContributor;
import com.ibm.team.repository.common.IItem;
import com.ibm.team.repository.common.IItemHandle;
import com.ibm.team.repository.common.TeamRepositoryException;
import com.ibm.team.scm.client.IWorkspaceConnection;
import com.ibm.team.scm.client.IWorkspaceManager;
import com.ibm.team.scm.client.SCMPlatform;
import com.ibm.team.scm.client.internal.WorkspaceManager;
import com.ibm.team.scm.common.IWorkspaceHandle;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import java.util.List;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 08.11.2012 11:42
 * @see
 */
public class JazzConnection {
    private String user;
    private String password;
    private String repositoryAddress;
    private ITeamRepository repository;

    public JazzConnection() {

    }

    public JazzConnection(String user, String password, String repositoryAddress) {
        this.user = user;
        this.password = password;
        this.repositoryAddress = repositoryAddress;
    }


    public final boolean connect() {
        if (!TeamPlatform.isStarted()) {
            TeamPlatform.startup();
        }

        repository = TeamPlatform.getTeamRepositoryService().getTeamRepository(repositoryAddress);
        repository.registerLoginHandler(getLoginHandler());
        try {
            repository.login(new NullProgressMonitor());
        } catch (TeamRepositoryException e) {
            e.printStackTrace();
            TeamPlatform.shutdown();
            return false;
        }
        return true;
    }

    private ITeamRepository.ILoginHandler getLoginHandler() {
        return new ITeamRepository.ILoginHandler() {
            public ILoginInfo challenge(ITeamRepository repository) {
                return new ILoginInfo() {
                    public String getUserId() {
                        return user;
                    }

                    public String getPassword() {
                        return password;
                    }
                };
            }
        };
    }


    public final void close() {
        try {
            if (TeamPlatform.isStarted()) {
                TeamPlatform.shutdown();
            }
        } catch (IllegalStateException e) {
            //ignore
        }
    }

    public Object getClientLibrary(Class clazz) {
        return repository.getClientLibrary(clazz);
    }

    public IWorkspaceManager getWorkspaceManager() {
        return SCMPlatform.getWorkspaceManager(repository);
    }

    public IItem fetchCompleteItem(IItemHandle itemHandle, List properties) {
        try {
            return repository.itemManager().fetchPartialItem(itemHandle, 0, properties, null);
        } catch (TeamRepositoryException e) {
            e.printStackTrace();
        }
        return null;
    }

    public IContributor user(){
         return repository.loggedInContributor();
    }

    public IWorkspaceConnection getWorkspaceConnection(IWorkspaceHandle workspaceHandle, IProgressMonitor monitor) {
        WorkspaceManager wm = (WorkspaceManager) getWorkspaceManager();
        try {
            return wm.getWorkspaceConnection(workspaceHandle, monitor);
        } catch (TeamRepositoryException e) {
            e.printStackTrace();
        }
        return null;
    }

    public IFileContentManager getContentManager() {
        return FileSystemCore
                .getContentManager(repository);
    }
}
