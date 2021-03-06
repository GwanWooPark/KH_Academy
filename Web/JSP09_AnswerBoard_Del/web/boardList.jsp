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

    <h1>LIST</h1>

    <table border="1">
        <col width="50px"/>
        <col width="300px"/>
        <col width="500px"/>
        <col width="100px"/>

        <tr>
            <th>번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>작성일</th>
        </tr>
        <c:choose>
            <c:when test="${empty list }">
                <th colspan="4">------------------작성된 글이 없습니다-------------------</th>
            </c:when>
            <c:otherwise>
                <c:forEach items="${list }" var="dto">
                    <tr>
                        <td>${dto.boardno }</td>
                        <td>${dto.writer }</td>
                        <td>
                            <c:choose>
                                <c:when test="${dto.delflag eq 'Y'}">
                                    <c:out value="-----------삭제된 글입니다------------"></c:out>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach begin="1" end="${dto.titletab }">
                                        &nbsp;
                                    </c:forEach>
                                    <a href="answer.do?command=select&boardno=${dto.boardno }">${dto.title }</a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${dto.regdate }</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <tr>
            <td colspan="4" align="right">
                <input type="button" value="글 작성" onclick="location.href='answer.do?command=insertForm'">
                <input type="button" value="페이지 리스트" onclick="location.href='answer.do?command=pageList&startPageNum=1'">
            </td>
        </tr>
    </table>
</body>
</html>
