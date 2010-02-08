import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
public class PlayingCards {

    private static final int NUM_CARDS = 3;
    private static final int MAX_CARD  = 52;


    public static void main(String[] args) {
        new PlayingCards().test();
    }
    
    public void test() {
        JFrame frame = new JFrame();
        frame.setTitle("Cards");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        frame.setLayout(new GridLayout(1, 3));
        JLabel[] boxes = makeCards();
        for (JLabel box : boxes) {
            frame.add(box);
        }
        frame.pack();
//      frame.doLayout();
        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);

    }

    private JLabel[] makeCards() {
    	Random rand = new Random();
        JLabel[] boxes = new JLabel[NUM_CARDS];
        for (int i = 0; i < NUM_CARDS; i++) {
            //Generate a random number
            int which = rand.nextInt(MAX_CARD);
            String filename = "images/deck/" + which + ".png";
            JLabel label = new JLabel(new ImageIcon(filename));
            label.setBorder(new LineBorder(Color.GREEN));
            boxes[i] = label;
        }
        return boxes;
    }
}
