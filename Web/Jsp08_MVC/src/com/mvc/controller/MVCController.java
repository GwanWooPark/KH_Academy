package com.mvc.controller;

import com.mvc.biz.MVCBiz;
import com.mvc.biz.MVCBizImpl;
import com.mvc.dto.MVCDto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/MVCController")
public class MVCController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 인코딩 바꿔주기
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String command = request.getParameter("command");
        System.out.println("{" + command + "}");

        MVCBiz biz = new MVCBizImpl();
        try {
            if (command.equals("list")) {
                List<MVCDto> list = biz.selectList();
                request.setAttribute("list", list);

                dispatch(request, response, "mvclist.jsp");

            } else if (command.equals("selectlist")) {
                int seq = Integer.parseInt(request.getParameter("seq"));
                MVCDto dto = biz.selectOne(seq);

                request.setAttribute("dto", dto);
                dispatch(request, response, "mvcselectlist.jsp");
            } else if (command.equals("insertform")) {
                // 1.
                // 2.
                // 3.
                // 4.
                response.sendRedirect("mvcinsert.jsp");
            } else if (command.equals("insertres")) {
                // 1.
                String writer = request.getParameter("writer");
                String title = request.getParameter("title");
                String content = request.getParameter("content");

                MVCDto dto = new MVCDto();
                //MVCDto dto = new MVCDto(0, writer, title, content, null);

                dto.setWriter(writer);
                dto.setTitle(title);
                dto.setContent(content);
                // 2.
                int res = biz.insert(dto);
                // 3.
                // 4.
                if (res > 0) {
                    System.out.println("삽입 성공");
                    dispatch(request, response, "mvc.do?command=list");
                } else {
                    System.out.println("삽입 실패");
                    dispatch(request, response, "mvc.do?command=insertform");
                }


            } else if (command.equals("updateform")) {
                int seq = Integer.parseInt(request.getParameter("seq"));

                MVCDto dto = biz.selectOne(seq);
                request.setAttribute("dto", dto);
                dispatch(request, response, "mvcupdate.jsp");

            } else if (command.equals("updateres")) {

                int seq = Integer.parseInt(request.getParameter("seq"));
                String title = request.getParameter("title");
                String content = request.getParameter("content");

                MVCDto dto = new MVCDto(seq, null, title, content, null);

                int res = biz.update(dto);
                if (res > 0) {
                    System.out.println("수정 성공");
                    dispatch(request, response, "mvc.do?command=list");
                } else {
                    System.out.println("수정 실패");
                    dispatch(request, response, "mvc.do?command=selectlist&seq="+seq);
                }

            } else if (command.equals("delete")) {

                int seq = Integer.parseInt(request.getParameter("seq"));

                int res = biz.delete(seq);

                if (res > 0) {
                    System.out.println("삭제 성공");
                    dispatch(request, response, "mvc.do?command=list");
                } else {
                    System.out.println("삭제 실패");
                    dispatch(request, response, "mvc.do?command=selectlist&seq="+seq);
                }

            }
        } catch (Exception e) {
            request.setAttribute("error", e);
            dispatch(request,response,"error.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException{

        RequestDispatcher dispatch = request.getRequestDispatcher(path);
        // RequestDispatcher = 요청을 전달해주는 애 (forward or include)
        dispatch.forward(request, response);
    }
}
