package edu.mccc.ist239.chat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Window that allows the user to select a file to send
 * Modified from FileWindow, http://www.java2s.com/Code/Java/Swing-JFC/DemonstrationofFiledialogboxes.htm
 */
public class FileWindow extends JFrame {
    
    private JTextField filename = new JTextField(), 
                       dir      = new JTextField();

    private JButton open = new JButton("Open"), 
                    save = new JButton("Save");

    public FileWindow() {
		setTitle("File Select");
        JPanel p = new JPanel();
        open.addActionListener(new OpenL());
        p.add(open);
        save.addActionListener(new SaveL());
        p.add(save);
        Container cp = getContentPane();
        cp.add(p, BorderLayout.SOUTH);
        dir.setEditable(false);
        filename.setEditable(false);
        p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        p.add(filename);
        p.add(dir);
        cp.add(p, BorderLayout.NORTH);
        pack();
		setLocationRelativeTo(null);
        setVisible(true);
    }

    class OpenL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser c = new JFileChooser();
            // Demonstrate "Open" dialog:
            int rVal = c.showOpenDialog(FileWindow.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                filename.setText(c.getSelectedFile().getName());
                dir.setText(c.getCurrentDirectory().toString());
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                filename.setText("You pressed cancel");
                dir.setText("");
            }
        }
    }

    class SaveL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser c = new JFileChooser();
            // Demonstrate "Save" dialog:
            int rVal = c.showSaveDialog(FileWindow.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                filename.setText(c.getSelectedFile().getName());
                dir.setText(c.getCurrentDirectory().toString());
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                filename.setText("You pressed cancel");
                dir.setText("");
            }
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(
            250,
            110
        );
    }

    //public static void main(String[] args) {
    //    run(new FileWindow(), 250, 110);
    //}

    //public static void run(JFrame frame, int width, int height) {
    //    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //    frame.setSize(width, height);
    //    frame.setVisible(true);
    //}
}
