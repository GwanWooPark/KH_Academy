<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>INSERT</h1>

    <form action="myinsertres.jsp" method="post"> <!-- header에 너무 많은 양의 데이터가 들어가게되면 오류 발생 -->
        <table border="1">

            <tr>
                <th>작성자</th>
                <td><input type="text" name="myname"></td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" name="mytitle"></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea rows="10" cols="60" name="mycontent"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="작성">
                    <input type="button" value="취소" onclick="location.href='mylist.jsp'">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
