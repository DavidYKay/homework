import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CurrentTime extends HttpServlet {
  /** Process the HTTP Get request */
  public void doGet(HttpServletRequest request, HttpServletResponse
      response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<p>The current time is " + new Date());
    out.close(); // Close stream
  }
}
