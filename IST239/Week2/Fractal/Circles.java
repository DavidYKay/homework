import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Circles {

    public static void main(String[] args) {
        new Circles().test();
    }
    public void test() {
        JFrame frame = new JFrame();
        frame.setTitle("Circles");
//        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        frame.add(new CirclePanel(), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

}
