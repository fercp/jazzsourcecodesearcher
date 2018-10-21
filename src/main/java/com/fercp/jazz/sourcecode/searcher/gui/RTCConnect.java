package com.fercp.jazz.sourcecode.searcher.gui;

import com.fercp.jazz.sourcecode.searcher.connection.JazzConnection;
import com.fercp.jazz.sourcecode.searcher.tree.Tree;
import com.fercp.jazz.sourcecode.searcher.item.JazzItem;
import com.fercp.jazz.sourcecode.searcher.tree.JazzTreeFactory;
import com.fercp.jazz.sourcecode.searcher.tree.JazzTreeSearcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RTCConnect extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JPasswordField passwordField1;

    public RTCConnect() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        textField1.setEnabled(false);
        passwordField1.setEnabled(false);
        buttonCancel.setEnabled(false);
        buttonOK.setEnabled(false);
        String user = textField1.getText();
        String password = String.copyValueOf(passwordField1.getPassword());
        String repositoryAddress = "";
        JazzConnection connection = new JazzConnection(user, password, repositoryAddress);
        connection.connect();
        JazzTreeFactory factory = new JazzTreeFactory(connection, 50);
        Tree<JazzItem> jazzTree = factory.produceTree();
        JFrame frame = new JFrame("RTCSearch");
        RTCTreeModel model=new RTCTreeModel(jazzTree);
        frame.setContentPane(new RTCSearch(model,new JazzTreeSearcher(50,connection.getContentManager()),connection.getContentManager()).getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        dispose();
    }

    private void onCancel() {

        dispose();
    }

    public static void main(String[] args) {
        RTCConnect dialog = new RTCConnect();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }
}
