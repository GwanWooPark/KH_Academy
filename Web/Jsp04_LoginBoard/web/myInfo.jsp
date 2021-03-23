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
    <h1>MYINFO</h1>
    <table border="1" align="center">
        <tr>
            <th>번호</th>
            <td><%=dto.getMyNo()%></td>
        </tr>
        <tr>
            <th>아이디</th>
            <td><%=dto.getMyId()%></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><%=dto.getMyName()%></td>
        </tr>
        <tr>
            <th>주소</th>
            <td><%=dto.getMyAddr()%></td>
        </tr>
        <tr>
            <th>전화번호</th>
            <td><%=dto.getMyAddr()%></td>
        </tr>
        <tr>
            <th>이메일</th>
            <td><%=dto.getMyEmail()%></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="개인정보 수정" onclick="location.href='loginController.jsp?command=updateInfoForm&myNo=<%=dto.getMyNo()%>'">
                <input type="button" value="탈퇴" onclick="location.href='loginController.jsp?command=signOut&myNo=<%=dto.getMyNo()%>'">
            </td>
        </tr>
    </table>

</body>
</html>
