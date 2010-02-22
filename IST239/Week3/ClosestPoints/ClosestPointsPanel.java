import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class ClosestPointsPanel extends JPanel {

    private static final int POINT_RADIUS = 10;

    /** Holds all points in the graph */
    private ArrayList<Point> points = new ArrayList<Point>();
    /** Holds only the closest pair */
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

    private Point[] divideAndConquer() {
        Point[] tempPoints = (Point[]) points.toArray();
        int numPoints = tempPoints.length;
        //1. Sort points along the x-coordinate
        Arrays.sort(tempPoints, new PointComparator());
        double minX = tempPoints[0].getX();
        double maxX = tempPoints[numPoints - 1].getX();
        //2. Split the set of points into two equal-sized subsets by a vertical
        //line x = xmid
        double xMid = (minX + maxX) / 2;

        LinkedList<Point> tempLeft  = new LinkedList<Point>();
        LinkedList<Point> tempRight = new LinkedList<Point>();
        for (int i = 0; i < numPoints / 2; i++) {
            if (tempPoints[i].getX() < xMid) {
                tempLeft.add(tempPoints[i]);
            } else {
                tempRight.add(tempPoints[i]);
            }
        }
        Point[] leftSubset  = (Point[]) tempLeft.toArray();
        Point[] rightSubset = (Point[]) tempRight.toArray();

        //3. Solve the problem recursively in the left and right subsets. This 
        //will give the left-side and right-side minimal distances 
        //dLmin and dRmin respectively.
        double minLeft  = getMinDistanceFromSubset(leftSubset,  Double.POSITIVE_INFINITY);
        double minRight = getMinDistanceFromSubset(rightSubset, Double.POSITIVE_INFINITY);

        //4. Find the minimal distance dLRmin among the pair of points in which
        //one point lies on the left of the dividing vertical and the second 
        //point lies to the right.
        double minMid = rightSubset[0].getX() - leftSubset[leftSubset.length - 1].getX();

        //5. The final answer is the minimum among dLmin, dRmin, and dLRmin.
        double finalMin = Math.min(
            minMid,
            Math.min(minLeft, minRight)
        );
        System.out.println("Final min is: " + finalMin);
        /*
        */
        Point[] closestPair = new Point[2];
        return closestPair;
    }
    /**
     * Recursive algorithm to get the min distance from a set of points
     * On each recursion, the head (first index) is chopped off and the tail is
     * fed back in.
     */
    private double getMinDistanceFromSubset(Point[] subset, double min) {
        if (subset.length == 0) {
            return min;
        } else {
            //We'll stash all of subset in here except the first entry,
            //just like lisp's CDR operator
            Point[] newSubset = new Point[subset.length - 1];

            //Find the min dist from A to each B
            for (int i = 1; i < subset.length; i++) {
                double newMin = subset[0].distance(subset[1]);
                if (newMin < min) {
                    min = newMin;
                }
                newSubset[i - 1] = subset[i];
            }
            //Chop off A
            return getMinDistanceFromSubset(newSubset, min);
        }
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
                g.fillOval(
                    (int) point.getX() - (bigRadius / 2),
                    (int) point.getY() - (bigRadius / 2),
                    bigRadius,
                    bigRadius
                );
            }
        }
    }
}
