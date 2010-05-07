package edu.mccc.ist239.piechart;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

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

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("PaintComponent");
        //Bounding box that holds the fan
        Rectangle2D box = getBoundingBox();
        g.setColor(Color.black);      

        int[] data         = model.getData();
        int[] pieSize      = getPieSize(data);

        //Draw the fan's perimeter
        g.drawOval(
            (int) box.getX(),
            (int) box.getY(),
            (int) box.getWidth(),
            (int) box.getHeight()
        );

        int i = 0;
        int currentAngle = 0;
        while (currentAngle < 360) {
            int angle = 0;
            if (i < data.length) {
                //Increment the color
                g.setColor(
                    colors[i]
                );
                //We're still reading from the actual data
                //angle = data[i];
                angle = pieSize[i];
            } else {
                //Note: This only here to compensate for rounding errors!
                //Round out the space, use the last color
                angle = 360 - currentAngle;
                //g.setColor(Color.GRAY);
                System.out.println(
                    "Filler angle: " + angle
                );
            }
            System.out.println(
                String.format(
                    "Filling arc from %s to %s, color: %s",
                    currentAngle,
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
                "n: " + n
            );
        }
        System.out.println(
            "Total: " + total
        );
        //double multiplier = (double) total / 360;
        double multiplier = (double) 360 / total; 
        System.out.println(
            "Multiplier: " + multiplier
        );
        for (int i = 0; i < data.length; i++) {
            angle[i] = (int) ((double) data[i] * multiplier);
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
