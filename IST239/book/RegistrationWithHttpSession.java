import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class RegistrationWithHttpSession extends HttpServlet {
  // Use a prepared statement to store a student into the database
  private PreparedStatement pstmt;

  /** Initialize global variables */
  public void init() throws ServletException {
    initializeJdbc();
  }

  /** Process the HTTP Get request */
  public void doGet(HttpServletRequest request, HttpServletResponse
      response) throws ServletException, IOException {
    // Set response type and output stream to the browser
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    // Obtain data from the form
    String lastName = request.getParameter("lastName");
    String firstName = request.getParameter("firstName");
    String mi = request.getParameter("mi");
    String telephone = request.getParameter("telephone");
    String email = request.getParameter("email");
    String street = request.getParameter("street");
    String city = request.getParameter("city");
    String state = request.getParameter("state");
    String zip = request.getParameter("zip");

    if (lastName.length() == 0 || firstName.length() == 0) {
      out.println("Last Name and First Name are required");
      return; // End the method
    }

    // Create a Student object
    Student student = new Student(lastName, firstName,
      mi, telephone, email, street, city, state, zip);

    // Get an HttpSession or create one if it does not exist
    HttpSession httpSession = request.getSession();

    // Store student object to the session
    httpSession.setAttribute("student", student);

    // Ask for confirmation
    out.println("You entered the following data");
    out.println("<p>Last name: " + lastName);
    out.println("<p>First name: " + firstName);
    out.println("<p>MI: " + mi);
    out.println("<p>Telephone: " + telephone);
    out.println("<p>Email: " + email);
    out.println("<p>Address: " + street);
    out.println("<p>City: " + city);
    out.println("<p>State: " + state);
    out.println("<p>Zip: " + zip);

    // Set the action for processing the answers
    out.println("<p><form method=\"post\" action=" +
      "/liangweb/RegistrationWithHttpSession>");
    out.println("<p><input type=\"submit\" value=\"Confirm\" >");
    out.println("</form>");

    out.close(); // Close stream
  }

  /** Process the HTTP Post request */
  public void doPost(HttpServletRequest request, HttpServletResponse
      response) throws ServletException, IOException {
    // Set response type and output stream to the browser
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    // Obtain the HttpSession
    HttpSession httpSession = request.getSession();

    // Get the Student object in the HttpSession
    Student student = (Student)(httpSession.getAttribute("student"));

    try {
      storeStudent(student);

      out.println(student.firstName + " " + student.lastName +
        " is now registered in the database");
      out.close(); // Close stream
    }
    catch(Exception ex) {
      out.println("Error: " + ex.getMessage());
      return; // End the method
    }
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
  private void storeStudent(Student student) throws SQLException {
    pstmt.setString(1, student.getLastName());
    pstmt.setString(2, student.getFirstName());
    pstmt.setString(3, student.getMi());
    pstmt.setString(4, student.getTelephone());
    pstmt.setString(5, student.getEmail());
    pstmt.setString(6, student.getAddress());
    pstmt.setString(7, student.getCity());
    pstmt.setString(8, student.getState());
    pstmt.setString(9, student.getZip());
    pstmt.executeUpdate();
  }

  class Student {
    private String lastName = "";
    private String firstName = "";
    private String mi = "";
    private String telephone = "";
    private String email = "";
    private String street = "";
    private String city = "";
    private String state = "";
    private String zip = "";

    Student(String lastName, String firstName,
      String mi, String telephone, String email, String street,
      String city, String state, String zip) {
      this.lastName = lastName;
      this.firstName = firstName;
      this.mi = mi;
      this.telephone = telephone;
      this.email = email;
      this.street = street;
      this.city = city;
      this.state = state;
      this.zip = zip;
    }

    public String getLastName() {
      return lastName;
    }

    public String getFirstName() {
      return firstName;
    }

    public String getMi() {
      return mi;
    }

    public String getTelephone() {
      return telephone;
    }

    public String getEmail() {
      return email;
    }

    public String getAddress() {
      return street;
    }

    public String getCity() {
      return city;
    }

    public String getState() {
      return state;
    }

    public String getZip() {
      return zip;
    }
  }
}
