package com.mvc.biz;

import com.mvc.dao.MVCDao;
import com.mvc.dao.MVCDaoImpl;
import com.mvc.dto.MVCDto;

import java.util.List;

public class MVCBizImpl implements MVCBiz{

    MVCDao dao = new MVCDaoImpl();

    @Override
    public List<MVCDto> selectList() {
        return dao.selectList();
    }

    @Override
    public MVCDto selectOne(int seq) {
        return dao.selectOne(seq);
    }

    @Override
    public int insert(MVCDto dto) {
        return dao.insert(dto);
    }

    @Override
    public int update(MVCDto dto) {
        return dao.update(dto);
    }

    @Override
    public int delete(int seq) {
        return dao.delete(seq);
    }
}
