package edu.mccc.ist239.chat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.cbthinkx.util.Debug;

/**
 * Quick prompt which asks the user to add a buddy
 */
public class AddBuddyWindow extends JFrame {
    private final ChatTest chatTest;
    private JTextField userField;
    public AddBuddyWindow(Component c, ChatTest chat) {
        System.out.println("New AddBuddyWindow");
        this.chatTest = chat;

		setTitle("Add Buddy");
		setLocationRelativeTo(c);

        //setLayout(
        //    //new FlowLayout()
        //    //new BorderLayout()
        //    new BoxLayout(
        //        AddBuddyWindow.this,
        //        BoxLayout.Y_AXIS
        //    )
        //);
        getContentPane().setLayout(
            new BoxLayout(
                getContentPane(), 
                BoxLayout.PAGE_AXIS
            )
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

        add(
            centerPanel
            //BorderLayout.CENTER
        );

        //BUTTONS
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(
            new FlowLayout()
        );
        JButton okButton = new JButton("OK");
        okButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("OK Button pressed");
                    chatTest.addBuddy(
                        userField.getText().trim()
                    );
                    dispose();
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
            buttonPanel
            //BorderLayout.SOUTH
        );

        setPreferredSize(
            new Dimension(
                300,
                150
            )
        );
        pack();
        setVisible(true);
    }
}
