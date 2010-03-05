package edu.mccc.cos210.car.cars;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class BoneCrusher extends Car {
	protected void paintTop(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("MyCar:paintTop()");

		Path2D body = new Path2D.Double();
		body.moveTo(-0.4, 1.25);
		body.lineTo(0.4, 1.25);
		body.lineTo(0.5, 1.10);
		body.lineTo(0.5, -1.15);
		body.lineTo(0.4, -1.25);
		body.lineTo(-0.4, -1.25);
		body.lineTo(-0.5, -1.15);
		body.lineTo(-0.5, 1.10);
		body.closePath();
		g2d.setPaint(Color.RED);
		Shape b = body.createTransformedShape(at);
		g2d.fill(b);

		Path2D winds = new Path2D.Double();
		winds.moveTo(-0.4, 0.5);
		winds.lineTo(-0.35, 0.55);
		winds.lineTo(0.0, .60);
		winds.lineTo(0.35, 0.55);
		winds.lineTo(0.4, 0.5);
		winds.lineTo(0.33, 0.0);
		winds.lineTo(-0.33, 0.0);
		winds.closePath();
		g2d.setPaint(Color.BLACK);
		Shape ws = winds.createTransformedShape(at);
		g2d.fill(ws);

		Path2D lwin = new Path2D.Double();
		lwin.moveTo(-0.45, 0.45);
		lwin.lineTo(-0.43, 0.45);
		lwin.lineTo(-.35, -.05);
		lwin.lineTo(-.35, -.5);
		lwin.lineTo(-0.43, -0.95);
		lwin.lineTo(-0.45, -0.95);
		lwin.closePath();
		g2d.setPaint(Color.BLACK);
		Shape lw = lwin	.createTransformedShape(at);
		g2d.fill(lw);			

		Path2D rwin = new Path2D.Double();
		rwin.moveTo(0.45, 0.45);
		rwin.lineTo(0.43, 0.45);
		rwin.lineTo(.35, -.05);
		rwin.lineTo(.35, -.5);
		rwin.lineTo(0.43, -0.95);
		rwin.lineTo(0.45, -0.95);
		rwin.closePath();
		g2d.setPaint(Color.BLACK);
		Shape rw = rwin	.createTransformedShape(at);
		g2d.fill(rw);

		Path2D rears = new Path2D.Double();
		rears.moveTo(-.35, -.75);
		rears.lineTo(.35, -.75);
		rears.lineTo(.45, -1.05);
		rears.lineTo(-.45, -1.05);
		rears.closePath();
		g2d.setPaint(Color.BLACK);
		Shape rs = rears.createTransformedShape(at);
		g2d.fill(rs);

		Ellipse2D origin = new Ellipse2D.Double(-0.025, -0.025, 0.05, 0.05);
		g2d.setPaint(Color.BLUE);
		Shape s = at.createTransformedShape(origin);
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
