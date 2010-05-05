import javax.swing.JOptionPane;

public class SubtractionTutorLoop {
  public static void main(String[] args) {
    int correctCount = 0; // Count the number of correct answers
    int count = 0; // Count the number of questions
    long startTime = System.currentTimeMillis();
    String output = "";

    while (count < 10) {
      // 1. Generate two random single-digit integers
      int number1 = (int)(Math.random() * 10);
      int number2 = (int)(Math.random() * 10);

      // 2. If number1 < number2, swap number1 with number2
      if (number1 < number2) {
        int temp = number1;
        number1 = number2;
        number2 = temp;
      }

      // 3. Prompt the student to answer “what is number1 – number2?”
      String answerString = JOptionPane.showInputDialog
        ("What is " + number1 + " - " + number2 + "?");
      int answer = Integer.parseInt(answerString);

      // 4. Grade the annser and display the result
      String replyString;
      if (number1 - number2 == answer) {
        replyString = "You are correct!";
        correctCount++;
      }
      else
        replyString = "Your answer is wrong.\n" + number1 + " - "
          + number2 + " should be " + (number1 - number2);
      JOptionPane.showMessageDialog(null, replyString);

      // Increase the count
      count++;

      output += "\n" + number1 + "-" + number2 + "=" + answerString +
        ((number1 - number2 == answer) ? " correct" : " wrong");
    }

    long endTime = System.currentTimeMillis();
    long testTime = endTime - startTime;

    JOptionPane.showMessageDialog(null,
      "Correct count is " + correctCount + "\nTest time is " +
      testTime / 1000 + " seconds\n" + output);
  }
}
