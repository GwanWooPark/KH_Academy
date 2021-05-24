package com.payCancel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/moduleServlet")
public class moduleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String merchant_uid = request.getParameter("merchant_uid");
        payCancel cancel = new payCancel();
        String token = cancel.getImportToken();
        cancel.cancelPayment(token, merchant_uid);

    }
}
