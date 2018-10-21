package com.fercp.jazz.sourcecode.searcher.tree;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 12.11.2012 10:50
 * @see
 */
public class Tree<T> {
    T root;
    ConcurrentLinkedQueue<Tree<T>> leafs;
    private int level;

    public Tree(T root) {
        this.root = root;
        leafs = new ConcurrentLinkedQueue<Tree<T>>();
        level = 0;
    }

    public T getRoot() {
        return root;
    }

    public void addLeaf(Tree<T> leaf) {
        leafs.add(leaf);
        leaf.level = level + 1;
    }

    public Collection<Tree<T>> getLeafs() {
        return leafs;
    }

    public int getLevel() {
        return level;
    }

    public String toString(){
        if(root!=null) return root.toString();
        return "";
    }
}
