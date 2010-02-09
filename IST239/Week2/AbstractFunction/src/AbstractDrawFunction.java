import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

public abstract class AbstractDrawFunction extends JPanel {

    /** Polygon to hold the points */
    private Polygon p = new Polygon();

    protected AbstractDrawFunction () {
        drawFunction();
        
        setPreferredSize(new Dimension(640, 480));
    }

    /** Return y coordinate */
    abstract double f(double x);

    /** Obtain points for x-coordinates 100 .. 300 */
    public void drawFunction() {
        for (int x = -100; x <= 100; x++) {
            p.addPoint(x + 200, 200 - (int)f(x));
        }
    }

    /** Implement paintComponent to draw axes, labels, and
     *   connecting points
     */ 
    protected void paintComponent(Graphics g) {
        //to be completed by you
		//X Axis
		g.drawLine(
			0,
			getHeight() / 2,
			getWidth(),
			getHeight() / 2
		);
		//Y Axis
		g.drawLine(
			getWidth() / 2,
			0,
			getWidth() / 2,
			getHeight()
		);
		makePolygon(g);
		g.drawPolygon(p);
    }

	private void makePolygon(Graphics g) {
		double scaleFactor = 0.1;
		for (int x = -100; x<= 100; x++) {
			p.addPoint(x + 200, 200 - (int)(scaleFactor * x));
		}
	}
}
