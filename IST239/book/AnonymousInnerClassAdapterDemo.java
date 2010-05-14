import java.awt.event.*;

public class AnonymousInnerClassAdapterDemo {
  CourseWithActionEvent course =
    new CourseWithActionEvent("Java Programming");

  public AnonymousInnerClassAdapterDemo() {
    course.setEnrollmentCap(2);
    course.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        processActionEvent(e);
      }
    });
    course.addStudent("John");
    course.addStudent("Jim");
    course.addStudent("Tim");
  }

  public static void main(String[] args) {
    new SimpleStandardAdapterDemo();
  }

  public void processActionEvent(ActionEvent e) {
    CourseWithActionEvent source =
      (CourseWithActionEvent)e.getSource();
    System.out.println(source.getNumberOfStudents() + " enrolled" +
      " and the enrollment cap is " + source.getEnrollmentCap());
  }
}
