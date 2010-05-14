import javax.servlet.*;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet implements Servlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter writer = response.getWriter();

        //Everything in a servlet is written out, like PHP, to the browser
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title> First Servlet </title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("Hello, world! I'm a servlet, and this time is: " + new java.util.Date().toString());
        writer.println("</body>");
        writer.println("</html>");
    }
}
