import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class TranslateDemo extends JApplet {
  public TranslateDemo() {
    add(new ShapePanel5());
  }

  /** Main method */
  public static void main(String[] args) {
    TranslateDemo applet = new TranslateDemo();
    applet.init();
    applet.start();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("TranslateDemo");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setSize(400, 200);
    frame.setVisible(true);
  }
}

class ShapePanel5 extends JPanel {
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D)g;
    Rectangle2D rectangle = new Rectangle2D.Double(10, 10, 50, 60);

    java.util.Random random = new java.util.Random();
    for (int i = 0; i < 10; i++) {
      g2d.setColor(new Color(random.nextInt(256),
        random.nextInt(256), random.nextInt(256)));
      g2d.draw(rectangle);
      g2d.translate(20, 5);
    }
  }
}
