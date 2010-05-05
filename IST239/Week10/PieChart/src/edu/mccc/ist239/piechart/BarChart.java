package edu.mccc.ist239.piechart;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class BarChart extends JPanel {
    private DataModel model;
    private int currentAngle = 0;

    public BarChart(DataModel model) {
        this.model = model;
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

    private double[] getBarAngles(int[] data) {
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
        //Width available for use
        int width  = (int) box.getWidth();
        int height = (int) box.getHeight();
        //Width per bar in the chart
        int widthBar = width / dataName.length;

        int[] data = model.getData();
        for (int n : data) {
            System.out.println(
                String.format(
                    "data point: %d",
                    n
                )
            );
        }
        int[] barHeight = getBarHeight(
            //model.getData()
            data,
            height
        );

        int x = (int) box.getX();
        for (int i = 0; i < dataName.length; i++) {
            g.setColor(colors[i]);
            g.fillRect(
                x,
                (int) box.getY(),
                widthBar,
                //height
                barHeight[i]
            );
            x += widthBar;
        }
    }

    private int[] getBarHeight(int[] data, int maxHeight) {
        int[] height = new int[data.length];
        int total = 0;
        for (int n : data) {
            total += n;
            System.out.println(
                "Total: " + total
            );
        }
        for (int i = 0; i < data.length; i++) {
            height[i] = (int) (((double) data[i] / total) * maxHeight);
            System.out.println(
                String.format(
                    "Height[%d], %d",
                    i,
                    height[i]
                )
            );
        }
        return height;
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
