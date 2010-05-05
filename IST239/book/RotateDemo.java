import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class RotateDemo extends JApplet {
  public RotateDemo() {
    add(new ShapePanel6());
  }

  /** Main method */
  public static void main(String[] args) {
    RotateDemo applet = new RotateDemo();
    applet.init();
    applet.start();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("RotateDemo");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setSize(400, 200);
    frame.setVisible(true);
  }
}

class ShapePanel6 extends JPanel {
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D)g;
    Rectangle2D rectangle = new Rectangle2D.Double(20, 20, 50, 60);

    g2d.translate(200, 150);
    java.util.Random random = new java.util.Random();
    for (int i = 0; i < 10; i++) {
      g2d.setColor(new Color(random.nextInt(256),
        random.nextInt(256), random.nextInt(256)));
      g2d.draw(rectangle);
      g2d.rotate(Math.PI / 5);
    }
  }
}
