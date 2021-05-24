package com.paging.model.biz;

import com.paging.dto.Board;
import com.paging.model.dao.BoardDao;

import java.util.List;


public class BoardBiz {
	
	BoardDao dao = new BoardDao();
	
	public List<Board> selectList(){
		return dao.selectList();
	}

}
