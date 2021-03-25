package com.scope.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ScopeController")
public class ScopeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String requestScope = (String) request.getAttribute("requestScope");
        HttpSession session = request.getSession();
        String sessionScope = (String) session.getAttribute("sessionScope");
        ServletContext application = getServletContext();
        String applicationScope = (String) application.getAttribute("applicationScope");

        System.out.println("request : " + requestScope);
        System.out.println("session : " + sessionScope);
        System.out.println("application : " + applicationScope);

       // PrintWriter out = response.getWriter();

        String responseText = "<h1>RESULT</h1>" +
                              "<table border=1>" +
                              " <tr>" +
                              "   <th>request</th>" +
                              "   <td>" +requestScope + "</td>" +
                              " </tr>" +
                              " <tr>" +
                              "   <th>session</th>" +
                              "   <td>" + sessionScope + "</td>" +
                              " </tr> " +
                              " <tr>" +
                              "   <th>application</th>" +
                              "   <td>" + applicationScope + "</td>" +
                              " </tr>" +
                              "</table>";

       // out.print(responseText);

        String requestVal = request.getParameter("requestVal");
        System.out.println("requestVal : " + requestVal);
        request.setAttribute("requestScope", "request forward value");

        RequestDispatcher dispatch = request.getRequestDispatcher("result.jsp");
        dispatch.forward(request, response);
    }
}
