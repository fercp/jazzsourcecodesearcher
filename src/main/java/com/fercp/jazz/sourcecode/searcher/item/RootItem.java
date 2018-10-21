package com.fercp.jazz.sourcecode.searcher.item;

import com.ibm.team.repository.common.IItem;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 12.11.2012 15:09
 * @see
 */
public class RootItem extends JazzItem {

    public RootItem(IItem item) {
        super(item);
    }

    public String toString() {
        return "root";
    }
}
