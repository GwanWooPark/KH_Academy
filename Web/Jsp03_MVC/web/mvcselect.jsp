<%@ page import="com.mvc.dto.MVCDto" %><%--
  Created by IntelliJ IDEA.
  User: parkgw
  Date: 2021/03/22
  Time: 3:46 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

%>
<html>
<head>
    <title>Title</title>
</head>
<% MVCDto dto = (MVCDto) request.getAttribute("dto"); // object 타입으로 받았으니 자식 형태로 다시 형 변환 해줘야하기 때문 큰 타입 -> 작은 타입 : 명시적 형변%>
<body>

    <h1>DETAIL</h1>

    <table border="1">
        <tr>
            <th>작성자</th>
            <td><%=dto.getWriter()%></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><%=dto.getTitle()%></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent()%></textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="button" value="수정" onclick="location.href='mvccontroller.jsp?command=updateform&seq=<%=dto.getSeq()%>'">
                <input type="button" value="삭제" onclick="location.href='mvcdelete.jsp?command=delete&seq=<%=dto.getSeq()%>'">
                <input type="button" value="목록" onclick="location.href='index.jsp'">
           </td>
        </tr>
    </table>

</body>
</html>
