import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class FanPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	/** Angle of a fan blade's arc, its slice of the pie */
	private static final int BLADE_ANGLE = 30;
	private static final int PREFERRED_X = 320;
	private static final int PREFERRED_Y = 320;

    private int currentAngle = 20;

	public FanPanel() {		
		Dimension preferredSize = new Dimension(PREFERRED_X, PREFERRED_Y);
		setPreferredSize(preferredSize);		
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Bounding box that holds the fan
		Rectangle2D box = getBoundingBox();
		g.setColor(Color.black);      
		//Draw the fan's perimeter
		g.drawOval(
				(int) box.getX(),
				(int) box.getY(),
				(int) box.getWidth(),
				(int) box.getHeight()
		);
		//Draw four fan blades
		for(int startAngle = currentAngle; startAngle < 360 + currentAngle; startAngle += 90) {
			g.fillArc(
					(int) box.getX(),
					(int) box.getY(),
					(int) box.getWidth(),
					(int) box.getHeight(),
					startAngle,
					BLADE_ANGLE
			);        
		}
	}

	/**
	 * Returns the bounding box for a fan
	 *
	 * Note: Find something that uses ints insteadof doubles?
	 */
	private Rectangle2D.Double getBoundingBox() {
		return new Rectangle2D.Double(
				(getWidth()  * .1),
				(getHeight() * .1),
				(getWidth()  * .8),
				(getHeight() * .8)
		);
	}

    public void setCurrentAngle(int angle) {
        this.currentAngle = angle;
        repaint();
    }
    public int getCurrentAngle() {
        return this.currentAngle;
    }
}
