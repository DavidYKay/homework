import java.sql.*;
import javax.sql.*;
import javax.sql.rowset.*;
import com.sun.rowset.JdbcRowSetImpl;

public class TestRowSet {
  public static void main(String[] args)
    throws SQLException, ClassNotFoundException {
    System.out.printf("%-6b%8s\n", (1 > 2), "Java");
    System.out.printf("%6b%-8s\n", (1 > 2), "Java");

    // Load the JDBC driver
//    Class.forName("oracle.jdbc.driver.OracleDriver");
    Class.forName("com.mysql.jdbc.Driver");
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    System.out.println("Driver loaded");

    JdbcRowSet rowSet = new JdbcRowSetImpl();
    rowSet.setUrl("jdbc:mysql://localhost/test");
    rowSet.setCommand("select firstName, mi, lastName from Student where lastName "
      + " = 'Smith'");
    rowSet.execute();

    while (rowSet.next()) {
      for (int i = 1; i <= 3; i++) {
        System.out.printf("%-8s\t", rowSet.getObject(i));
      }

      System.out.println();
    }
  }
}
