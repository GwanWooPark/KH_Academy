<%@ page import="com.muldel.biz.MDBoardBIz" %>
<%@ page import="com.muldel.biz.MDBoardBIzImpl" %><%--
  Created by IntelliJ IDEA.
  User: parkgw
  Date: 2021/03/18
  Time: 7:48 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" language="java" %>
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
    // 같은 이름으로 여러개의 값이 넘어올 경우
    String[] seqs = request.getParameterValues("chk");

    if (seqs == null || seqs.length == 0) {
%>
<script type="text/javascript">
    alert("삭제할 글을 하나이상 체크해 주세요!");
    location.href = "boardlist.jsp";
</script>

<%
    } else {
        MDBoardBIz biz = new MDBoardBIzImpl();
        int res = biz.multiDelete(seqs);
        if (res == seqs.length) {
%>
<script type="text/javascript">
    alert("선택된 글들이 모두 삭제 되었습니다.");
    location.href = "boardlist.jsp";
</script>
<%
        } else {
%>
<script type="text/javascript">
    alert("선택한 글들이 삭제되지 않았습니다");
    location.href = "boardlist.jsp";
</script>
<%
        }
    }
%>

</body>
</html>
