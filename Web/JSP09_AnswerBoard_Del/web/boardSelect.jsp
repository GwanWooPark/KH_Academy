<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTf-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>SELECT</h1>
    <table border="1">
        <tr>
            <th>작성자</th>
            <td>${dto.writer }</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>${dto.title }</td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea rows="10" cols="60" readonly="readonly">${dto.content }</textarea></td>
        </tr>
        <tr>
            <td colspan="3" align="right">
                <input type="button" value="삭제" onclick="location.href='answer.do?command=delete'">
                <input type="button" value="수정" onclick="location.href='answer.do?command=updateForm&boardno=${dto.boardno }'">
                <input type="button" value="댓글" onclick="location.href='answer.do?command=answerInsertForm'">
                <input type="button" value="취소" onclick="location.href='answer.do?command=list'">
            </td>
        </tr>
    </table>
</body>
</html>
