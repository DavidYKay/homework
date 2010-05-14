// PrintCalendar.java: Print a calendar for a given month in a year
import javax.swing.*;

public class PrintCalendarSkeleton {
  /** Main method */
  public static void main(String[] args) {
    // Prompt the user to enter year
    String yearString = JOptionPane.showInputDialog(
      "Enter full year (e.g., 2001):");

    // Convert string into integer
    int year = Integer.parseInt(yearString);

    // Prompt the user to enter month
    String monthString = JOptionPane.showInputDialog(
      "Enter month in number between 1 and 12:");

    // Convert string into integer
    int month = Integer.parseInt(monthString);

    // Print calendar for the month of the year
    printMonth(year, month);
  }

  /** A stub for printMonth may look like this */
  public static void printMonth(int year, int month) {
    System.out.print(month + " " + year);
  }

  /** A stub for printMonthTitle may look like this */
  public static void printMonthTitle(int year, int month) {
  }

  /** A stub for getMonthName may look like this */
  public static String getMonthName(int month) {
    return "January"; // a dummy value
  }

  /** A stub for getMonthNmae may look like this */
  public static int getStartDay(int year, int month) {
    return 1; // a dummy value
  }

  /** A stub for getNumberOfDaysInMonth may look like this */
  public static int getNumberOfDaysInMonth(int year, int month) {
    return 31; // a dummy value
  }

  /** A stub for getTotalNumberOfDays may look like this */
  public static int getTotalNumberOfDays(int year, int month) {
    return 10000; // a dummy value
  }

  /** A stub for getTotalNumberOfDays may look like this */
  public static boolean isLeapYear(int year) {
    return true; // a dummy value
  }
}
