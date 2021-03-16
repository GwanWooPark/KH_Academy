<%@ page import="java.util.List" %>
<%@ page import="com.my.dto.MyBoardDto" %>
<%@ page import="com.my.biz.MyBoardBiz" %>

<%--
  Created by IntelliJ IDEA.
  User: parkgw
  Date: 2021/03/16
  Time: 7:45 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    MyBoardBiz biz = new MyBoardBiz();
    List<MyBoardDto> list = biz.selectList();
%>
    <h1>LIST</h1>
    <table border="1">
        <col width="50px">
        <col width="100px">
        <col width="500px">
        <col width="100px">
        <tr>
            <th>번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>작성일</th>
        </tr>
        <%
            for (MyBoardDto dto : list) {
        %>
        <tr>
            <td><%=dto.getMyno()%></td>
            <td><%=dto.getMyname()%></td>
            <td><a href="myselect.jsp?myno<%=dto.getMyno()%>"><%=dto.getMytitle()%></a></td>
            <td><%=dto.getMydate()%></td>
        </tr>
        <%
            }
        %>

        <tr>
            <td colspan="4" align="right">
                <input type="button" value="글 작성" onclick="location.href='myinsert.jsp'">
            </td>
        </tr>
    </table>
</body>
</html>
