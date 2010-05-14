package edu.mccc.ist239.chat;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

/**
 * Window that allows the user to select a file to send
 * Modified from example at:
 * http://www.java2s.com/Code/Java/Swing-JFC/DemonstrationofFiledialogboxes.htm
 */
public class FileWindow extends JFrame {
    private ChatClient chatClient;
    private String userName;
    
    private JTextField fileField = new JTextField(), 
                       dirField  = new JTextField();

    private JButton browseButton = new JButton("Browse"), 
                    sendButton   = new JButton("Send");

    public FileWindow(ChatClient chatClient, String userName) {
        this.chatClient = chatClient;
        this.userName   = userName;
		setTitle("Send File");
        JPanel p = new JPanel();
        browseButton.addActionListener(new BrowseL());
        p.add(browseButton);
        sendButton.addActionListener(new SendL());
        p.add(sendButton);
        Container cp = getContentPane();
        cp.add(p, BorderLayout.SOUTH);
        dirField.setEditable(false);
        fileField.setEditable(false);
        p = new JPanel();
        p.setLayout(
            new GridLayout(
                2, 
                1
            )
        );
        p.add(fileField);
        p.add(dirField);
        cp.add(p, BorderLayout.NORTH);
        pack();
		setLocationRelativeTo(null);
        setVisible(true);
    }

    class BrowseL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser c = new JFileChooser();
            // Demonstrate "Open" dialog:
            int rVal = c.showOpenDialog(FileWindow.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                fileField.setText(c.getSelectedFile().getName());
                dirField.setText(c.getCurrentDirectory().toString());
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                fileField.setText("You pressed cancel");
                dirField.setText("");
            }
        }
    }

    class SendL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Speak to callback
            String fileName = fileField.getText();
            String dirName  = dirField.getText();
            System.out.println("FileName: " + fileName);
            System.out.println("DirName: " + dirName);
            File file = new File(
                dirName + '/' + fileName
            );
            System.out.println("File: " + file);

            //readFile(file);
            chatClient.sendFile(userName, file);
        }
    }

    class SaveL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser c = new JFileChooser();
            // Demonstrate "Save" dialog:
            int rVal = c.showSaveDialog(FileWindow.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                fileField.setText(c.getSelectedFile().getName());
                dirField.setText(c.getCurrentDirectory().toString());
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                fileField.setText("You pressed cancel");
                dirField.setText("");
            }
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(
            250,
            110
        );
    }

    private void readFile(File file) {
        try {
            FileInputStream fin = new FileInputStream(file);
            int nextUnsignedByte = 0;
            while ((nextUnsignedByte = fin.read()) != -1) {
                System.out.println("Read " + nextUnsignedByte);
            }
            fin.close();
        } catch (IOException ioe) {
        }
    }
}
