<%@ page import="com.my.dto.MyBoardDto" %>
<%@ page import="com.my.biz.MyBoardBiz" %><%--
  Created by IntelliJ IDEA.
  User: parkgw
  Date: 2021/03/16
  Time: 11:30 오후
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
    String myname = request.getParameter("myname");
    String mytitle = request.getParameter("mytitle");
    String mycontent = request.getParameter("mycontent");

    MyBoardBiz biz = new MyBoardBiz();
    MyBoardDto dto = new MyBoardDto();
    dto.setMyno(myno);
    dto.setMyname(myname);
    dto.setMytitle(mytitle);
    dto.setMycontent(mycontent);

    int res = biz.update(dto);

    if (res > 0) {
%>
<script type="text/javascript">
    alert("수정 성공!");
    location.href = "mylist.jsp"
</script>
<%
    } else {
%>
<script type="text/javascript">
    alert("수정 실패..");
    location.href = "mylist.jsp"
</script>
<%
    }
%>

</body>
</html>
