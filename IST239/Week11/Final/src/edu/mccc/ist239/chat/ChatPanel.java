package edu.mccc.ist239.chat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ChatPanel extends JPanel {
    private ChatClient chatClient;
    private JTextArea chatText;
    private JTextField inputField;

    public ChatPanel() {
        System.out.println("New ChatPanel");
        initGUI();
        System.out.println("ChatPanel GUI");
        setVisible(true);
    }

    private void initGUI() {
        //GUI
        setLayout(new BorderLayout());
        chatText = new JTextArea();
        chatText.setEditable(false);
        chatText.setBorder(
            BorderFactory.createTitledBorder(
                "Chat"
            )
        );
        JScrollPane scrollPane = new JScrollPane(chatText);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sendMessage();
                }
            }
        );

        inputField = new JTextField();
        inputField.addKeyListener(
            new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        sendMessage();
                    }
                }
            }
        );

        JButton fileButton = new JButton("Send File");
        fileButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sendFile();
                }
            }
        );

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(
            new GridLayout(
                2,
                1
            )
        );
        buttonPanel.add(
            fileButton
        );
        buttonPanel.add(
            sendButton
        );

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(
            //sendButton,
            //fileButton,
            buttonPanel,
            BorderLayout.EAST
        );
        inputPanel.add(
            inputField,
            BorderLayout.CENTER
        );

        add(
            scrollPane,
            BorderLayout.CENTER
        );
        add(
            inputPanel,
            BorderLayout.SOUTH
        );

        setPreferredSize(
            new Dimension(
                500,
                500
            )
        );
    }

    private void sendMessage() {
        //TODO
    }
    private void sendFile() {
        //TODO
    }
}
