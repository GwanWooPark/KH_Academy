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
<table border="1">
    <tr>
        <th>아이디</th>
        <td>${loginDto.myid}</td>
    </tr>
    <tr>
        <th>이름</th>
        <td>${loginDto.myname}</td>
    </tr>
    <tr>
        <th>주소</th>
        <td>${loginDto.myaddr}</td>
    </tr>
    <tr>
        <th>전화번호</th>
        <td>${loginDto.myphone}</td>
    </tr>
    <tr>
        <th>이메일</th>
        <td>${loginDto.myemail}</td>
    </tr>
    <tr>
        <th>가입 여부</th>
        <td>${loginDto.myenabled != 'Y' ? '가입':'탈퇴'}</td>
    </tr>
    <tr>
        <th>권한</th>
        <td>${loginDto.myrole}</td>
    </tr>


</table>

</body>
</html>
