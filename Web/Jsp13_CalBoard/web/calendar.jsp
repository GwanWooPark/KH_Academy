<%@ page import="java.util.Calendar" %>
<%@ page import="com.cal.controller.Util" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<style type="text/css">
    a:visited{text-decoration: none; color: black;}
    a:link{text-decoration: none; color: black;}

    #calendar {
        border-collapse: collapse;
        border: 1px solid gray;
    }

    #calendar th {
        width: 80px;
        border: 1px solid gray;
    }

    #calendar td {
        width: 80px;
        height: 80px;
        border: 1px solid gray;
        text-align: left;
        vertical-align: top;
        position: relative;
    }
</style>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Calendar cal = Calendar.getInstance();

    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH) + 1;

    String paramYear = request.getParameter("year");
    String paramMonth = request.getParameter("month");

    if (paramYear != null) {
        year = Integer.parseInt(paramYear);
    }
    if (paramMonth != null) {
        month = Integer.parseInt(paramMonth);
    }
    if (month > 12) {
        year++;
        month = 1;
    }
    if (month < 1) {
        year--;
        month = 12;
    }

    cal.set(year, month - 1, 1);

    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
    int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);



%>
</body>
</html>

    <table id="calendar" align="center">
        <caption>
            <a href="calendar.jsp?year=<%=year-1%>&month=<%=month%>">◁</a>
            <a href="calendar.jsp?year=<%=year%>&month=<%=month-1%>">◀</a>

            <span class="y"><%=year%></span>년
            <span class="m"><%=month%></span>월

            <a href="calendar.jsp?year=<%=year%>&month=<%=month+1%>">▶</a>
            <a href="calendar.jsp?year=<%=year+1%>&month=<%=month%>">▷</a>
        </caption>

        <tr>
            <th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
        </tr>
        <tr>
            <%
                for (int i = 0; i < dayOfWeek - 1; i++) {
                    out.print("<td></td>"); // 공백 주기
                }
                for (int i = 1; i <= lastDay; i++) {
            %>
            <td>
                <a href="cal.do?command=calendarList&year=<%=year%>&month=<%=month%>&date=<%=i%>" style="color: <%=Util.fontColor(i, dayOfWeek)%>"><%=i %></a>
                <a href="insertCalendar.jsp?year=<%=year%>&month=<%=month%>&date=<%=i%>&lastday=<%=lastDay%>">
                    <img src="resources/image/pen.png" alt="일정 추가" style="width: 10px; height: 10px;">
                </a>
            </td>
            <%
                    if ((dayOfWeek - 1 + i) % 7 == 0) {
                        out.print("</tr><tr>");    // 요일 끝 줄바꿈
                    }
                }
                for (int i = 0; i < (7 - (dayOfWeek - 1 + lastDay) % 7) % 7; i++) {
                    out.print("<td></td>");       // 칸 맞춰주기
                }
            %>
        </tr>
    </table>