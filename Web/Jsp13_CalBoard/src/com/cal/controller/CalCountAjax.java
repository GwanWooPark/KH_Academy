package com.cal.controller;

import com.cal.dao.CalDao;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/count.do")
public class CalCountAjax extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String id = request.getParameter("id");
        String yyyyMMdd = request.getParameter("yyyyMMdd");
        System.out.println("param : " + id + "," + yyyyMMdd);

        CalDao dao = new CalDao();
        int count = dao.calendarViewCount(id, yyyyMMdd);
        System.out.println("일정 갯수 : " + count);

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("count", count);
        // json-lib 가지고 map(java object) -> json으로 바꿈 "key" : "value"형태

        JSONObject obj = JSONObject.fromObject(map);

        PrintWriter out = response.getWriter();
        // json-lib에서 이렇게 만들어 놨음.(=out.println());
        obj.write(out);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}
