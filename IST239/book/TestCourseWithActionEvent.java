import java.awt.event.*;

public class TestCourseWithActionEvent {
  CourseWithActionEvent course =
    new CourseWithActionEvent("Java Programming");

  public TestCourseWithActionEvent() {
    course.setEnrollmentCap(2);
    course.addActionListener(new Listener());
    course.addStudent("John");
    course.addStudent("Jim");
    course.addStudent("Tim");
  }

  public static void main(String[] args) {
    new TestCourseWithActionEvent();
  }
}

class Listener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    System.out.println("Enrollment cap exceeded");
  }
}
