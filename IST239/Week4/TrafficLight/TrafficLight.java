import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.lang.reflect.*;

public class TrafficLight extends JComponent implements ActionListener {
    private TrafficColor color;
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

    public void setColor(TrafficColor color) {
        this.color = color;
        repaint();
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
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        actionCommand = actionCommand.toUpperCase();
        System.out.println("Event ID: " + e.getID());
        //System.out.println("State changed: " + actionCommand);
    }

    public static class ButtonPanel extends JPanel {
        String redString    = "Red";
        String yellowString = "Yellow";
        String greenString  = "Green";

        TrafficLight trafficLight;

        //public ButtonPanel(ActionListener listener) {
        public ButtonPanel(TrafficLight newLight) {

            this.trafficLight = newLight;
            
            JRadioButton redButton = new JRadioButton(redString);
            redButton.setMnemonic(KeyEvent.VK_P);
            redButton.setActionCommand(redString);

            JRadioButton yellowButton = new JRadioButton(yellowString);
            yellowButton.setMnemonic(KeyEvent.VK_P);
            yellowButton.setActionCommand(yellowString);

            JRadioButton greenButton = new JRadioButton(greenString);
            greenButton.setMnemonic(KeyEvent.VK_P);
            greenButton.setActionCommand(greenString);

            //Group the radio buttons.
            ButtonGroup group = new ButtonGroup();
            group.add(redButton);
            group.add(yellowButton);
            group.add(greenButton);

            JPanel radioPanel = new JPanel(new GridLayout(0, 1));
            radioPanel.add(redButton);
            radioPanel.add(yellowButton);
            radioPanel.add(greenButton);

            add(radioPanel);

            //Register a trafficLight for the radio buttons.
            //   redButton.addActionListener(trafficLight);
            //yellowButton.addActionListener(trafficLight);
            // greenButton.addActionListener(trafficLight);

            redButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    trafficLight.setColor(TrafficColor.RED);
                }
            });
            yellowButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    trafficLight.setColor(TrafficColor.YELLOW);
                }
            });
            greenButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    trafficLight.setColor(TrafficColor.GREEN);
                }
            });
        }
    }

}
