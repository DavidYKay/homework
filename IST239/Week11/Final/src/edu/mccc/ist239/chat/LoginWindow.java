package edu.mccc.ist239.chat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.cbthinkx.util.Debug;

/**
 * JFrame which allows the user to log in
 */
public class LoginWindow extends JFrame implements ChatLoginListener {
    private ChatClient chatClient;
    private JTextField userField;
    private JPasswordField passField;
    public LoginWindow(Component c, ChatClient client) {
        System.out.println("New LoginWindow");
        chatClient = client;

		setTitle("Login Window");
		setLocationRelativeTo(c);

        setLayout(
            new BorderLayout()
        );

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(
            new BoxLayout(
                centerPanel,
                BoxLayout.Y_AXIS
            )
        );
        //Credentials
        centerPanel.add(
            new JLabel("Username")
        );
        userField = new JTextField();
        centerPanel.add(userField);
        centerPanel.add(
            new JLabel("Password")
        );
        passField = new JPasswordField(ChatServer.PASSWORD_LENGTH);
        passField.enableInputMethods(true);
        centerPanel.add(passField);

        add(
            centerPanel,
            BorderLayout.CENTER
        );

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(
            new FlowLayout()
        );
        JButton okButton = new JButton("OK");
        okButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("OK Button pressed");
                    //Pass credentials to client, wait for approval
                    chatClient.login(
                        userField.getText().trim(),
                        new String(
                            passField.getPassword()
                        )
                    );
                }
            }
        );
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Cancel Button pressed");
                    dispose();
                }
            }
        );
        buttonPanel.add(
            okButton
        );
        buttonPanel.add(
            cancelButton
        );
        add(
            buttonPanel,
            BorderLayout.SOUTH
        );

        //setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        pack();
        setVisible(true);
    }

    public void loginEvent(boolean success) {
        Debug.println("Login Event: " + success);
        //TODO Notify client?
        if (success) {
            //Success!
            dispose();
        } else {
            //show login failed
            System.err.println("Login FAILED");
        }
    }

    private void cleanup() {
        chatClient.removeChatLoginListener(this);
        dispose();
    }
}
