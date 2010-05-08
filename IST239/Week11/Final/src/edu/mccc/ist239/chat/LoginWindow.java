package edu.mccc.ist239.chat;
import java.awt.*;
import java.awt.event.*;
import java.security.*;
import java.math.*;

import javax.swing.*;

/**
 * JFrame which allows the user to log in
 */
public class LoginWindow extends JFrame {
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
                    if (
                        login(
                            userField.getText().trim(),
                            passField.getPassword()
                        )
                    ) {
                        //Success!
                        //TODO Notify client?
                        dispose();
                    } else {
                        //Show something on the gui? Maybe a pop-up?
                        System.err.println("Login failed!");
                    }
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

    private void showLoginFailed() {
        //TODO
    }

    /**
     * MD5 hash the password and send it over the wire
     */
    private boolean login(String user, char[] password) {
        String ps = new String(password);
        MessageDigest m = null;
        try {
            byte[] bytes = ps.getBytes("UTF-8");
            //byte[] bytes = ps.getBytes("ASCII");
            m = MessageDigest.getInstance("MD5");
            m.update(bytes, 0, bytes.length);
        } catch (Exception ex) {
            
        }
        String passwordMD5 = new BigInteger(1, m.digest()).toString(16);
        System.out.println("MD5: " + passwordMD5);
        //send to server, return result
        return chatClient.login(
            user,
            passwordMD5
        );
    }
}
