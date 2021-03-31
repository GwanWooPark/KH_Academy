package com.answer.controller;

import com.answer.biz.AnswerBiz;
import com.answer.biz.AnswerBizImpl;
import com.answer.dto.AnswerDto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/answer.do")
public class AnswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String command = request.getParameter("command");
        AnswerBiz biz = new AnswerBizImpl();

        try {

            if (command.equals("list")) {
                List<AnswerDto> list = biz.selectList();
                request.setAttribute("list", list);
                dispatch(request, response, "boardList.jsp");

            } else if (command.equals("detail")) {

                int boardno = Integer.parseInt(request.getParameter("boardno"));
                AnswerDto dto = biz.selectOne(boardno);

                request.setAttribute("dto", dto);
                dispatch(request, response, "boardDetail.jsp");
            } else if (command.equals("insertForm")){

                response.sendRedirect("insert.jsp");

            } else if (command.equals("insertRes")){

                String title = request.getParameter("title");
                String content = request.getParameter("content");
                String writer = request.getParameter("writer");

                AnswerDto dto = new AnswerDto();

                dto.setTitle(title);
                dto.setContent(content);
                dto.setWriter(writer);

                int res = biz.boardInsert(dto);

                if (res > 0) {
                    dispatch(request, response, "answer.do?command=list");
                }
            } else if (command.equals("updateForm")) {

                int boardno = Integer.parseInt(request.getParameter("boardno"));

                AnswerDto dto = biz.selectOne(boardno);
                request.setAttribute("dto", dto);
                dispatch(request, response, "update.jsp");

            } else if (command.equals("updateRes")) {

                int boardno = Integer.parseInt(request.getParameter("boardno"));
                String title = request.getParameter("title");
                String content = request.getParameter("content");

                AnswerDto dto = new AnswerDto();
                dto.setBoardno(boardno);
                dto.setTitle(title);
                dto.setContent(content);

                int res = biz.boardUpdate(dto);

                if (res > 0) {
                    jsResponse(response, "글 수정 성공", "answer.do?command=detail&boardno=" + boardno);
                } else {
                    jsResponse(response, "글 수정 실패", "answer.do&command=updateForm&boardno=" + boardno);
                }
            } else if (command.equals("delete")) {

                int boardno = Integer.parseInt(request.getParameter("boardno"));
                int res = biz.boardDelete(boardno);

                if (res > 0) {
                    dispatch(request, response, "answer.do?command=list");
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

    private void jsResponse(HttpServletResponse response, String msg, String url) throws IOException{
        String responseText = "<script type='text/javascript'>"
                + "alert('" + msg + "');"
                + "location.href='" + url + "';"
                + "</script>";
        response.getWriter().print(responseText);

    }
}
