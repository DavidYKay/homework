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
        RoundRectangle2D.Double rr2d = new RoundRectangle2D.Double(
            //-0.8978,
            //0.7833,
            //-0.8978,
            //0.5910,
            //-0.9433,
            //0.7833,
            -0.46,
            0.7833,
            TIRE_WIDTH,
            TIRE_HEIGHT,
            TIRE_ARC_X,
            TIRE_ARC_Y
        );
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(rr2d);
        g2d.draw(s);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);

        //Front pass
        rr2d = new RoundRectangle2D.Double(
            //0.5591,
            //0.7867,
            //0.57188,
            //0.5911,
            //-0.1767,
            //0.7833,
            0.2967,
            0.7833,
            TIRE_WIDTH,
            TIRE_HEIGHT,
            TIRE_ARC_X,
            TIRE_ARC_Y
        );
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(rr2d);
        g2d.draw(s);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);
        
        //Rear driver
        rr2d = new RoundRectangle2D.Double(
            //-0.9553,
            //-0.4333,
            //-0.9617,
            //-1.767,
            //-0.9617,
            //-1.767,
            //-0.9617,
            //-1.767,
            -0.52,
            -0.4333,
            TIRE_WIDTH,
            TIRE_HEIGHT,
            TIRE_ARC_X,
            TIRE_ARC_Y
        );
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(rr2d);
        g2d.draw(s);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);

        //Rear pass
        rr2d = new RoundRectangle2D.Double(
            //0.6102,
            //-0.4333,
            //0.6230,
            //-1.767,
            0.3133,
            -0.4333,
            TIRE_WIDTH,
            TIRE_HEIGHT,
            TIRE_ARC_X,
            TIRE_ARC_Y
        );
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(rr2d);
        g2d.draw(s);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);

        //TRIM
        /*
		p2d = new Path2D.Double();
        //Left side, corner just below axel
		p2d.moveTo(-0.4823, 0.6133);
		p2d.lineTo(-0.4760, 0.7133);
        p2d.quadTo(-0.4569, 0.7267, -0.4569, 0.7167);
		p2d.lineTo(-0.3546, 0.7333);
		p2d.lineTo(-0.3546, 0.77);
		p2d.lineTo(-0.2843, 0.77);
		p2d.lineTo(-0.1949, 0.7733);
		p2d.lineTo(-0.1438, 0.8067);
		
		s = p2d.createTransformedShape(at);
        g2d.setPaint(Color.RED);
		g2d.draw(s);
        g2d.setPaint(Color.BLACK);
		g2d.fill(s);
        */

        //BODY

        //SPOILER OLD
		//p2d = new Path2D.Double();
        ////Bottom left, above bump
		//p2d.moveTo(-0.5847, -0.9833);
		//p2d.lineTo(-0.5399, -0.82);
		//p2d.lineTo(-0.5463, -0.7867);
		//p2d.lineTo(-0.5272, -0.7733);
		//p2d.lineTo(-0.4824, -0.7833);
        ////Top right, left of bump
		//p2d.lineTo(0.4824, -0.7833);
		//p2d.lineTo(0.5272, -0.7733);
		//p2d.lineTo(0.5463, -0.7867);
		//p2d.lineTo(0.5399, -0.82);
		//p2d.lineTo(0.5847, -0.9833);
		////right bump
        //p2d.lineTo(0.5718, -0.9933);
        //p2d.lineTo(0.5208, -0.9767);
        //p2d.lineTo(-0.5208, -0.9767);
		//p2d.lineTo(-0.5847, -0.9833);
        //
		//g2d.setPaint(Color.BLACK);
		//s = p2d.createTransformedShape(at);
		//g2d.draw(s);

        //SPOILER NEW
		//p2d = new Path2D.Double();
        Rectangle2D.Double r2d = new Rectangle2D.Double(
                -0.2633, -0.8033,
                0.5366, 0.16
                );
        
		g2d.setPaint(Color.BLACK);
		//s = r2d.createTransformedShape(at);
		s = at.createTransformedShape(r2d);
		g2d.fill(s);

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
