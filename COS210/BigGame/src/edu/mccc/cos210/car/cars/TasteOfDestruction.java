package edu.mccc.cos210.car.cars;
import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Path2D.Double;

import javax.swing.*;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;

public class TasteOfDestruction extends Car {
	protected void paintTop(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("TasteOfDestruction:paintTop()");
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(-0.5, .8);
		p2d.curveTo(-0.5, .8 , 0 , 1.15 , 0.5, .8 );
		p2d.lineTo(0.5, -1);
		p2d.curveTo(0.5, -1 , 0 , -1.15 , -0.5, -1);
		p2d.closePath();
		g2d.setPaint(new Color(102, 153, 153));
		
		Shape s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(-0.5, .8);
		p2d.curveTo(-0.5, .8 , 0 , 1.15 , 0.5, .8 );
		p2d.lineTo(0.5, -1);
		p2d.curveTo(0.5, -1 , 0 , -1.15 , -0.5, -1);
		p2d.lineTo(-0.5, .8);
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(-0.279, .89);
		p2d.curveTo(-0.279, .89 , -0.4, 0.5 , -0.35, 0.25);
		p2d.curveTo(-0.35, 0.25, 0, .3, 0.35, 0.25);
		p2d.curveTo(0.35,0.25,0.4, 0.5, 0.279, 0.89);
		p2d.curveTo(0.279, 0.89, 0, 1, -0.279, 0.89);
		g2d.setPaint(Color.BLACK);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		
		p2d= new Path2D.Double();
		p2d.moveTo(-0.35, 0.25);
		p2d.curveTo(-0.35, 0.25, 0, .3, 0.35, 0.25);
		p2d.lineTo(0.35, -0.75);
		p2d.curveTo(0.35, -0.75,0, -0.9, -0.35,-0.75);
		p2d.lineTo(-0.35, 0.25);
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.BLACK);
		g2d.fill(s);
		
		p2d= new Path2D.Double();
		p2d.moveTo(-0.35, 0.25);
		p2d.curveTo(-0.35, 0.25, 0, .3, 0.35, 0.25);
		p2d.lineTo(0.29,-0.1);
		p2d.lineTo(-0.29, -0.1);
		p2d.lineTo(-0.35,0.25);
		g2d.setPaint(new Color(204, 255, 255));
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		p2d= new Path2D.Double();
		p2d.moveTo(-0.34, -0.75);
		p2d.lineTo(-0.36, -1.02);
		
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		p2d= new Path2D.Double();
		p2d.moveTo(0.34, -0.75);
		p2d.lineTo(0.36, -1.02);
		
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		
		p2d= new Path2D.Double();
		p2d.moveTo(-0.49, .80);
		p2d.curveTo(-0.49, .80, -0.45, 0.855, -0.399, 0.838);
		p2d.curveTo(-0.399, 0.838, -0.47, 0.756, -0.49, .80);
		
		s = p2d.createTransformedShape(at);
		g2d.setPaint(new Color(255,255,51));
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		p2d= new Path2D.Double();
		p2d.moveTo(0.49, .80);
		p2d.curveTo(0.49, .80, 0.45, 0.855, 0.399, 0.838);
		p2d.curveTo(0.399, 0.838, 0.47, 0.756, 0.49, .80);
		
		s = p2d.createTransformedShape(at);
		g2d.setPaint(new Color(255,255,51));
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		Ellipse2D mirror1 = new Ellipse2D.Double(-0.499, 0.213,0.14,0.037);
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(mirror1);
		g2d.draw(s);
		
		
		Ellipse2D mirror2 = new Ellipse2D.Double(0.356, 0.213,0.14,0.037);
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(mirror2);
		g2d.draw(s);
		
		
		
		s = p2d.createTransformedShape(at);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		
		Ellipse2D origin = new Ellipse2D.Double(-0.025, -0.025, 0.05, 0.05);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(origin);
		g2d.fill(s);
	}
	protected void paintSide(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("TasteOfDestruction:paintSide()");
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(-0.9, 0.15);
		p2d.curveTo(-.9, 0.15, -1.05 , 0.23 , -.9, 0.45 );
		p2d.lineTo(.7, 0.45);
		p2d.curveTo(.7, 0.45 , 1.15 , 0.35 , .9, 0.15);
		p2d.closePath();
		g2d.setPaint(new Color(102, 153, 153));
		
		Shape s = p2d.createTransformedShape(at);
		g2d.fill(s);
		g2d.setStroke(
				new BasicStroke(
						(float) (2),
						BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND
					)
				);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(0.45, 0.45);
		p2d.lineTo(-0.07, 0.62);
		p2d.lineTo(-0.08, .61);
		p2d.lineTo(0.23, 0.45);
		p2d.closePath();
		g2d.setPaint(new Color(204, 255, 255));
		
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		g2d.setStroke(
				new BasicStroke(
						(float) (2),
						BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND
					)
				);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		
		Ellipse2D wheel1 = new Ellipse2D.Double(-0.75,0, 0.35, 0.35);
		g2d.setPaint(new Color(248,248,255));
		s = at.createTransformedShape(wheel1);
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.setStroke(
				new BasicStroke(
						(float) (6),
						BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND
					)
				);
		g2d.draw(s);
		p2d= new Path2D.Double();
		p2d.moveTo(-0.69,0.26 );
		p2d.lineTo(-0.44, 0.067);
		g2d.setPaint(Color.BLACK);
		g2d.setStroke(
				new BasicStroke(
						(float) (6),
						BasicStroke.CAP_SQUARE,
						BasicStroke.JOIN_ROUND
					)
				);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		p2d= new Path2D.Double();
		p2d.moveTo(-0.48,0.27 );
		p2d.lineTo(-0.68, 0.065);
		g2d.setPaint(Color.BLACK);
		g2d.setStroke(
				new BasicStroke(
						(float) (6),
						BasicStroke.CAP_SQUARE,
						BasicStroke.JOIN_ROUND
					)
				);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		wheel1= new Ellipse2D.Double(-0.61,0.13, 0.07, 0.07);
		g2d.setPaint(new Color(248,248,255));
		s = at.createTransformedShape(wheel1);
		g2d.fill(s);
		
		Ellipse2D wheel2 = new Ellipse2D.Double(0.35,0, 0.35, 0.35);
		g2d.setPaint(new Color(248,248,255));
		s = at.createTransformedShape(wheel2);
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.setStroke(
				new BasicStroke(
						(float) (6),
						BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND
					)
				);
		g2d.draw(s);
		p2d= new Path2D.Double();
		p2d.moveTo(0.443,0.269 );
		p2d.lineTo(0.60, 0.077);
		g2d.setPaint(Color.BLACK);
		g2d.setStroke(
				new BasicStroke(
						(float) (6),
						BasicStroke.CAP_SQUARE,
						BasicStroke.JOIN_ROUND
					)
				);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		p2d= new Path2D.Double();
		p2d.moveTo(0.60,0.269 );
		p2d.lineTo(0.443, 0.077);
		g2d.setPaint(Color.BLACK);
		g2d.setStroke(
				new BasicStroke(
						(float) (6),
						BasicStroke.CAP_SQUARE,
						BasicStroke.JOIN_ROUND
					)
				);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		wheel2= new Ellipse2D.Double(0.49,0.13, 0.07, 0.07);
		g2d.setPaint(new Color(248,248,255));
		s = at.createTransformedShape(wheel2);
		g2d.fill(s);
		
		Ellipse2D dot = new Ellipse2D.Double(-0.61, 0.25, 0.06, 0.06);
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(dot);
		g2d.fill(s);
		dot = new Ellipse2D.Double(-0.61, 0.04, 0.06, 0.06);
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(dot);
		g2d.fill(s);
		dot = new Ellipse2D.Double(0.49, 0.25, 0.06, 0.06);
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(dot);
		g2d.fill(s);
		dot = new Ellipse2D.Double(0.49, 0.04, 0.06, 0.06);
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(dot);
		g2d.fill(s);
		dot = new Ellipse2D.Double(-0.495, 0.135, 0.06, 0.06);
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(dot);
		g2d.fill(s);
		dot = new Ellipse2D.Double(-0.71, 0.13, 0.06, 0.06);
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(dot);
		g2d.fill(s);
		dot = new Ellipse2D.Double(0.39, 0.135, 0.06, 0.06);
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(dot);
		g2d.fill(s);
		dot = new Ellipse2D.Double(0.595, 0.135, 0.06, 0.06);
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(dot);
		g2d.fill(s);
		
		
		p2d= new Path2D.Double();
		p2d.moveTo(.96 , 0.27 );
		p2d.curveTo(0.96, 0.27,0.92 , 0.25 ,0.82,0.29);
		p2d.curveTo(0.82,0.29, 0.92, 0.31, 0.96 , 0.30);
		p2d.curveTo(.96 , 0.30, 0.97, 0.29,  0.96 , 0.27  );
		g2d.setStroke(
				new BasicStroke(
						(float) (2),
						BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND
					)
				);
		s= p2d.createTransformedShape(at);
		g2d.setPaint(new Color(255,255,51));
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		// Door outline
		p2d= new Path2D.Double();
		p2d.moveTo(-0.36, 0.45 );
		p2d.curveTo(-0.36, 0.45, -0.43, 0.3, -0.30, 0.20);
		p2d.lineTo(0.23, 0.20);
		p2d.curveTo(0.23, 0.20, 0.30, 0.3, 0.23, 0.45);
		
		g2d.setStroke(
				new BasicStroke(
						(float) (2),
						BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND
					)
				);
		s= p2d.createTransformedShape(at);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		p2d= new Path2D.Double();
		p2d.moveTo(-.94 , 0.35 );
		p2d.curveTo(-0.94, 0.35,-0.93 , 0.33 ,-0.84,0.37);
		p2d.curveTo(-0.84,0.37, -0.93, 0.39, -0.94 , 0.38);
		p2d.curveTo(-.94 , 0.38, -0.95, 0.37,  -0.94 , 0.35  );
		g2d.setStroke(
				new BasicStroke(
						(float) (2),
						BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND
					)
				);
		s= p2d.createTransformedShape(at);
		g2d.setPaint(Color.RED);
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		
		p2d= new Path2D.Double();
		p2d.moveTo(-.34 , 0.45 );
		p2d.curveTo(-.34 , 0.45, -0.29, 0.76,  -0.24 , 0.45  );
		p2d.lineTo(-.34,0.45);
		g2d.setStroke(
				new BasicStroke(
						(float) (2),
						BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND
					)
				);
		s= p2d.createTransformedShape(at);
		g2d.setPaint(Color.BLACK);
		g2d.fill(s);
		g2d.draw(s);
		
		Ellipse2D mirror = new Ellipse2D.Double(0.20, 0.43, 0.11, 0.06);
		g2d.setPaint(Color.BLACK);
		s = at.createTransformedShape(mirror);
		g2d.draw(s);
		g2d.setColor(new Color(102, 153, 153));
		g2d.fill(s);
		
		Ellipse2D origin = new Ellipse2D.Double(-0.025, -0.025, 0.05, 0.05);
		g2d.setPaint(Color.RED);
		s = at.createTransformedShape(origin);
		g2d.fill(s);
	}
	public void paintShifter(JPanel jp, Graphics2D g2d, int gear, int maxGear){
		Debug.println("TasteOfDestruction:paintShifter()");
		Path2D p2d= new Path2D.Double();
		int xmid= jp.getWidth()/2;
		int ymid= jp.getHeight()/2;
		p2d.moveTo(xmid,ymid-30);
		p2d.lineTo(xmid+25,ymid-30);
		g2d.setStroke(
				new BasicStroke(
						(float) (6),
						BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND
					)
				);
		g2d.setPaint(Color.BLACK);
		g2d.draw(p2d);
		
		p2d= new Path2D.Double();
		p2d.moveTo(xmid,ymid);
		p2d.lineTo(xmid-20,ymid);
		g2d.setStroke(
				new BasicStroke(
						(float) (6),
						BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND
					)
				);
		g2d.setPaint(Color.BLACK);
		g2d.draw(p2d);
		
		
		p2d= new Path2D.Double();
		p2d.moveTo(xmid,ymid+30);
		p2d.lineTo(xmid+15,ymid+30);
		g2d.setStroke(
				new BasicStroke(
						(float) (6),
						BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND
					)
				);
		g2d.setPaint(Color.BLACK);
		g2d.draw(p2d);
		
		p2d= new Path2D.Double();
		p2d.moveTo(xmid,ymid-30);
		p2d.lineTo(xmid,ymid+30);
		g2d.setStroke(
				new BasicStroke(
						(float) (6),
						BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND
					)
				);
		g2d.setPaint(Color.BLACK);
		g2d.draw(p2d);
		
		p2d= new Path2D.Double();
		p2d.moveTo(xmid,ymid-20);
		p2d.lineTo(xmid+25,ymid-20);
		p2d.lineTo(xmid+25,ymid+15);
		p2d.lineTo(xmid,ymid+15);
		g2d.setStroke(
				new BasicStroke(
						(float) (3),
						BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND
					)
				);
		g2d.setPaint(Color.BLACK);
		g2d.draw(p2d);
		
		Ellipse2D handle;
		String value = String.valueOf(gear);
		
		if(gear==3){
			handle = new Ellipse2D.Double(xmid+15,ymid-43, 20, 20);
			g2d.setPaint(Color.RED);
			
			
			
		} else if(gear==2){
			handle = new Ellipse2D.Double(xmid-25,ymid-13, 20, 20);
			g2d.setPaint(new Color(255,51,102));
			
			
		}else{
			handle = new Ellipse2D.Double(xmid+7,ymid+17, 20, 20);
			g2d.setPaint(new Color(255,153,204));
			
			
		}
		g2d.fill(handle);
		
		g2d.drawString(
			value,
			xmid+5,
			ymid+10
		);
		
		
		
		
		
		
	}
}

