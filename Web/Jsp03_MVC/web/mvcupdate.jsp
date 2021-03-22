<%@ page import="com.mvc.biz.MVCBiz" %>
<%@ page import="com.mvc.biz.MVCBizImpl" %>
<%@ page import="com.mvc.dto.MVCDto" %><%--
  Created by IntelliJ IDEA.
  User: parkgw
  Date: 2021/03/22
  Time: 4:39 오후
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
    MVCDto dto = (MVCDto) request.getAttribute("dto");
%>

    <form action="mvccontroller.jsp" method="post">
        <input type="hidden" name="command" value="updateres">
        <input type="hidden" name="seq" value="<%=dto.getSeq()%>">
        <table border="1">
            <tr>
                <th>작성자</th>
                <td><%=dto.getWriter()%></td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" name="title" value="<%=dto.getTitle()%>"></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea rows="10" cols="60" name="content"><%=dto.getContent()%></textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="수정">
                    <input type="button" value="취소" onclick="location.href='mvccontroller.jsp?command=list'">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
