package com.fercp.jazz.sourcecode.searcher.explorer;

import com.fercp.jazz.sourcecode.searcher.item.FileSystemItem;
import com.ibm.team.repository.common.TeamRepositoryException;
import com.ibm.team.scm.client.IConfiguration;
import com.ibm.team.scm.common.IFolderHandle;
import com.ibm.team.scm.common.IVersionableHandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 09.11.2012 10:19
 * @see
 */
public class FileSystemExplorer implements JazzExplorer<FileSystemItem, FileSystemItem> {
    private IConfiguration configuration;

    public FileSystemExplorer(IConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public List<FileSystemItem> findItems(FileSystemItem parent) {
        List<FileSystemItem> fileSystemItems = new ArrayList<FileSystemItem>();
        try {
            Map<String, IVersionableHandle> childList = configuration.childEntries((IFolderHandle) parent.getItem(), monitor);
            for (Map.Entry<String, IVersionableHandle> entry : childList.entrySet()) {
                IVersionableHandle vHandle = entry.getValue();

                /*   if(vHandle instanceof IFileItemHandle){
              List<String> properties=new ArrayList<String>(2);
              properties.add("content");
              properties.add("name");
              vHandle = configuration.fetchPartialItem(vHandle,properties, monitor);
           }     */

                FileSystemItem item = new FileSystemItem(vHandle);
                item.setName(entry.getKey());
                item.setConfiguration(configuration);
                fileSystemItems.add(item);
            }
        } catch (TeamRepositoryException e) {
            e.printStackTrace();
        }

        return fileSystemItems;

    }


}
