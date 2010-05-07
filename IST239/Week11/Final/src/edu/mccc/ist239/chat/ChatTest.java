package edu.mccc.ist239.chat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


/**
 * The actual client GUI. A ChatClient object is used to send/received messages from the server.
 */
public class ChatTest extends JPanel implements ChatClientListener {
    private ChatClient chatClient;
    private JTextArea nameField;
    private JTextArea chatText;
    private JTextField inputField;

    public ChatTest() {
        this.chatClient = new ChatClient(
            //This should the the actual user name. Currently just dead weight
            "Bob",
            "127.0.0.1"
        );
        chatClient.addChatClientListener(this);
        initGUI();
    }
    private void initGUI() {
        //GUI
        setLayout(new BorderLayout());
        chatText = new JTextArea();
        chatText.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatText);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sendMessage();
                }
            }
        );
        JPanel namePanel = new JPanel();
        namePanel.setLayout(
            new BorderLayout()
        );
        namePanel.setBorder(
            BorderFactory.createLineBorder(
                Color.BLACK
            )
        );
        namePanel.add(
            new JLabel(
                "Name: "
            ),
            BorderLayout.WEST
        );
        nameField = new JTextArea();
        nameField.setRows(1);
        namePanel.add(
            nameField,
            BorderLayout.CENTER
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
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(
            sendButton,
            BorderLayout.EAST
        );
        inputPanel.add(
            inputField,
            BorderLayout.CENTER
        );

        add(
            namePanel,
            BorderLayout.NORTH
        );
        add(
            //chatText,
            scrollPane,
            BorderLayout.CENTER
        );
        add(
            inputPanel,
            BorderLayout.SOUTH
        );

        JButton frameButton = new JButton("New Conversation");
        frameButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("newFrame Button pressed");
                    //Open a new frame
                    new ChatWindow(ChatTest.this);
                }
            }
        );
        add(
            makeSidePanel(),
            BorderLayout.EAST
        );

        setPreferredSize(
            new Dimension(
                800,
                600
            )
        );
    }
    private JPanel makeSidePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(
            new BorderLayout()
        );
        //BUDDY LIST
        JPanel buddyListPanel = new JPanel();
        buddyListPanel.add(
            new JLabel("Buddy List")
        );
        buddyListPanel.setBackground(
            Color.WHITE
        );

        //BUTTONS
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(
            new GridLayout(
                1, 
                3
            )
        );
        JButton addButton    = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JButton fileButton   = new JButton("File");

        buttonPanel.add(
            addButton
        );
        buttonPanel.add(
            removeButton
        );
        buttonPanel.add(
            fileButton
        );

        panel.add(
            buddyListPanel,
            BorderLayout.CENTER
        );
        panel.add(
            buttonPanel,
            BorderLayout.SOUTH
        );

        return panel;
    }

    public static void main(String[] sa) {
		JFrame frame = new JFrame();
		frame.setTitle("Chat Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
        frame.add(
            new ChatTest()
        );
		frame.pack();
		frame.setVisible(true);
    }

    public void messageReceived(ChatClientEvent e) {
        System.out.println("Message received!: " + e.getMessage());
        chatText.append(e.getMessage() + "\n");
    }

    private void sendMessage() {
        chatClient.sendMessage(
            nameField.getText() + ": " + inputField.getText()
        );
        inputField.setText("");
    }
}
