<%--
  Created by IntelliJ IDEA.
  User: parkgw
  Date: 2021/03/19
  Time: 5:52 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <jsp:forward page="mvccontroller.jsp?command=list"></jsp:forward>
  </body>
</html>
