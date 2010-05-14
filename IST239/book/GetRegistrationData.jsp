<!-- GetRegistrationData.jsp -->
<%@ page import = "chapter35.Student" %>
<jsp:useBean id = "studentId" 
  class = "chapter35.Student" scope = "session"></jsp:useBean>
<jsp:setProperty name = "studentId" property = "*" />
       
<html>
  <body>
    <h1>Registration Using JSP</h1>

    <%    
    if (studentId.getLastName() == null || 
            studentId.getFirstName() == null) {
      out.println("Last Name and First Name are required");
      return; // End the method
    }
    %>
    
    <p>You entered the following data</p>
    <p>Last name: <%= studentId.getLastName() %></p>
    <p>First name: <%= studentId.getFirstName() %></p>
    <p>MI: <%= studentId.getMi() %></p>
    <p>Telephone: <%= studentId.getTelephone() %></p>
    <p>Email:  <%= studentId.getEmail() %></p>
    <p>Address: <%= studentId.getStreet() %></p>
    <p>City: <%= studentId.getCity() %></p>
    <p>State: <%= studentId.getState() %></p>
    <p>Zip: <%= studentId.getZip() %></p>

    <!-- Set the action for processing the answers -->
    <form method = "post" action = "/liangweb/StoreStudent.jsp">
      <input type = "submit" value = "Confirm">
    </form>
  </body>
</html>
