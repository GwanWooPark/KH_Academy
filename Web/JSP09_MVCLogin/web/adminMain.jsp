<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>${loginDto.myid }님 환영합니다.</h1>
    <a href="mvclogin.do?command=logout">로그아웃</a>

    <div>
        <p>
            <a href="mvclogin.do?command=userListAll">회원정보 조회(All)</a>
        </p>
        <p>
            <a href="mvclogin.do?command=userEnabledList">회원정보 조회(Enabled=Y)</a>
        </p>
        <p>
            <a href="mvclogin.do?command=boardList&id=${loginDto.myid }">게시판</a>
        </p>
    </div>
</body>
</html>
