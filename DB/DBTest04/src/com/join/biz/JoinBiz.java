package com.join.biz;

import com.join.dto.JoinDto;

import java.util.List;

public interface JoinBiz {

    public List<JoinDto> selectList();

    public JoinDto selectOne(int m_no);

    public int insert(JoinDto dto);

    public int update(JoinDto dto);

    public int delete(int m_no);

    public JoinDto topNproc(int n);

}
