<%@ page import="com.my.dto.MyBoardDto" %>
<%@ page import="com.my.biz.MyBoardBiz" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        String myname = request.getParameter("myname");
        String mytitle = request.getParameter("mytitle");
        String mycontent = request.getParameter("mycontent");

        MyBoardDto dto = new MyBoardDto();
        dto.setMyname(myname);
        dto.setMytitle(mytitle);
        dto.setMycontent(mycontent);

        MyBoardBiz biz = new MyBoardBiz();
        int res = biz.insert(dto);
        if (res > 0) {
    %>
    <script type="text/javascript">
        alert("글 작성 성공");
        location.href = "mylist.jsp"
    </script>
    <%
        } else {
    %>
    <script type="text/javascript">
        alert("글 작성 실패");
        location.href = "myinsert.jsp"
    </script>
    <%
        }
    %>

</body>
</html>
