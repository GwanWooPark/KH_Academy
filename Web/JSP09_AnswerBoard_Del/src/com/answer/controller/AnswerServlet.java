package com.answer.controller;

import com.answer.biz.AnswerBiz;
import com.answer.biz.AnswerBizImpl;
import com.answer.dto.AnswerDto;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/answer.do")

public class AnswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        AnswerBiz biz = new AnswerBizImpl();
        String command = request.getParameter("command");

        if (command.equals("list")) {
            List<AnswerDto> list = biz.selectList();
            request.setAttribute("list", list);
            dispatch(request, response, "boardList.jsp");
        } else if (command.equals("select")) {

            int boardno = Integer.parseInt(request.getParameter("boardno"));
            AnswerDto dto = biz.selectOne(boardno);
            request.setAttribute("dto", dto);

            dispatch(request, response, "boardSelect.jsp");

        } else if (command.equals("delete")) {

            int boardno = Integer.parseInt(request.getParameter("boardno"));
            boolean res = biz.boardDelete(boardno);
            if (res) {
                jsResponse(response, "삭제 성공", "answer.do?command=list");

            } else {
                jsResponse(response, "삭제 성공", "answer.do?command=select&boardno=" + boardno);
            }
        } else if (command.equals("answerForm")) {

            int boardno = Integer.parseInt(request.getParameter("boardno"));
            AnswerDto dto = biz.selectOne(boardno);
            request.setAttribute("dto", dto);
            dispatch(request, response, "boardAnswer.jsp");

        } else if (command.equals("answerProc")) {

            int parentboardno = Integer.parseInt(request.getParameter("parentboardno"));
            String writer = request.getParameter("writer");
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            AnswerDto dto = new AnswerDto();
            dto.setWriter(writer);
            dto.setTitle(title);
            dto.setContent(content);
            dto.setBoardno(parentboardno);

            boolean res = biz.answerProc(dto);

            if (res) {
                jsResponse(response, "답변 성공", "answer.do?command=list");
            } else {
                jsResponse(response, "답변 실패", "answer.do?command=select&boardno=" + parentboardno);
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
            dto.setTitle(title);
            dto.setContent(content);
            dto.setBoardno(boardno);

            boolean res = biz.boardUpdate(dto);
            if (res) {
                jsResponse(response, "수정 성공", "answer.do?command=select&boardno=" + boardno);
            } else {
                jsResponse(response, "수정 실패", "answer.do?command=updateForm&boardno=" + boardno);

            }
        } else if (command.equals("insertForm")) {

            response.sendRedirect("insert.jsp");

        } else if (command.equals("insertRes")) {

            String writer = request.getParameter("writer");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            AnswerDto dto = new AnswerDto();
            dto.setWriter(writer);
            dto.setTitle(title);
            dto.setContent(content);

            boolean res = biz.boardInsert(dto);

            if (res) {
                jsResponse(response, "Success!", "answer.do?command=list");
            } else {
                jsResponse(response, "Failed..", "answer.do?command=list");
            }
        } else if (command.equals("pageList")) {

            int startPageNum = Integer.getInteger(request.getParameter("startPageNum"));
            int endPageNum = startPageNum + 4;
            System.out.println(startPageNum);
            System.out.println(endPageNum);

            List<AnswerDto> list = new ArrayList<AnswerDto>();
            list = biz.pageList(startPageNum, endPageNum);


            request.setAttribute("list", list);

            dispatch(request, response, "pageList.jsp");
        }
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws IOException, ServletException{
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
