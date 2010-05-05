import javax.swing.JOptionPane;

public class DisplayTime {
  public static void main(String[] args) {
    int seconds = 10000;
    int totalMinutes = seconds / 60;
    int hours = totalMinutes / 60;
    int minutes = totalMinutes % 60;
    JOptionPane.showMessageDialog(null,
      seconds + " seconds is " + hours +
      " hours and " + minutes + " minutes");
  }
}
