import java.awt.*;

import javax.swing.*;
import java.util.*;

public class CirclePanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static final double CIRCLE_RADIUS = 100;
	private static final double CIRCLE_RADIUS = 1;
	//private static final double DISTANCE = 300;
	private static final double DISTANCE = 3;
	private static final int PREFERRED_X = 1024;
	private static final int PREFERRED_Y = 768;
	
    private static final int MAX_DISTANCE = 600;

	private static final double ORIGIN_X = PREFERRED_X / 2;
	private static final double ORIGIN_Y = PREFERRED_Y / 2;
	private static final double INITIAL_ANGLE = 3.14;
	
	public CirclePanel() {		
		Dimension preferredSize = new Dimension(PREFERRED_X, PREFERRED_Y);
		setPreferredSize(preferredSize);
	}
	
	private void drawCircles(Graphics g) {
		drawCircle(INITIAL_ANGLE, CIRCLE_RADIUS, DISTANCE, g, 0);
	}
	
	private void drawCircle(double radians, double radCircle, double distance, Graphics g, int counter) {
        setColor(counter, g);
		Graphics2D g2d = (Graphics2D) g.create();
		//Abort if we get too small
		//if (radCircle < 1) { return; }
		//Abort if we get too big
		//if (radCircle > 200) { return; }
		if (distance > MAX_DISTANCE) { return; }
        double rX = Math.cos(radians) * distance;
        double rY = Math.sin(radians) * distance;
        //Center the oval on (x,y)
        double x = (ORIGIN_X - (rX + radCircle) / 2);
        double y = (ORIGIN_Y - (rY + radCircle) / 2);

		//Render the circle
		g.fillOval(
                (int) x,
                (int) y,
                (int) radCircle,
                (int) radCircle);
		//Recurse
		//drawCircle(radians + .3, radCircle * .95, distance * .95, g);
		//drawCircle(radians + .3, radCircle * 1.05, distance * 1.05, g);
		//drawCircle(radians + .4, radCircle + 10, distance + 10, g);
		//drawCircle(radians + .3, radCircle * 1.05, distance * 1.05, g);
		//drawCircle(radians + .3, 50, radians * 10, g);

		//drawCircle(radians + .4, 50, 10 + radians * 20, g, ++counter);

		//drawCircle(radians + .4, 10 + radians * 5, 10 + radians * 20, g, ++counter);

		drawCircle(radians + .6, 10 + radians * 5, 10 + radians * 20, g, ++counter);
	}
    //Archimedean spiral
    //r = a + bθ
    //where R is radius, and theta is angle

    //The logarithmic spiral: 
    //r = abθ; approximations of this are found in nature

	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        g.setColor(Color.black);      
        drawCircles(g);
        drawAxes(g);
    }

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

    private Color[] colors = {
        Color.RED,
        Color.ORANGE,
        Color.YELLOW,
        Color.GREEN,
        Color.BLUE,
        Color.CYAN,
        //Purple
        new Color(0xff, 0x00, 0xff),
        Color.BLACK
    };
    private void setColor(int counter, Graphics g) {
        g.setColor(
            colors[counter % colors.length]
        );
    }
}
