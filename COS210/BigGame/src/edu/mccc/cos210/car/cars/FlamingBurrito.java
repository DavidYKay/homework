package edu.mccc.cos210.car.cars;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class FlamingBurrito extends Car {
	protected void paintTop(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("MyCar:paintTop()");

		Ellipse2D x = new Ellipse2D.Double(-0.53, 0.32, 0.16, 0.05);
		Shape s = at.createTransformedShape(x);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		g2d.setPaint(Color.YELLOW);
		g2d.fill(s);

		x = new Ellipse2D.Double(0.36, 0.32, 0.16, 0.05);
		s = at.createTransformedShape(x);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		g2d.setPaint(Color.YELLOW);
		g2d.fill(s);

		Path2D p2d = new Path2D.Double();
		p2d.moveTo(-0.3, 0.95);
		p2d.lineTo(0.3, 0.95);
		p2d.lineTo(0.4, 0.65);
		p2d.lineTo(0.4, -0.55);
		p2d.lineTo(0.3, -0.95);
		p2d.lineTo(-0.3, -0.95);
		p2d.lineTo(-0.4, -0.65);
		p2d.lineTo(-0.4, 0.65);
		p2d.lineTo(-0.3, 0.95);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		g2d.setPaint(Color.YELLOW);
		g2d.fill(s);

		p2d = new Path2D.Double();	//hood
		p2d.moveTo(-0.3, 0.85);
		p2d.lineTo(0.3, 0.85);
		p2d.lineTo(0.4, 0.35);
		p2d.lineTo(-0.4, 0.35);
		p2d.lineTo(-0.3, 0.85);
		p2d.closePath();
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		p2d = new Path2D.Double();	//front window
		p2d.moveTo(-0.4, 0.35);
		p2d.lineTo(0.4, 0.35);
		p2d.lineTo(0.2, 0.05);
		p2d.lineTo(-0.2, 0.05);
		p2d.lineTo(-0.4, 0.35);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		g2d.setPaint(Color.LIGHT_GRAY);
		g2d.fill(s);

		p2d = new Path2D.Double();	//top of car
		p2d.moveTo(-0.25, 0.0);
		p2d.lineTo(0.25, 0.0);
		p2d.lineTo(0.25, -0.2);
		p2d.lineTo(-0.25, -0.2);
		p2d.lineTo(-0.25, 0.0);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.draw(s);

		p2d = new Path2D.Double();	//right window
		p2d.moveTo(0.25, 0.0);
		p2d.lineTo(0.35, 0.15);
		p2d.lineTo(0.35, -0.4);
		p2d.lineTo(0.25, -0.1);
		p2d.lineTo(0.25, 0.0);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		g2d.setPaint(Color.LIGHT_GRAY);
		g2d.fill(s);

		p2d = new Path2D.Double();	//left window
		p2d.moveTo(-0.25, 0.0);
		p2d.lineTo(-0.35, 0.15);
		p2d.lineTo(-0.35, -0.4);
		p2d.lineTo(-0.25, -0.1);
		p2d.lineTo(-0.25, 0.0);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		g2d.setPaint(Color.LIGHT_GRAY);
		g2d.fill(s);



		p2d = new Path2D.Double();	//back window
		p2d.moveTo(-0.25, -0.35);
		p2d.lineTo(0.25, -0.35);
		p2d.lineTo(0.3, -0.75);
		p2d.lineTo(-0.3, -0.75);
		p2d.lineTo(-0.25, -0.35);
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		g2d.setPaint(Color.LIGHT_GRAY);
		g2d.fill(s);

		p2d = new Path2D.Double();	//writing on hood
		p2d.moveTo(-0.25, 0.8);
		p2d.lineTo(0.25, 0.8);
		p2d.lineTo(0.25, 0.72);
		p2d.lineTo(-0.25, 0.72);
		p2d.lineTo(-0.25, 0.8);
		p2d.closePath();
		g2d.setPaint(Color.WHITE);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		p2d = new Path2D.Double();
		p2d.moveTo(0.0, 0.75);
		p2d.lineTo(0.5, 0.5);
		p2d.moveTo(0.0, 0.75);
		p2d.lineTo(-0.5, 0.5);
		p2d.moveTo(0.0, 0.75);
		p2d.lineTo(0.0, -0.75);
		g2d.setPaint(Color.WHITE);
		s = p2d.createTransformedShape(at);
//		g2d.draw(s);
		Ellipse2D origin = new Ellipse2D.Double(-0.025, -0.025, 0.05, 0.05);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(origin);
		g2d.fill(s);
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
//		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(0.75, 0.25);
		p2d.lineTo(0.5, 0.5);
		p2d.moveTo(0.75, 0.25);
		p2d.lineTo(0.5, 0.0);
		p2d.moveTo(0.75, 0.25);
		p2d.lineTo(-0.75, 0.25);
		g2d.setPaint(Color.WHITE);
		s = p2d.createTransformedShape(at);
//		g2d.draw(s);
		Ellipse2D origin = new Ellipse2D.Double(-0.025, -0.025, 0.05, 0.05);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(origin);
		g2d.fill(s);

		p2d = new Path2D.Double();
		p2d.moveTo(-0.88, 0.1);
		p2d.lineTo(0.90, 0.1);
		p2d.lineTo(0.95, 0.15);
		p2d.lineTo(0.95, 0.4);
		p2d.lineTo(0.88, 0.45);
		p2d.lineTo(0.45, 0.5);
		p2d.lineTo(0.3, 0.6);
		p2d.lineTo(-0.3, 0.6);
		p2d.lineTo(-0.8, 0.5);
		p2d.lineTo(-0.90, 0.5);
		p2d.lineTo(-0.95, 0.55);
		p2d.lineTo(-0.95, 0.2);
		p2d.lineTo(-0.88, 0.1);
		p2d.closePath();
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		g2d.setPaint(Color.YELLOW);
		g2d.fill(s);

		Ellipse2D wheel = new Ellipse2D.Double(-0.775, -0.011, 0.3, 0.3);
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(wheel);
		g2d.fill(s);

		wheel = new Ellipse2D.Double(0.475, -0.011, 0.3, 0.3);
		s = at.createTransformedShape(wheel);
		g2d.fill(s);

		p2d = new Path2D.Double();
		p2d.moveTo(-0.9, 0.4);
		p2d.lineTo(0.5, 0.4);
		p2d.lineTo(-0.9, 0.36);
		p2d.lineTo(-0.9, 0.4);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		wheel = new Ellipse2D.Double(-0.750, 0.01, 0.25, 0.25);
		g2d.setPaint(Color.WHITE);
		s = at.createTransformedShape(wheel);
		g2d.draw(s);

		wheel = new Ellipse2D.Double(0.500, 0.01, 0.25, 0.25);
		s = at.createTransformedShape(wheel);
		g2d.draw(s);

		p2d = new Path2D.Double();
		p2d.moveTo(-0.2, 0.55);
		p2d.lineTo(0.2, 0.55);
		p2d.lineTo(0.45, 0.42);
		p2d.lineTo(-0.4, 0.42);
		p2d.lineTo(-0.2, 0.55);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		g2d.setPaint(Color.LIGHT_GRAY);
		g2d.fill(s);
	}
	public void paintShifter(JPanel jp, Graphics2D g2d, int gear, int maxGear) {
		Debug.println("FlamingBurrito:paintShifter()");
		String value = String.valueOf(gear);
		String maxValue = String.valueOf(maxGear);
		int w = SwingUtilities.computeStringWidth(
			g2d.getFontMetrics(),
			value
		);
		g2d.setPaint(new Color(128, 128, 128));
		g2d.drawString(
			value,
			jp.getWidth() / 2 - w / 2,
			jp.getHeight() / 2 + 8
		);
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(50.0, 20.0);
		p2d.lineTo(50.0, 100.0);
		p2d.lineTo(55.0, 100.0);
		p2d.lineTo(55.0, 50.0);
		p2d.lineTo(100.0, 50.0);
		p2d.lineTo(100.0, 100.0);
		p2d.lineTo(105.0, 100.0);
		p2d.lineTo(105.0, 50.0);
		p2d.lineTo(150.0, 50.0);
		p2d.lineTo(150.0, 100.0);
		p2d.lineTo(155.0, 100.0);
		p2d.lineTo(155.0, 20.0);

		p2d.lineTo(150.0, 20.0);
		p2d.lineTo(150.0, 45.0);
		p2d.lineTo(105.0, 45.0);
		p2d.lineTo(105.0, 20.0);
		p2d.lineTo(100.0, 20.0);
		p2d.lineTo(100.0, 45.0);
		p2d.lineTo(55.0, 45.0);
		p2d.lineTo(55.0, 20.0);
		p2d.lineTo(50.0, 20.0);
		p2d.closePath();
		g2d.draw(p2d);
		g2d.fill(p2d);

		if(gear == 1) {
			Ellipse2D shifter = new Ellipse2D.Double(42.5, 15.0, 20.0, 20.0);
			g2d.setPaint(Color.RED);
			g2d.fill(shifter);
		}
		if(gear == 2) {
			Ellipse2D shifter = new Ellipse2D.Double(42.5, 95.0, 20.0, 20.0);
			g2d.setPaint(Color.RED);
			g2d.fill(shifter);
		}
		if(gear == 3) {
			Ellipse2D shifter = new Ellipse2D.Double(92.5, 15.0, 20.0, 20.0);
			g2d.setPaint(Color.RED);
			g2d.fill(shifter);
		}
		if(gear == 4) {
			Ellipse2D shifter = new Ellipse2D.Double(92.5, 95.0, 20.0, 20.0);
			g2d.setPaint(Color.RED);
			g2d.fill(shifter);
		}
		if(gear == 5) {
			Ellipse2D shifter = new Ellipse2D.Double(142.5, 15.0, 20.0, 20.0);
			g2d.setPaint(Color.RED);
			g2d.fill(shifter);
		}
		if(gear == 6) {
			Ellipse2D shifter = new Ellipse2D.Double(142.5, 95.0, 20.0, 20.0);
			g2d.setPaint(Color.RED);
			g2d.fill(shifter);
		}
	}
}
