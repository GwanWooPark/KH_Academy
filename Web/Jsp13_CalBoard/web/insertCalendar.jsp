<%@ page import="java.util.Calendar" %>
<%@ page import="com.cal.controller.Util" %>
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
    int year = Integer.parseInt(request.getParameter("year"));
    int month = Integer.parseInt(request.getParameter("month"));
    int date = Integer.parseInt(request.getParameter("date"));
    int lastDay = Integer.parseInt(request.getParameter("lastday"));

    Calendar cal = Calendar.getInstance();
    int hour = cal.get(Calendar.HOUR_OF_DAY);
    int min = cal.get(Calendar.MINUTE);
%>

    <h1>일정 작성하기</h1>
    <form action="cal.do" method="post">
        <input type="hidden" name="command" value="insertCalendar">
        <table border="1">
            <tr>
                <th>ID</th>
                <td><input type="text" name="id" value="admin" readonly="readonly"></td>
            </tr>
            <tr>
                <th>일정</th>
                <td>
                    <select name="year">
<%
                    for (int i = year-5; i <= year+5; i++) {
%>
                        <option value="<%=i%>" <%=(year==i) ? "selected" : ""%>><%=i%></option>
<%
                    }
%>
                    </select>년
                    <select name="month">
<%
                    for (int i = 1; i < 13; i++) {
%>
                        <option value="<%=i%>" <%=(month==i) ? "selected" : ""%>><%=i%></option>
<%
                    }
%>
                    </select>월
                    <select name="date">
<%
                            for (int i = 1; i <= lastDay; i++) {
%>
                        <option value="<%=i%>" <%=(date==i) ? "selected" : ""%>><%=i%></option>
<%
                            }
%>
                    </select>일
                    <select name="hour">
<%
                            for (int i = 1; i < 24; i++) {
%>
                        <option value="<%=i%>" <%=(hour==i) ? "selected" : ""%>><%=i%></option>
<%
                            }
%>
                    </select>시
                    <select name="minute">
<%
                            for (int i = 1; i < 60; i++) {
%>
                        <option value="<%=i%>" <%=(min==i) ? "selected" : ""%>><%=i%></option>
<%
                            }
%>
                    </select>분
                </td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea rows="10" cols="60" name="content"></textarea> </td>
            </tr>
            <tr>
                <td colspan="3" align="right">
                    <input type="submit" value="일정작성">
                    <input type="button" value="목록" onclick="location.href='cal.do?command=calendarList&year=<%=year%>&month=<%=month%>&date=<%=date%>'">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
