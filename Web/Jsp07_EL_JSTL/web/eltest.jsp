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
    <h1>EL</h1>
    <!-- score가 없지만 page->request->session->application순으로 찾기 시작한다. if 없으면 아무것도 안나올거임 에러가아님 그레이스풀하게 처리하기 때문에 -->
    <!-- score라는 개체를 찾아서 get?()를 가져온 것. -->
    <table border="1">
        <tr>
            <th colspan="2">${score.name } 점수</th>
        </tr>
        <tr>
            <th>국어</th>
            <td>${score.kor }</td>
        </tr>
        <tr>
            <th>영어</th>
            <td>${score.eng }</td>
        </tr>
        <tr>
            <th>수학</th>
            <td>${score.math }</td>
        </tr>
        <tr>
            <th>총점</th>
            <td>${score.sum }</td>
        </tr>
        <tr>
            <th>평균</th>
            <td>${score.avg }</td>
        </tr>
        <tr>
            <th>등급</th>
            <td>${score.grade }</td>
        </tr>
    </table>
</body>
</html>
