package com.fercp.jazz.sourcecode.searcher.gui;

import com.fercp.jazz.sourcecode.searcher.item.FileSystemItem;
import com.fercp.jazz.sourcecode.searcher.item.JazzItem;
import com.fercp.jazz.sourcecode.searcher.tree.JazzTreeSearcher;
import com.fercp.jazz.sourcecode.searcher.tree.Tree;
import com.ibm.team.filesystem.client.IFileContentManager;
import com.ibm.team.filesystem.common.IFileItemHandle;

import javax.swing.*;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 21.11.2012 17:48
 * @see
 */
public class RTCSearch {
    private JPanel panel1;
    private JTree tree1;
    private JTextField filExtension;
    private JButton searchButton;
    private JTextField keyword;

    public RTCSearch(final TreeModel model, final JazzTreeSearcher searcher, final IFileContentManager contentManager) {
        tree1.setModel(model);

        MouseListener ml = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int selRow = tree1.getRowForLocation(e.getX(), e.getY());
                TreePath selPath = tree1.getPathForLocation(e.getX(), e.getY());
                if(selRow != -1) {
                    if(e.getClickCount() == 2) {


                        Tree node = (Tree) selPath.getLastPathComponent();
                        if (node.getRoot() instanceof FileSystemItem) {
                            FileSystemItem fileSystemItem = (FileSystemItem) node.getRoot();
                            if (fileSystemItem.getItem() instanceof IFileItemHandle) {
                                FileViewer dialog = new FileViewer(fileSystemItem, contentManager, keyword.getText());
                                dialog.pack();
                                dialog.setVisible(true);
                            }
                        }
                    }
                }
            }
        };
        tree1.addMouseListener(ml);
        /*tree1.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent tse) {
                TreePath tp = tse.getPath();

                Tree node = (Tree) tp.getLastPathComponent();
                if (node.getRoot() instanceof FileSystemItem) {
                    FileSystemItem fileSystemItem = (FileSystemItem) node.getRoot();
                    if (fileSystemItem.getItem() instanceof IFileItemHandle) {
                        FileViewer dialog = new FileViewer(fileSystemItem, contentManager, keyword.getText());
                        dialog.pack();
                        dialog.setVisible(true);
                    }
                }
            }

        });          */
        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                panel1.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                Tree<JazzItem> tree = (Tree<JazzItem>) model.getRoot();
                for(Tree<JazzItem> leaf:tree.getLeafs())
                    if("Harmoni_2".equals(leaf.getRoot().toString())){
                       Tree<JazzItem> searchResult = searcher.findKeywordAndCollectAsTree(leaf, keyword.getText(), filExtension.getText());
                       tree1.setModel(new RTCTreeModel(searchResult));
                        break;
                    }
                super.mouseClicked(mouseEvent);
                panel1.setCursor(Cursor.getDefaultCursor());
            }
        });
    }


    public void setData(SearcherGUI data) {
        keyword.setText(data.getKeyword());
        filExtension.setText(data.getExtension());
    }

    public void getData(SearcherGUI data) {
        data.setKeyword(keyword.getText());
        data.setExtension(filExtension.getText());
    }

    public boolean isModified(SearcherGUI data) {
        if (keyword.getText() != null ? !keyword.getText().equals(data.getKeyword()) : data.getKeyword() != null)
            return true;
        if (filExtension.getText() != null ? !filExtension.getText().equals(data.getExtension()) : data.getExtension() != null)
            return true;
        return false;
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
