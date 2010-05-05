import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class DisplayGUIComponents extends JFrame {
  public DisplayGUIComponents() {

// Create a button with text OK
    JButton jbtOK = new JButton("OK");

// Create a label with text "Enter your name: "
    JLabel jlblName = new JLabel("Enter your name: ");

// Create a text field with text "Type Name Here"
    JTextField jtfName = new JTextField("Type Name Here");

// Create a check box with text bold
    JCheckBox jchkBold = new JCheckBox("Bold");

// Create a radio button with text red
    JRadioButton jrbRed = new JRadioButton("Red");

// Create a combo box with choices red, green, and blue
    JComboBox jcboColor = new JComboBox(new String[] {"Red",
      "Green", "Blue"});

    getContentPane().setLayout(new java.awt.FlowLayout());
    getContentPane().add(jbtOK);
    getContentPane().add(jlblName);
    getContentPane().add(jtfName);
    getContentPane().add(jchkBold);
    getContentPane().add(jrbRed);
    getContentPane().add(jcboColor);
  }

  public static void main(String[] args) {
    DisplayGUIComponents frame = new DisplayGUIComponents();
    frame.setTitle("Display GUI Components");
    frame.setSize(400, 320);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation((d.width - frame.getSize().width) / 2,
      (d.height - frame.getSize().height) / 2);
    frame.setVisible(true);
  }
}
