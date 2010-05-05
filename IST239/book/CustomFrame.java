import javax.swing.*;
import java.awt.*;

public class CustomFrame extends JFrame {
  public CustomFrame() {
    // Set FlowLayout for the frame
    FlowLayout layout = new FlowLayout();
    setLayout(layout);

    // Add two buttons to frame
    JButton jbtOK = new JButton("OK");
    JButton jbtCancel = new JButton("Cancel");
    add(jbtOK);
    add(jbtCancel);
  }

  public static void main(String[] args) {
    JFrame frame = new CustomFrame();
    frame.setTitle("Window 1");
    frame.setSize(200, 150);
    frame.setLocation(200, 100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
