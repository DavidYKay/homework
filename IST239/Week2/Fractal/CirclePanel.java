import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * JPanel that draws a basic fractal, in the form of a spiral of circles.
 * Here are two common spiral algorithms:
 * Archimedean spiral (Dreamcast logo):
 *     r = a + bθ
 *     where R is radius, and theta is angle
 * The logarithmic spiral (Nautilus shell): 
 *     r = abθ; approximations of this are found in nature
 *
 *  This program implements the 'Archimedean spiral'
 */
public class CirclePanel extends JPanel {

    /** Baseline radius of a circle */
	private static final double CIRCLE_RADIUS = 1;
    /** Preferred Resolution */
	private static final int PREFERRED_X = 1024;
	private static final int PREFERRED_Y = 768;
	
    /** Render circles until they get this far away from the center */
    private static final int MAX_DISTANCE = 600;

    /** The effective center of the display  */
	private static final double ORIGIN_X = PREFERRED_X / 2;
	private static final double ORIGIN_Y = PREFERRED_Y / 2;
    /** Angle, in radians, of first circle from center */
	private static final double INITIAL_ANGLE = 0;

    private static final Color[] COLORS = {
        Color.RED,
        Color.ORANGE,
        Color.YELLOW,
        Color.GREEN,
        Color.BLUE,
        Color.CYAN,
        //Purple
        new Color(0xff, 0x00, 0xff),
    };
	
	public CirclePanel() {		
		Dimension preferredSize = new Dimension(PREFERRED_X, PREFERRED_Y);
		setPreferredSize(preferredSize);
	}
	
	private void drawCircle(double radians, Graphics g, int counter) {
        setColor(counter, g);

        //Calculate new values
        double radCircle = CIRCLE_RADIUS + radians * 5;
        double distance  = CIRCLE_RADIUS + radians * 30;

		//Abort if we get too big/too far
		if (distance > MAX_DISTANCE) { return; }

        double rX = Math.cos(radians) * distance;
        double rY = Math.sin(radians) * distance;
        //Center the circle on (x,y)
        double x = (ORIGIN_X - (rX + radCircle) / 2);
        double y = (ORIGIN_Y - (rY + radCircle) / 2);

		//Render the circle
		g.fillOval(
                (int) x,
                (int) y,
                (int) radCircle,
                (int) radCircle);

		//Recurse
        drawCircle(
                radians + .6,
                g,
                ++counter);
    }

	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);      
        drawAxes(g);
		drawCircle(INITIAL_ANGLE, g, 0);
    }

    /**
     * Draws X/Y Axes at 1/2 X and 1/2 Y, mainly for reference
     */
    private void drawAxes(Graphics g) {
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
    }

    /**
     * Changes the current Graphics Color by rotating through the array of colors
     */
    private void setColor(int counter, Graphics g) {
        g.setColor(
            COLORS[counter % COLORS.length]
        );
    }
}
