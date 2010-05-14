public class EnrollmentEvent extends java.util.EventObject {
  private int numberOfStudents;
  private int enrollmentCap;

  /** Construct a EnrollmentEvent */
  public EnrollmentEvent(Object source, int numberOfStudents,
      int enrollmentCap) {
    super(source);
    this.numberOfStudents = numberOfStudents;
    this.enrollmentCap = enrollmentCap;
  }

  public long getNumberOfStudents() {
    return numberOfStudents;
  }

  public long getEnrollmentCap() {
    return enrollmentCap;
  }
}
