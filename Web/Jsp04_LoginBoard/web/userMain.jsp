<%@ page import="com.login.dto.LoginDto" %>
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
<%
    LoginDto dto = (LoginDto) session.getAttribute("dto");
%>

    <h1><%=dto.getMyId()%></h1>
    <p>
        <a href="loginController.jsp?command=logout">로그아웃</a>
    </p>

    <div>
        <p>
            <a href="loginController.jsp?command=myInfo&myNo=<%=dto.getMyNo()%>">내 정보 보기</a>
        </p>
    </div>
</body>
</html>
