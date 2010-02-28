package edu.mccc.cos210.car.cars;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class TestosteroneEliminator extends Car {
	protected void paintTop(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("TestosteroneEliminator:paintTop()");
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(-0.45, 1.04);
		p2d.curveTo(-0.3,1.14,0.3,1.14,0.45, 1.04);
		p2d.curveTo(0.475,0.81,0.475,0.64,0.45,.55);
		p2d.lineTo(.45,.45);
		p2d.lineTo(.5,.44);
		p2d.lineTo(.5,.41);
		p2d.lineTo(.45,.41);
		p2d.lineTo(.45,-0.45);
		p2d.curveTo(.475,-0.64,.475,-0.55,.45,-.81);
		p2d.lineTo(0.45, -1.04);
		p2d.moveTo(-.45,1.04);
		p2d.curveTo(-0.475,0.81,-0.475,0.64,-0.45,.55);
		p2d.lineTo(-.45,.45);
		p2d.lineTo(-.5,.44);
		p2d.lineTo(-.5,.41);
		p2d.lineTo(-.45,.41);
		p2d.lineTo(-.45,-0.45);
		p2d.curveTo(-.475,-0.64,-.475,-0.55,-.45,-.81);
		p2d.lineTo(-0.45, -1.04);
		p2d.curveTo(-.2,-1.14,.2,-1.14,.45,-1.04);
		g2d.setPaint(Color.BLACK);
		Shape s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(.27,.27);
		p2d.lineTo(.36,.54);
		p2d.curveTo(.1,.57,-.1,.57,-.36,.54);
		p2d.lineTo(-.27,.27);
		p2d.curveTo(-.1,.29,.1,.29,.27,.27);
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(.23,0);
		p2d.lineTo(.23,.18);
		p2d.lineTo(-.23,.18);
		p2d.lineTo(-.23,0);
		p2d.closePath();
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(.29,0);
		p2d.lineTo(.39,0);
		p2d.lineTo(.39,.37);
		p2d.lineTo(.35,.37);
		p2d.lineTo(.29,.18);
		p2d.closePath();
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(-.29,0);
		p2d.lineTo(-.39,0);
		p2d.lineTo(-.39,.37);
		p2d.lineTo(-.35,.37);
		p2d.lineTo(-.29,.18);
		p2d.closePath();
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(.29,-.1);
		p2d.lineTo(.39,-.1);
		p2d.lineTo(.39,-.4);
		p2d.lineTo(.29,-.33);
		p2d.closePath();
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(-.29,-.1);
		p2d.lineTo(-.39,-.1);
		p2d.lineTo(-.39,-.4);
		p2d.lineTo(-.29,-.33);
		p2d.closePath();
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(.29,-.4);
		p2d.lineTo(.39,-.47);
		p2d.lineTo(.39,-.9);
		p2d.lineTo(.29,-.83);
		p2d.closePath();
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(-.29,-.4);
		p2d.lineTo(-.39,-.47);
		p2d.lineTo(-.39,-.9);
		p2d.lineTo(-.29,-.83);
		p2d.closePath();
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(-.29,-.91);
		p2d.lineTo(.29,-.91);
		p2d.lineTo(.39,-1);
		p2d.curveTo(-.2,-1.04,.2,-1.04,-.39,-1);
		p2d.closePath();
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(.37,.45);
		p2d.lineTo(.47,.43);
		g2d.setPaint(Color.WHITE);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(-.37,.45);
		p2d.lineTo(-.47,.43);
		g2d.setPaint(Color.WHITE);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		
		
		RoundRectangle2D roof = new RoundRectangle2D.Double(-0.015,-.9,.03,.9,0.1,0.1);
		g2d.setPaint(Color.DARK_GRAY);
		s = at.createTransformedShape(roof);
		g2d.draw(s);

		roof = new RoundRectangle2D.Double(-0.115,-.9,.03,.9,0.1,0.1);
		g2d.setPaint(Color.DARK_GRAY);
		s = at.createTransformedShape(roof);
		g2d.draw(s);
		
		roof = new RoundRectangle2D.Double(-0.115+.2,-.9,.03,.9,0.1,0.1);
		g2d.setPaint(Color.DARK_GRAY);
		s = at.createTransformedShape(roof);
		g2d.draw(s);
		
		roof = new RoundRectangle2D.Double(-0.115+.3,-.9,.03,.9,0.1,0.1);
		g2d.setPaint(Color.DARK_GRAY);
		s = at.createTransformedShape(roof);
		g2d.draw(s);
		
		roof = new RoundRectangle2D.Double(-0.115-.1,-.9,.03,.9,0.1,0.1);
		g2d.setPaint(Color.DARK_GRAY);
		s = at.createTransformedShape(roof);
		g2d.draw(s);
		
		roof = new RoundRectangle2D.Double(-.225,-.15,.45,.05,0.1,0.1);
		
		s = at.createTransformedShape(roof);
		g2d.setPaint(Color.BLACK);
		g2d.fill(s);
		g2d.setPaint(Color.DARK_GRAY);
		g2d.draw(s);
		
		
		roof = new RoundRectangle2D.Double(-.225,-.8,.45,.05,0.1,0.1);
		s = at.createTransformedShape(roof);
		g2d.setPaint(Color.BLACK);
		g2d.fill(s);
		g2d.setPaint(Color.DARK_GRAY);
		g2d.draw(s);
		
		RoundRectangle2D light = new RoundRectangle2D.Double(.2,1.03,.2,.03,.1,.1);
		s = at.createTransformedShape(light);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);
		
		light = new RoundRectangle2D.Double(-.4,1.03,.2,.03,.1,.1);
		s = at.createTransformedShape(light);
		g2d.setPaint(Color.GRAY);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(-.2,1.05);
		p2d.curveTo(.1,1.07,-.1,1.07,.2,1.05);
		g2d.setPaint(Color.GRAY);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(.2,1.05);
		p2d.curveTo(.25,.83,.25,.8,.25,.63);
		p2d.moveTo(-.2,1.05);
		p2d.curveTo(-.25,.83,-.25,.8,-.25,.63);
		p2d.moveTo(.35,.55);
		p2d.lineTo(.37,1);
		p2d.moveTo(-.35,.55);
		p2d.lineTo(-.37,1);
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.draw(s);
		
		
	}
	protected void paintSide(JPanel jp, Graphics2D g2d, AffineTransform at) {
		Debug.println("TestosteroneEliminator:paintSide()");
		at.scale(-1,1);
		Path2D p2d = new Path2D.Double();
		p2d.moveTo(-1.14,.1245);
		p2d.curveTo(-1.14, .3,-1.14,.3,-1.06875,.35);
		p2d.lineTo(-1.06875,.5);
		p2d.curveTo(-1.03,.53,-1.03,.53,-.5,.57);
		p2d.lineTo(-.21,.78);
		p2d.lineTo(.03,.79);
		p2d.lineTo(.14,.83);
		p2d.lineTo(.78,.83);
		p2d.lineTo(.93,.78);
		p2d.curveTo(1.07,.45,1.07,.45,1.07,.36);
		p2d.curveTo(1.14,.3,1.14,.12,1.07,.08);
		p2d.lineTo(-1,.08);
		p2d.curveTo(-1.1,.1,-1.1,.1,-1.14,.1245);
		g2d.setPaint(Color.BLACK);
		Shape s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(-.57, .08);
		p2d.curveTo(-.62,.42,-.91,.42,-.96,.08);
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(.78, .08);
		p2d.curveTo(.73,.42,.44,.42,.39,.08);
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(0, .53);
		p2d.lineTo(0, .73);
		p2d.lineTo(-.16, .73);
		p2d.lineTo(-.42,.53);
		p2d.closePath();
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(.1, .53);
		p2d.lineTo(.45,.53);
		p2d.lineTo(.38,.73);
		p2d.lineTo(.1, .73);
		p2d.closePath();
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(.55, .53);
		p2d.lineTo(.95,.53);
		p2d.lineTo(.88,.73);
		p2d.lineTo(.48, .73);
		p2d.closePath();
		g2d.setPaint(Color.DARK_GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(.36, .14);
		p2d.lineTo(.42,.29);
		p2d.lineTo(.08,.29);
		p2d.lineTo(.08,.14);
		p2d.closePath();
		g2d.setPaint(Color.GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(.03,.29);
		p2d.lineTo(.03,.14);
		p2d.lineTo(-.35,.14);
		p2d.lineTo(-.41,.29);
		p2d.closePath();
		g2d.setPaint(Color.GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(-1.05,.36);
		p2d.lineTo(-1,.5);
		p2d.curveTo(-1.05,.5,-1.05,.5,-1.05,.36);
		p2d.closePath();
		g2d.setPaint(Color.GRAY);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		p2d = new Path2D.Double();
		p2d.moveTo(1,.36);
		p2d.lineTo(1.07,.36);
		p2d.lineTo(1.06,.45);
		p2d.curveTo(1,.43,1,.43,1,.36);
		g2d.setPaint(Color.RED);
		s = p2d.createTransformedShape(at);
		g2d.fill(s);
		
		//wheels
		AffineTransform atwheelR = new AffineTransform(at);
		atwheelR.translate(-.77,.15);
		AffineTransform atwheelL = new AffineTransform(at);
		atwheelL.translate(.58,.15);
		
		Ellipse2D wheel = new Ellipse2D.Double(-.15,-.15,.3,.3);
		g2d.setPaint(Color.BLACK);
		s = atwheelL.createTransformedShape(wheel);
		g2d.fill(s);
		s = atwheelR.createTransformedShape(wheel);
		g2d.fill(s);
		
		wheel = new Ellipse2D.Double(-.12,-.12,.24,.24);
		g2d.setPaint(Color.GRAY);
		s = atwheelL.createTransformedShape(wheel);
		g2d.fill(s);
		s = atwheelR.createTransformedShape(wheel);
		g2d.fill(s);
		
		wheel = new Ellipse2D.Double(-.11,-.11,.22,.22);
		g2d.setPaint(Color.BLACK);
		s = atwheelL.createTransformedShape(wheel);
		g2d.fill(s);
		s = atwheelR.createTransformedShape(wheel);
		g2d.fill(s);
		
		wheel = new Ellipse2D.Double(-.03,-.03,.06,.06);
		g2d.setPaint(Color.GRAY);
		s = atwheelL.createTransformedShape(wheel);
		g2d.fill(s);
		s = atwheelR.createTransformedShape(wheel);
		g2d.fill(s);
		
		
		
	}
	public void paintShifter(JPanel jp, Graphics2D g2d, int gear, int maxGear) {
		Debug.println("MyCar:paintShifter()");
		String value = String.valueOf(gear);
		String maxValue = String.valueOf(maxGear);
		int w = SwingUtilities.computeStringWidth(
			g2d.getFontMetrics(),
			value
		);
		g2d.setPaint(Color.BLACK);
		g2d.drawString(
			value,
			10,
			jp.getHeight()-10
		);
		Path2D p2d;
		
		p2d = new Path2D.Double();
		p2d.moveTo(20,40);
		p2d.lineTo(40,40);
		p2d.lineTo(40,60);
		p2d.lineTo(50,60);
		p2d.lineTo(50,40);
		p2d.lineTo(70,40);
		p2d.lineTo(70,60);
		p2d.lineTo(80,60);
		p2d.lineTo(80,40);
		p2d.lineTo(100,40);
		p2d.lineTo(100,60);
		p2d.lineTo(110,60);
		p2d.lineTo(110,40);
		p2d.lineTo(130,40);
		p2d.lineTo(130,85);
		p2d.lineTo(100,85);
		p2d.lineTo(100,105);
		p2d.lineTo(80,105);
		p2d.lineTo(80,85);
		p2d.lineTo(70,85);
		p2d.lineTo(70,105);
		p2d.lineTo(50,105);
		p2d.lineTo(50,85);
		p2d.lineTo(40,85);
		p2d.lineTo(40,105);
		p2d.lineTo(20,105);
		p2d.lineTo(20,40);
		
		g2d.setPaint(Color.WHITE);
		g2d.fill(p2d);
		g2d.setPaint(Color.BLACK);
		g2d.draw(p2d);
		
		AffineTransform knob = new AffineTransform();
		Shape s;
		s = new Ellipse2D.Double(
				-15,
				-15,
				30,
				30
				);
		switch(gear){
			case 1:
				knob.translate(30,50);
				g2d.setPaint(Color.GREEN);
				break;
			case 2:
				knob.translate(30,95);	
				g2d.setPaint(Color.GREEN);
				break;
			case 3:
				knob.translate(60,50);
				g2d.setPaint(Color.YELLOW);
				break;
			case 4:
				knob.translate(60,95);
				g2d.setPaint(Color.YELLOW);
				break;
			case 5:
				knob.translate(90,50);
				g2d.setPaint(Color.ORANGE);
				break;
			case 6:
				knob.translate(90,95);
				g2d.setPaint(Color.RED);
				break;
			case 7:
				knob.translate(120,50);
				g2d.setPaint(Color.RED);
				break;
		}
		
		s = knob.createTransformedShape(s);
		g2d.fill(s);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
	}
}
