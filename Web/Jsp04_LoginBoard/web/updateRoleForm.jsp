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

    <h1>UPDATE ROLE</h1>
    <form action="loginController.jsp" method="post">
        <input type="hidden" name="command" value="updateRole">
        <input type="hidden" name="myNo" value="<%=dto.getMyNo()%>">

        <table border="1">
            <tr>
                <th>번호</th>
                <td><%=dto.getMyNo()%></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><%=dto.getMyName()%></td>
            </tr>
            <tr>
                <th>등급</th>
                <td>
                    <select name="myRole">
                        <option value="USER" <%=dto.getMyRole().equals("USER") ? "selected" : ""%>>일반회원</option>
                        <option value="ADMIN" <%=dto.getMyRole().equals("ADMIN") ? "selected" : ""%>>관리자</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="변경완료">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
