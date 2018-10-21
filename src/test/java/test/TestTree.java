package test;

import com.fercp.jazz.sourcecode.searcher.item.JazzItem;
import com.fercp.jazz.sourcecode.searcher.item.ProcessAreaItem;
import com.fercp.jazz.sourcecode.searcher.tree.StringParser;
import com.fercp.jazz.sourcecode.searcher.tree.Tree;
import com.fercp.jazz.sourcecode.searcher.tree.TreeParser;
import org.junit.Test;
import test.mock.MockProjectArea;

import static junit.framework.Assert.assertEquals;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 12.11.2012 10:26
 * @see
 */
public class TestTree {
    @Test
    public void testTreeRoot() {
        JazzItem jazzItem = new ProcessAreaItem(new MockProjectArea("project"));
        Tree<JazzItem> tree = new Tree(jazzItem);
        assertEquals(jazzItem, tree.getRoot());
    }

    @Test
    public void testAddLeaf() {
        JazzItem root = new ProcessAreaItem(new MockProjectArea("root"));
        Tree<JazzItem> tree = new Tree(root);

        JazzItem item = new ProcessAreaItem(new MockProjectArea("child2"));
        Tree<JazzItem> firstLeaf = new Tree(item);
        tree.addLeaf(firstLeaf);

        item = new ProcessAreaItem(new MockProjectArea("child2"));
        Tree<JazzItem> secondLeaf = new Tree(item);
        tree.addLeaf(secondLeaf);
        boolean first = true;
        for (Tree expectedLeaf : tree.getLeafs())
            if (first) {
                assertEquals(expectedLeaf, firstLeaf);
                first = false;
            } else
                assertEquals(expectedLeaf, secondLeaf);
    }

    @Test
    public void testLavel() {
        JazzItem root = new ProcessAreaItem(new MockProjectArea("root"));
        Tree<JazzItem> tree = new Tree(root);

        JazzItem item = new ProcessAreaItem(new MockProjectArea("child1"));
        Tree<JazzItem> firstLeaf = new Tree(item);
        tree.addLeaf(firstLeaf);

        item = new ProcessAreaItem(new MockProjectArea("child2"));
        Tree<JazzItem> secondLeaf = new Tree(item);
        tree.addLeaf(secondLeaf);

        item = new ProcessAreaItem(new MockProjectArea("child3"));
        Tree<JazzItem> leafOfSecondLeaf = new Tree(item);
        secondLeaf.addLeaf(leafOfSecondLeaf);

        assertEquals(0, tree.getLevel());
        assertEquals(1, firstLeaf.getLevel());
        assertEquals(1, secondLeaf.getLevel());
        assertEquals(2, leafOfSecondLeaf.getLevel());
    }

    @Test
    public void traverseTree() {
        JazzItem root = new ProcessAreaItem(new MockProjectArea("root"));
        Tree<JazzItem> tree = new Tree(root);

        JazzItem item = new ProcessAreaItem(new MockProjectArea("child1"));
        Tree<JazzItem> firstLeaf = new Tree(item);
        tree.addLeaf(firstLeaf);

        item = new ProcessAreaItem(new MockProjectArea("child2"));
        Tree<JazzItem> secondLeaf = new Tree(item);
        tree.addLeaf(secondLeaf);

        item = new ProcessAreaItem(new MockProjectArea("child3"));
        Tree<JazzItem> leafOfSecondLeaf = new Tree(item);
        secondLeaf.addLeaf(leafOfSecondLeaf);

        item = new ProcessAreaItem(new MockProjectArea("child4"));
        Tree<JazzItem> leafOfLeafSecondLeaf = new Tree(item);
        leafOfSecondLeaf.addLeaf(leafOfLeafSecondLeaf);

        TreeParser<JazzItem> parser = new StringParser();
        assertEquals("root\n\tchild1\n\tchild2\n\t\tchild3\n\t\t\tchild4\n", parser.parse(tree));

    }
}
