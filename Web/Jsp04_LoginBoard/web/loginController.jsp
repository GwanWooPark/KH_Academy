<%@ page import="com.login.dao.LoginDao" %>
<%@ page import="com.login.dto.LoginDto" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String command = request.getParameter("command");
    System.out.println("[" + command + "]");

    LoginDao dao = new LoginDao();

    if (command.equals("login")) {
        // 1.
        String myId = request.getParameter("myId");
        String myPw = request.getParameter("myPw");
        // 2.
        LoginDto dto = dao.login(myId, myPw);

        if (dto != null) {                                  // side effect
            // 3.
            // session scope에 담기
            session.setAttribute("dto", dto);
            // 특정 시간동안 활동이 없으면 session 완료
            session.setMaxInactiveInterval(10 * 60);

            // 4.
            if (dto.getMyRole().equals("ADMIN")) {
                response.sendRedirect("adminMain.jsp");
            } else if (dto.getMyRole().equals("USER")) {
                response.sendRedirect("userMain.jsp");
            }
        } else {
%>
        <script type="text/javascript">
            alert("login 실패");
            location.href = "index.html";
        </script>
<%
        }
    } else if (command.equals("logout")) {
        // session 만료
        session.invalidate();
        response.sendRedirect("index.html");

    } else if (command.equals("userListAll")) {

    } else if (command.equals("userListEnabled")) {

    }
%>
</body>
</html>