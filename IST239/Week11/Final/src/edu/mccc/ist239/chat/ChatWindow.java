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
 
    public ChatWindow(Component c) {
        System.out.println("New ChatWindow");
		setTitle("Chat Window");
		setLocationRelativeTo(c);
        add(new ChatPanel());
        //setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        pack();
        setVisible(true);
    }
}
