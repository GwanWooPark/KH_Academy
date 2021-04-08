<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="util" class="com.cal.controller.Util"></jsp:useBean>
    <h1>Calendar List</h1>
<form action="cal.do" method="post">
    <input type="hidden" name="command" value="">
    <table border="1">
        <col width="50">
        <col width="130">
        <col width="300">
        <col width="200">
        <col width="200">
        <tr>
            <th>번호</th>
            <th>글 번호</th>
            <th>제목</th>
            <th>일정</th>
            <th>작성 날짜</th>
        </tr>
            <c:choose>
                <c:when test="${empty list }">
                    <th colspan="5">----------------작성된 글이 없습니다----------------</th>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${list }" var="dto">
                        <tr align="center">
                            <th><input type="checkbox" name="chk" value="${dto.seq }"></th>
                            <td>${dto.seq }</td>
                            <td><a href="#">${dto.title }</a></td>
                            <td>
                                <jsp:setProperty name="util" property="todates" value="${dto.mdate }"></jsp:setProperty>
                                <jsp:getProperty name="util" property="todates"/>
                            </td>
                            <td><fmt:formatDate value="${dto.regdate }" pattern="yyyy.MM.dd"></fmt:formatDate></td>
                            <!-- Formats a date and/or time using the supplied styles and pattern -->
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        <tr>
            <td colspan="5" align="right">
                <input type="submit" value="선택 삭제">
                <input type="button" value="달력" onclick="location.href='cal.do?command=calendar'">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
