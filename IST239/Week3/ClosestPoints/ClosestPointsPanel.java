import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class ClosestPointsPanel extends JPanel {

    private static final int POINT_RADIUS = 10;

    private ArrayList<Point> points = new ArrayList<Point>();
    private Point[] closest = new Point[2];

    /** The width of the game area, as specified by in the constructor */
    private int xMax;
    /** The height of the game area, as specified by in the constructor */
    private int yMax;

    public ClosestPointsPanel(int xMax, int yMax, ClosestPoints cp) {
        //Null out layout manager for absolute positioning
        this.xMax   = xMax;
        this.yMax   = yMax;
        this.setLayout(null);

        addMouseListener(new MouseAdapter() { 
            public void mouseClicked(MouseEvent me) { 
                //Add point at clicked location
                addPoint(
                    me.getX(),
                    me.getY()
                );
                //System.out.println(me); 
            } 
        }); 

        newGame();
	}

    public void newGame() {
        //clear the JPanel
        removeAll();
        points.clear();
        repaint();
    }

    private void addPoint(int x, int y) {
        Point point = new Point(x, y);
        points.add(point);
        System.out.println(point); 
        updateClosest();
        repaint();
    }

    private void updateClosest() {
        closest = bruteForce();
        if (closest != null) {
            System.out.print("The closest are: ");
            System.out.print(closest[0]);
            System.out.print(", ");
            System.out.println(closest[1]);
        }
    }

    private Point[] bruteForce() {
        Point[] closestPair = new Point[2];
        double minDistance = Double.POSITIVE_INFINITY;
        
        for (Point a : points) {
            for (Point b : points) {
                if (a != b && a.distance(b) < minDistance) {
                    minDistance = a.distance(b);
                    closestPair[0] = a;
                    closestPair[1] = b;
                }
            }
        }
        return closestPair;
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(xMax, yMax);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (Point point : points) {
            g.fillOval(
                (int) point.getX() - (POINT_RADIUS / 2),
                (int) point.getY() - (POINT_RADIUS / 2),
                POINT_RADIUS,
                POINT_RADIUS
            );
        }
        g.setColor(Color.BLUE);
        if (closest != null && 
            closest[0] != null && 
            closest[1] != null
        ) {
            for (Point point : closest) {
                int bigRadius = POINT_RADIUS + 3;
                g.drawOval(
                    (int) point.getX() - (bigRadius / 2),
                    (int) point.getY() - (bigRadius / 2),
                    bigRadius,
                    bigRadius
                );
            }
        }
    }
}
