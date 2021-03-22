<%@ page import="java.util.List" %>
<%@ page import="com.mvc.dto.MVCDto" %>
<%@ page import="com.mvc.dao.MVCDao" %><%--
  Created by IntelliJ IDEA.
  User: parkgw
  Date: 2021/03/19
  Time: 7:10 오후
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
<body>
<%
    List<MVCDto> list = (List<MVCDto>) request.getAttribute("list");
%>
    <h1>LIST</h1>

    <table border="">
        <col width="50">
        <col width="100">
        <col width="500">
        <col width="100">
        <tr>
            <th>번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>작성일</th>
        </tr>
<%
    for (MVCDto dto : list) {
%>
        <tr>
            <td><%=dto.getSeq()%></td>
            <td><%=dto.getWriter()%></td>
            <td><a href="mvccontroller.jsp?command=detail&seq=<%=dto.getSeq()%>"><%=dto.getTitle()%></a></td>
            <td><%=dto.getDate()%></td>
        </tr>
<%
            }
%>
    </table>
    <input type="button" value="글쓰기" onclick="location.href='mvccontroller.jsp?command=insertform'">
</body>
</html>
