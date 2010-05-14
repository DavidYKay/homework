package edu.mccc.ist239.chat;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

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

        client.addChatLoginListener(this);

		setTitle("Login");
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
        passField.addKeyListener(
            new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        loginAction();
                    }
                }
            }
        );
        centerPanel.add(passField);

        add(
            centerPanel,
            BorderLayout.CENTER
        );

        JPanel southPanel  = new JPanel();
        southPanel.setLayout(
            //new BoxLayout(
            //    southPanel,
            //    BoxLayout.Y_AXIS
            //)
            new GridLayout(
                2,
                1
            )
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
                    loginAction();
                }
            }
        );
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Cancel Button pressed");
                    cleanup();
                }
            }
        );
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Register Button pressed");
                    registerPage();
                }
            }
        );
        buttonPanel.add(
            okButton
        );
        buttonPanel.add(
            cancelButton
        );

        southPanel.add(
            registerButton
        );
        southPanel.add(
            buttonPanel
        );

        add(
            southPanel,
            BorderLayout.SOUTH
        );

        //setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        pack();
        setVisible(true);
    }

    /**
     * Fired by either the enter key or the OK button
     */
    private void loginAction() {
        //Pass credentials to client, wait for approval
        chatClient.login(
            userField.getText().trim(),
            new String(
                passField.getPassword()
            )
        );
    }

    public void loginEvent(boolean success) {
        Debug.println("Login Event: " + success);
        //TODO Notify client?
        if (success) {
            cleanup();
        } else {
            //show login failed
            System.err.println("Login FAILED");
            JOptionPane.showMessageDialog(
                this, 
                "Login failed. Please check your username/password."
            );
        }
    }

    private void cleanup() {
        chatClient.removeChatLoginListener(this);
        dispose();
    }

    /**
     * Opens the registration page in a web browser.
     * Taken from example at:
     * http://johnbokma.com/mexit/2008/08/19/java-open-url-default-browser.html
     */
    private void registerPage() {
        //String url = "http://davidykay.com:8080/dk/register";
        String url = "http://localhost:8080/dk/register";

        if(!java.awt.Desktop.isDesktopSupported() ) {
            System.err.println( "Desktop is not supported (fatal)" );
            return;
            //System.exit( 1 );
        }
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        if(!desktop.isSupported( java.awt.Desktop.Action.BROWSE ) ) {
            System.err.println( "Desktop doesn't support the browse action (fatal)" );
            //System.exit( 1 );
            return;
        }
        try {
            java.net.URI uri = new java.net.URI( url );
            desktop.browse( uri );
        }
        catch ( Exception e ) {
            System.err.println( e.getMessage() );
        }
    }
}
