package edu.mccc.cos210.car.cars;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class H1N1 extends Car {
	
	protected void paintTop(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("H1N1:paintTop()");
		
		Arc2D a2d = new Arc2D.Double();
		Path2D p2d = new Path2D.Double();
		QuadCurve2D q2d = new QuadCurve2D.Double();
		Line2D l2d = new Line2D.Double();
		RoundRectangle2D rr2d = new RoundRectangle2D.Double();
		Shape s;

		double y = 1.5;
		double x = .50;
		//outline
		rr2d.setRoundRect(-x,-y,x * 2,y * 2,0,0);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(rr2d);
		g2d.draw(s);		
		
		y = 1.3;
		x = .48;
		
		//Body and bumper
		//bumper
		rr2d.setRoundRect(-x,-y,x * 2,y * 2,x * .15,y * .15);	
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(rr2d);
		g2d.fill(s);
		//body
		rr2d.setRoundRect(-x,-y * .97,x * 2,y * 1.95,x * .1,y * .15);	
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(rr2d);
		g2d.fill(s);
		
		//Lines on trunk
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.RED.darker().darker().darker());
		for(double i = -.9; i < .9; i += .1){
			l2d.setLine(x * i, -y * .1, x * i, -y * .9);
			s = at.createTransformedShape(l2d);
			g2d.draw(s);		
		}
		//Place for wheels
		rr2d.setRoundRect(-x * 1.07, -y * .7,x * .5,y * .25,x * .15,y * .15);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(rr2d);
		g2d.fill(s);
		rr2d.setRoundRect(x * .57, -y * .7,x * .5,y * .25,x * .15,y * .15);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(rr2d);
		g2d.fill(s);
		
		rr2d.setRoundRect(-x * 1.07, y * .6,x * .5,y * .25,x * .15,y * .15);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(rr2d);
		g2d.fill(s);
		rr2d.setRoundRect(x * .57, y * .6,x * .5,y * .25,x * .15,y * .15);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(rr2d);
		g2d.fill(s);		
		
		//top of seat
		p2d = new Path2D.Double();
		p2d.moveTo(-x * .8, y * .4);
		p2d.lineTo(x * .8, y * .4);
		p2d.lineTo(x * .8, 0);
		p2d.lineTo(-x * .8, 0);	
		g2d.setPaint(Color.RED);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		//Wind Shield
		p2d = new Path2D.Double();
		p2d.moveTo(-x * .95, y * .55);
		p2d.lineTo(x * .95, y * .55);
		p2d.lineTo(x * .8, y * .26);
		p2d.lineTo(-x * .8, y * .26);	
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		//Left Mirror
		p2d = new Path2D.Double();
		p2d.moveTo(-x * .98, y * .53);
		p2d.lineTo(-x * .8, y * .26);
		p2d.lineTo(-x * .8, y * .03);
		p2d.lineTo(-x * .98, -y * .01);	
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		//Right Mirror
		p2d = new Path2D.Double();
		p2d.moveTo(x * .98, y * .53);
		p2d.lineTo(x * .8, y * .26);
		p2d.lineTo(x * .8, y * .03);
		p2d.lineTo(x * .98, -y * .01);	
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		//Back Mirror
		p2d = new Path2D.Double();
		p2d.moveTo(-x * .85, -y * .01);
		p2d.lineTo(x * .85, -y * .01);
		p2d.lineTo(x * .98, -y * .05);
		p2d.lineTo(-x * .98, -y * .05);	
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		
		Ellipse2D origin = new Ellipse2D.Double(-0.025, -0.025, 0.05, 0.05);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(origin);
		g2d.fill(s);		

		g2d.setPaint(Color.RED);
		g2d.setStroke(new BasicStroke(5));
		l2d.setLine(-x * .95, y * .53,-x * .77, y * .26 );
		s = at.createTransformedShape(l2d);
		g2d.draw(s);

		l2d.setLine(x * .95, y * .53,x * .77, y * .26 );
		s = at.createTransformedShape(l2d);
		g2d.draw(s);		
		
		//
		l2d.setLine(-x * .95, y * .53,-x * .77, y * .26 );
		s = at.createTransformedShape(l2d);
		g2d.draw(s);

		l2d.setLine(x * .95, y * .53,x * .77, y * .26 );
		s = at.createTransformedShape(l2d);
		g2d.draw(s);
		
		//
		q2d.setCurve(-x * .95, y * .54, 0, y * .61,x * .95, y * .54);
		s = at.createTransformedShape(q2d);
		g2d.draw(s);	
		//
		q2d.setCurve(-x * .785, y * .25, 0, y * .283,x * .77, y * .25);
		s = at.createTransformedShape(q2d);
		g2d.draw(s);
	}
	
	protected void paintSide(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Arc2D a2d = new Arc2D.Double();
		Path2D p2d = new Path2D.Double();
		Line2D l2d = new Line2D.Double();
		RoundRectangle2D rr2d = new RoundRectangle2D.Double();
		Ellipse2D e2d = new Ellipse2D.Double();
		Shape s;

		double y = .90;
		double x = 1.50;
		//outline
		rr2d.setRoundRect(-x, 0,x * 2,y,0,0);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(rr2d);
		g2d.draw(s);
		//---------------------------		
		y = .78;
		x = 1.3;		
		
		//Hood
		g2d.setStroke(new BasicStroke(9));
		p2d = new Path2D.Double();
		p2d.moveTo(0, y * .4);
		p2d.lineTo(0, y);
		p2d.lineTo(x * .25, y);
		p2d.lineTo(x * .7, y * .38);
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		g2d.setStroke(new BasicStroke(9));
		p2d = new Path2D.Double();
		p2d.moveTo(0, y * .4);
		p2d.lineTo(0, y);
		p2d.lineTo(x * .25, y);
		p2d.lineTo(x * .7, y * .38);
		g2d.setPaint(Color.RED);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		
		g2d.setPaint(Color.BLACK);		
		//body
		rr2d.setRoundRect(-x, y * .15,x * 1.7,y *.45,x * .15,y * .15);	
		s = at.createTransformedShape(rr2d);
		g2d.fill(s);
		rr2d.setRoundRect(-x, y * .15,x * 2,y *.2,x * .05,x * .05);	
		s = at.createTransformedShape(rr2d);
		g2d.fill(s);
		
		rr2d.setRoundRect(-x * .98, y * .2,x * 1.96,y *.4,x * .7,x * .2);	
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(rr2d);
		g2d.fill(s);
		rr2d.setRoundRect(-x * .98, y * .2,x,y *.4,x * .05, x * .05);	
		s = at.createTransformedShape(rr2d);
		g2d.fill(s);
		rr2d.setRoundRect(0, y * .22,x,y *.25,x * .05,x * .05);	
		s = at.createTransformedShape(rr2d);
		g2d.fill(s);

	
		//Wheels
		g2d.setPaint(Color.BLACK);
		e2d = new Ellipse2D.Double(-x * .7, 0, x * .2, x * .2);
		s = at.createTransformedShape(e2d);
		g2d.fill(s);
		e2d = new Ellipse2D.Double(x * .6, 0, x * .2, x * .2);
		s = at.createTransformedShape(e2d);
		g2d.fill(s);
		
		//Door
		g2d.setStroke(new BasicStroke(2));
		p2d = new Path2D.Double();
		p2d.moveTo(0, y * .2);
		p2d.lineTo(0, y);
		p2d.lineTo(x * .25, y);
		p2d.lineTo(x * .53, y * .6);
		p2d.lineTo(x * .53, y * .2);
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		
		//Handel
		rr2d.setRoundRect(x * .05, y * .48, x * .08 ,x * .05, 0, 0);	
		s = at.createTransformedShape(rr2d);
		g2d.fill(s);

	}
	
	public void paintShifter(JPanel jp, Graphics2D g2d, int gear, int maxGear) {
		Debug.println("MyCar:paintShifter()");
		
		Line2D l2d = new Line2D.Double();
		int x = (int)(jp.getWidth() / 2.5);
		int y = -(int)(jp.getHeight() / 2.5);
		
		g2d.translate(jp.getWidth() / 2,jp.getHeight() / 2);
		g2d.setStroke(new BasicStroke(7));
		g2d.setPaint(Color.RED);
		
		//Fifth
		if (gear < 5){
			g2d.setPaint(Color.BLACK);
		}
		l2d.setLine(0, 0, x, 0); g2d.draw(l2d);
		l2d.setLine(x, 0, x, y); g2d.draw(l2d);

		g2d.setPaint(Color.RED);
		//Fourth
		if (gear < 4){
			g2d.setPaint(Color.BLACK);
		}
		l2d.setLine(0, 0, 0, -y); g2d.draw(l2d);
		
		g2d.setPaint(Color.RED);
		//Third
		if (gear < 3){
			g2d.setPaint(Color.BLACK);
		}
		l2d.setLine(0, 0, 0, y); g2d.draw(l2d);
		
		g2d.setPaint(Color.RED);
		//Second
		if (gear < 2){
			g2d.setPaint(Color.BLACK);
		}
		l2d.setLine(-x, 0, -x, -y); g2d.draw(l2d);
		
		g2d.setPaint(Color.RED);
		//First
		if (gear < 1){
			g2d.setPaint(Color.BLACK);
		}
		l2d.setLine(0, 0, -x, 0); g2d.draw(l2d);
		l2d.setLine(-x, 0, -x, y); g2d.draw(l2d);
	
			
	}
}
