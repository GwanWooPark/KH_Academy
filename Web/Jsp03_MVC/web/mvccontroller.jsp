<%@ page import="com.mvc.biz.MVCBiz" %>
<%@ page import="com.mvc.biz.MVCBizImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mvc.dto.MVCDto" %>
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
    String command = request.getParameter("command");
    System.out.println("<" + command + ">");

    MVCBiz biz = new MVCBizImpl();

    if (command.equals("list")) {
        // 1. 전달된 값이 있으면 받아준다.

        // 2. 필요하다면 db와 연결
        List<MVCDto> list = biz.selectList();
        // 3.
        request.setAttribute("list", list);
        // 4. 보낸다.
        pageContext.forward("mvclist.jsp");
    } else if (command.equals("insertform")) {
        // 1.
        // 2.
        // 3.
        // 4.
        response.sendRedirect("mvcinsert.jsp");

    } else if (command.equals("insertres")) {
        // 1.
        String writer = request.getParameter("writer");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        // 2.
        MVCDto dto = new MVCDto();
        dto.setWriter(writer);
        dto.setTitle(title);
        dto.setContent(content);
        biz = new MVCBizImpl();
        int res = biz.insert(dto);

        // 3.
        // 4.
         if (res > 0) {

%>
<script type="text/javascript">
    alert("글 작성 성공");
    location.href="mvccontroller.jsp?command=list";
</script>
<%
    } else {
%>
<script type="text/javascript">
    alert("글 작성 실패");
    location.href="mvccontroller.jsp?command=insertform";
</script>
<%
        }
    }
%>
<h1>잘못 옴</h1>
</body>
</html>
