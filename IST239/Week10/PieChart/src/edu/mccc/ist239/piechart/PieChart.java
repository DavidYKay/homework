package edu.mccc.ist239.piechart;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class PieChart extends JPanel {
    private int currentAngle = 0;
    private final int BLADE_ANGLE = 20;

    private String[] dataName = {
        "CS",
        "Math",
        "Chem",
        "Bio",
        "Phys"
    };

    private double[] getPieAngles(int[] data) {
        int total = 0;
        double percentages[] = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            total += data[i];
        }
        for (int i = 0; i < data.length; i++) {
            percentages[i] = data[i] / total;
        }
        return percentages;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("PaintComponent");
        //Bounding box that holds the fan
        Rectangle2D box = getBoundingBox();
        g.setColor(Color.black);      
        //Draw the fan's perimeter
        g.drawOval(
                (int) box.getX(),
                (int) box.getY(),
                (int) box.getWidth(),
                (int) box.getHeight()
                );
        //Draw four fan blades
        for(int startAngle = currentAngle; startAngle < 360 + currentAngle; startAngle += 90) {
            g.fillArc(
                    (int) box.getX(),
                    (int) box.getY(),
                    (int) box.getWidth(),
                    (int) box.getHeight(),
                    startAngle,
                    BLADE_ANGLE
            );
        }
    }

    private Rectangle2D.Double getBoundingBox() {
        return new Rectangle2D.Double(
            (getWidth()  * .1),
            (getHeight() * .1),
            (getWidth()  * .8),
            (getHeight() * .8)
        );
    }
} 
