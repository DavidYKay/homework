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
        //System.out.println("State changed: " + actionCommand);

        //Enum reflection code modified from example on StackOverflow.com
        try {
            //Class<?> clz = Class.forName("test.PropertyEnum");
            //Class<?> clz = Class.forName("TrafficLight.TrafficColor");
            Class<?> clz = Class.forName("TrafficColor");
            /* Use method added in Java 1.5. */
            Object[] consts = clz.getEnumConstants();
            /* Enum constants are in order of declaration. */
            Class<?> sub = consts[0].getClass();

            //Method mth = sub.getDeclaredMethod("getValue");
            Method mth = sub.getDeclaredMethod("getColor");
            //String val = (String) mth.invoke(consts[0]);
            Color val = (Color) mth.invoke(consts[0]);
            /* Prove it worked. */
            //System.out.println("getDefaultValue " + val.equals(PropertyEnum.SYSTEM_PROPERTY_ONE.getDefaultValue()));
            System.out.println("Class: " + clz);
            System.out.println("Sub: " + sub);
            System.out.println("Method: " + mth);
            System.out.println("Result: " + val);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static class ButtonPanel extends JPanel {
        String redString    = "Red";
        String yellowString = "Yellow";
        String greenString  = "Green";

        public ButtonPanel(ActionListener listener) {
            
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

            //Register a listener for the radio buttons.
               redButton.addActionListener(listener);
            yellowButton.addActionListener(listener);
             greenButton.addActionListener(listener);
        }
    }

}
