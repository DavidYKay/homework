import javax.swing.*;
import java.awt.Graphics;

public class TestCustomCanvas extends JFrame {
  public TestCustomCanvas() {
    add(new CustomCanvas());
  }

  public static void main(String[] args) {
    TestCustomCanvas frame = new TestCustomCanvas();
    frame.setTitle("TestCustomCanvas");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 100);
    frame.setVisible(true);
  }
}

class CustomCanvas extends JComponent {
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawLine(0, 0, 50, 50);
    g.drawString("Banner", 0, 40);
  }
}
