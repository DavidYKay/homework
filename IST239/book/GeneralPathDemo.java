import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class GeneralPathDemo extends JApplet {
  public GeneralPathDemo() {
    add(new ShapePanel4());
  }

  /** Main method */
  public static void main(String[] args) {
    GeneralPathDemo applet = new GeneralPathDemo();
    applet.init();
    applet.start();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("GeneralPathDemo");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setSize(400, 200);
    frame.setVisible(true);
  }
}

class ShapePanel4 extends JPanel {
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D)g;
    GeneralPath generalPath = new GeneralPath();
    generalPath.moveTo(10, 10); // Set the initial point at (10, 10)
    generalPath.lineTo(100, 10); // Draw a line to (100, 10)
    generalPath.lineTo(55, 90); // Draw a line to (55, 90)
    generalPath.closePath(); // Close the path

    g2d.translate(10, 100);
    Rectangle2D box = new Rectangle2D.Double(10, 10, 100, 100);
    g2d.draw(box); // Draw the general path
    g2d.draw(generalPath); // Draw the general path
  }
}
