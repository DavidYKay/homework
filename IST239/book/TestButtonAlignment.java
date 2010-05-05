// TestButtonTextPosition.java: Test button text position
import javax.swing.*;

public class TestButtonAlignment extends JFrame  {
  public static void main(String[] args) {
// Create an image icon from image file
ImageIcon icon = new ImageIcon("image/grapes.gif");

// Create a label with text, an icon,
// with centered horizontal alignment
JButton jlbl = new JButton("Grapes", icon);

// Set label's text alignment and gap between text and icon
jlbl.setVerticalTextPosition(SwingConstants.BOTTOM);
jlbl.setIconTextGap(5);

    // Create a frame and set its properties
    JFrame frame = new JFrame("BOTTOM");
  //  frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
    frame.getContentPane().add(jlbl);
    frame.setSize(180, 103);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

  }
}
