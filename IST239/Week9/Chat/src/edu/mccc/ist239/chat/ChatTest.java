package edu.mccc.ist239.chat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatTest extends JPanel implements ChatClientListener {
    private ChatClient chatClient;
    private JTextArea chatText;
    private JTextField inputField;
    public ChatTest() {
        this.chatClient = new ChatClient(
            "Bob",
            "127.0.0.1"
        );
        chatClient.addChatClientListener(this);

        //GUI
        setLayout(new BorderLayout());
        chatText = new JTextArea();
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
            inputField.getText()
        );
        inputField.setText("");
    }
}
