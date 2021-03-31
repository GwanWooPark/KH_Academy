package com.mvclogin.dao;

import com.mvclogin.dto.MVCBoardDto;
import com.mvclogin.dto.MVCLoginDto;

import java.util.List;

public interface MVCBoardDao {

    String SELECT_LIST = " SELECT NUM, WRITER, TITLE, CONTENT, REGDATE "
                       + " FROM MVCBOARD "
                       + " ORDER BY NUM DESC ";

    String INSERT_BOARD = " INSERT INTO MVCBOARD "
                        + " VALUES(MVCBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
    public List<MVCBoardDto> selectList();

    public MVCLoginDto selectOne(int num);

    public int insert(MVCBoardDto dto);

    public int update(MVCBoardDto dto);

    public int delete(String writer);
}
