package com.fercp.jazz.sourcecode.searcher.explorer;

import com.fercp.jazz.sourcecode.searcher.item.JazzItem;
import com.fercp.jazz.sourcecode.searcher.monitor.ConsoleProgressMonitor;
import org.eclipse.core.runtime.IProgressMonitor;

import java.util.List;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 08.11.2012 13:41
 * @see
 */
public interface JazzExplorer<T extends JazzItem, P extends JazzItem> {
    IProgressMonitor monitor = new ConsoleProgressMonitor();

    List<T> findItems(P parent);
}
