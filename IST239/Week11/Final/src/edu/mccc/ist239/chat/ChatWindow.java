package edu.mccc.ist239.chat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Class that represents a one-on-one IM Window
 *
 * Has a send button and a file button
 */
public class ChatWindow extends JFrame {
    /** The person the user is chatting with */
    //private String username;
 
    public ChatWindow(Component c, String username, ChatClient chatClient) {
        //this.username = username;

        System.out.println("New ChatWindow");
		setTitle("Chat with " + username);
		setLocationRelativeTo(c);
        //add(new ChatPanel());
        add(
            new ChatPanel(
                chatClient, 
                username
            )
        );
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        pack();
        setVisible(true);
    }
}
