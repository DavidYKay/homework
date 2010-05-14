// CheckBoxDemoUsingItemEvent.java:
//    Extend ButtonDemo to add three check boxes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxDemoUsingItemEvent extends ButtonDemo
  implements ItemListener {
  // Create three check boxes to control the display of message
  private JCheckBox jchkCentered = new JCheckBox("Centered");
  private JCheckBox jchkBold = new JCheckBox("Bold");
  private JCheckBox jchkItalic = new JCheckBox("Italic");

  public static void main(String[] args) {
    CheckBoxDemoUsingItemEvent frame =
      new CheckBoxDemoUsingItemEvent();
    frame.setTitle("CheckBoxDemoUsingItemEvent");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 200);
    frame.setVisible(true);
  }

  public CheckBoxDemoUsingItemEvent() {
    // Set mnemonic keys
    jchkCentered.setMnemonic('C');
    jchkBold.setMnemonic('B');
    jchkItalic.setMnemonic('I');

    // Create a new panel to hold check boxes
    JPanel jpCheckBoxes = new JPanel();
    jpCheckBoxes.setLayout(new GridLayout(3, 0));
    jpCheckBoxes.add(jchkCentered);
    jpCheckBoxes.add(jchkBold);
    jpCheckBoxes.add(jchkItalic);
    getContentPane().add(jpCheckBoxes, BorderLayout.EAST);

    // Register listeners with the check boxes
    jchkCentered.addItemListener(this);
    jchkBold.addItemListener(this);
    jchkItalic.addItemListener(this);
  }

  /** Handle ItemEvent */
  public void itemStateChanged(ItemEvent e) {
    if (e.getSource() == jchkCentered) {
      messagePanel.setCentered(jchkCentered.isSelected());
    }
    else if ((e.getSource() == jchkBold) ||
      (e.getSource() == jchkItalic)) {
      // Determine a font style
      int fontStyle = Font.PLAIN;
      fontStyle += (jchkBold.isSelected() ? Font.BOLD : 0);
      fontStyle += (jchkItalic.isSelected() ? Font.ITALIC : 0);

      // Set font for the message
      Font font = messagePanel.getFont();
      messagePanel.setFont(
          new Font(font.getName(), fontStyle, font.getSize()));
    }
  }
}
