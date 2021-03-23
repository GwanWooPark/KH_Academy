<%@ page import="com.login.dto.LoginDto" %>
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
<%
    LoginDto dto = (LoginDto) request.getAttribute("dto");
%>
    <h1>UPDATE INFO</h1>
    <form action="loginController.jsp?command=updateInfo" method="post">
        <input type="hidden" name="myNo" value="<%=dto.getMyNo()%>">
        <table border="1">
            <tr>
                <th>수정할 비밀번호</th>
                <td><input type="password" name="myPw" value=""></td>
            </tr>
            <tr>
                <th>수정할 주소</th>
                <td><input type="text" name="myAddr" value="<%=dto.getMyAddr()%>"></td>
            </tr>
            <tr>
                <th>수정할 전화번호</th>
                <td><input type="text" name="myPhone" value="<%=dto.getMyPhone()%>"></td>
            </tr>
            <tr>
                <th>수정할 이메일</th>
                <td><input type="text" name="myEmail" value="<%=dto.getMyEmail()%>"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="수정">
                    <input type="button" value="취소" onclick="location.href='myInfo.jsp'">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
