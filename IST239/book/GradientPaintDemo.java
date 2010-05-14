import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class GradientPaintDemo extends JApplet {
  public GradientPaintDemo() {
    add(new ShapePanel2());
  }

  /** Main method */
  public static void main(String[] args) {
    GradientPaintDemo applet = new GradientPaintDemo();
    applet.init();
    applet.start();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("GradientPaintDemo");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setSize(400, 130);
    frame.setVisible(true);
  }
}


class ShapePanel2 extends JPanel {
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    g2d.setPaint(new GradientPaint(10, 10, Color.RED, 30, 30,
      Color.BLUE, false));
    g2d.fill(new Rectangle2D.Double(10, 10, 70, 70));

    g2d.setPaint(new GradientPaint(90, 10, Color.YELLOW, 130, 130,
      Color.BLACK, true));
    g2d.fill(new Rectangle2D.Double(90, 10, 70, 70));

    g2d.setPaint(new GradientPaint(170, 10, Color.RED, 200, 200,
      Color.YELLOW, false));
    g2d.fill(new Rectangle2D.Double(170, 10, 70, 70));

    g2d.setPaint(Color.YELLOW);
    g2d.fill(new Rectangle2D.Double(250, 10, 70, 70));

    g2d.setColor(Color.GREEN);
    g2d.fill(new Rectangle2D.Double(330, 10, 70, 70));
  }
}
