import javax.swing.JOptionPane;

public class AssignGrade {
  /** Main method */
  public static void main(String[] args) {
    // Get number of students
    String numberOfStudentsString = JOptionPane.showInputDialog(
      "Please enter number of students:");

    // Convert string into integer
    int numberOfStudents = Integer.parseInt(numberOfStudentsString);

    int[] scores = new int[numberOfStudents]; // Array scores
    int best = 0; // The best score
    char grade; // The grade

    // Read scores and find the best score
    for (int i = 0; i < scores.length; i++) {
      String scoreString = JOptionPane.showInputDialog(
        "Please enter a score:");

      // Convert string into integer
      scores[i] = Integer.parseInt(scoreString);
      if (scores[i] > best)
        best = scores[i];
    }

    // Declare and initialize output string
    String output = "";

    // Assign and display grades
    for (int i = 0; i < scores.length; i++) {
      if (scores[i] >= best - 10)
        grade = 'A';
      else if (scores[i] >= best - 20)
        grade = 'B';
      else if (scores[i] >= best - 30)
        grade = 'C';
      else if (scores[i] >= best - 40)
        grade = 'D';
      else
        grade = 'F';

      output += "Student " + i + " score is " +
        scores[i] + " and grade is " + grade + "\n";
    }

    // Display the result
    JOptionPane.showMessageDialog(null, output);
  }
}
