<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form action="mvclogin.do" method="post">
        <input type="hidden" name="command" value="boardInsertRes">
        <table border="1">
            <tr>
                <th>제목</th>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text" name="writer" readonly="readonly" value="${loginDto.myid }"></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea rows="10" cols="60" name="content"></textarea></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="글 작성">
                    <c:choose>
                        <c:when test="${loginDto.myrole eq 'ADMIN'}">
                            <input type="button" value="메인으로" onclick="location.href='adminMain.jsp'">
                        </c:when>
                        <c:otherwise>
                            <input type="button" value="메인으로" onclick="location.href='userMain.jsp'">
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
