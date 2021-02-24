package com.score.biz;

import com.score.dao.ScoreDao;
import com.score.dto.ScoreDto;

import java.util.List;

public class ScoreBizImpl implements ScoreBiz {

    @Override
    public List<ScoreDto> selectList() {

        return dao.selectList();
    }

    @Override
    public ScoreDto selectOne(String s_name) {
        return null;
    }

    @Override
    public int insert(ScoreDto dto) {
        return 0;
    }

    @Override
    public int update(ScoreDto dto) {
        return 0;
    }

    @Override
    public int delete(ScoreDto dto) {
        return 0;
    }
}
