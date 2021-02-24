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

        return dao.selectOne(s_name);
    }

    @Override
    public int insert(ScoreDto dto) {

        return dao.insert(dto);
    }

    @Override
    public int update(ScoreDto dto) {

        return dao.update(dto);
    }

    @Override
    public int delete(String name) {

        return dao.delete(name);
    }
}
