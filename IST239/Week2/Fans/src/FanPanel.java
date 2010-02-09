import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;
import java.util.*;

public class FanPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int BLADE_ANGLE = 30;
	private static final int PREFERRED_X = 320;
	private static final int PREFERRED_Y = 320;
	
	public FanPanel() {		
		Dimension preferredSize = new Dimension(PREFERRED_X, PREFERRED_Y);
		setPreferredSize(preferredSize);
		setLayout(new GridLayout(3, 3));		
	}

	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Rectangle2D box = getBoundingBox();

        g.setColor(Color.black);      
        g.drawOval(
                (int) box.getX(),
                (int) box.getY(),
                (int) box.getWidth(),
                (int) box.getHeight()
        );
        for(int start_angle = 0; start_angle < 360; start_angle += 90) {
            g.fillArc(
                 (int) box.getX(),
                 (int) box.getY(),
                 (int) box.getWidth(),
                 (int) box.getHeight(),
                 start_angle,
                 BLADE_ANGLE
             );        
        }
    }
    //Find something that uses ints instead?
    private Rectangle2D.Double getBoundingBox() {
        return new Rectangle2D.Double(
                (getWidth()  * .1),
                (getHeight() * .1),
                (getWidth()  * .8),
                (getHeight() * .8)
        );
    }
}
