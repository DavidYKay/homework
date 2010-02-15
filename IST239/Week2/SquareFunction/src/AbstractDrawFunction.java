import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

/** 
 * Abstract class responsible for taking a function f(x) and rendering the 
 * function's output to a Cartesian plot.
 */
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
        //This example assumes a domain of [-100, 100]
        //x is offset by 200 pix, placing items between 100 and 300 pix
        //y axis is at 200 pix
        p.reset();
        for (int x = -100; x <= 100; x++) {
            p.addPoint(x + 200, 200 - (int)f(x));
        }
    }

    /** 
     * paintComponent responsible for drawing axes, labels, and connecting points
     * Won't do anything interesting unless f(x) is implemented 
     */ 
    protected void paintComponent(Graphics g) {
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
        //Add points to the polygon
        drawFunction();
        //Actually draw the polygon
		g.drawPolygon(p);
    }
}
