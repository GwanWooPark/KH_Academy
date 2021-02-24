package com.score.biz;

import com.score.dao.ScoreDao;
import com.score.dao.ScoreDaoImpl;
import com.score.dto.ScoreDto;

import java.util.List;

public interface ScoreBiz {

    ScoreDaoImpl dao = new ScoreDaoImpl();

    public List<ScoreDto> selectList();

    public ScoreDto selectOne(String s_name);

    public int insert(ScoreDto dto);

    public int update(ScoreDto dto);

    public int delete(String name);

}
