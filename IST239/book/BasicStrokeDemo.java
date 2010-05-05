import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class BasicStrokeDemo extends JApplet {
  public BasicStrokeDemo() {
    add(new ShapePanel3());
  }

  /** Main method */
  public static void main(String[] args) {
    BasicStrokeDemo applet = new BasicStrokeDemo();
    applet.init();
    applet.start();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("BasicStrokeDemo");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setSize(400, 320);
    frame.setVisible(true);
  }
}

class ShapePanel3 extends JPanel {
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D)g;

    g2d.setStroke(new BasicStroke(15.0f, BasicStroke.CAP_ROUND,
      BasicStroke.JOIN_BEVEL));
    g2d.draw(new Line2D.Double(10, 10, 40, 80));
    g2d.draw(new Rectangle2D.Double(70, 10, 30, 70));

    g2d.setStroke(new BasicStroke(15.0f, BasicStroke.CAP_ROUND,
      BasicStroke.JOIN_MITER));
    g2d.draw(new Rectangle2D.Double(130, 10, 30, 70));

    g2d.setStroke(new BasicStroke(15.0f, BasicStroke.CAP_SQUARE,
      BasicStroke.JOIN_ROUND));
    g2d.draw(new Rectangle2D.Double(190, 10, 30, 70));

    g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE,
      BasicStroke.JOIN_ROUND, 1.0f, new float[]{8}, 0));
    g2d.draw(new Line2D.Double(240, 10, 270, 80));
  }
}
