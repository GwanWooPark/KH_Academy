package com.paging.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paging.dto.Board;
import com.paging.dto.Paging;
import com.paging.model.biz.BoardBiz;

@WebServlet("/paging.do")
public class PagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		int currentPageNo = 1;				// ������ ��ȣ
		int recordsPerPage = 0;				// �������� ���ڵ� ��
		BoardBiz biz = new BoardBiz();
		String url = null;
		if("paging".equals(command)) {
			
			
			if(request.getParameter("pages") != null)	// pages & lines = null�� �ƴϴ�. -> �̵��� �ߴ�.
				currentPageNo = Integer.parseInt(request.getParameter("pages"));
			if(request.getParameter("lines") != null)
				recordsPerPage = Integer.parseInt(request.getParameter("lines"));
			
			Paging paging = new Paging(currentPageNo, recordsPerPage);	// Paging �ν��Ͻ� ����
			
			int offset = (paging.getCurrentPageNo() -1) * paging.getRecordsPerPage();
			
			List<Board> list = biz.selectList();
			paging.setNumberOfRecords(list.size());	// ��ü ���ڵ� ��
			System.out.println(list.size());
			
			System.out.println("offset : " + offset + "record : " + paging.getRecordsPerPage() * (currentPageNo * 2));
			
			List<Board> bist = new ArrayList<Board>();
			
			for(Board dto : list) {		// list�� �ִ� ������ dto�� ����ָ鼭 if ���ǹ��� �ִ� ���ڵ���� bist�� add����(���������� ������ ���ڵ�)
				if(dto.getMyno() >= (offset * 2) + 1 && dto.getMyno() < paging.getRecordsPerPage() * (currentPageNo * 2) + 1) {
					bist.add(dto);
				}
			}
			
			paging.makePaging();	// ������ ����
			
			
			System.out.println("startpage : " + paging.getStartPageNo() + "endPage : " + paging.getEndPageNo() + "final : " + paging.getFinalPageNo() );
			
			if(list != null) {
				request.setAttribute("key", "paging");	// command ���� key�� ��Ƽ� ����
				request.setAttribute("list", bist);	
				request.setAttribute("paging", paging);
				request.setAttribute("servletPath", "paging.do");
				
				url = "exam.jsp";
			}
			
			request.getRequestDispatcher(url).forward(request, response);
			
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
