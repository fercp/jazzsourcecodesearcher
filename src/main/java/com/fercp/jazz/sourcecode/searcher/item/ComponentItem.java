package com.fercp.jazz.sourcecode.searcher.item;

import com.ibm.team.scm.common.IComponent;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 09.11.2012 10:54
 * @see
 */
public class ComponentItem extends JazzItem<IComponent> {
    private WorkspaceItem workspaceItem;

    public ComponentItem(IComponent item, WorkspaceItem workspaceItem) {
        super(item);
        this.workspaceItem = workspaceItem;
    }

    public WorkspaceItem getWorkspaceItem() {
        return workspaceItem;
    }
}
