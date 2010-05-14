package edu.mccc.ist239.piechart;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class PieChart extends DKChart {
    
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
        Graphics2D g2d = (Graphics2D) g;
        //Bounding box that holds the fan
        Rectangle2D box = getBoundingBox();
        g.setColor(Color.black);      

        int[] data    = model.getData();
        int[] pieSize = getPieSize(data);

        //Draw the fan's perimeter
        g.drawOval(
            (int) box.getX(),
            (int) box.getY(),
            (int) box.getWidth(),
            (int) box.getHeight()
        );

        int i = 0;
        int currentAngle = 0;
        //int radius = 50;
        int radius = (int) box.getHeight() / 4;
        while (currentAngle < 360) {
            int angle = 0;
            if (i < data.length) {
                //We're still reading from the actual data
                angle = pieSize[i];

                //Increment the color
                g.setColor(
                    colors[i]
                );
            } else {
                //Note: This only here to compensate for rounding errors!
                //Round out the space, use the last color
                angle = 360 - currentAngle;
                //g.setColor(Color.GRAY);
                g.setColor(
                    colors[i - 1]
                );
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
            currentAngle += angle;
            i++;
            if (i < data.length) {
                int originX = (int) box.getX() + ((int) box.getWidth() / 2);
                int originY = (int) box.getY() + ((int) box.getHeight() / 2);

                double radians = Math.toRadians(angle);
//                double radians = Math.toRadians(angle + currentAngle);
                int textY = (int) (originY -
                (radius * Math.sin(
                    radians
                )));
                int textX = (int) (originX +
                (radius * Math.cos(
                    radians
                )));
                System.out.println(
                    "Angle: " + angle
                );
                System.out.println(
                    String.format(
                        "Text: (%d, %d)",
                        textX,
                        textY
                    )
                );

                g2d.setColor(Color.BLACK);
                g2d.drawString(
                    //dataName[i],
                    "TEXT",
                    textX,
                    textY
                );
            }
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
        //double multiplier = (double) total / maxAngle;
        double multiplier = (double) maxAngle / total; 
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
