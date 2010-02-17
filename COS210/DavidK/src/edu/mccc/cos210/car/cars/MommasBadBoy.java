package edu.mccc.cos210.car.cars;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class MommasBadBoy extends Car {

    final private static int PICTURE_WIDTH  = 600;
    final private static int PICTURE_HEIGHT = 313;
    
    final private static double TIRE_WIDTH  = 0.26;
    final private static double TIRE_HEIGHT = 0.29;
    final private static double TIRE_ARC_X  = 0.037;
    final private static double TIRE_ARC_Y  = 0.051;

	protected void paintTop(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("MommasBadBoy:paintTop()");

        //g2d.transform(getGraphicsTransform());

        //Blue box
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(-0.5, 0.75);
		p2d.lineTo(0.5, 0.75);
		p2d.lineTo(0.5, -0.75);
		p2d.lineTo(-0.5, -0.75);
		p2d.closePath();
		g2d.setPaint(Color.BLUE);
		Shape s = p2d.createTransformedShape(at);
		g2d.fill(s);

        //Tires
        //Front driver
        RoundRectangle2D.Double r2d = new RoundRectangle2D.Double(
            -0.8978,
            0.7833,
            TIRE_WIDTH,
            TIRE_HEIGHT,
            TIRE_ARC_X,
            TIRE_ARC_Y
        );
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(r2d);
        g2d.draw(s);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);

        //Front pass
        r2d = new RoundRectangle2D.Double(
            0.5591,
            0.7867,
            TIRE_WIDTH,
            TIRE_HEIGHT,
            TIRE_ARC_X,
            TIRE_ARC_Y
        );
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(r2d);
        g2d.draw(s);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);
        
        //Rear driver
        r2d = new RoundRectangle2D.Double(
            -0.9553,
            -0.4333,
            TIRE_WIDTH,
            TIRE_HEIGHT,
            TIRE_ARC_X,
            TIRE_ARC_Y
        );
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(r2d);
        g2d.draw(s);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);

        //Rear pass
        r2d = new RoundRectangle2D.Double(
            0.6102,
            -0.4333,
            TIRE_WIDTH,
            TIRE_HEIGHT,
            TIRE_ARC_X,
            TIRE_ARC_Y
        );
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(r2d);
        g2d.draw(s);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);

        //Arrow
		p2d = new Path2D.Double();
		p2d.moveTo(0.0, 0.0);
		p2d.lineTo(1.0, 1.0);
		g2d.setPaint(Color.RED);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);

        //Arrow
		p2d = new Path2D.Double();
		p2d.moveTo(0.0, 0.75);
		p2d.lineTo(0.5, 0.5);
		p2d.moveTo(0.0, 0.75);
		p2d.lineTo(-0.5, 0.5);
		p2d.moveTo(0.0, 0.75);
		p2d.lineTo(0.0, -0.75);
		g2d.setPaint(Color.WHITE);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		Ellipse2D origin = new Ellipse2D.Double(-0.025, -0.025, 0.05, 0.05);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(origin);
		g2d.fill(s);
	}
	protected void paintSide(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("MommasBadBoy:paintSide()");
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(-0.75, 0.5);
		p2d.lineTo(0.75, 0.5);
		p2d.lineTo(0.75, 0.0);
		p2d.lineTo(-0.75, 0.0);
		p2d.closePath();
		g2d.setPaint(Color.BLUE);
		Shape s = p2d.createTransformedShape(at);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(0.75, 0.25);
		p2d.lineTo(0.5, 0.5);
		p2d.moveTo(0.75, 0.25);
		p2d.lineTo(0.5, 0.0);
		p2d.moveTo(0.75, 0.25);
		p2d.lineTo(-0.75, 0.25);
		g2d.setPaint(Color.WHITE);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		Ellipse2D origin = new Ellipse2D.Double(-0.025, -0.025, 0.05, 0.05);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(origin);
		g2d.fill(s);
	}
    
    /**
     * Produces
     */
    private AffineTransform getGraphicsTransform(boolean undo) {
        AffineTransform at = new AffineTransform();
        /*
        if (undo) {

        } else {
            final double trans_x = getCenter().getWidth();
            final double trans_y = getCenter().getHeight();
            final double scale_x = 1.0 / (PICTURE_WIDTH  / 2);
            final double scale_y = 1.0 / (PICTURE_HEIGHT / 2);
            try {
                at.translate(
                        trans_x,
                        trans_y
                );
                at.scale(
                        scale_x,
                        scale_y
                );
            } catch (NumberFormatException ex) {

            }
        }
    */
        return at;
    }
}
