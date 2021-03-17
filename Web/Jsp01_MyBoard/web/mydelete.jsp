<%@ page import="com.my.biz.MyBoardBiz" %><%--
  Created by IntelliJ IDEA.
  User: parkgw
  Date: 2021/03/16
  Time: 11:06 오후
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

    int res = biz.delete(myno);

    if (res > 0) {
%>
<script type="text/javascript">
    alert("삭제 성공!");
    location.href = "mylist.jsp"
</script>
<%
} else {
%>
<script type="text/javascript">
    alert("삭제 실패..");
    location.href = "mylist.jsp"
</script>
<%
    }
%>
</body>
</html>
