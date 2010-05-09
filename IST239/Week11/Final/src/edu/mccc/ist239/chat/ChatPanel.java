package edu.mccc.ist239.chat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ChatPanel extends JPanel implements ChatClientListener {
    /** The person the user is chatting with */
    private String userName;
    private ChatClient chatClient;
    private JTextArea chatText;
    private JTextField inputField;

    public ChatPanel(ChatClient chatClient, String userName) {
        System.out.println("New ChatPanel");
        this.chatClient = chatClient;
        this.userName   = userName;
        //chatClient.addChatClientListener(this);
        chatClient.addChatWindow(userName, this);
        initGUI();
        System.out.println("ChatPanel GUI");
        setVisible(true);
    }

    /**
     * On receipt of message
     */
    public void messageReceived(ChatClientEvent e) {
        System.out.println("Message received!: " + e.getMessage());
        //Check if it matches this conversation
        String msg = e.getMessage();
        if (msg.startsWith("im")) {
            String[] args = msg.split(":");
            String message = userName + ": " + args[2];
            //Chop off the prefix
            //msg = msg.substring(
            //    3,
            //    msg.length() 
            //);
            chatText.append(message + "\n");
        }
    }

    public String getUsername() {
        return userName;
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

    /**
     * Sends the currently input text to the other user in the conversation
     */
    private void sendMessage() {
        String message = inputField.getText().trim();
        if (message != null) {
            chatClient.sendPrivateMessage(
                userName,
                message
            );
            chatText.append(
                "Me: " + message + "\n"
            );
        }
        inputField.setText("");
    }

    /**
     * Initiates a private connection with the other user and sends a file 
     * across the wire.
     */
    private void sendFile() {
        //TODO
        new FileWindow(chatClient);
    }
}
