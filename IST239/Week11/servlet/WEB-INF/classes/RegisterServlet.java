import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.*;
import java.sql.*;
import java.security.*;
import java.math.*;
//import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class RegisterServlet extends HttpServlet implements Servlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter writer = response.getWriter();

        //Everything in a servlet is written out, like PHP, to the browser
        writer.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
        writer.println("<HTML>");
        writer.println("<HEAD>");
        writer.println("<TITLE>Registration Form</TITLE>");
        writer.println("</HEAD>");
        writer.println("<BODY BGCOLOR=\"#FDF5E6\">");
        writer.println("<H1 ALIGN=\"CENTER\">Registration Form</H1>");
        writer.println("<FORM ACTION=\"/dk/register\"");
        writer.println("METHOD=\"POST\">");
        writer.println("User name:");
        writer.println("<INPUT TYPE=\"TEXT\" NAME=\"userName\"><BR>");
        writer.println("Password:");
        writer.println("<INPUT TYPE=\"TEXT\" NAME=\"password\"><BR>");
        writer.println("Email:");
        writer.println("<INPUT TYPE=\"TEXT\" NAME=\"email\" VALUE=\"\"><BR>");
        writer.println("<HR>");
        writer.println("<CENTER>");
        writer.println("<INPUT TYPE=\"SUBMIT\" VALUE=\"Submit Registration\">");
        writer.println("</CENTER>");
        writer.println("</FORM>");
        writer.println("</BODY>");
        writer.println("</HTML>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter writer = response.getWriter();

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email    = request.getParameter("email");

        boolean success = true;
        try {
            int status = registerUser( userName,
                password,
                email
            );
            if (status == -1) {
                success = false;
            }
        //} catch (MySQLIntegrityConstraintViolationException ex) {
        } catch (Exception ex) {
            success = false;
        }
        //Everything in a servlet is written out, like PHP, to the browser
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title> Register Servlet </title>");
        writer.println("</head>");
        writer.println("<body>");
        if (success) {
            writer.println("Registration Successful!");
        } else {
            writer.println("Registration Failed!");
        }
        writer.println("<br />");
        writer.println(
            String.format(
                "Username: %s, Password: %s, Email: %s",
                userName,
                password,
                email
            )
        );

        writer.println("<br />");
        writer.println("<br />");
        writer.println("<a href=\"/dk/register\">Return to registration page</a>");
        writer.println("</body>");
        writer.println("</html>");
    }

    /**
     * TODO: Merge this with the hash function in ChatClient
     */
    private String hashPassword(String ps) {
        System.out.println("hashPassword()");
        MessageDigest m = null;
        try {
            //byte[] bytes = ps.getBytes("ASCII");
            byte[] bytes = ps.getBytes("UTF-8");
            m = MessageDigest.getInstance("MD5");
            m.update(bytes, 0, bytes.length);
        } catch (Exception ex) {
            System.err.println("MD5 failed");
        }
        String md5Password = new BigInteger(1, m.digest()).toString(16);
        System.out.println("MD5: " + md5Password);

        return md5Password;
    }

    /**
     * Hashes password before inserting
     * Returns int indicating rows
     */
    private int registerUser(String userName, String password, String email) 
    //throws MySQLIntegrityConstraintViolationException {
    throws Exception {
        int retVal = -1;
        Connection conn = null;
        
        password = hashPassword(password);

        try {
            String dbUser     = "ist239";
            String dbPassword = "password";
            String url        = "jdbc:mysql://localhost/ist239";
            Class.forName ("com.mysql.jdbc.Driver").newInstance ();
            conn = DriverManager.getConnection (url, dbUser, dbPassword);
            System.out.println ("Database connection established");

            //fetch that shit
            String query = 
                "INSERT INTO user"
                + " VALUES (NULL, ?, ?, ?)";
            
            PreparedStatement prepStatement = conn.prepareStatement(
                query
            );

            prepStatement.setString(
                1,
                userName
            );
            prepStatement.setString(
                2,
                password
            );
            prepStatement.setString(
                3,
                email
            );

            retVal = prepStatement.executeUpdate();
        }
        catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close ();
                    System.out.println ("Database connection terminated");
                }
                catch (Exception e) { /* ignore close errors */ }
            }
        }
        return retVal;
    }

    public static void main(String[] sa) {
        try {
            RegisterServlet rs = new RegisterServlet();
            rs.registerUser(
                "bob",
                "test",
                "bob@yahoo.com"
            );
        } catch (Exception ex) {
            System.err.println("Test insert failed!");
        }
    }
}
