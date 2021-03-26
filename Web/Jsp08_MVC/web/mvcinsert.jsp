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

    <form action="mvc.do" method="post">
        <input type="hidden" name="command" value="insertres">
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
                <td colspan="2">
                    <input type="submit" value="작성">
                    <input type="button" value="취소" onclick="location.href='mvc.do?command=list'">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
