package com.hello.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/controller.do")
public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private String initParam;

    // 직렬화 찾아보기
    public HelloServlet() {
        System.out.println("HelloServlet 생성");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("HelloServlet init!");

        initParam = config.getInitParameter("actor");
        String contextParam = config.getServletContext().getInitParameter("singer");

        System.out.println("initParam : " + initParam);
        System.out.println("contextParam : " + contextParam);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        System.out.println("get방식으로 들어옴");

        String commamd = request.getParameter("command");
        System.out.println("[" + commamd + "]");

        PrintWriter out = response.getWriter();
        out.print("<h1 style='color: red;'>Hello Servlet</h1>");
        out.print("<h2>계층구조/LifeCycle/url-mapping</h2>");
        out.print("<a href='home.html'>home...</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        System.out.println("post 방식");

        String command = request.getParameter("command");
        System.out.println("{" + command + "}");

        String result = "<h1 style='color:blue;'>Hello Servlet</h1>" +
                        "<h2>계층구조/LifeCycle/url-mapping</h2>" +
                        "<a href='home.html'>home</a>";
        response.getWriter().append(result);
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet destroy");
    }
}
