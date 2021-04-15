<%--
  Created by IntelliJ IDEA.
  User: parkgw
  Date: 2021/03/19
  Time: 3:37 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="form/header.jsp"%>

    <h1>INSERT</h1>

    <form action="boardinsertres.jsp" method="post">
        <table border="1">
            <tr>
                <th>작성자</th>
                <td><input type="text" name="writer"></td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea rows="10" cols="60" name="content"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="작성">
                    <input type="button" value="취소" onclick="location.href='boardlist.jsp'">
                </td>
            </tr>
        </table>
    </form>

<%@include file="form/footer.jsp"%>
</body>
</html>
