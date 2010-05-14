import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ShowButtonAlignments extends JFrame{
    //private ImageIcon windowsIcon = new ImageIcon("images/win.jpg");
    private ImageIcon windowsIcon = new ImageIcon("eclipse.png");
    private JButton jbtButton1 = new JButton("Click Here",
            windowsIcon);
    public ShowButtonAlignments(){
        //jbtButton1.setHorizontalAlignment(JButton.LEFT);
        //jbtButton1.setVerticalAlignment(JButton.TOP);
        jbtButton1.setHorizontalAlignment(JButton.RIGHT);
        jbtButton1.setVerticalAlignment(JButton.BOTTOM);
        add(jbtButton1);
    }
    public static void main(String[] args){
        JFrame frame = new ShowButtonAlignments();
        frame.setTitle("Buttons with icons");
        frame.setSize(250,150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

