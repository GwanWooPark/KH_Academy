<%@ page import="com.login.dto.LoginDto" %>
<%@ page import="java.util.List" %>
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
        List<LoginDto> list = (List<LoginDto>) request.getAttribute("list");
    %>

    <h1>USER LIST</h1>

    <table border="1" align="center">
        <col width="50"/>
        <col width="100"/>
        <col width="100"/>
        <col width="500"/>
        <col width="200"/>
        <col width="200"/>
        <col width="50"/>
        <col width="100"/>
        <tr>
            <th>NO</th>
            <th>ID</th>
            <th>NAME</th>
            <th>ADDR</th>
            <th>PHONE</th>
            <th>EMAIL</th>
            <th>ENABLED</th>
            <th>ROLE</th>
        </tr>
<%
     for (LoginDto dto : list) {
%>
        <tr align="center">
            <td><%=dto.getMyNo()%></td>
            <td><%=dto.getMyId()%></td>
            <td><%=dto.getMyName()%></td>
            <td><%=dto.getMyAddr()%></td>
            <td><%=dto.getMyPhone()%></td>
            <td><%=dto.getMyEmail()%></td>
            <td><%=dto.getMyEnabled().equals("Y") ? "가입" : "탈퇴"%></td>
            <td><%=dto.getMyRole()%></td>
        </tr>

<%
    }
%>
        <tr>
            <td colspan="8">
                <input type="button" value="메인" onclick="location.href='adminMain.jsp'">
            </td>
        </tr>
    </table>
</body>
</html>
