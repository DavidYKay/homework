// TestButtonTextPosition.java: Test button text position
import java.awt.*;
import javax.swing.*;

public class TestButtonTextPosition {
  public static void main(String[] args) {
// Create an image icon from image file
ImageIcon icon = new ImageIcon("image/grapes.gif");

// Create a label with text, an icon,
// with centered horizontal alignment
JLabel jlbl = new JLabel("Grapes", icon, SwingConstants.CENTER);

// Set label's text alignment and gap between text and icon
jlbl.setVerticalTextPosition(SwingConstants.CENTER);
jlbl.setVerticalTextPosition(SwingConstants.BOTTOM);
jlbl.setIconTextGap(5);

    // Create a frame and set its properties
    JFrame frame = new JFrame("Text and Icon Label");
    frame.getContentPane().add(jlbl, BorderLayout.CENTER);
    frame.setSize(300, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
