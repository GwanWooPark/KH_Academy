<%@ page import="com.login.dao.LoginDao" %>
<%@ page import="com.login.dto.LoginDto" %>
<%@ page import="java.util.List" %>
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

    } else if (command.equals("registerForm")) {

        pageContext.forward("registerForm.jsp");

    } else if (command.equals("regist")) {
        String id = request.getParameter("myId");
        String pass = request.getParameter("myPass");
        String name = request.getParameter("myName");
        String addr = request.getParameter("myAddr");
        String phone = request.getParameter("myPhone");
        String email = request.getParameter("myEmail");

        LoginDto dto = new LoginDto(id, pass, name, addr, phone, email);
        int res = dao.insert(dto);

        if (res > 0) {
%>
        <script type="text/javascript">
            alert("회원가입 성공");
            window.close();
        </script>
<%
        } else {
%>
        <script type="text/javascript">
            alert("회원가입 실패");
            location.href="registerForm.jsp";
        </script>
<%
        }
    } else if (command.equals("idChk")) {
        String myId = request.getParameter("myId");
        LoginDto dto = dao.idCheck(myId);

        boolean idNotUsed = true;
        if (dto != null) {
            idNotUsed = false;
        }

        response.sendRedirect("idChk.jsp?idNotUsed="+idNotUsed);


    } else if (command.equals("userListAll")) {

        // 1.
        // 2.
        List<LoginDto> list = dao.selectAllList();
        // 3.
        request.setAttribute("list", list);
        // 4.
        pageContext.forward("userListAll.jsp");

    } else if (command.equals("userListEnabled")) {
        // 1.
        // 2.
        List<LoginDto> list = dao.selectEnabledList();
        // 3.
        request.setAttribute("list", list);
        // 4.
        pageContext.forward("userListEnabled.jsp");

    } else if (command.equals("updateRoleForm")) {
        // 1.
        int myNo = Integer.parseInt(request.getParameter("myNo"));
        // 2.
        LoginDto dto = dao.selectOne(myNo);
        // 3.
        request.setAttribute("dto", dto);
        // 4.
        pageContext.forward("updateRoleForm.jsp");

    } else if (command.equals("updateRole")) {
        int myNo = Integer.parseInt(request.getParameter("myNo"));
        String myRole = request.getParameter("myRole");

        int res = dao.updateRole(myNo, myRole);
        if (res > 0) {
            %>
        <script type="text/javascript">
            alert("회원등급 조정 성공");
            location.href="loginController.jsp?command=userListEnabled";
        </script>
<%
        } else {
            %>
        <script type="text/javascript">
            alert("회원등급 조정 실패");
            location.href="loginController.jsp?command=updateRoleForm?myno=<%=myNo%>";
        </script>
<%
        }
    } else if (command.equals("myInfo")) {
        int myNo = Integer.parseInt(request.getParameter("myNo"));

        LoginDto dto = dao.selectOne(myNo);

        request.setAttribute("dto", dto);

        pageContext.forward("myInfo.jsp");
    } else if (command.equals("updateInfoForm")) {
        int myNo = Integer.parseInt(request.getParameter("myNo"));
        LoginDto dto = dao.selectOne(myNo);
        request.setAttribute("dto", dto);
        pageContext.forward("updateInfo.jsp");

    } else if (command.equals("updateInfo")) {

        int myNo = Integer.parseInt(request.getParameter("myNo"));
        String myPw = request.getParameter("myPw");
        String myAddr = request.getParameter("myAddr");
        String myPhone = request.getParameter("myPhone");
        String myEmail = request.getParameter("myEmail");

        LoginDto dto = new LoginDto(myNo, myPw, myAddr, myPhone, myEmail);
        int res = dao.update(dto);

            if (res > 0) {
%>
            <script type="text/javascript">
                alert("수정 성공");
                location.href="userMain.jsp";
            </script>
<%
            } else {
%>
            <script type="text/javascript">
                alert("수정 실패");
                location.href="userMain.jsp";
            </script>
<%
        }
    } else if (command.equals("signOut")) {
        int myNo = Integer.parseInt(request.getParameter("myNo"));
        int res = 0;
        res = dao.delete(myNo);

        if (res > 0) {
%>
        <script type="text/javascript">
            alert("탈퇴 성공");
            location.href = "index.html";
        </script>
<%
        } else {
%>
        <script type="text/javascript">
            alert("탈퇴 실패");
            location.href = "userMain.jsp";
        </script>
<%
        }
    }
%>

<h1 style="color: deepskyblue">잘못 왔음</h1>
<p>
    이 메시지가 뜨면 <br>
    command 확인
</p>
</body>
</html>