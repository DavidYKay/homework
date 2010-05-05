<!-- Test.jsp -->
<%@ page import = "chapter28.CountBean" %>
<jsp:useBean id="countBeanId" scope="application"
  class="chapter28.CountBean" >
</jsp:useBean>
<HTML>
<HEAD>
<TITLE>Test</TITLE>
</HEAD>
<BODY>
Session: <%= session.getId() %>
</BODY>
</HTML>
