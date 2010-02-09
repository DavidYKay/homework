import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

public abstract class AbstractDrawFunction extends JPanel {

    /** Polygon to hold the points */
    private Polygon p = new Polygon();

    protected AbstractDrawFunction () {
        
        setPreferredSize(new Dimension(640, 480));
    }

    /** Return y coordinate */
    abstract double f(double x);

    /** Obtain points for x-coordinates 100 .. 300 */
    public void drawFunction() {
//        int domain = getWidth();
//        int range  = getHeight();

        //This example assumes domain 200
        //x is offset by 200, placing items between 100 and 300
        //y axis is at 200 pix
        //range =
        p.reset();
        for (int x = -100; x <= 100; x++) {
            p.addPoint(x + 200, 200 - (int)f(x));
        }

        //range = width
    }

    /** Implement paintComponent to draw axes, labels, and
     *   connecting points
     */ 
    protected void paintComponent(Graphics g) {
        drawFunction();
        //to be completed by you
		////X Axis
		//g.drawLine(
		//	0,
		//	getHeight() / 2,
		//	getWidth(),
		//	getHeight() / 2
		//);
		////Y Axis
		//g.drawLine(
		//	getWidth() / 2,
		//	0,
		//	getWidth() / 2,
		//	getHeight()
		//);
		//X Axis
		g.drawLine(
			0,
			200,
			getWidth(),
			200
		);
		//Y Axis
		g.drawLine(
			200,
			0,
			200,
			getHeight()
		);
		//makePolyline(g);
		g.drawPolygon(p);
    }

	private void makePolyline(Graphics g) {
		int[] yPoints = null;
		int[] xPoints = null;
		for (int x = -100; x<= 100; x++) {          
			xPoints[x] = x + 200;
			yPoints[x] = 200 - (int)(x);
		}
	}
}
