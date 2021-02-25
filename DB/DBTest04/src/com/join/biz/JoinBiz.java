package com.join.biz;

import com.join.dto.JoinDto;

import java.util.List;

public interface JoinBiz {

    public List<JoinDto> selectList();

    public JoinDto selectOne(int m_no);

    public int insertScore(JoinDto dto);

    public int updateScore(JoinDto dto);

    public int deleteScore(String name);

    public int insertMember(JoinDto dto);

    public int updateMember(JoinDto dto);

    public int deleteMember(String name);

    public JoinDto topNproc(int n);

}
