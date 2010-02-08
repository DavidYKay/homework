import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class TicTacToe {
   
    private static final int BOX_O     = 1;
    private static final int BOX_X     = 2;

    private static final int NUM_BOXES = 9;
    private static final int ROWS      = 3;
    private static final int COLUMNS   = NUM_BOXES / ROWS;
    
    private final ImageIcon O = new ImageIcon("o.png");
    private final ImageIcon X = new ImageIcon("x.png");

    public static void main(String[] args) {
        new TicTacToe().test();
    }
    
    public void test() {
        JFrame frame = new JFrame();
        frame.setTitle("TicTacToe");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(ROWS, COLUMNS));
        JLabel[] boxes = makeTicTacToe();
        for (JLabel box : boxes) {
            frame.add(box);
        }
        frame.pack();
        frame.setVisible(true);
    }

    private JLabel[] makeTicTacToe() {
    	Random rand = new Random();
        JLabel[] boxes = new JLabel[NUM_BOXES];
        for (int i = 0; i < NUM_BOXES; i++) {
            //Generate a random number
            int which = rand.nextInt(3);
            JLabel label;        
            switch (which) {
                case BOX_X:
                    label = new JLabel(X);        
                    break;
                case BOX_O:
                    label = new JLabel(O);        
                    break;
                default:
                    label = new JLabel(" ");        
                    break;
            }
            label.setBorder(new LineBorder(Color.GREEN));
            boxes[i] = label;
        }
        return boxes;
    }
}
