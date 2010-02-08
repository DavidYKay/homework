package edu.mccc.cos210.dial;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import com.cbthinkx.util.Debug;
public class MVCView3 extends JPanel implements MVCModelListener {
	private MVCModel model;
    //Init to -1 because we advance one lap right off the bat
    private int laps = -2;
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
        if (value == 0) {
            laps++;
        }

        //Draw the ring
        Ellipse2D.Double ring = new Ellipse2D.Double(
            getWidth()  * .1,
            getHeight() * .1,
            getWidth()  * .8,
            getHeight() * .8
        );

        g2d.setPaint(Color.BLACK);
        g2d.fill(ring);
        g2d.setPaint(Color.BLACK);
        g2d.draw(ring);

        //Transform graphics
        g2d.transform(getGraphicsTransform());

        System.out.println("Value is: " + value);
        //Shows the current value of the model, 
        //analogous to the progressbar or counter
        Line2D minuteLine = new Line2D.Double(
            0,
            0,
            0,
            -getClockRadius()
        );
        //Advances by one tick after each lap around the clock
        Line2D hourLine = new Line2D.Double(
            0,
            0,
            0,
            -(getCenter().getHeight() * .6)
        );
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

        //drawNumbers(g2d);

		g2d.dispose();
	}
    private void drawNumbers(Graphics2D g2d) {
        for (int i = 0; i < NUM_HOURS; i++) {
            //Draw a number at the current position on the clock face
        }
    }
    private void drawTicks(Graphics2D g2d) {
        for (int i = 0; i < MINUTES_PER_HOUR; i++) {
            //Draw a tick at the current position on the clock face
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
    public AffineTransform getRotateTransform(double degrees) {
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
    public AffineTransform getGraphicsTransform() {
        Debug.println("MVCView3.getGraphicsTransform()");
        AffineTransform at = new AffineTransform();
        final double trans_x = getCenter().getWidth();
        final double trans_y = getCenter().getHeight();
        final double scale_x = 1.0;
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
