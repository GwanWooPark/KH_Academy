package com.mvclogin.biz;

import com.mvclogin.dto.MVCBoardDto;
import com.mvclogin.dto.MVCLoginDto;

import java.util.List;

public interface MVCBoardBiz {

    public List<MVCBoardDto> selectList();

    public MVCLoginDto selectOne(int num);

    public int insert(MVCBoardDto dto);

    public int update(MVCBoardDto dto);

    public int delete(String writer);
}
