import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class TrafficLight extends JComponent {
    private TrafficLight.TrafficColor color;
    private static final int BORDER = 10;

    public TrafficLight() {
        //color = TrafficColor.RED;
        color = TrafficColor.YELLOW;
        //color = TrafficColor.GREEN;
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 500);
        //return new Dimension(200, 200);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int trafficWidth = (getWidth() / 2) - (2 * BORDER);
        //Draw traffic light
        g.drawRect(
            BORDER,
            BORDER,
            trafficWidth,
            getHeight() - (2 * BORDER)
        );
        int ovalHeight = (getHeight() / 3) - (2 * BORDER);
        for (int i = 0; i < 3; i++) {
            if (i == color.getValue()) {
                g.setColor(color.getColor());
                //g.setColor(Color.RED);

                g.fillOval(
                    BORDER,
                    BORDER + (i * ovalHeight),
                    trafficWidth,
                    ovalHeight
                );
            } else {
                //g.setColor(OFF_COLOR);
                g.setColor(Color.BLACK);
                g.drawOval(
                    BORDER,
                    BORDER + (i * ovalHeight),
                    trafficWidth,
                    ovalHeight
                );
            }
        }
    }

    public class ButtonPanel {
        public ButtonPanel() {
            //use radio buttons
            //Sends a TrafficLightEvent when clicked
        }
    }

    public enum TrafficColor {
        RED    ( 0, Color.RED ) ,
        YELLOW ( 1, Color.YELLOW ) ,
        GREEN  ( 2, Color.GREEN ) ;
        
        private final int value; 
        private final Color color; 
        TrafficColor(int value, Color color) {
            this.value = value;
            this.color = color;
        }
        private int getValue()   { return value; }
        private Color getColor()   { return color; }
    }
}
