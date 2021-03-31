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

    <table border="1" align="center">
        <col width="100"/>
        <col width="100"/>
        <col width="500"/>
        <col width="150"/>
        <col width="200"/>
        <col width="50"/>
        <col width="100"/>
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>주소</th>
            <th>전화번호</th>
            <th>이메일</th>
            <th>가입여부</th>
            <th>권한</th>
        </tr>
        <tr align="center">
            <c:choose>
                <c:when test="${empty list}">
                    <td colspan="7">가입자가 없습니다.</td>
                </c:when>
                <c:otherwise>
                <c:forEach items="list" var="dto">
                    <td>${loginDto.myid}</td>
                    <td>${loginDto.myname}</td>
                    <td>${loginDto.myaddr}</td>
                    <td>${loginDto.myphone}</td>
                    <td>${loginDto.myemail}</td>
                    <td>${loginDto.myenabled != 'Y' ? '가입':'탈퇴' }</td>
                    <td>${loginDto.myrole}</td>
                </c:forEach>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td colspan="7">
                <input type="button" value="메인으로" onclick="location.href='adminMain.jsp'">
            </td>
        </tr>
    </table>
</body>
</html>
