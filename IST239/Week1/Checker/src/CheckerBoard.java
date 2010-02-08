import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CheckerBoard {

    private static final int NUM_CHECKERS = 64;
    private static final int ROWS         = 8;
    private static final int COLUMNS      = 8;

    public static void main(String[] args) {
        new CheckerBoard().test();
    }
    
    public void test() {
        JFrame frame = new JFrame();
        frame.setTitle("CheckerBoard");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(8, 8));
        JPanel[] checkers = makeCheckers();
        for (JPanel checker : checkers) {
            frame.add(checker);
        }
//        frame.pack();
        frame.setVisible(true);
    }

    private JPanel[] makeCheckers() {
        JPanel[] checkers = new JPanel[NUM_CHECKERS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                Color color;
                if (i % 2 == 0) {       //Even rows
                    if (j % 2 == 0) {
                        color = Color.RED;
                    } else {
                        color = Color.BLACK;
                    }
                } else {                //Odd rows
                    if (j % 2 == 0) {
                        color = Color.BLACK;
                    } else {
                        color = Color.RED;
                    }
                }
                JPanel panel = new JPanel();        
                panel.setBackground(color);
                panel.setBorder(new LineBorder(Color.GREEN));
                checkers[8 * i + j] = panel;
            }
        }
        return checkers;
    }
}
