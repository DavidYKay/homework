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

    public ChatWindow(Component c, ChatPanel panel) {
        System.out.println("New ChatWindow");
		setTitle("Chat with " + panel.getUsername());
		setLocationRelativeTo(c);
        //add(new ChatPanel());
        add(
            panel
        );
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        pack();
        setVisible(true);
    }

    public ChatWindow(Component c, String username, ChatClient chatClient) {
        this(
            c,
            new ChatPanel(
                chatClient, 
                username
            )
        );
    }
}
