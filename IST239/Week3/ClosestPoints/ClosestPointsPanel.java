import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class ClosestPointsPanel extends JPanel {

    private static final int POINT_RADIUS = 10;

    private ArrayList<Point> points = new ArrayList<Point>();

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
                //System.out.println(me); 
                addPoint(
                    me.getX(),
                    me.getY()
                );
            } 
        }); 

        newGame();
	}

    public void newGame() {
        //clear the JPanel
        removeAll();
        points.clear();
    }

    private void addPoint(int x, int y) {
        Point point = new Point(x, y);
        points.add(point);
        System.out.println(point); 
        repaint();
    }

    private void nextRound(long prevTime) {
        //Create a new ball
        //Add the ball to the panel
        //add(ball);
        Container pane = this;
        //Insets insets = pane.getInsets();
        //Dimension size = ball.getPreferredSize();
        //ball.setBounds(
        //    //25 + insets.left, 5 + insets.top,
        //    getRandom(xMax, size.width), 
        //    getRandom(yMax, size.height), 
        //    size.width, 
        //    size.height
        //);
        //Mark the time
        repaint();
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(xMax, yMax);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point point : points) {
            g.fillOval(
                (int) point.getX(),
                (int) point.getY(),
                POINT_RADIUS,
                POINT_RADIUS
            );
        }
    }
}
