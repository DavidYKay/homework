import java.awt.*;

import javax.swing.*;
import java.util.*;

public class CirclePanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final double CIRCLE_RADIUS = 100;
	private static final double DISTANCE = 300;
	private static final int PREFERRED_X = 1024;
	private static final int PREFERRED_Y = 768;

	private static final double ORIGIN_X = PREFERRED_X / 2;
	private static final double ORIGIN_Y = PREFERRED_Y / 2;
	private static final double INITIAL_ANGLE = 3.14;
	
	public CirclePanel() {		
		Dimension preferredSize = new Dimension(PREFERRED_X, PREFERRED_Y);
		setPreferredSize(preferredSize);
	}
	
	private void drawCircles(Graphics g) {
		drawCircle(INITIAL_ANGLE, CIRCLE_RADIUS, DISTANCE, g);
	}
	
	private void drawCircle(double radians, double radCircle, double distance, Graphics g) {
		//Abort if we get too small
		if (radCircle < 1) { return; }
        double rX = Math.cos(radians) * distance;
        double rY = Math.sin(radians) * distance;
        double x = (ORIGIN_X + (rX + radCircle));
        double y = (ORIGIN_Y + (rY + radCircle));

		//Render the circle
		g.drawOval(
                (int) x,
                (int) y,
                (int) radCircle,
                (int) radCircle);
		//Recurse
		drawCircle(radians + .3, radCircle * .95, distance * .95, g);
	}

	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        g.setColor(Color.black);      
        drawCircles(g);
    }
}
