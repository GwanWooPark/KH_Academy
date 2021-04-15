<%@ page import="com.muldel.dto.MDBoardDto" %>
<%@ page import="com.muldel.biz.MDBoardBIz" %>
<%@ page import="com.muldel.biz.MDBoardBIzImpl" %><%--
  Created by IntelliJ IDEA.
  User: parkgw
  Date: 2021/03/19
  Time: 3:43 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String writer = request.getParameter("writer");
    String title = request.getParameter("title");
    String content = request.getParameter("content");

    MDBoardDto dto = new MDBoardDto(writer, title, content);

    MDBoardBIz biz = new MDBoardBIzImpl();
    int res = biz.insert(dto);
    if (res > 0) {
%>
     <script type="text/javascript">
         alert("글 작성 성공");
         location.href="boardlist.jsp"
     </script>
<%
    } else {
%>
     <script type="text/javascript">
         alert("글 작성 실패");
         location.href="boardlist.jsp"
     </script>
<%
    }
%>
</body>
</html>
