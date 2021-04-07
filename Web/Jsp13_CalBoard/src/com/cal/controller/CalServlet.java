package com.cal.controller;

import com.cal.dao.CalDao;
import com.cal.dto.CalDto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/CalServlet")
public class CalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        CalDao dao = new CalDao();
        String command = request.getParameter("command");

        if (command.equals("calendar")) {
            response.sendRedirect("calendar.jsp");

        } else if (command.equals("calendarList")) {
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String date = request.getParameter("date");

            String yyyyMMdd = year + Util.isTwo(month) + Util.isTwo(date);

            List<CalDto> list = dao.calendarList("admin",yyyyMMdd);

            request.setAttribute("list", list);
            dispatch(request, response, "calendarList.jsp");

        } else if (command.equals("insertCalendar")) {
            String year = request.getParameter("year");
            String month = Util.isTwo(request.getParameter("month"));
            String date = Util.isTwo(request.getParameter("date"));
            String hour = request.getParameter("hour");
            String min = request.getParameter("minute");

            String id = request.getParameter("id");
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            String mdate = year + month + date + hour + min;

            int res = dao.insert(new CalDto(0, id, title, content, mdate, null));

            if (res > 0) {
                jsResponse(response, "일정 작성 성공", "cal.do?command=calendar");
            } else {
                jsResponse(response, "일정 추가 실패", "cal.do?command=calendar&mdate=" + mdate);

            }



        }
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException{
        RequestDispatcher dispatch = request.getRequestDispatcher(path);

        dispatch.forward(request, response);
    }

    private void jsResponse(HttpServletResponse response, String msg, String url) throws IOException {
        String responseText = "<script type='text/javascript'>"
                + "alert('" + msg + "');"
                + "location.href='" + url + "';"
                + "</script>";
        response.getWriter().print(responseText);
    }
}
