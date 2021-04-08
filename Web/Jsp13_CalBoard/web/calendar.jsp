<%@ page import="java.util.Calendar" %>
<%@ page import="com.cal.controller.Util" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cal.dto.CalDto" %>
<%@ page import="com.cal.dao.CalDao" %>
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

    .list > p {
        font-size: 5px;
        margin: 1px;
        background-color: skyblue;
    }

    .preview {
        position: absolute;
        top: -30px;
        left: 10px;
        background-color: skyblue;
        width: 40px;
        height: 40px;
        text-align: center;
        line-height: 40px;
        border-radius: 40px 40px 40px 1px;

    }
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

    $(function () {
        $(".countView").hover(function () {

            var countView = $(this);
            var year = $(".y").text().trim();
            var month = $(".m").text().trim();
            var countDate = countView.text().trim();

            var yyyyMMdd = year + isTwo(month) + isTwo(countDate);
            $.ajax({
                url : "count.do",
                data : "id=admin&yyyyMMdd="+yyyyMMdd,
                type : "post",
                dataType : "json",
                async : false,   // 비동기가 false -> 동기화로 동작
                success: function (msg) {
                    var count = msg.count;
                    countView.after("<div class='preview'>" + count + "</div>");
                },
                error: function () {
                    alert("통신 실패");
                }
            });

        }, function () {
            $(".preview").remove();
        });
    });

    function isTwo(n) {
        return (n.length < 2) ? "0" + n : n;
    }
</script>
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
    // 날짜 변경을 위해 값을 받아오는거 같

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

    CalDao dao = new CalDao();
    String yyyyMM = year + Util.isTwo(String.valueOf(month));
    List<CalDto> list = dao.calendarViewList("admin", yyyyMM);


%>
</body>
</html>
    <table id="calendar" align="center">
        <!--  캡션(caption, 테이블이나 사진, 삽화 등에 붙는 설명)을 정의할 때 사용 -->
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
                <a class="countView" href="cal.do?command=calendarList&year=<%=year%>&month=<%=month%>&date=<%=i%>" style="color: <%=Util.fontColor(i, dayOfWeek)%>"><%=i %></a>

                <a href="insertCalendar.jsp?year=<%=year%>&month=<%=month%>&date=<%=i%>&lastday=<%=lastDay%>">
                    <img src="resources/image/pen.png" alt="일정 추가" style="width: 10px; height: 10px;">
                </a>

                <div class="list">
                    <%=Util.getCalView(i, list)%>
                </div>
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