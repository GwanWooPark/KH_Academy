<%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-control", "no-store");
    response.setHeader("Expires", "0");

    /*
       데이터가 변경되었을 때, 이전 내용을 화면에 보여주는 이유는,
       서버에서 응답된 값이 아닌 캐시에 저장된 값을 가져오기 때문

       - 브라우저가 캐시에 응답결과를 저장하지 않도록 설정하는 코드
       response.setHeader("Pragma", "no-cache");          // http 1.0
       response.setHeader("Cache-control", "no-store");   // http 1.1
       response.setHeader("Expires", "0");                // proxy server

       우리는 1.1 사용중 (tomcat server.xml에 있음
     */
%>
<%@ page import="com.login.dto.LoginDto" %>
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
    LoginDto dto = (LoginDto) session.getAttribute("dto");
    if (dto == null) {
        pageContext.forward("index.html");

    }
%>
    <h1><%=dto.getMyName()%>님 환영합니다.</h1>
    <a href="loginController.jsp?command=logout">로그아웃</a>

    <div>
        <p>
            <a href="loginController.jsp?command=userListAll">회원정보 조회(All)</a>
        </p>
        <p>
            <a href="loginController.jsp?command=userListEnabled">회원정보 조회(Enabled=Y)</a>
        </p>
    </div>
</body>
</html>
