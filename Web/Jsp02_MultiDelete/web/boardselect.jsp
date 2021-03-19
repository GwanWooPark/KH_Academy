<%@ page import="com.muldel.biz.MDBoardBIz" %>
<%@ page import="com.muldel.biz.MDBoardBIzImpl" %>
<%@ page import="com.muldel.dto.MDBoardDto" %><%--
  Created by IntelliJ IDEA.
  User: parkgw
  Date: 2021/03/19
  Time: 4:04 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="form/header.jsp"%>
<%
    int seq = Integer.parseInt(request.getParameter("seq"));

    MDBoardBIz biz = new MDBoardBIzImpl();
    MDBoardDto dto = biz.selectOne(seq);
%>

<h1>SELECT</h1>
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
        <td>내용</td>
        <td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent()%></textarea></td>
    </tr>
    <tr>
        <td colspan="2" align="right">
            <input type="button" value="수정" onclick="location.href='boardupdate.jsp'">
            <input type="button" value="삭제" onclick="location.href='boarddelete.jsp'">
            <input type="button" value="목록" onclick="location.href='boardlist.jsp'">
        </td>
    </tr>
</table>
<%-- ./ 는 생략 가능 --%>
<%@include file="form/footer.jsp"%>
</body>
</html>
