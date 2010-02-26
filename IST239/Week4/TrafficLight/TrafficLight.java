import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class TrafficLight extends JComponent implements ActionListener {
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
    public void actionPerformed(ActionEvent e) {
        System.out.println("State changed!");
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
