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
        <col width="100">
        <col width="100">
        <col width="300">
        <col width="200">
        <tr>
            <th>번호</th>
            <th>글쓴이</th>
            <th>제목</th>
            <th>작성 날짜</th>
        </tr>
        <tr align="center">
            <c:choose>
                <c:when test="${empty boardDto }">
                    <td colspan="4">게시글이 없습니다</td>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${boardDto }" var="dto">
                        <td>${dto.num }</td>
                        <td>${dto.writer }</td>
                        <td><a href="mvclogin.do/command=boardSelect">${dto.title}</a></td>
                        <td>${dto.date}</td>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td colspan="4" align="right">
                <input type="button" value="글 작성" onclick="location.href='mvclogin.do?command=boardInsertForm'">
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
</body>
</html>
