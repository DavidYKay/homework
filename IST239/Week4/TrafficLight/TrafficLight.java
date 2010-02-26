import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class TrafficLight extends JComponent {
    private TrafficLight.Color color;

    public TrafficLight() {
        
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Draw traffic light

        //Check radio button status
    }

    public class ButtonPanel {
        public ButtonPanel() {
            //use radio buttons
            //Sends a TrafficLightEvent when clicked
        }
    }

    public enum Color {
        RED,
        YELLOW,
        GREEN
    }
}
