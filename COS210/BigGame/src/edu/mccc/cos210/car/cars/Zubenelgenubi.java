package edu.mccc.cos210.car.cars;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class Zubenelgenubi extends Car {
	protected void paintTop(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("MyCar:paintTop()");
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(-0.5, 1.2);
		p2d.curveTo(
			-0.5,
			1.4,
			0.5,
			1.4,
			0.5,
			1.2
		);
		p2d.lineTo(0.5, -1.3529);
		p2d.lineTo(-0.5, -1.3529);
		p2d.closePath();
		g2d.setPaint(Color.WHITE);
		Shape s = p2d.createTransformedShape(at);
		g2d.fill(s);

		//Windshield
		p2d = new Path2D.Double();
		p2d.moveTo(-0.4, 0.6129);
		p2d.curveTo(
			-0.25,
			0.8029,
			0.25,
			0.8029,
			0.4,
			0.6129
		);
		p2d.lineTo(0.3194, 0.3);
		p2d.curveTo(
			0.15,
			0.4,
			-0.15,
			0.4,
			-0.3194,
			0.3
		);
		p2d.closePath();
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		//Right-side windows
		p2d = new Path2D.Double();
		p2d.moveTo(0.35, 0.2 + 0.05);
		p2d.lineTo(0.42, 0.4273 + 0.05);
		p2d.lineTo(0.42, 0 + .05);
		p2d.lineTo(0.35, 0 + 0.05);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		p2d = new Path2D.Double();
		p2d.moveTo(0.35, -0.07 + 0.05);
		p2d.lineTo(0.42, -0.07 + 0.05);
		p2d.lineTo(0.42, -0.27 + 0.05);
		p2d.lineTo(0.35, -0.27 + 0.05);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		//Left-side Windows
		p2d = new Path2D.Double();
		p2d.moveTo(-0.35, 0.2 + 0.05);
		p2d.lineTo(-0.42, .4273 + 0.05);
		p2d.lineTo(-0.42, 0 + 0.05);
		p2d.lineTo(-0.35, 0 + 0.05);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		p2d = new Path2D.Double();
		p2d.moveTo(-0.35, -0.07 + 0.05);
		p2d.lineTo(-0.42, -0.07 + 0.05);
		p2d.lineTo(-0.42, -0.27 + 0.05);
		p2d.lineTo(-0.35, -0.27 + 0.05);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		//rear window
		p2d = new Path2D.Double();
		p2d.moveTo(0.42,-0.37);
		p2d.lineTo(-0.42, -0.37);
		p2d.lineTo(-0.3, -0.35);
		p2d.lineTo(0.3, -0.35);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		//flatbed
		p2d = new Path2D.Double();
		p2d.moveTo(0.42, -0.42);
		p2d.lineTo(0.42, -1.25);
		p2d.lineTo(-0.42, -1.25);
		p2d.lineTo(-0.42, -0.42);
		p2d.closePath();
		g2d.setPaint(new Color(200, 200, 200));
		s = p2d.createTransformedShape(at);
		g2d.draw(s);

		//hood
		p2d = new Path2D.Double();
		p2d.moveTo(-0.4, 0.615);
		p2d.lineTo(-0.4, 1.15);
		p2d.moveTo(0.4, 0.615);
		p2d.lineTo(0.4, 1.15);
		p2d.moveTo(-0.28, 1.2);
		p2d.lineTo(-0.35, 0.7);
		p2d.moveTo(0.28, 1.2);
		p2d.lineTo(0.35, 0.7);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		
		//right side view mirror
		p2d = new Path2D.Double();
		p2d.moveTo(0.42, 0.4773);
		p2d.lineTo(0.55, 0.4773);
		p2d.lineTo(0.55, 0.55);
		p2d.lineTo(0.42, 0.58);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		g2d.setPaint(Color.WHITE);
		g2d.fill(s);

		//left side view mirror
		p2d = new Path2D.Double();
		p2d.moveTo(-0.42, 0.4773);
		p2d.lineTo(-0.55, 0.4773);
		p2d.lineTo(-0.55, 0.55);
		p2d.lineTo(-0.42, 0.58);
		g2d.setPaint(new Color(200, 200, 200));
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		g2d.setPaint(Color.WHITE);
		g2d.fill(s);

		//right wheel well
		p2d = new Path2D.Double();
		p2d.moveTo(0.42, -0.55);
		p2d.lineTo(0.3, -0.55);
		p2d.curveTo(
			.25,
			-0.55,
			.25,
			-0.9,
			.3,
			-0.9
		);
		p2d.lineTo(0.42, -0.9);
		s = p2d.createTransformedShape(at);
		g2d.setPaint(new Color(200, 200, 200));
		g2d.draw(s);

		//left wheel well
		p2d = new Path2D.Double();
		p2d.moveTo(-0.42, -0.55);
		p2d.lineTo(-0.3, -0.55);
		p2d.curveTo(
			-0.25,
			-0.55,
			-0.25,
			-0.9,
			-0.3,
			-0.9
		);
		p2d.lineTo(-0.42, -0.9);
		s = p2d.createTransformedShape(at);
		g2d.setPaint(new Color(200, 200, 200));
		g2d.draw(s);

		//right headlight
		p2d = new Path2D.Double();
		p2d.moveTo(0.45, 1.15);
		p2d.quadTo(
			0.4,
			1.22,
			0.3,
			1.22
		);
		p2d.lineTo(0.3, 1.21);
		p2d.quadTo(
			0.4,
			1.19,
			0.42,
			1.15
		);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.setPaint(new Color(100, 100, 100));
		g2d.fill(s);

		//left headlight
		p2d = new Path2D.Double();
		p2d.moveTo(-0.45, 1.15);
		p2d.quadTo(
			-0.4,
			1.22,
			-0.3,
			1.22
		);
		p2d.lineTo(-0.3, 1.21);
		p2d.quadTo(
			-0.4,
			1.19,
			-0.42,
			1.15
		);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.setPaint(new Color(100, 100, 100));
		g2d.fill(s);

		//grill
		p2d = new Path2D.Double();
		p2d.moveTo(0.28, 1.22);
		p2d.lineTo(0.25, 1.26);
		p2d.lineTo(-0.25, 1.26);
		p2d.lineTo(-0.28, 1.22);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.BLACK);
		g2d.fill(s);

		Ellipse2D origin = new Ellipse2D.Double(-0.025, -0.025, 0.05, 0.05);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(origin);
		g2d.fill(s);
	}
	protected void paintSide(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("MyCar:paintSide()");
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(-1.3529, 0.7305);
		p2d.lineTo(-0.2372, 0.7305);
		p2d.lineTo(-0.23, 0.9961);
		p2d.lineTo(0.4 -0.1, 0.9961);
		p2d.quadTo(
			0.5 - 0.1,
			0.9961,
			0.56 - 0.1,
			0.95
		);
		p2d.lineTo(0.7, 0.7305);
		p2d.quadTo(
			1,
			0.7305,
			1.25,
			0.65
		);
		p2d.quadTo(
			1.3,
			0.65,
			1.34,
			0.4
		);
		p2d.lineTo(1.3529, 0.1992);
		p2d.lineTo(1.14, 0.1992);
		p2d.curveTo(
			1.14,
			0.55,
			.7,
			0.55,
			.7,
			0.1992
		);
		p2d.lineTo(-0.5, 0.1992);
		p2d.curveTo(
			-0.5,
			0.55,
			-0.94,
			0.55,
			-0.94,
			0.1992
		);
		p2d.lineTo(-1.3529, 0.1992);
		p2d.closePath();
		g2d.setPaint(Color.WHITE);
		Shape s = p2d.createTransformedShape(at);
		g2d.fill(s);

		//windows
		p2d = new Path2D.Double();
		p2d.moveTo(-0.12, 0.92);
		p2d.lineTo(0, 0.92);
		p2d.lineTo(0, 0.7305);
		p2d.lineTo(-0.12, 0.7305);
		p2d.closePath();
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		p2d = new Path2D.Double();
		p2d.moveTo(0.1, 0.92);
		p2d.curveTo(
			0.4,
			0.92,
			0.4,
			0.92,
			0.53,
			0.78
		);
		p2d.lineTo(0.53, 0.69);
		p2d.lineTo(0.4 - 0.01, 0.69);
		p2d.lineTo(0.3595 - 0.01, 0.7305);
		p2d.lineTo(0.1, 0.7305);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		p2d = new Path2D.Double();
		p2d.moveTo(0.4, 0.95);
		p2d.lineTo(0.46, 0.95);
		p2d.lineTo(0.7, 0.7305);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		//side view mirror
		p2d = new Path2D.Double();
		p2d.moveTo(0.53, 0.78);
		p2d.lineTo(0.59, 0.78);
		p2d.lineTo(0.59, 0.69);
		p2d.lineTo(0.53, 0.69);
		p2d.closePath();
		g2d.setPaint(Color.LIGHT_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		p2d = new Path2D.Double();
		p2d.moveTo(0.54, 0.77);
		p2d.lineTo(0.57, 0.77);
		p2d.lineTo(0.57, 0.71);
		p2d.lineTo(0.54, 0.71);
		p2d.closePath();
		g2d.setPaint(Color.WHITE);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		//------------------------
		p2d = new Path2D.Double();
		p2d.moveTo(-0.18, 0.9961);
		p2d.lineTo(-0.195, 0.69);
		p2d.lineTo(-0.197, 0.32);
		p2d.lineTo(-0.185, 0.1992);
		p2d.moveTo(0.05, 0.95);
		p2d.lineTo(0.05, 0.1992);
		p2d.moveTo(-0.18, 0.95);
		p2d.lineTo(0.3, 0.95);
		p2d.quadTo(
			0.3,
			0.95,
			0.37,
			0.94
		);
		p2d.moveTo(0, 0.7305);
		p2d.lineTo(0.1, 0.7305);
		p2d.moveTo(-1.3529, 0.7);
		p2d.lineTo(-0.195, 0.7);
		p2d.moveTo(0.59, 0.78);
		p2d.lineTo(0.63, 0.72);
		p2d.lineTo(0.63, 0.1992);
		p2d.moveTo(-1.3529, 0.3);
		p2d.lineTo(1.3529, 0.3);
		p2d.moveTo(1.2, 0.48);
		p2d.quadTo(
			1.12,
			0.5,
			1.05,
			0.4
		);
		p2d.moveTo(0.7, 0.7305);
		p2d.lineTo(1.25, 0.6);
		g2d.setPaint(Color.LIGHT_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);

		//handle
		p2d = new Path2D.Double();
		p2d.moveTo(0.1, 0.625);
		p2d.lineTo(0.2, 0.625);
		p2d.lineTo(0.2, 0.57);
		p2d.lineTo(0.1, 0.57);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.draw(s);

		//Headlight
		p2d = new Path2D.Double();
		p2d.moveTo(1.21, 0.48);
		p2d.lineTo(1.2, 0.57);
		p2d.curveTo(
			1.27,
			0.57,
			1.27,
			0.55,
			1.28,
			0.48
		);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.setPaint(new Color(150, 150, 150));
		g2d.fill(s);

		//Taillight
		p2d = new Path2D.Double();
		p2d.moveTo(-1.3529, 0.6);
		p2d.lineTo(-1.3, 0.6);
		p2d.lineTo(-1.3, 0.48);
		p2d.lineTo(-1.3529, 0.48);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(p2d);
		g2d.fill(s);

		//rear bumper
		p2d = new Path2D.Double();
		p2d.moveTo(-1.355, 0.3);
		p2d.lineTo(-1.28, 0.3);
		p2d.lineTo(-1.28, 0.1992);
		p2d.lineTo(-1.355, 0.1992);
		p2d.closePath();
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(p2d);
		g2d.fill(s);

		//-----------------------
		p2d = new Path2D.Double();
		p2d.moveTo(1.14, 0.1992);
		p2d.curveTo(
			1.14,
			0.55,
			.7,
			0.55,
			.7,
			0.1992
		);
		p2d.closePath();
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		p2d = new Path2D.Double();
		p2d.moveTo(-0.5, 0.1992);
		p2d.curveTo(
			-0.5,
			0.55,
			-0.94,
			0.55,
			-0.94,
			0.1992
		);
		p2d.closePath();
		s = p2d.createTransformedShape(at);
		g2d.fill(s);

		//Front wheel
		Ellipse2D wheel = new Ellipse2D.Double(0.72, 0, 0.4, 0.4);
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(wheel);
		g2d.fill(s);

		//Rear wheel
		wheel = new Ellipse2D.Double(-0.92, 0, 0.4, 0.4);
		s = at.createTransformedShape(wheel);
		g2d.fill(s);


		Ellipse2D origin = new Ellipse2D.Double(-0.025, -0.025, 0.05, 0.05);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(origin);
		g2d.fill(s);
	}
	public void paintShifter(JPanel jp, Graphics2D g2d, int gear, int maxGear) {
		AffineTransform at = new AffineTransform();
		at.translate(
			jp.getWidth() / 2,
			jp.getHeight() / 2
		);
		at.scale(jp.getWidth() / 2, -jp.getWidth() / 2);
		Debug.println("MyCar:paintShifter()");
		/*String value = String.valueOf(gear);
		String maxValue = String.valueOf(maxGear);
		int w = SwingUtilities.computeStringWidth(
			g2d.getFontMetrics(),
			value
		);
		g2d.setPaint(Color.BLACK);
		g2d.drawString(
			value,
			jp.getWidth() / 2 - w / 2,
			jp.getHeight() / 2 + 8
		);*/

		Path2D p2d = new Path2D.Double();
		p2d.moveTo(-0.1,-0.5);
		p2d.lineTo(-0.25, 0);
		p2d.lineTo(-0.13, 0.3);
		p2d.moveTo(-0.25, 0);
		p2d.lineTo(0.3, 0.1);
		p2d.lineTo(0.2, -0.4);
		g2d.setStroke(
			new BasicStroke(
				(float) (0.05 * jp.getWidth()/2),
				BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND
			)
		);
		g2d.setPaint(Color.DARK_GRAY);
		Shape s = at.createTransformedShape(p2d);
		g2d.draw(s);

		Ellipse2D stick = new Ellipse2D.Double(-0.05, -0.05, 0.1, 0.1);
		switch (gear) {
			case 1: stick = new Ellipse2D.Double(-0.15, -0.55, 0.1, 0.1); break;
			case 2: stick = new Ellipse2D.Double(-0.18, 0.25, 0.1, 0.1); break;
			case 3: stick = new Ellipse2D.Double(0.15, -0.45, 0.1, 0.1); break;
			default: stick = new Ellipse2D.Double(-0.15, -0.55, 0.1, 0.1); break;
		}
		
		g2d.setPaint(new Color(150, 0, 0));
		s = at.createTransformedShape(stick);
		g2d.fill(s);
	}
}
