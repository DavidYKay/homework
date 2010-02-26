import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class TrafficLightTest {
    private TrafficLight trafficLight;
    
    public TrafficLightTest() {
    }

    public static void main(String[] sa) {
        new TrafficLightTest().doit();
    }

    public void doit() {
		JFrame frame = new JFrame();
		frame.setTitle("Investment Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		//frame.setLayout();

        //frame.add(new TrafficLight.ButtonPanel(this));
        //frame.add(new TrafficLight(this));
        frame.add(new TrafficLight());

		frame.pack();
		frame.setVisible(true);
    }

    //private void updateLight(TrafficLightEvent e) {
    //    trafficLight.setColor(
    //        e.getColor()
    //    );
    //}
}
