package edu.mccc.cos210.car.cars;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class WeedWacker extends Car {
	protected void paintTop(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("Weed Wacker:paintTop()");
		RoundRectangle2D front = new RoundRectangle2D.Double(
			-0.5,
			0.235,
			1.0,
			1.0,
			10,
			0.3
		);
		Shape s = at.createTransformedShape(front);
		g2d.setColor(Color.getHSBColor(0.0f, 0.0f, 0.450f));
		g2d.fill(s);
		RoundRectangle2D back = new RoundRectangle2D.Double(
			-0.5,
			-1.235,
			1.0,
			1.0,
			10,
			0.2
		);
		s = at.createTransformedShape(back);
		g2d.setColor(Color.GRAY);
		g2d.fill(s);
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(-0.5, 0);
		p2d.lineTo(-0.5, 1.0);
		p2d.lineTo(0.5, 1.0);
		p2d.lineTo(0.5, -1.0);
		p2d.lineTo(-0.5, -1.0);
		p2d.lineTo(-0.5, 0);
		p2d.closePath();
		g2d.setPaint(Color.GRAY);
		s = at.createTransformedShape(p2d);
		g2d.fill(s);
		Arc2D windshield = new Arc2D.Double(
			-0.45,
			0.45,
			0.9,
			0.1,
			0.0,
			-180.0,
			Arc2D.PIE
		);
		s = at.createTransformedShape(windshield);
		g2d.setPaint(Color.DARK_GRAY);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.45, 0.5);
		p2d.lineTo(-0.4, 0.1);
		p2d.lineTo(0.4, 0.1);
		p2d.lineTo(0.45, 0.5);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.fill(s);
		windshield = new Arc2D.Double(
			-0.4,
			0.075,
			0.8,
			0.05,
			0.0,
			-180.0,
			Arc2D.PIE
		);
		s = at.createTransformedShape(windshield);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);
		Line2D roof = new Line2D.Double(
			-0.4,
			0.0,
			-0.4,
			-1.0
		);
		s = at.createTransformedShape(roof);
		g2d.setPaint(Color.BLACK);
		g2d.setStroke(
			new BasicStroke(2)
		);
		g2d.draw(s);
		roof = new Line2D.Double(
			0.4,
			0.0,
			0.4,
			-1.0
		);
		s = at.createTransformedShape(roof);
		g2d.setPaint(Color.BLACK);
		g2d.setStroke(
			new BasicStroke(2)
		);
		g2d.draw(s);
		windshield = new Arc2D.Double(
			-0.4,
			-1.075,
			0.8,
			0.1,
			0.0,
			-180.0,
			Arc2D.OPEN
		);
		s = at.createTransformedShape(windshield);
		g2d.setColor(Color.getHSBColor(0.0f, 0.0f, 0.65f));
		g2d.draw(s);
		windshield = new Arc2D.Double(
			-0.425,
			-1.175,
			0.85,
			0.05,
			0.0,
			180.0,
			Arc2D.PIE
		);
		s = at.createTransformedShape(windshield);
		g2d.setPaint(Color.DARK_GRAY);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.425, -1.15);
		p2d.lineTo(0.425, -1.15);
		p2d.lineTo(0.4, -1.075);
		p2d.lineTo(-0.4, -1.075);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.4625, 0.4);
		p2d.lineTo(-0.4625, -1.025);
		p2d.lineTo(-0.425, -1.0);
		p2d.lineTo(-0.425, 0.05);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(0.4625, 0.4);
		p2d.lineTo(0.4625, -1.025);
		p2d.lineTo(0.425, -1.0);
		p2d.lineTo(0.425, 0.05);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.4775, 0.0);
		p2d.lineTo(-0.4775, -0.125);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.draw(s);
		p2d = new Path2D.Double();
		p2d.moveTo(0.4775, 0.0);
		p2d.lineTo(0.4775, -0.125);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.draw(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.4775, -0.5);
		p2d.lineTo(-0.4775, -0.625);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.draw(s);
		p2d = new Path2D.Double();
		p2d.moveTo(0.4775, -0.5);
		p2d.lineTo(0.4775, -0.625);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.setColor(Color.GRAY);
		g2d.draw(s);
		windshield = new Arc2D.Double(
			-0.45,
			0.9,
			0.9,
			0.2,
			0.0,
			-180.0,
			Arc2D.PIE
		);
		s = at.createTransformedShape(windshield);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.45, 1.0);
		p2d.lineTo(-0.5, 1.0);
		p2d.lineTo(-0.5, 0.3);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.setColor(Color.getHSBColor(0.0f, 0.0f, 0.450f));
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(0.45, 1.0);
		p2d.lineTo(0.5, 1.0);
		p2d.lineTo(0.5, 0.3);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.setColor(Color.getHSBColor(0.0f, 0.0f, 0.450f));
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.375, 1.1);
		p2d.lineTo(-0.4, 0.65);
		p2d.lineTo(-0.375, 0.55);
		s = at.createTransformedShape(p2d);
		g2d.setColor(Color.getHSBColor(0.0f, 0.0f, 0.45f));
		g2d.draw(s);
		p2d = new Path2D.Double();
		p2d.moveTo(0.375, 1.1);
		p2d.lineTo(0.4, 0.65);
		p2d.lineTo(0.375, 0.55);
		s = at.createTransformedShape(p2d);
		g2d.setColor(Color.getHSBColor(0.0f, 0.0f, 0.45f));
		g2d.draw(s);
		Ellipse2D lights = new Ellipse2D.Double(
			-0.425,
			1.1,
			0.0825,
			0.04125
		);
		s = at.createTransformedShape(lights);
		g2d.setColor(Color.WHITE);
		g2d.fill(s);
		lights = new Ellipse2D.Double(
			0.375,
			1.1,
			0.0825,
			0.03625
		);
		s = at.createTransformedShape(lights);
		g2d.fill(s);
		lights = new Ellipse2D.Double(
			0.275,
			1.1125,
			0.0725,
			0.03625
		);
		s = at.createTransformedShape(lights);
		g2d.fill(s);
		lights = new Ellipse2D.Double(
			-0.325,
			1.1125,
			0.0725,
			0.04125
		);
		s = at.createTransformedShape(lights);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.4625, 0.425);
		p2d.lineTo(-0.55, 0.425);
		p2d.lineTo(-0.55, 0.375);
		p2d.lineTo(-0.4625, 0.375);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.setColor(Color.getHSBColor(0.0f, 0.0f, 0.65f));
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(0.4625, 0.425);
		p2d.lineTo(0.55, 0.425);
		p2d.lineTo(0.55, 0.375);
		p2d.lineTo(0.4625, 0.375);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.setColor(Color.getHSBColor(0.0f, 0.0f, 0.65f));
		g2d.fill(s);
		Ellipse2D bmw = new Ellipse2D.Double(
			-0.025,
			1.025,
			0.05,
			0.05
		);
		s = at.createTransformedShape(bmw);
		g2d.setColor(Color.BLUE);
		g2d.fill(s);
		g2d.setColor(Color.BLACK);
		g2d.draw(s);
		RoundRectangle2D grate = new RoundRectangle2D.Double(
			-0.2125,
			1.125,
			0.2,
			0.075,
			0.1,
			0.05
		);
		s = at.createTransformedShape(grate);
		g2d.setColor(Color.getHSBColor(0.0f, 0.0f, 0.40f));
		g2d.draw(s);
		grate = new RoundRectangle2D.Double(
			0.015,
			1.125,
			0.2,
			0.075,
			0.1,
			0.05
		);
		s = at.createTransformedShape(grate);
		g2d.setColor(Color.getHSBColor(0.0f, 0.0f, 0.40f));
		g2d.draw(s);
	}
	protected void paintSide(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("MyCar:paintSide()");
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(-1.235, 1.0);
		p2d.lineTo(1.235, 1.0);
		p2d.lineTo(1.235, 0.0);
		p2d.lineTo(-1.235, 0.0);
		p2d.closePath();
		g2d.setPaint(Color.BLUE);
		Shape s = p2d.createTransformedShape(at);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-1.135, 0.85);
		p2d.lineTo(-0.1, 0.925);
		p2d.lineTo(0.4, 0.55);
		p2d.lineTo(1.1, 0.475);
		p2d.lineTo(1.1, 0.1);
		p2d.lineTo(-1.135, 0.1);
		p2d.closePath();
		g2d.setPaint(Color.GRAY);
		s = at.createTransformedShape(p2d);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-1.2, 0.3);
		p2d.lineTo(-1.235, 0.5);
		p2d.lineTo(-1.0, 0.5);
		p2d.lineTo(-1.0, 0.3);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-1.235, 0.5);
		p2d.lineTo(-1.135, 0.85);
		p2d.lineTo(-1.0, 0.85);
		p2d.lineTo(-1.0, 0.5);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.fill(s);
		CubicCurve2D roof = new CubicCurve2D.Double(
			-1.135,
			0.85,
			-0.5,
			0.95,
			-0.2,
			0.95,
			-0.1,
			0.925
		);
		s = at.createTransformedShape(roof);
		g2d.fill(s);
		RoundRectangle2D front = new RoundRectangle2D.Double(
			1.0,
			0.1,
			0.2,
			0.375,
			0.2,
			0.4
		);
		s = at.createTransformedShape(front);
		g2d.fill(s);
		Arc2D bumper = new Arc2D.Double(
			1.0125,
			0.1,
			0.2,
			0.4,
			0.0,
			90.0,
			Arc2D.PIE
		);
		s = at.createTransformedShape(bumper);
		g2d.setColor(Color.getHSBColor(0.0f, 0.0f, 0.15f));
		g2d.fill(s);
		bumper = new Arc2D.Double(
			-1.235,
			0.1,
			0.2,
			0.4,
			-180.0,
			-90.0,
			Arc2D.PIE
		);
		s = at.createTransformedShape(bumper);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-1.15, 0.1);
		p2d.lineTo(1.1275, 0.1);
		p2d.lineTo(1.1275, 0.175);
		p2d.lineTo(-1.0, 0.175);
		p2d.lineTo(-1.0, 0.3);
		p2d.lineTo(-1.15, 0.3);
		p2d.lineTo(-1.15, 0.175);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.fill(s);
		Arc2D tirewell = new Arc2D.Double(
			-1.05,
			-0.1,
			0.5,
			0.5,
			0.0,
			-180.0,
			Arc2D.PIE
		);
		s = at.createTransformedShape(tirewell);
		g2d.fill(s);
		tirewell = new Arc2D.Double(
			0.6675,
			-0.1,
			0.5,
			0.5,
			0.0,
			-180.0,
			Arc2D.PIE
		);
		s = at.createTransformedShape(tirewell);
		g2d.fill(s);
		Ellipse2D tire = new Ellipse2D.Double(
			-1.0,
			0.0,
			0.35,
			0.35
		);
		s = at.createTransformedShape(tire);
		g2d.setPaint(Color.BLACK);
		g2d.fill(s);
		tire = new Ellipse2D.Double(
			0.75,
			0.0,
			0.35,
			0.35
		);
		s = at.createTransformedShape(tire);
		g2d.fill(s);
		tire = new Ellipse2D.Double(
			-0.95,
			0.05,
			0.25,
			0.25
		);
		s = at.createTransformedShape(tire);
		g2d.setPaint(Color.WHITE);
		g2d.fill(s);
		tire = new Ellipse2D.Double(
			0.8,
			0.05,
			0.25,
			0.25
		);
		s = at.createTransformedShape(tire);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(1.15, 0.45);
		p2d.lineTo(1.1, 0.45);
		p2d.lineTo(1.05, 0.375);
		p2d.lineTo(1.1, 0.35);
		p2d.lineTo(1.2, 0.35);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.setPaint(Color.DARK_GRAY);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-1.235, 0.5);
		p2d.lineTo(-1.15, 0.45);
		p2d.lineTo(-1.15, 0.4);
		p2d.lineTo(-1.235, 0.4);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.setPaint(Color.WHITE);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-1.235, 0.4);
		p2d.lineTo(-1.15, 0.4);
		p2d.lineTo(-1.15, 0.35);
		p2d.lineTo(-1.23, 0.3);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.setPaint(Color.RED);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(0.2, 0.6);
		p2d.lineTo(-0.9, 0.6);
		p2d.lineTo(-0.9, 0.85);
		p2d.lineTo(-0.3, 0.875);
		p2d.lineTo(0.2, 0.65);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.setPaint(Color.DARK_GRAY);
		g2d.fill(s);
		CubicCurve2D window = new CubicCurve2D.Double(
			-0.3,
			0.875,
			-0.1,
			0.9,
			0.0,
			0.8,
			0.2,
			0.65
		);
		s = at.createTransformedShape(window);
		g2d.fill(s);
		window = new CubicCurve2D.Double(
			-0.9,
			0.6,
			-1.1,
			0.6,
			-1.1,
			0.85,
			-0.9,
			0.85
		);
		s = at.createTransformedShape(window);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.8, 0.85);
		p2d.lineTo(-0.85, 0.6);
		p2d.lineTo(-0.75, 0.6);
		p2d.lineTo(-0.75, 0.85);
		s = at.createTransformedShape(p2d);
		g2d.setColor(Color.getHSBColor(0.0f, 0.0f, 0.15f));
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.325, 0.8675);
		p2d.lineTo(-0.325, 0.6);
		p2d.lineTo(-0.225, 0.6);
		p2d.lineTo(-0.275, 0.8675);
		s = at.createTransformedShape(p2d);
		g2d.fill(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.3, 0.8675);
		p2d.lineTo(-0.275, 0.6);
		p2d.lineTo(-0.275, 0.175);
		s = at.createTransformedShape(p2d);
		g2d.setColor(Color.getHSBColor(0.0f, 0.0f, 0.65f));
		g2d.draw(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.775, 0.85);
		p2d.lineTo(-0.8, 0.6);
		p2d.lineTo(-0.8, 0.4);
		s = at.createTransformedShape(p2d);
		g2d.draw(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.9, 0.5);
		p2d.lineTo(-1.0, 0.5);
		p2d.lineTo(-1.0, 0.45);
		p2d.lineTo(-0.9, 0.45);
		p2d.closePath();
		s = at.createTransformedShape(p2d);
		g2d.draw(s);
		p2d = new Path2D.Double();
		p2d.moveTo(0.2, 0.65);
		p2d.lineTo(0.4, 0.5);
		p2d.lineTo(0.4, 0.175);
		s = at.createTransformedShape(p2d);
		g2d.draw(s);
		g2d.setStroke(
			new BasicStroke(3)
		);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.1, 0.5);
		p2d.lineTo(-0.2, 0.5);
		s = at.createTransformedShape(p2d);
		g2d.draw(s);
		p2d = new Path2D.Double();
		p2d.moveTo(-0.6, 0.5);
		p2d.lineTo(-0.7, 0.5);
		s = at.createTransformedShape(p2d);
		g2d.draw(s);
	}
	public void paintShifter(JPanel jp, Graphics2D g2d, int gear, int maxGear) {
		Debug.println("WeedWacker:paintShifter()");
		String value = String.valueOf(gear);
		String maxValue = String.valueOf(maxGear);
		int w = SwingUtilities.computeStringWidth(
			g2d.getFontMetrics(),
			value
		);
		g2d.setPaint(Color.BLACK);
		g2d.setStroke(
			new BasicStroke(8)
		);
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(36.0, 72.0);
		p2d.lineTo(108.0, 72.0);
		p2d.moveTo(36.0, 36.0);
		p2d.lineTo(36.0, 108.0);
		p2d.moveTo(72.0, 36.0);
		p2d.lineTo(72.0, 108.0);
		p2d.moveTo(108.0, 36.0);
		p2d.lineTo(108.0, 72.0);
		Shape a = null;
		Shape s = p2d;
		int x = 0;
		int y = 0;
		g2d.draw(s);
		g2d.setStroke(
			new BasicStroke(4)
		);
		switch (gear) {
			case 1: s = new Ellipse2D.Double(
					26,
					26,
					20,
					20
				);
				p2d = new Path2D.Double();
				p2d.moveTo(36.0, 36.0);
				p2d.lineTo(36.0, 72.0);
				a = p2d;
				x = 36 -5;
				y = 36 + 5; break;
			case 2: s = new Ellipse2D.Double(
					26,
					98,
					20,
					20
				);
				p2d = new Path2D.Double();
				p2d.moveTo(36.0, 108.0);
				p2d.lineTo(36.0, 72.0);
				a = p2d;
				x = 36 - 5;
				y = 108 + 5; break;
			case 3: s = new Ellipse2D.Double(
					62,
					26,
					20,
					20
				);
				p2d = new Path2D.Double();
				p2d.moveTo(72.0, 36.0);
				p2d.lineTo(72.0, 72.0);
				a = p2d;
				x = 72 - 5;
				y = 36 + 5; break;
			case 4: s = new Ellipse2D.Double(
					62,
					98,
					20,
					20
				);
				p2d = new Path2D.Double();
				p2d.moveTo(72.0, 108.0);
				p2d.lineTo(72.0, 72.0);
				a = p2d;
				x = 72 - 5;
				y = 108 + 5; break;
			case 5: s = new Ellipse2D.Double(
					98,
					26,
					20,
					20
				);
				p2d = new Path2D.Double();
				p2d.moveTo(108.0, 36.0);
				p2d.lineTo(108.0, 72.0);
				a = p2d;
				x = 108 - 5;
				y = 36 + 5; break;
			default: System.out.println("Error");break;
		}
		g2d.setColor(Color.DARK_GRAY);
		g2d.draw(a);
		g2d.setColor(Color.WHITE);
		g2d.fill(s);
		g2d.setColor(Color.BLACK);
		g2d.drawString(
			value,
			x,
			y
		);

	}
	public Car.Speedometer createSpeedometer() {
		Debug.println("WeedWacker:createSpeedometer()");
		setSpeedometer(
			new MySpeedometer(
				new DefaultBoundedRangeModel(0, 300, 0, 600)
			)
		);
		getSpeedometer().setRound(false);
		return getSpeedometer();
	}
	public class MySpeedometer extends Car.Speedometer {
		public MySpeedometer(BoundedRangeModel model) {
			super(model);
			Debug.println("MySpeedometer.MySpeedometer()");
		}
	}
	public Car.Tachometer createTachometer() {
		Debug.println("WeedWacker:createTachometer()");
		setTachometer(
			new MyTachometer(
				new DefaultBoundedRangeModel(0, 300, 0, 600)
			)
		);
		getTachometer().setRound(false);
		return getTachometer();
	}
	public class MyTachometer extends Car.Tachometer {
		public MyTachometer(BoundedRangeModel model) {
			super(model);
			Debug.println("MyTachometer.MyTachometer()");
		}
	}
}
