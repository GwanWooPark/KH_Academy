<%@ page import="com.my.biz.MyBoardBiz" %>
<%@ page import="com.my.dto.MyBoardDto" %><%--
  Created by IntelliJ IDEA.
  User: parkgw
  Date: 2021/03/16
  Time: 11:17 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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
    int myno = Integer.parseInt(request.getParameter("myno"));
    MyBoardBiz biz = new MyBoardBiz();
    MyBoardDto dto = biz.selectOne(myno);


%>
<form action="myupdateres.jsp" method="post"> <!-- header에 너무 많은 양의 데이터가 들어가게되면 오류 발생 -->
    <table border="1">
        <tr>
            <th>글 번호</th>
            <td><input type="text" name="myno" readonly="readonly" value="<%=myno%>"></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" name="myname" readonly="readonly" value="<%=dto.getMyname()%> "></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><input type="text" name="mytitle" value="<%=dto.getMytitle()%>"></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea rows="10" cols="60" name="mycontent"><%=dto.getMycontent()%></textarea></td>
        </tr>
        <tr>
            <td colspan="3" align="right">
                <input type="submit" value="수정">
                <input type="button" value="취소" onclick="location.href='mylist.jsp'">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
