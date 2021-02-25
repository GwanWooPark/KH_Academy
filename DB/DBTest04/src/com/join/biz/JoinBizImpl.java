package com.join.biz;

import com.join.dao.JoinDaoImpl;
import com.join.dto.JoinDto;

import java.util.List;

public class JoinBizImpl implements JoinBiz {

    private JoinDaoImpl dao = new JoinDaoImpl();

    @Override
    public List<JoinDto> selectList() {
        return dao.selectList();
    }

    @Override
    public JoinDto selectOne(int m_no) {
        return dao.selectOne(m_no);
    }

    @Override
    public int insert(JoinDto dto) {
        return dao.insert(dto);
    }

    @Override
    public int update(JoinDto dto) {
        return dao.update(dto);
    }

    @Override
    public int delete(int m_no) {
        return dao.delete(m_no);
    }

    @Override
    public JoinDto topNproc(int n) {
        return dao.topNproc(n);
    }
}


