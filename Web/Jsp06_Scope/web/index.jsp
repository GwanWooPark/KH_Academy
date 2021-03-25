<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<title>$Title$</title>
<%
  pageContext.setAttribute("pageScope", "page scope value");
  request.setAttribute("requestScope", "request scope value");
  session.setAttribute("sessionScope", "session scope value");
  application.setAttribute("applicationScope", "application scope value");
%>
</head>
<%-- scope : 객체 전달 범위
       1) page : 현재 페이지에서 객체를 전달(현재 페이지만 객체 유지)
       2) request : 현재 페이지에서 요청한 다음 페이지까지만 객체 전달 (요청된 페이지까지 객체 유지)
       3) session : 현재 브라우저에서 context내에 있는 모든 페이지에 객체 유지
       4) application : 현재 context내에서 객체 유지.--%>
<body>

    <h1>INDEX</h1>
    page : <%=pageContext.getAttribute("pageScope")%>
    <br>
    request : <%=request.getAttribute("requestScope")%>
    <br>
    session : <%=session.getAttribute("sessionScope")%>
    <br>
    application : <%=application.getAttribute("applicationScope")%>
    <br>
    <a href="result.jsp">result</a>
    <br>
    <a href="scope.do">servlet</a>
    <br>
    <form action="scope.do" method="get">
        <input type="hidden" name="requestVal" value="my request value">
        <input type="submit" value="request">
    </form>
</body>
</html>
