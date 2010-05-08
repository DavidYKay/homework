package edu.mccc.ist239.chat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * JFrame which allows the user to log in
 */
public class LoginWindow extends JFrame {
    public LoginWindow(Component c) {
        System.out.println("New LoginWindow");
		setTitle("Login Window");
		setLocationRelativeTo(c);

        setLayout(
            new BorderLayout()
        );
        JPanel centerPanel = new JPanel();
        centerPanel.add(
            new JLabel("TEST")
        );

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


}
