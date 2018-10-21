package com.fercp.jazz.sourcecode.searcher.tree;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 12.11.2012 11:17
 * @see
 */
public class StringParser<T> implements TreeParser<T> {
    @Override
    public String parse(Tree<T> tree) {
        if (tree == null)
            return "";
        T root = tree.getRoot();
        String value = root == null ? "" : root.toString();
        StringBuilder result = new StringBuilder();
        result.append(value).append("\n");
        if (tree.getLeafs() != null)
            for (Tree<T> leaf : tree.getLeafs()) {
                for (int i = 0; i < leaf.getLevel(); i++)
                    result.append("\t");
                result.append(parse(leaf));
            }
        return result.toString();

    }
}
