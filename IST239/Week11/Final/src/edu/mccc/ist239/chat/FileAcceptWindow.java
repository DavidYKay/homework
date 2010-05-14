package edu.mccc.ist239.chat;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

public class FileAcceptWindow extends JFrame {
    private ChatClient chatClient;
    private String remoteFileName;
    private Socket hostSocket;
    
    private JTextField fileField = new JTextField(), 
                       dirField  = new JTextField();

    private JButton browseButton = new JButton("Browse"), 
                    saveButton   = new JButton("Save");

    public FileAcceptWindow(ChatClient chatClient, Socket hostSocket, String remoteFileName) {
        this.chatClient = chatClient;
        this.hostSocket = hostSocket;
        this.remoteFileName   = remoteFileName;
		setTitle("Accept File");
        JPanel p = new JPanel();
        browseButton.addActionListener(new BrowseL());
        p.add(browseButton);
        saveButton.addActionListener(new SaveL());
        p.add(saveButton);
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
            int rVal = c.showOpenDialog(FileAcceptWindow.this);
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

    class SaveL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Speak to callback
            String localFileName = fileField.getText();
            String dirName       = dirField.getText();
            System.out.println("FileName: " + localFileName);
            System.out.println("DirName: " + dirName);
            String fullLocalName = dirName + '/' + localFileName;
            File file = new File(
                fullLocalName
            );
            System.out.println("File: " + file);

            chatClient.receiveFile(
				hostSocket, 
				remoteFileName,
                fullLocalName
			);
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
