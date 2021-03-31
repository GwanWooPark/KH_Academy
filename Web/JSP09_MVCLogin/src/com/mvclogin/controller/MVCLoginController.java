package com.mvclogin.controller;

import com.mvclogin.biz.MVCBoardBiz;
import com.mvclogin.biz.MVCBoardBizImpl;
import com.mvclogin.biz.MVCLoginBiz;
import com.mvclogin.biz.MVCLoginBizImpl;
import com.mvclogin.dto.MVCBoardDto;
import com.mvclogin.dto.MVCLoginDto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/MVCLogin.do")
public class MVCLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String command = request.getParameter("command");
        System.out.println("[" + command + "]");
        MVCBoardBiz boardBiz = new MVCBoardBizImpl();
        MVCLoginBiz loginBiz = new MVCLoginBizImpl();
        HttpSession session = request.getSession(true);// true : 세션이 없을경우 생성, false : 세션이 없을경우 생성안함

        try {
            if (command.equals("login")) {
                String id = request.getParameter("myId");
                String pw = request.getParameter("myPw");

                MVCLoginDto loginDto = loginBiz.login(id, pw);

                if (loginDto != null) {

                    session.setAttribute("loginDto", loginDto);
                    session.setMaxInactiveInterval(60 * 10); //1분간 유지 (default : 30분)

                    if (loginDto.getMyrole().equals("ADMIN")) {
                        response.sendRedirect("adminMain.jsp");
                    } else if (loginDto.getMyrole().equals("USER")) {
                        response.sendRedirect("userMain.jsp");
                    } else {
                        jsResponse(response, "로그인 실패", "index.html");
                    }
                }

            } else if (command.equals("logout")) {
                session.invalidate();
                response.sendRedirect("index.html");

            } else if (command.equals("userListAll")) {

                List<MVCLoginDto> list = loginBiz.selectList();

                request.setAttribute("list", list);
                dispatch(request, response, "userListAll.jsp");

            } else if (command.equals("userEnabledList")) {
                List<MVCLoginDto> list = loginBiz.selectEnabledList();

                request.setAttribute("list", list);
                dispatch(request, response, "userEnabledList.jsp");
            } else if (command.equals("boardList")) {

                List<MVCBoardDto> boardDto = boardBiz.selectList();
                request.setAttribute("boardDto", boardDto);
                dispatch(request, response, "boardList.jsp");
            } else if (command.equals("boardInsertForm")) {

                response.sendRedirect("boardInsert.jsp");

            } else if (command.equals("boardInsertRes")) {
                String title = request.getParameter("title");
                String writer = request.getParameter("writer");
                String content = request.getParameter("content");

                MVCBoardDto dto = new MVCBoardDto(0, title, writer, content, null);
                int res = boardBiz.insert(dto);

                if (res > 0) {
                    jsResponse(response, "글 작성 성공!", "boardList.jsp");
                } else {
                    jsResponse(response, "글 작성 실패..", "mvclogin.do/command=boardInsertForm");
                }
            }
        } catch (Exception e) {
            request.setAttribute("error", e);
            dispatch(request, response, "error.jsp");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        request.getRequestDispatcher(path).forward(request, response);
    }

    private void jsResponse(HttpServletResponse response, String msg, String url) throws IOException{
        String responseText = "<script type='text/javascript'>"
                            + "alert('" + msg + "');"
                            + "location.href='" + url + "';"
                            + "</script>";
        response.getWriter().print(responseText);

    }
}
