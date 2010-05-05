import java.awt.*;
import javax.swing.*;

public class TestFigureCanvas extends JFrame {
  public TestFigureCanvas() {
    setLayout(new GridLayout(2, 3, 5, 5));
    add(new FigureCanvas(FigureCanvas.LINE));
    add(new FigureCanvas(FigureCanvas.RECTANGLE));
    add(new FigureCanvas(FigureCanvas.ROUND_RECTANGLE));
    add(new FigureCanvas(FigureCanvas.OVAL));
    add(new FigureCanvas(FigureCanvas.RECTANGLE, true));
    add(new FigureCanvas(FigureCanvas.ROUND_RECTANGLE, true));
  }

  public static void main(String[] args) {
    TestFigureCanvas frame = new TestFigureCanvas();
    frame.setSize(400, 200);
    frame.setTitle("TestFigureCanvas");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}

