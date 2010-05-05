import java.awt.*;
import javax.swing.*;

public class TestMessageCanvas extends JFrame {
  public TestMessageCanvas() {
    MessageCanvas messageCanvas1 = new MessageCanvas("Wecome to Java");
    MessageCanvas messageCanvas2 = new MessageCanvas("Java is fun");
    MessageCanvas messageCanvas3 = new MessageCanvas("Java is cool");
    MessageCanvas messageCanvas4 = new MessageCanvas("I love Java");
    messageCanvas1.setFont(new Font("SansSerif", Font.ITALIC, 20));
    messageCanvas2.setFont(new Font("Courie", Font.BOLD, 20));
    messageCanvas3.setFont(new Font("Times", Font.ITALIC, 20));
    messageCanvas4.setFont(new Font("Californian FB", Font.PLAIN, 20));
   // ((JPanel)(this.getContentPane())).setOpaque(false);
    messageCanvas1.setOpaque(true);
    messageCanvas2.setOpaque(true);
    messageCanvas3.setOpaque(true);
    messageCanvas4.setOpaque(true);
    messageCanvas1.setForeground(Color.red);
    messageCanvas2.setBackground(Color.cyan);
    messageCanvas3.setBackground(Color.green);
    messageCanvas4.setBackground(Color.white);
    messageCanvas1.setCentered(true);

    setLayout(new GridLayout(2, 2));
    add(messageCanvas1);
    add(messageCanvas2);
    add(messageCanvas3);
    add(messageCanvas4);
  }

  public static void main(String[] args) {
    TestMessageCanvas frame = new TestMessageCanvas();
    frame.setSize(300, 200);
    frame.setTitle("TestMessageCanvas");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
