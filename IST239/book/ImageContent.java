import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Scanner;

public class ImageContent extends HttpServlet {
  /** Process the HTTP Get request */
  public void doGet(HttpServletRequest request, HttpServletResponse
      response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String country = request.getParameter("country");

    out.println("<img src = \"/liangweb/images/" + country + ".gif"
      + "\" align=left>");

    // Read flag description from a file and send it to the browser
    Scanner input = new Scanner(new File(
      "c:\\book\\" + country + ".txt"));

    // Read a line from the text file and send it to the browser
    while (input.hasNext())
      out.println(input.nextLine());

    out.close();
  }
}
