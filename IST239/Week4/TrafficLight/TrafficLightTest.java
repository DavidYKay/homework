import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class TrafficLightTest {
    
    public static void main(String[] sa) {
        new TrafficLightTest().doit();
    }

    public void doit() {
		JFrame frame = new JFrame();
		frame.setTitle("Investment Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());

        TrafficLight trafficLight = new TrafficLight();
        frame.add(trafficLight);
        frame.add(new TrafficLight.ButtonPanel(trafficLight));

		frame.pack();
		frame.setVisible(true);
    }

    //private void updateLight(TrafficLightEvent e) {
    //    trafficLight.setColor(
    //        e.getColor()
    //    );
    //}
}
