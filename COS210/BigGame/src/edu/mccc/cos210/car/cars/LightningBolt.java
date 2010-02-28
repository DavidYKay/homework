package edu.mccc.cos210.car.cars;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class LightningBolt extends Car {
	protected void paintTop(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("MyCar:paintTop()");

		// Background
		Path2D p2d = new Path2D.Double();
		//p2d.moveTo(-0.5, 0.75);
		//p2d.lineTo(0.5, 0.75);
		//p2d.lineTo(0.5, -0.75);
		//p2d.lineTo(-0.5, -0.75);
		//p2d.closePath();
		//g2d.setPaint(Color.PINK);
		Shape s = p2d.createTransformedShape(at);
		Rectangle2D r2d = new Rectangle2D.Double();
		Line2D l2d = new Line2D.Double();
		//g2d.fill(s);
		// Grill
		g2d.setPaint(Color.BLACK);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.35, 0.65);
		p2d.lineTo(-0.30, 0.75);
		p2d.lineTo(-0.25, 0.65);
		p2d.lineTo(-0.20, 0.75);
		p2d.lineTo(-0.15, 0.65);
		p2d.lineTo(-0.10, 0.75);
		p2d.lineTo(-0.05, 0.65);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		g2d.draw(s);
		// Grill
		g2d.setPaint(Color.BLACK);
		p2d = new Path2D.Double();
		p2d.moveTo(0.35, 0.65);
		p2d.lineTo(0.30, 0.75);
		p2d.lineTo(0.25, 0.65);
		p2d.lineTo(0.20, 0.75);
		p2d.lineTo(0.15, 0.65);
		p2d.lineTo(0.10, 0.75);
		p2d.lineTo(0.05, 0.65);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		g2d.draw(s);
		// Wheel (Back Right)
		g2d.setPaint(Color.BLACK);
		p2d = new Path2D.Double();
		p2d.moveTo(0.40, -0.275);
		p2d.lineTo(0.45, -0.275);
		p2d.lineTo(0.45, -0.395);
		p2d.lineTo(0.50, -0.425);
		p2d.lineTo(0.45, -0.455);
		p2d.lineTo(0.45, -0.575);
		p2d.lineTo(0.40, -0.575);
		p2d.lineTo(0.40, -0.275);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		g2d.draw(s);
		// Wheel (Front Right)
		g2d.setPaint(Color.BLACK);
		p2d = new Path2D.Double();
		p2d.moveTo(0.40, 0.275);
		p2d.lineTo(0.45, 0.275);
		p2d.lineTo(0.45, 0.395);
		p2d.lineTo(0.50, 0.425);
		p2d.lineTo(0.45, 0.455);
		p2d.lineTo(0.45, 0.575);
		p2d.lineTo(0.40, 0.575);
		p2d.lineTo(0.40, 0.275);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		g2d.draw(s);
		// Wheel (Back Left)
		g2d.setPaint(Color.BLACK);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.40, -0.275);
		p2d.lineTo(-0.45, -0.275);
		p2d.lineTo(-0.45, -0.395);
		p2d.lineTo(-0.50, -0.425);
		p2d.lineTo(-0.45, -0.455);
		p2d.lineTo(-0.45, -0.575);
		p2d.lineTo(-0.40, -0.575);
		p2d.lineTo(-0.40, -0.275);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		g2d.draw(s);
		// Wheel (Front Left)
		g2d.setPaint(Color.BLACK);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.40, 0.275);
		p2d.lineTo(-0.45, 0.275);
		p2d.lineTo(-0.45, 0.395);
		p2d.lineTo(-0.50, 0.425);
		p2d.lineTo(-0.45, 0.455);
		p2d.lineTo(-0.45, 0.575);
		p2d.lineTo(-0.40, 0.575);
		p2d.lineTo(-0.40, 0.275);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		g2d.draw(s);
		// Body
		RoundRectangle2D rr2d = new RoundRectangle2D.Double(
			-0.4,	// Initial X
			-0.67,	// Initial Y
			0.8,	// Width
			1.34,	// Height
			0.1,	// Arc W
			0.1		// Arc H
			);
		s = at.createTransformedShape(rr2d);
		g2d.setPaint(Color.BLUE);
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		// Front Windshield
		g2d.setPaint(Color.BLACK);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.20,  0.20);
		p2d.lineTo(-0.25,  0.40);
		p2d.quadTo( 0.00,  0.44,
					0.25,  0.40);
		p2d.lineTo( 0.20,  0.20);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		g2d.draw(s);
		// Rear Window
		g2d.setPaint(Color.BLACK);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.25, -0.35);
		p2d.lineTo(-0.20, -0.25);
		p2d.lineTo(	0.20, -0.25);
		p2d.lineTo(	0.25, -0.35);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		g2d.draw(s);
		// Jet Engine (left)
		p2d = new Path2D.Double();
		p2d.moveTo(-0.30, -0.65);
		p2d.lineTo(-0.20, -0.75);
		p2d.lineTo(-0.10, -0.75);
		p2d.lineTo(-0.00, -0.65);
		p2d.quadTo(-0.15, -0.15,
				   -0.30, -0.65);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		l2d = new Line2D.Double(-0.075, -0.650,
								-0.100, -0.750);
		s = at.createTransformedShape(l2d);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		l2d = new Line2D.Double(-0.150, -0.650,
								-0.150, -0.750);
		s = at.createTransformedShape(l2d);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		l2d = new Line2D.Double(-0.225, -0.650,
								-0.200, -0.750);
		s = at.createTransformedShape(l2d);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		// Jet Engine (right)
		g2d.setStroke(new BasicStroke(1));
		p2d = new Path2D.Double();
		p2d.moveTo(0.30, -0.65);
		p2d.lineTo(0.20, -0.75);
		p2d.lineTo(0.10, -0.75);
		p2d.lineTo(0.00, -0.65);
		p2d.quadTo(0.15, -0.15,
				   0.30, -0.65);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		l2d = new Line2D.Double(0.075, -0.650,
								0.100, -0.750);
		s = at.createTransformedShape(l2d);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		l2d = new Line2D.Double(0.150, -0.650,
								0.150, -0.750);
		s = at.createTransformedShape(l2d);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		l2d = new Line2D.Double(0.225, -0.650,
								0.200, -0.750);
		s = at.createTransformedShape(l2d);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		// Emblem (sun roof)
		Ellipse2D e2d = new Ellipse2D.Double(-0.090, -0.090,
									  0.180,  0.180);
		s = at.createTransformedShape(e2d);
		g2d.setPaint(Color.BLUE);
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.050, -0.100);
		p2d.lineTo( 0.050,  0.010);
		p2d.lineTo( 0.020,  0.020);
		p2d.lineTo( 0.090,  0.080);
		p2d.lineTo( 0.020,  0.100);
		p2d.lineTo(-0.050,  0.010);
		p2d.lineTo(-0.005, -0.015);
		p2d.lineTo(-0.050, -0.100);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.YELLOW);
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		// Supercharger
		r2d = new Rectangle2D.Double(-0.075,  0.450,
									  0.150,  0.150);
		s = at.createTransformedShape(r2d);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		// Weapon (right)
		g2d.setPaint(Color.BLACK);
		p2d = new Path2D.Double();
		p2d.moveTo(0.275, 0.10);
		p2d.lineTo(0.275, 0.20);
		p2d.quadTo(0.400, 0.15,
				   0.275, 0.10);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		g2d.draw(s);
		p2d = new Path2D.Double();
		p2d.moveTo(0.290, 0.125);
		p2d.lineTo(0.290, 0.500);
		p2d.lineTo(0.310, 0.500);
		p2d.lineTo(0.310, 0.125);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		p2d = new Path2D.Double();
		p2d.moveTo(0.290, 0.500);
		p2d.lineTo(0.275, 0.500);
		p2d.lineTo(0.290, 0.550);
		p2d.lineTo(0.310, 0.550);
		p2d.lineTo(0.325, 0.500);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.RED);
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		// Weapon (left)
		g2d.setPaint(Color.BLACK);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.275, 0.10);
		p2d.lineTo(-0.275, 0.20);
		p2d.quadTo(-0.400, 0.15,
				   -0.275, 0.10);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		g2d.draw(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.290, 0.125);
		p2d.lineTo(-0.290, 0.500);
		p2d.lineTo(-0.310, 0.500);
		p2d.lineTo(-0.310, 0.125);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.290, 0.500);
		p2d.lineTo(-0.275, 0.500);
		p2d.lineTo(-0.290, 0.550);
		p2d.lineTo(-0.310, 0.550);
		p2d.lineTo(-0.325, 0.500);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.RED);
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		//Details
		l2d = new Line2D.Double(-0.250, -0.350,
								-0.250,  0.400);
		s = at.createTransformedShape(l2d);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		l2d = new Line2D.Double(0.250, -0.350,
								0.250,  0.400);
		s = at.createTransformedShape(l2d);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		l2d = new Line2D.Double(-0.150, 0.670,
								-0.250, 0.400);
		s = at.createTransformedShape(l2d);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		l2d = new Line2D.Double(0.150,  0.670,
								0.250,  0.400);
		s = at.createTransformedShape(l2d);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		l2d = new Line2D.Double(0.30, -0.65,
								-0.30, -0.65);
		s = at.createTransformedShape(l2d);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		l2d = new Line2D.Double( 0.200, -0.250,
								 0.200,  0.200);
		s = at.createTransformedShape(l2d);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		l2d = new Line2D.Double(-0.200, -0.250,
								-0.200,  0.200);
		s = at.createTransformedShape(l2d);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
	}
	protected void paintSide(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("MyCar:paintSide()");
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
		// Origin
		Ellipse2D origin = new Ellipse2D.Double(-0.025, -0.025, 0.05, 0.05);
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(origin);
		g2d.draw(s);
	}
}
