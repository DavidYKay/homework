package edu.mccc.cos210.car.cars;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class NuclearMeltdown extends Car {
	protected void paintTop(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("MyCar:paintTop()");
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(0.0, 1.0);
		p2d.lineTo(-0.25, 1.0);
		p2d.curveTo(-0.45, 1.0, -0.50, 0.78, -0.5, 0.75);
		p2d.curveTo(-0.57, 0.70, -0.57, 0.60, -0.5, 0.50);
		p2d.lineTo(-0.5, -0.50);
		p2d.curveTo(-0.57, -0.60, -0.57, -0.70, -0.5, -0.75);
		p2d.curveTo(-0.50, -0.78, -0.45, -1.0, -0.25, -1.0);
		p2d.lineTo(0.25, -1.0);
		p2d.curveTo(0.45, -1.0, 0.50 , -0.78, 0.50, -0.75);
		p2d.curveTo(0.57, -0.70, 0.57, -0.60, 0.5, -0.50);
		p2d.lineTo(0.5, 0.5);
		p2d.curveTo(0.57, 0.60, 0.57, 0.70, 0.5, 0.75);		
		p2d.curveTo(0.50, 0.78, 0.45, 1.0,  0.25, 1.0);		
		p2d.closePath();
		g2d.setPaint(Color.RED);
		Shape s = p2d.createTransformedShape(at);
		g2d.fill(s);
		g2d.setStroke(new BasicStroke(3.0f));
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		p2d = new Path2D.Double();		
		p2d.moveTo(-0.30, 0.95);
		p2d.curveTo(-0.38, 0.93, -0.40, 0.88, -0.45, 0.75);
		p2d.lineTo(-0.35, 0.85);
		p2d.lineTo(-0.30, 0.95);		
		p2d.moveTo(0.30, 0.95);
		p2d.curveTo(0.38, 0.93, 0.40, 0.88, 0.45, 0.75);
		p2d.lineTo(0.35, 0.85);
		p2d.lineTo(0.30, 0.95);
		p2d.moveTo(-0.30, -0.95);
		p2d.curveTo(-0.38, -0.93, -0.40, -0.88, -0.45, -0.75);
		p2d.lineTo(-0.35, -0.85);
		p2d.lineTo(-0.30, -0.95);		
		p2d.moveTo(0.30, -0.95);
		p2d.curveTo(0.38, -0.93, 0.40, -0.88, 0.45, -0.75);
		p2d.lineTo(0.35, -0.85);
		p2d.lineTo(0.30, -0.95);
		
	
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);

		
		
		p2d = new Path2D.Double();
		p2d.moveTo(-0.40, 0.50);
		p2d.curveTo(-0.20, 0.70, 0.20, 0.70, 0.40, 0.50);
		p2d.lineTo(0.32, 0.13);
		p2d.lineTo(-0.32, 0.13);
		p2d.lineTo(-0.40, 0.50);
		s = p2d.createTransformedShape(at);
		g2d.setStroke(new BasicStroke(2.0f));
		g2d.setPaint(Color.WHITE);
		g2d.draw(s);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(-0.32, 0.13);
		p2d.lineTo(0.32, 0.13);
		p2d.lineTo(0.28, -0.60);
		p2d.lineTo(-0.28, -0.60);
		p2d.lineTo(-0.32, 0.13);
		s = p2d.createTransformedShape(at);
		g2d.setStroke(new BasicStroke(1.0f));
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		g2d.setPaint(Color.WHITE);
		g2d.fill(s);
		
		p2d = new Path2D.Double();		
		p2d.moveTo(-0.28, -0.60);
		p2d.lineTo(0.28, -0.60);
		p2d.lineTo(0.25, -0.80);
		p2d.curveTo(0.15, -0.87, -0.15, -0.87, -0.25, -0.80);
		p2d.lineTo(-0.28, -0.60);
		s = p2d.createTransformedShape(at);
		g2d.setStroke(new BasicStroke(2.0f));
		g2d.setPaint(Color.WHITE);
		g2d.draw(s);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);
		
		p2d = new Path2D.Double();		
		p2d.moveTo(-0.15, 0.0);
		p2d.lineTo(0.15, 0.0);
		p2d.lineTo(0.15, -0.30);
		p2d.lineTo(-0.15, -0.30);
		p2d.lineTo(-0.15, 0.0);		
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.RED);
		g2d.fill(s);
		
		p2d = new Path2D.Double();		
		p2d.moveTo(0.0, 0.0);
		p2d.lineTo(0.15, -0.15);
		p2d.lineTo(0.0, -0.075);
		p2d.lineTo(-0.15, -0.15);
		p2d.lineTo(0.0, 0.0);			
		p2d.moveTo(0.0, -0.110);
		p2d.lineTo(0.15, -0.30);
		p2d.lineTo(0.0, -0.175);
		p2d.lineTo(-0.15, -0.30);
		p2d.lineTo(0.0, -0.110);	
		s = p2d.createTransformedShape(at);		
		g2d.setPaint(Color.WHITE);
		g2d.fill(s);

		p2d = new Path2D.Double();		
		p2d.moveTo(-0.23, -0.87);
		p2d.lineTo(0.23, -0.87);
		p2d.lineTo(0.28, -0.93);
		p2d.curveTo(0.15, -1.0, -0.15, -1.0, -0.28, -0.93);
		p2d.lineTo(-0.23, -0.87);
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.BLACK);
		g2d.fill(s);
		
		
	
		
	
	}
	protected void paintSide(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("MyCar:paintSide()");
		Path2D p2d = new Path2D.Double();
		
		
		p2d.moveTo(-0.71, 0.65);
		p2d.lineTo(-0.75, 0.76);
		p2d.curveTo(-0.72, 0.79, -0.76, 0.82, -0.65, 0.80);
		p2d.lineTo(-0.55, 0.78);
		p2d.curveTo(-0.53, 0.77, -0.54, 0.76, -0.50, 0.73);
		p2d.lineTo(-0.50, 0.70);
		p2d.curveTo(-0.35, 0.83, -0.15, 0.80, 0.10, 0.75);
		p2d.lineTo(0.12, 0.77);
		p2d.lineTo(0.20, 0.77);
		p2d.lineTo(0.23, 0.73);
		p2d.curveTo(0.35, 0.70, 0.45, 0.68, 0.53, 0.58);
		p2d.curveTo(0.804, 0.55, 0.89, 0.45, 0.93, 0.35);
		p2d.lineTo(0.96, 0.35);
		p2d.lineTo(1.00, 0.20);
		p2d.lineTo(-0.60, 0.20);
		p2d.lineTo(-0.70, 0.23);
		p2d.lineTo(-0.72, 0.30);
		p2d.curveTo(-0.76, 0.40, -0.72, 0.55, -0.71, 0.65);
		g2d.setPaint(Color.RED);
		Shape s = p2d.createTransformedShape(at);
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.setStroke(new BasicStroke(2.0f));
		g2d.draw(s);
		
		
		p2d = new Path2D.Double();		
		p2d.moveTo(-0.45, 0.70);
		p2d.lineTo(-0.40, 0.50);
		p2d.lineTo(0.0, 0.50);
		p2d.lineTo(-0.05, 0.70);
		p2d.curveTo(-0.15, 0.75, -0.35, 0.78, -0.45, 0.70);
		p2d.moveTo(-0.03, 0.69);
		p2d.lineTo(0.03, 0.50);
		p2d.lineTo(0.50, 0.50);
		p2d.lineTo(0.35, 0.60);
		p2d.curveTo(0.25, 0.66, 0.10, 0.71, -0.03, 0.69);
				
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);
		g2d.setStroke(new BasicStroke(1.0f));
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		Ellipse2D wheel1 = new Ellipse2D.Double( -0.50, 0.10, 0.30, 0.30);
		g2d.setPaint(Color.GRAY);
		s = at.createTransformedShape(wheel1);
		g2d.fill(s);
		g2d.setStroke(new BasicStroke(7.0f));
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		Ellipse2D wheel2 = new Ellipse2D.Double( 0.40, 0.10, 0.30, 0.30);
		g2d.setPaint(Color.GRAY);
		s = at.createTransformedShape(wheel2);
		g2d.fill(s);
		g2d.setStroke(new BasicStroke(7.0f));
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
	}
	public void paintShifter(JPanel jp, Graphics2D g2d, int gear, int maxGear) {
		Debug.println("MyCar:paintShifter()");
		String value = String.valueOf(gear);
		String maxValue = String.valueOf(maxGear);
		jp.setOpaque(false);
		int current = gear;
		int w = SwingUtilities.computeStringWidth(
			g2d.getFontMetrics(),
			value
		);
		AffineTransform at = new AffineTransform(); 
		

		g2d.setPaint(Color.WHITE);
		g2d.drawString(
			value, 80, 100
		);
		
		
		
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(20.0, 20.0);
		p2d.lineTo(20.0, 100.0);
		p2d.lineTo(30.0, 100.0);
		p2d.lineTo(30.0, 65.0);
		p2d.lineTo(60.0, 65.0);
		p2d.lineTo(60.0, 100.0);
		p2d.lineTo(70.0, 100.0);
		p2d.lineTo(70.0, 65.0);
		p2d.lineTo(100.0, 65.0);
		p2d.lineTo(100.0, 20.0);
		p2d.lineTo(90.0, 20.0);
		p2d.lineTo(90.0, 55.0);		
		p2d.lineTo(70.0, 55.0);
		p2d.lineTo(70.0, 20.0);
		p2d.lineTo(60.0, 20.0);
		p2d.lineTo(60.0, 55.0);
		p2d.lineTo(30.0, 55.0);
		p2d.lineTo(30.0, 20.0);
		p2d.lineTo(20.0, 20.0);
		
		
		Shape s = p2d.createTransformedShape(at);
		g2d.setStroke(new BasicStroke(3.0f));
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);	
		
		g2d.setPaint(Color.WHITE);
		
		g2d.fill(s);
		
		if ( current == 1) {
			Shape shifter = new Ellipse2D.Double(20, 5, 10, 10);
			g2d.setColor(Color.BLUE);
			g2d.fill(shifter);
			g2d.setStroke(new BasicStroke(2.0f));
			g2d.setColor(Color.BLACK);
			g2d.draw(shifter);
		}  else if ( current == 2) {
			Shape shifter = new Ellipse2D.Double(20, 105, 10, 10 );
			g2d.setColor(Color.BLUE);
			g2d.fill(shifter);
			g2d.setStroke(new BasicStroke(3.0f));
			g2d.setColor(Color.BLACK);
			g2d.draw(shifter);
		} 	else if ( current == 3) {
			Shape shifter = new Ellipse2D.Double(60, 5, 10, 10);
			g2d.setColor(Color.BLUE);
			g2d.fill(shifter);
			g2d.setStroke(new BasicStroke(3.0f));
			g2d.setColor(Color.BLACK);
			g2d.draw(shifter);
		}    else if ( current == 4) {
			Shape shifter = new Ellipse2D.Double(60, 105, 10, 10);
			g2d.setColor(Color.BLUE);
			g2d.fill(shifter);
			g2d.setStroke(new BasicStroke(3.0f));
			g2d.setColor(Color.BLACK);
			g2d.draw(shifter);
		} 	else if ( current == 5) {
			Shape shifter = new Ellipse2D.Double(90, 5, 10, 10);
			g2d.setColor(Color.BLUE);
			g2d.fill(shifter);
			g2d.setStroke(new BasicStroke(3.0f));
			g2d.setColor(Color.BLACK);
			g2d.draw(shifter);
		}  
		
		
		
				
	}
	
}
