package com.eljstl.controller;

import com.eljstl.score.Score;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Mycontroller")
public class MyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String command = request.getParameter("command");
        System.out.printf("[%s] \n", command);

        if (command.equals("basic")) {
            RequestDispatcher dispatch = request.getRequestDispatcher("basic-arithmetic.jsp");
            dispatch.forward(request, response);
        } else if (command.equals("el")) {
            Score sc = new Score("홍길동", 100, 100, 100);

            request.setAttribute("score", sc);
            RequestDispatcher dispatch = request.getRequestDispatcher("eltest.jsp");
            dispatch.forward(request, response);

        } else if (command.equals("jstl")) {
            List<Score> list = new ArrayList<Score>();
            for (int i = 10; i < 50; i += 10) {
                Score sc = new Score("이름" + i, 50 + i, 50 + i, 50 + i);
                list.add(sc);
            }

            request.setAttribute("list", list);

            RequestDispatcher dispatch = request.getRequestDispatcher("jstltest.jsp");
            dispatch.forward(request, response);

            // RequestDispatcher 는 요청을 보내주는 클래스
            // 클라이언트로부터 요청받은 정보를 서버의 다른 자원(HTMl, JSP또는 Servlet등의 자원) 에 보내는 역할을 하는 인터페이스
            // RequestDispatcher는 클라이언트로부터 최초에 들어온 요청을 JSP/Servlet 내에서 원하는 자원으로 요청을 넘기는(보내는) 역할을 수행하거나,
            // 특정 자원에 처리를 요청하고 처리 결과를 얻어오는 기능을 수행하는 클래스
        } else if (command.equals("bean")) {
            response.sendRedirect("usebean.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
