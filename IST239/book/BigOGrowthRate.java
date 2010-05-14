import java.awt.*;
import javax.swing.*;

public class BigOGrowthRate extends JFrame {
  public BigOGrowthRate() {
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(new DrawSine(), BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    BigOGrowthRate frame = new BigOGrowthRate();
    frame.setSize(400, 300);
    frame.setTitle("BigOGrowthRate");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  // Inner class
  class DrawSine extends JPanel {
    double f(double x) {
      return x * Math.log10(x);
    }

    // Draw the function
    public void drawFunction() {
      repaint();
    }

    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      g.drawLine(10, 100, 380, 100);
      g.drawLine(200, 30, 200, 190);

      // Draw arrows
      g.drawLine(380, 100, 370, 90);
      g.drawLine(380, 100, 370, 110);
      g.drawLine(200, 30, 190, 40);
      g.drawLine(200, 30, 210, 40);

      // Draw x, y axises
      g.drawString("X", 360, 80);
      g.drawString("Y", 220, 40);

      // Draw function
      Polygon p = new Polygon();

      int y = 300;
      for (int x = 10; x <= 600; x++) {
        p.addPoint(x, y - (int)f(x * 100) / 1000);
      }
      g.drawPolyline(p.xpoints, p.ypoints, p.npoints);


      g.drawString("-2\u03c0", 95, 115);
      g.drawString("2\u03c0", 305, 115);
      g.drawString("0", 200, 115);
    }
  }
}
