<!-- DisplayTime.jsp -->
<%@page pageEncoding = "GB18030"%>
<%@ page import = "java.util.*" %>
<%@ page import = "java.text.*" %>
<%@ page import = "chapter35.TimeBean" %>
<jsp:useBean id = "timeBeanId" 
  class = "chapter35.TimeBean" scope = "application" >
</jsp:useBean>

<html>
  <head>
    <title>
      Display Time
    </title>
  </head>
  <body>
  <h3>Choose locale and time zone</h3>
    <%
    out.println("<html>");
    int localeIndex = Integer.parseInt(
      request.getParameter("locale"));
    String timeZoneID = request.getParameter("timezone");
    out.println("<head><title>Current Time</title></head>");
    out.println("<body>");
    Calendar calendar =
      new GregorianCalendar(timeBeanId.getAllLocale()[localeIndex]);
    TimeZone timeZone = TimeZone.getTimeZone(timeZoneID);
    DateFormat dateFormat = DateFormat.getDateTimeInstance(
      DateFormat.FULL, DateFormat.FULL, 
      timeBeanId.getAllLocale()[localeIndex]);
    dateFormat.setTimeZone(timeZone);
    out.println("Current time is " +
      dateFormat.format(calendar.getTime()) + "</p>");
    out.println("</body></html>");
    %>
  </body>
<html>
