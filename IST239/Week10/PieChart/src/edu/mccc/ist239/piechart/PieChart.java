package edu.mccc.ist239.piechart;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

//public class PieChart extends JPanel {
public class PieChart extends DKChart {
    private final int BLADE_ANGLE = 20;
    
    public PieChart(DataModel model) {
        super(model);
    }

    private String[] dataName = {
        "CS",
        "Math",
        "Chem",
        "Bio",
        "Phys"
    };

    private Color[] colors = {
        Color.RED,
        Color.GREEN,
        Color.BLUE,
        Color.YELLOW,
        Color.MAGENTA
    };

    private double[] getPieAngles(int[] data) {
        int total = 0;
        double percentages[] = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            total += data[i];
        }
        for (int i = 0; i < data.length; i++) {
            percentages[i] = (double) data[i] / total;
            System.out.println(
                "Percentages: " + percentages[i]
            );
        }
        return percentages;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("PaintComponent");
        //Bounding box that holds the fan
        Rectangle2D box = getBoundingBox();
        g.setColor(Color.black);      

        int[] data         = model.getData();
        double[] pieAngles = getPieAngles(data);
        int[] pieSize      = getPieSize(data);

        //Draw the fan's perimeter
        g.drawOval(
            (int) box.getX(),
            (int) box.getY(),
            (int) box.getWidth(),
            (int) box.getHeight()
        );
        //Draw four fan blades
        //for(int startAngle = currentAngle; startAngle < 360 + currentAngle; startAngle += 90) {
        //    g.fillArc(
        //        (int) box.getX(),
        //        (int) box.getY(),
        //        (int) box.getWidth(),
        //        (int) box.getHeight(),
        //        startAngle,
        //        BLADE_ANGLE
        //    );
        //}

        int i = 0;
        int currentAngle = 0;
        //for(int startAngle = 0; startAngle < 360; startAngle += currentAngle) {
        while (currentAngle < 360) {
            int angle = 0;
            if (i < data.length - 1) {
                //We're still reading from the actual data
                angle = data[i];
                //Increment the color
                g.setColor(
                    colors[i]
                );
            } else {
                //Round out the space, use the last color
                angle = 360 - currentAngle;
            }
            System.out.println(
                String.format(
                    "Filling arc from %s to %s, color: %s",
                    currentAngle,
                    //angle,
                    currentAngle + angle,
                    g.getColor()
                )
            );
            g.fillArc(
                (int) box.getX(),
                (int) box.getY(),
                (int) box.getWidth(),
                (int) box.getHeight(),
                currentAngle,
                angle
            );
            i++;
            currentAngle += angle;
        }
    }

    private int[] getPieSize(int[] data) {
        final int maxAngle = 360;
        int[] angle = new int[data.length];
        int total = 0;
        for (int n : data) {
            total += n;
            System.out.println(
                "Total: " + total
            );
        }
        for (int i = 0; i < data.length; i++) {
            angle[i] = (int) (((double) data[i] / total) * maxAngle);
            System.out.println(
                String.format(
                    "Angle[%d], %d",
                    i,
                    angle[i]
                )
            );
        }
        return angle;
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
