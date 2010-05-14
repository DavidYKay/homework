package chapter35;

import java.sql.*;

public class StoreData {
  // Use a prepared statement to store a student into the database
  private PreparedStatement pstmt;

  public StoreData() {
    initializeJdbc();
  }

  /** Initialize database connection */
  private void initializeJdbc() {
    try {
      // Declare driver and connection string
      String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
      String connectionString = "jdbc:odbc:exampleMDBDataSource";

      // Load the Oracle JDBC Thin driver
      Class.forName(driver);
      System.out.println("Driver " + driver + " loaded");

      // Connect to the sample database
      Connection conn = DriverManager.getConnection
        (connectionString);
      System.out.println("Database " + connectionString +
        " connected");

      // Create a Statement
      pstmt = conn.prepareStatement("insert into Address " +
        "(lastName, firstName, mi, telephone, email, street, city, "
        + "state, zip) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    }
    catch (Exception ex) {
      System.out.println(ex);
    }
  }

  /** Store a student record to the database */
  public void storeStudent(Student student) throws SQLException {
    pstmt.setString(1, student.getLastName());
    pstmt.setString(2, student.getFirstName());
    pstmt.setString(3, student.getMi());
    pstmt.setString(4, student.getTelephone());
    pstmt.setString(5, student.getEmail());
    pstmt.setString(6, student.getStreet());
    pstmt.setString(7, student.getCity());
    pstmt.setString(8, student.getState());
    pstmt.setString(9, student.getZip());
    pstmt.executeUpdate();
  }
}
