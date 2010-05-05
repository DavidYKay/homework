<!-- CountVisitUsingFile.jsp -->
<%@ page import = "chapter28.CountUsingFile" %>
<jsp:useBean id="count" scope="application"
   class="chapter28.CountUsingFile">
</jsp:useBean>
<HTML>
<HEAD>
<TITLE>CountVisitUsingFile</TITLE>
</HEAD>
<BODY>
<H3>
Count Visit and Store Count in a File
</H3>
<% count.increaseCount(); count.saveCount(); %>
You are visitor number <%= count.getCount() %><br>
From host: <%= request.getRemoteHost() %>
and session: <%= session.getId() %>
</BODY>
</HTML>
