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

        //Blue box
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(-0.5, 0.75);
		p2d.lineTo(0.5, 0.75);
		p2d.lineTo(0.5, -0.75);
		p2d.lineTo(-0.5, -0.75);
		p2d.closePath();
		g2d.setPaint(Color.BLUE);
		Shape s = p2d.createTransformedShape(at);
		//g2d.fill(s);

        //Tires
        //Front driver
        RoundRectangle2D.Double rr2d = new RoundRectangle2D.Double(
            -0.4633,
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
		p2d = new Path2D.Double();
        //Left corner, above flames
		p2d.moveTo(-0.31, 0.1533);
		p2d.lineTo(-0.19, 0.19);
		p2d.lineTo(-0.1167, 0.29); //curve?
		p2d.lineTo(-0.09, 0.5567); 
		p2d.lineTo(-0.2267, 0.6533); 
		p2d.lineTo(-0.2267, 0.6967); 
		p2d.lineTo(-0.08, 0.7167); 
		p2d.lineTo(-0.05, 0.9967); 
		p2d.lineTo(0.0, 1.0); 
		p2d.lineTo(0.05, 0.9967); 
		p2d.lineTo(0.08, 0.7167); 
		p2d.lineTo(0.2267, 0.6967); 
		p2d.lineTo(0.2267, 0.6533); 
        p2d.lineTo(0.09, 0.5567); 
		p2d.lineTo(0.1167, 0.29); //curve?
		p2d.lineTo(0.19, 0.19);
        //right corner, above flames
		p2d.lineTo(0.31, 0.1533);
		p2d.lineTo(0.32, -0.0467);
		p2d.lineTo(0.3367, -0.08);
		p2d.lineTo(0.34, -0.3267);
		p2d.lineTo(0.3767, -0.46);
		p2d.lineTo(0.38, -0.5167);
		p2d.lineTo(0.31, -0.566);
		p2d.lineTo(0.27, -0.69);
		p2d.lineTo(0.28, -0.71);
		p2d.lineTo(0.1833, -0.7367);
		p2d.lineTo(0.18, -0.7533);
		p2d.lineTo(0.15, -0.7767);

		p2d.lineTo(-0.15, -0.7767);
		p2d.lineTo(-0.18, -0.7533);
		p2d.lineTo(-0.1833, -0.7367);
		p2d.lineTo(-0.28, -0.71);
        p2d.lineTo(-0.27, -0.69);
		p2d.lineTo(-0.31, -0.566); 
		p2d.lineTo(-0.38, -0.5167);
		p2d.lineTo(-0.3767, -0.46);
		p2d.lineTo(-0.34, -0.3267);
		p2d.lineTo(-0.3367, -0.08);
		p2d.lineTo(-0.32, -0.0467);
		p2d.lineTo(-0.31, 0.1533);

        s = p2d.createTransformedShape(at);
        g2d.setPaint(Color.RED);
		g2d.draw(s);
        g2d.setPaint(Color.BLACK);
		//g2d.fill(s);


        //SPOILER
		p2d = new Path2D.Double();
        //Bottom left, above bump
		p2d.moveTo(-0.3033, -0.9867);
		p2d.lineTo(-0.28, -0.8233);
		p2d.lineTo(-0.28, -0.7867);
		p2d.quadTo(
                -0.2467, -0.7867,
                -0.2667, -0.7867
        );

        //Top right, left of bump
		p2d.lineTo(0.2533, -0.7867);
		p2d.quadTo(
                0.29, -0.7867,
                0.2733, -0.7867
        );
        p2d.lineTo(0.28, -0.8233);
        p2d.lineTo(0.303, -0.9867);
		//right bump
        p2d.quadTo(0.2733, -0.9767,
                0.2933, -0.9733
        );
        //bottom left
        p2d.lineTo(-0.27, -0.9733);
        p2d.quadTo(-0.2733, -0.9767,
                -0.2933, -0.9733
        );
        
		g2d.setPaint(Color.GRAY);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		g2d.setPaint(Color.BLACK);
		g2d.fill(s);

        /*
        //SPOILER inset
		//Note that Rect2d should be drawn from bottom left corner in this implementation
        Rectangle2D.Double r2d = new Rectangle2D.Double(
                -0.2633, -0.9667,
                0.5366, 0.16
                );
        
		g2d.setPaint(Color.GRAY);
		//s = r2d.createTransformedShape(at);
		s = at.createTransformedShape(r2d);
		g2d.fill(s);
        */

        //Rear logo
        Ellipse2D.Double e2d = new Ellipse2D.Double(
            -0.2, -0.9333,
            0.4, 0.11
        );
		g2d.setPaint(Color.GRAY);
		s = at.createTransformedShape(e2d);
		g2d.draw(s);
		g2d.setPaint(Color.WHITE);
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
}
