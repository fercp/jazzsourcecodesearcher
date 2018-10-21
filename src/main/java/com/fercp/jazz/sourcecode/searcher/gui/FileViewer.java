package com.fercp.jazz.sourcecode.searcher.gui;

import com.fercp.jazz.sourcecode.searcher.item.FileSystemItem;
import com.ibm.team.filesystem.client.IFileContentManager;
import com.ibm.team.filesystem.common.IFileItem;
import com.ibm.team.filesystem.common.IFileItemHandle;
import com.ibm.team.repository.common.TeamRepositoryException;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static java.util.Arrays.asList;

public class FileViewer extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextPane textPane1;

    public FileViewer(FileSystemItem file, IFileContentManager contentManager, String keyword) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        if(file.getItem() instanceof IFileItemHandle){
            loadFile(file,contentManager);
            if(keyword!=null&&!"".equals(keyword))
               highlight(textPane1,keyword);
        }
    }

    private void loadFile(FileSystemItem file,IFileContentManager contentManager){
        List properties = asList("content");
        try {
            IFileItem fileItem = (IFileItem) file.getConfiguration().fetchPartialItem(file.getItem(), properties, null);
            InputStream is = contentManager.retrieveContentStream((IFileItemHandle) file.getItem(), fileItem.getContent(), null);
            textPane1.read(is,null);
        } catch (TeamRepositoryException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void highlight(JTextPane textComp, String pattern) {
        // First remove all old highlights

        try {
            Highlighter hilite = textComp.getHighlighter();
            Document doc = textComp.getDocument();
            String text = doc.getText(0, doc.getLength());
            int pos = 0;

            // Search for pattern
            // see I have updated now its not case sensitive
            while ((pos = text.toUpperCase().indexOf(pattern.toUpperCase(), pos)) >= 0) {
                // Create highlighter using private painter and apply around pattern
                hilite.addHighlight(pos, pos+pattern.length(), new MyHighlightPainter(Color.yellow));
                pos += pattern.length();
            }
        } catch (BadLocationException e) {
        }
    }

    private void onOK() {
// add your code here
        dispose();
    }

    class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter {
        public MyHighlightPainter(Color color) {
            super(color);
        }
    }


}
