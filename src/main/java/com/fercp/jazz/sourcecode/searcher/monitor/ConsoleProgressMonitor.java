package com.fercp.jazz.sourcecode.searcher.monitor;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 09.11.2012 15:48
 * @see
 */

import org.eclipse.core.runtime.IProgressMonitor;


public class ConsoleProgressMonitor implements IProgressMonitor {

    public void beginTask(String name, int totalWork) {
        print(name);
    }

    public void done() {
    }

    public void internalWorked(double work) {
    }

    public boolean isCanceled() {
        return false;
    }

    public void setCanceled(boolean value) {
    }

    public void setTaskName(String name) {
        print(name);
    }

    public void subTask(String name) {
        print(name);
    }

    public void worked(int work) {
    }

    private void print(String name) {
        if (name != null && !"".equals(name))
            System.out.println(name);
    }
}
