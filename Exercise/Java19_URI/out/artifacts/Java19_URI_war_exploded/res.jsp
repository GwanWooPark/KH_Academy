<%--
  Created by IntelliJ IDEA.
  User: Gwanwoo
  Date: 2021-02-05
  Time: 오후 4:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> <%=request.getParameter("name")%> 님의 주소는 <%=request.getParameter("addr")%> 입니다 .</h1>
</body>
</html>
