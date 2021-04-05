package com.score.controller;

import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/score.do")
public class ScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String name = request.getParameter("name");
        int kor = Integer.parseInt(request.getParameter("kor"));
        int eng = Integer.parseInt(request.getParameter("eng"));
        int math = Integer.parseInt(request.getParameter("math"));

        int sum = kor + eng + math;
        double avg = sum / 3.0;

        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("sum", sum);
        obj.put("avg", avg);
        PrintWriter out = response.getWriter();
        out.println(obj.toJSONString());

        System.out.println("servlet에서 보내는 데이터 : " + obj.toJSONString());
    }
}
