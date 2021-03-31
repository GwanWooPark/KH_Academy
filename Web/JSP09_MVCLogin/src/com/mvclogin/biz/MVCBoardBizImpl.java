package com.mvclogin.biz;

import com.mvclogin.dao.MVCBoardDao;
import com.mvclogin.dao.MVCBoardDaoImpl;
import com.mvclogin.dto.MVCBoardDto;
import com.mvclogin.dto.MVCLoginDto;

import java.util.List;

public class MVCBoardBizImpl implements MVCBoardBiz{

    MVCBoardDao dao = new MVCBoardDaoImpl();
    @Override
    public List<MVCBoardDto> selectList() {
        return dao.selectList();
    }

    @Override
    public MVCLoginDto selectOne(int num) {
        return dao.selectOne(num);
    }

    @Override
    public int insert(MVCBoardDto dto) {
        return dao.insert(dto);
    }

    @Override
    public int update(MVCBoardDto dto) {
        return dao.update(dto);
    }

    @Override
    public int delete(String writer) {
        return dao.delete(writer);
    }
}
