package com.paging.model.dao;

import com.paging.dto.Board;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BoardDao {
	
	public List<Board> selectList(){
		
		List<Board> list = new ArrayList<Board>();
		
		if(list.size() < 10) {
		
			for(int i = 1; i < 51; i ++) {
				Board dto = new Board(i, "���̵�Ƽ��", "�׽�Ʈ���Դϴ�.");
				
				list.add(dto);
			}
		}
		
		
		return list;
	}

}
