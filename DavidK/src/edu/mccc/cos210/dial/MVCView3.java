package edu.mccc.cos210.dial;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import com.cbthinkx.util.Debug;
public class MVCView3 extends JPanel implements MVCModelListener {
	private MVCModel model;
    //Init to -1 because we advance one lap right off the bat
    private static final int NUM_HOURS = 10;
    private static final int MINUTES_PER_HOUR = 100;
	public MVCView3(MVCModel model) {
		Debug.println("MVCView3()");
		this.model = model;
		setLayout(null);
		setBackground(Color.RED);
	}
	public void paintComponent(Graphics g) {
		Debug.println("MVCView3.paintComponent()");
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();

		int value = this.model.getValue();
		int laps  = this.model.getHours();

        //Draw the ring
        Ellipse2D.Double ring = new Ellipse2D.Double(
            getWidth()  * .1,
            getHeight() * .1,
            getWidth()  * .8,
            getHeight() * .8
        );

        g2d.setPaint(Color.WHITE);
        g2d.fill(ring);
        g2d.setPaint(Color.WHITE);
        g2d.draw(ring);

        //Transform graphics
        g2d.transform(getGraphicsTransform());

        //Shows the current value of the model, 
        //analogous to the progressbar or counter
        Path2D minuteLine = new Path2D.Double();
        minuteLine.moveTo(0,0);
        minuteLine.lineTo(-10,0);
        minuteLine.lineTo(0, -getClockRadius());
        minuteLine.lineTo(10,0);
        minuteLine.lineTo(0,0);
        minuteLine.closePath();
        
        Path2D hourLine = new Path2D.Double();
        hourLine.moveTo(0,0);
        hourLine.lineTo(-10,0);
        hourLine.lineTo(0, -getHourHandLength());
        hourLine.lineTo(10,0);
        hourLine.lineTo(0,0);
        hourLine.closePath();
        //Draw/Transform minuteLine
        double degrees = value * 3.6;
        Shape s = getRotateTransform(degrees).createTransformedShape(minuteLine);

        g2d.setPaint(Color.BLUE);
        g2d.fill(s);
        g2d.setPaint(Color.BLUE);
        g2d.draw(s);

        //Draw/Transform hourLine
        degrees = laps * 36;
        s = getRotateTransform(degrees).createTransformedShape(hourLine);

        g2d.setPaint(Color.BLUE);
        g2d.fill(s);
        g2d.setPaint(Color.BLUE);
        g2d.draw(s);

        drawTicks(g2d);

		g2d.dispose();
	}
    private void drawTicks(Graphics2D g2d) {
        for (int i = 1; i <= MINUTES_PER_HOUR; i++) {
            AffineTransform at = getRotateTransform(i * 360 / MINUTES_PER_HOUR);
            Shape tick;
            //Draw a tick at the current position on the clock face
            if (i % NUM_HOURS == 0) {
                //HOUR tick
                tick = new Line2D.Double(
                    0,
                    getClockRadius(),
                    0,
                    getClockRadius() - 10
                );
            } else {
                //MINUTE tick
                tick = new Line2D.Double(
                    0,
                    getClockRadius(),
                    0,
                    getClockRadius() -5
                );
            }
            tick = at.createTransformedShape(tick);
            g2d.setPaint(Color.BLACK);
            g2d.fill(tick);
            g2d.setPaint(Color.BLACK);
            g2d.draw(tick);
        }
    }
	public Dimension getPreferredSize() {
		Debug.println("MVCView3.getPreferredSize()");
		return new Dimension(400, 400);
	}
	public void stateChanged(MVCModelEvent e) {
		Debug.println("MVCView3.stateChanged()");
		repaint();
	}
    private AffineTransform getRotateTransform(double degrees) {
        Debug.println("MVCView3.getShapeTransform()");
        AffineTransform at = new AffineTransform();
        try {
            at.rotate(
                Math.toRadians(
                    degrees
                )
            );
        } catch (NumberFormatException ex) {
        }
        return at;
    }
    private AffineTransform getGraphicsTransform() {
        Debug.println("MVCView3.getGraphicsTransform()");
        AffineTransform at = new AffineTransform();
        final double trans_x = getCenter().getWidth();
        final double trans_y = getCenter().getHeight();
        final double scale_x = (double) ((double) getWidth() / getHeight());
        final double scale_y = 1.0;
        try {
            at.translate(
                trans_x,
                trans_y
            );
            at.scale(
                scale_x,
                scale_y
            );
        } catch (NumberFormatException ex) {
        }
        return at;
    }
    private double getClockRadius() {
        return getHeight() * .4;
    }
    private double getHourHandLength() {
        return getClockRadius() * .6;
    }
    private Dimension getCenter() {
        return new Dimension(getWidth() / 2, getHeight() / 2);
    }
}
