package edu.mccc.cos210.car.cars;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class BeepBeep extends Car {
	protected void paintTop(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("MyCar:paintTop()");
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(-0.5, 0.90);
		p2d.lineTo(-0.15, 1.10);
		p2d.lineTo(0.15, 1.10);
		p2d.lineTo(0.5, 0.90);

		p2d.lineTo(0.5, -0.80);
		p2d.lineTo(0.4, -1.0);
		p2d.lineTo(-0.4, -1.0);
		p2d.lineTo(-0.5, -0.80);	
	
		p2d.closePath();
		g2d.setPaint(Color.YELLOW);
		Shape s = p2d.createTransformedShape(at);
		g2d.fill(s);
		//Front Window
		p2d = new Path2D.Double();
		p2d.moveTo(-0.4, 0.60);
		p2d.lineTo(0.4, 0.60);
		p2d.lineTo(0.35, 0.20);
		p2d.lineTo(-0.35, 0.20);
	
	
		p2d.closePath();
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		//Rear Window
		p2d = new Path2D.Double();
		p2d.moveTo(-0.35, -0.60);
		p2d.lineTo(0.35, -0.60);
		p2d.lineTo(0.40, -0.80);
		p2d.lineTo(-0.40, -0.80);

		p2d.closePath();
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		//Side Windows
		p2d = new Path2D.Double();
		p2d.moveTo(-0.48, 0.40);
		p2d.lineTo(-0.37, 0.20);
		p2d.lineTo(-0.37, -0.20);
		p2d.lineTo(-0.48, -0.20);

		p2d.closePath();
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		p2d = new Path2D.Double();
		p2d.moveTo(0.48, 0.40);
		p2d.lineTo(0.37, 0.20);
		p2d.lineTo(0.37, -0.20);
		p2d.lineTo(0.48, -0.20);

		p2d.closePath();
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		p2d = new Path2D.Double();
		p2d.moveTo(-0.48, -0.30);
		p2d.lineTo(-0.37, -0.30);
		p2d.lineTo(-0.37, -0.50);
		p2d.lineTo(-0.48, -0.60);

		p2d.closePath();
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		p2d = new Path2D.Double();
		p2d.moveTo(0.48, -0.30);
		p2d.lineTo(0.37, -0.30);
		p2d.lineTo(0.37, -0.50);
		p2d.lineTo(0.48, -0.60);

		p2d.closePath();
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		//Outline
		p2d = new Path2D.Double();
		p2d.moveTo(-0.40, 0.95);
		p2d.lineTo(-0.40, 0.6);
		p2d.lineTo(-0.35, 0.2);
		p2d.lineTo(-0.35, -0.60);
		p2d.lineTo(-0.40, -0.80);
		p2d.lineTo(-0.40, -1.00);
		p2d.moveTo(0.40, 0.95);
		p2d.lineTo(0.40, 0.6);
		p2d.lineTo(0.35, 0.2);
		p2d.lineTo(0.35, -0.60);
		p2d.lineTo(0.40, -0.80);
		p2d.lineTo(0.40, -1.00);

		p2d.moveTo(-0.40, 0.6);
		p2d.lineTo(-0.15, 1.10);

		p2d.moveTo(0.40, 0.6);
		p2d.lineTo(0.15, 1.10);

		g2d.setPaint(Color.GRAY);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);


		Ellipse2D origin = new Ellipse2D.Double(-0.025, -0.025, 0.05, 0.05);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(origin);
		g2d.fill(s);
	}
	protected void paintSide(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("MyCar:paintSide()");
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(0.15, 0.65);
		p2d.lineTo(0.45, .40);
		p2d.lineTo(1.0, .40);
		p2d.lineTo(1.1, 0.05);

		p2d.lineTo(-1.0, 0.05);
		p2d.lineTo(-0.9, 0.40);
		p2d.lineTo(-0.7, .40);
		p2d.lineTo(-0.6, 0.65);	
	
		p2d.closePath();
		g2d.setPaint(Color.YELLOW);
		Shape s = p2d.createTransformedShape(at);
		g2d.fill(s);

		//front side window
		p2d = new Path2D.Double();
		p2d.moveTo(-0.2, 0.60);
		p2d.lineTo(0.1, 0.60);
		p2d.lineTo(0.35, 0.40);
		p2d.lineTo(-0.2, 0.40);

		p2d.closePath();
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);


		//rear side window
		p2d = new Path2D.Double();
		p2d.moveTo(-0.5, 0.60);
		p2d.lineTo(-0.3, 0.60);
		p2d.lineTo(-0.3, 0.40);
		p2d.lineTo(-0.6, 0.40);

		p2d.closePath();
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		//Door Outline
		p2d = new Path2D.Double();
		p2d.moveTo(-0.25, 0.625);
		p2d.lineTo(0.1, 0.625);
		p2d.lineTo(0.4, 0.40);
		p2d.lineTo(0.4, 0.05);
		p2d.lineTo(-0.25, 0.05);
		p2d.closePath();
		g2d.setPaint(Color.GRAY);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);

		//Logo
		//g2d.drawString("Get" , 0.0, 0.3);

		//HeadLight
		p2d = new Path2D.Double();
		p2d.moveTo(0.9, 0.40);
		p2d.lineTo(1.0, 0.40);
		p2d.lineTo(1.04, 0.25);
		p2d.lineTo(0.9, 0.25);
		p2d.closePath();
		g2d.setPaint(Color.WHITE);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		//TailLight
		p2d = new Path2D.Double();
		p2d.moveTo(-0.85, 0.40);
		p2d.lineTo(-0.9, 0.40);
		p2d.lineTo(-0.95, 0.2);
		p2d.lineTo(-0.85, 0.2);
		p2d.closePath();
		g2d.setPaint(Color.RED);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		//Front Tire
		p2d = new Path2D.Double();
		p2d.moveTo(-0.45, 0.05);
		p2d.curveTo( -.45, .05, -.65, .6, -.85, .05);
		p2d.closePath();
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		Ellipse2D FT= new Ellipse2D.Double(-0.785, 0.0, 0.275, 0.275);
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(FT);
		g2d.fill(s);

		FT= new Ellipse2D.Double(-0.7575, 0.025, 0.225, 0.225);
		g2d.setPaint(Color.WHITE);
		s = at.createTransformedShape(FT);
		g2d.fill(s);


		FT= new Ellipse2D.Double(-0.7, 0.08, 0.1, 0.1);
		g2d.setPaint(Color.GRAY);
		s = at.createTransformedShape(FT);
		g2d.fill(s);

		//Rear Tire
		p2d = new Path2D.Double();
		p2d.moveTo(0.95, 0.05);
		p2d.curveTo( .95, .05, .75, .6, .55, .05);
		p2d.closePath();
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		Ellipse2D RT= new Ellipse2D.Double(0.6175, 0.0, 0.275, 0.275);
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(RT);
		g2d.fill(s);

		RT= new Ellipse2D.Double(0.64, 0.025, 0.225, 0.225);
		g2d.setPaint(Color.WHITE);
		s = at.createTransformedShape(RT);
		g2d.fill(s);


		RT= new Ellipse2D.Double(0.7, 0.08, 0.1, 0.1);
		g2d.setPaint(Color.GRAY);
		s = at.createTransformedShape(RT);
		g2d.fill(s);

		Ellipse2D origin = new Ellipse2D.Double(-0.025, -0.025, 0.05, 0.05);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(origin);
		g2d.fill(s);
	}
	public void paintShifter(JPanel jp, Graphics2D g2d, int gear, int maxGear) {
	}
}
