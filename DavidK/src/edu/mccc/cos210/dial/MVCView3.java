package edu.mccc.cos210.dial;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import com.cbthinkx.util.Debug;
public class MVCView3 extends JPanel implements MVCModelListener {
	private MVCModel model;
    //Init to -1 because we advance one lap right off the bat
    private int laps = -1;
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

        System.out.println("Value is: " + value);
        //Shows the current value of the model, 
        //analogous to the progressbar or counter
        Line2D valueLine = new Line2D.Double(
            0,
            0,
            0,
            -200
        );
        //Advances by one tick after each lap around the clock
        Line2D lapLine = new Line2D.Double(
            0,
            0,
            0,
            -120
        );
        //Transform graphics
        g2d.transform(getGraphicsTransform());
        //Draw/Transform valueLine
        double degrees = value * 3.6;
        Shape s = getRotateTransform(degrees).createTransformedShape(valueLine);

        g2d.setPaint(Color.BLUE);
        g2d.fill(s);
        g2d.setPaint(Color.BLUE);
        g2d.draw(s);

        //Draw/Transform lapLine
        degrees = laps * 36;
        s = getRotateTransform(degrees).createTransformedShape(lapLine);

        g2d.setPaint(Color.BLUE);
        g2d.fill(s);
        g2d.setPaint(Color.BLUE);
        g2d.draw(s);

		g2d.dispose();
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
        final double trans_x = 200;
        final double trans_y = 200;
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
}
