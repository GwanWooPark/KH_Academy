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
    <h1 style="color: red">ERROR</h1>

    <div>
        <p>${error }</p>
    </div>

    <a href="answer.do?command=list">list로 돌오가기</a>
</body>
</html>
