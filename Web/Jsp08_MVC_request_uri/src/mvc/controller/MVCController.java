package mvc.controller;

import mvc.biz.MVCBiz;
import mvc.biz.MVCBizImpl;
import mvc.dto.MVCDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/mvcList", "/mvcSelect", "/mvcDelete", "/mvcInsertForm", "/mvcInsert", "/mvcUpdateForm", "/mvcUpdate"})
public class MVCController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private MVCBiz biz = new MVCBizImpl();
    // 자바의 원칙중 solid원칙 : 하나의 메소드는 하나의 기능만 해야함

    private void getRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String command = request.getRequestURI();
        System.out.println("[" + command + "]");

        if (command.endsWith("/mvcList")) {

            doSelectList(request, response);
        } else if (command.endsWith("/mvcSelect")) {

            int seq = Integer.parseInt(request.getParameter("seq"));
            doSelectOne(request, response, seq);
        } else if (command.endsWith("/mvcDelete")) {

            int seq = Integer.parseInt(request.getParameter("seq"));
            doDeleteOne(response, seq);
        } else if (command.endsWith("/mvcInsertForm")) {

            response.sendRedirect("mvcinsert.jsp");
        } else if (command.endsWith("/mvcInsert")) {

            String writer = request.getParameter("writer");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            doInsert(response, writer, title, content);
        } else if (command.endsWith("/mvcUpdateForm")) {

            int seq = Integer.parseInt(request.getParameter("seq"));
            doUpdateForm(request, response, seq);
        } else if (command.endsWith("/mvcUpdate")) {

            int seq = Integer.parseInt(request.getParameter("seq"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            doUpdate(response, seq, title, content);
        }
    }

    private void doSelectList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MVCDto> list = biz.selectList();
        request.setAttribute("list", list);
        dispatch(request, response, "mvclist.jsp");
    }

    private void doSelectOne(HttpServletRequest request, HttpServletResponse response, int seq) throws ServletException, IOException {
        MVCDto dto = biz.selectOne(seq);
        request.setAttribute("dto", dto);
        dispatch(request,response, "mvcselectlist.jsp");
    }
    private void doDeleteOne(HttpServletResponse response, int seq) throws IOException {
        int res = 0;
        res = biz.delete(seq);
        if (res > 0) {
            jsResponse(response, "삭제 성공!", "mvclist.jsp");
        } else {
            jsResponse(response, "삭제 실패!", "mvclist.jsp");
        }


    } private void doInsert(HttpServletResponse response, String writer, String title, String content) throws IOException {
        int res = 0;
        MVCDto dto = new MVCDto(0, writer, title, content, null);
        res = biz.insert(dto);
        if (res > 0) {
            jsResponse(response, "작성 성공!", "mvclist.jsp");
        } else {
            jsResponse(response, "작성 실패!", "mvclist.jsp");
        }
    }

    private void doUpdateForm(HttpServletRequest request, HttpServletResponse response, int seq) throws ServletException, IOException {
        MVCDto dto = biz.selectOne(seq);
        request.setAttribute("dto", dto);
        dispatch(request, response, "mvcupdate.jsp");
    }

    private void doUpdate(HttpServletResponse response, int seq, String title, String content) throws IOException {
        MVCDto dto = new MVCDto();
        dto.setSeq(seq);
        dto.setTitle(title);
        dto.setContent(content);
        int res = biz.update(dto);
        if (res > 0) {
            jsResponse(response, "수정 성공!", "mvclist.jsp");
        } else {
            jsResponse(response, "수정 실패!", "mvclist.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getRequest(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getRequest(request, response);
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException{

        RequestDispatcher dispatch = request.getRequestDispatcher(path);
        // RequestDispatcher = 요청을 전달해주는 애 (forward or include)
        dispatch.forward(request, response);
    }

    private void jsResponse(HttpServletResponse response, String msg, String url) throws IOException {
        String responseText = "<script type='text/javascript'>"
                            + "alert(" + msg + ");"
                            + "location.href=" + url
                            + "</script>";

        PrintWriter out = response.getWriter();
        out.print(responseText);
    }
}
