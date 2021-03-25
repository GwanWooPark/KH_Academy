<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>jsp : useBean</h1>

    <jsp:useBean id="sc" class="com.eljstl.score.Score" scope="session"></jsp:useBean>
    <!-- jsp:useBean = jsp안에서 자바 객체를 사용하겠다 -->
    <!-- Score sc = new Score(); 와 같은 뜻-->
    <jsp:setProperty name="sc" property="name" value="hong"></jsp:setProperty>
    <!-- sc.setName("hong"); -->
    <jsp:getProperty name="sc" property="name"/>
    <!-- sc.getName("hong"); -->
    <a href="result.jsp">scope</a>
</body>
</html>
