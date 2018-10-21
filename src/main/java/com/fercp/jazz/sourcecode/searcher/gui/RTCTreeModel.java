package com.fercp.jazz.sourcecode.searcher.gui;

import com.fercp.jazz.sourcecode.searcher.item.JazzItem;
import com.fercp.jazz.sourcecode.searcher.tree.Tree;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 21.11.2012 20:49
 * @see
 */
public class RTCTreeModel implements TreeModel {
    private Tree<JazzItem> jazzTree;

    public RTCTreeModel(Tree tree){
        this.jazzTree=tree;
    }

    @Override
    public Object getRoot() {
        return jazzTree;
    }

    @Override
    public Object getChild(Object o, int i) {
        Tree<JazzItem> item=(Tree<JazzItem>)o;
        return item.getLeafs().toArray()[i];
    }

    @Override
    public int getChildCount(Object o) {
        Tree<JazzItem> item=(Tree<JazzItem>)o;
        return item.getLeafs().size();
    }

    @Override
    public boolean isLeaf(Object o) {
        Tree<JazzItem> item=(Tree<JazzItem>)o;
        return item.getLeafs().isEmpty();
    }

    @Override
    public void valueForPathChanged(TreePath treePath, Object o) {

    }

    @Override
    public int getIndexOfChild(Object o, Object o1) {
        Tree<JazzItem> item=(Tree<JazzItem>)o;
        Tree<JazzItem>[] leafs=(Tree<JazzItem>[])item.getLeafs().toArray();
        int i=0;
        for(Tree<JazzItem> leaf:leafs)
           if(leaf==o1)
               return i;
           else
               i++;
        return i;
    }

    @Override
    public void addTreeModelListener(TreeModelListener treeModelListener) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeTreeModelListener(TreeModelListener treeModelListener) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
