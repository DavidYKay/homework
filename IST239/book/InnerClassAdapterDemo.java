import java.awt.event.*;

public class InnerClassAdapterDemo {
  CourseWithActionEvent course =
    new CourseWithActionEvent("Java Programming");

  public InnerClassAdapterDemo() {
    course.setEnrollmentCap(2);
    ActionListener listener = new NewAdapter();
    course.addActionListener(listener);
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

  class NewAdapter implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      processActionEvent(e);
    }
  }
}
