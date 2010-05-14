import java.awt.event.*;

public class StandardAdapterDemo {
  CourseWithActionEvent course =
    new CourseWithActionEvent("Java Programming");

  public StandardAdapterDemo() {
    course.setEnrollmentCap(2);
    ActionListener listener = new Adapter(new Adaptee());
    course.addActionListener(listener);
    course.addStudent("John");
    course.addStudent("Jim");
    course.addStudent("Tim");
  }

  public static void main(String[] args) {
    new StandardAdapterDemo();
  }
}

class Adapter implements ActionListener {
  Adaptee adaptee;

  public Adapter(Adaptee adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.processActionEvent(e);
  }
}

class Adaptee {
  public void processActionEvent(ActionEvent e) {
    CourseWithActionEvent source =
      (CourseWithActionEvent)e.getSource();
    System.out.println(source.getNumberOfStudents() + " enrolled" +
      " and the enrollment cap is " + source.getEnrollmentCap());
  }
}

