package com.fercp.jazz.sourcecode.searcher.item;

import com.ibm.team.scm.client.IConfiguration;
import com.ibm.team.scm.common.IVersionableHandle;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 09.11.2012 11:43
 * @see
 */
public class FileSystemItem extends JazzItem<IVersionableHandle> {

    private String path;
    private String name;
    private IConfiguration configuration;

    public FileSystemItem(IVersionableHandle item) {
        super(item);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String toString() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(IConfiguration configuration) {
        this.configuration = configuration;
    }
}
