package edu.mccc.ist239.chat;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


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
            chatText,
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
