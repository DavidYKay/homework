public class TestCourseWithEnrollmentEvent {
  CourseWithEnrollmentEvent course =
    new CourseWithEnrollmentEvent("Java Programming");

  public TestCourseWithEnrollmentEvent() {
    course.setEnrollmentCap(2);
    EnrollmentListener listener = new NewListener();
    course.addEnrollmentListener(listener);
    course.addStudent("John");
    course.addStudent("Jim");
    course.addStudent("Tim");
  }

  public static void main(String[] args) {
    new TestCourseWithEnrollmentEvent();
  }
}

class NewListener implements EnrollmentListener {
  public void enrollmentExceeded(EnrollmentEvent e) {
    System.out.println(e.getNumberOfStudents() + " enrolled" +
      " and the enrollment cap is " + e.getEnrollmentCap());
  }
}
