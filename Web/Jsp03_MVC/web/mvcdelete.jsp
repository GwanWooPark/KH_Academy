<%@ page import="com.mvc.biz.MVCBiz" %>
<%@ page import="com.mvc.biz.MVCBizImpl" %><%--
  Created by IntelliJ IDEA.
  User: parkgw
  Date: 2021/03/22
  Time: 5:25 오후
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
    int seq = Integer.parseInt(request.getParameter("seq"));
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    MVCBiz biz = new MVCBizImpl();
    int res = biz.delete(seq);
    if (res > 0) {
%>
<script type="text/javascript">
    alert("삭제 성공");
    location.href = "mvccontroller.jsp?command=list";
</script>
<%
} else {
%>
<script type="text/javascript">
    alert("삭제 실패");
    location.href = "mvcselect.jsp?seq=<%=seq%>";
</script>
<%
    }
%>
</body>
</html>
