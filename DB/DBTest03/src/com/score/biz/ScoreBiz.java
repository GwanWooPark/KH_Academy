package com.score.biz;

import com.score.dto.ScoreDto;

import java.util.List;

public interface ScoreBiz {

    public List<ScoreDto> selectList();

    public ScoreDto selectOne(String s_name);

    public int insert(ScoreDto dto);

    public int update(ScoreDto dto);

    public int delete(ScoreDto dto);

}
