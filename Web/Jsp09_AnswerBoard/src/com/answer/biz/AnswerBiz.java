package com.answer.biz;

import com.answer.dto.AnswerDto;

import java.util.List;

public interface AnswerBiz {
    public List<AnswerDto> selectList();
    public AnswerDto selectOne(int boardno);
    public int boardInsert(AnswerDto dto);
    public int boardUpdate(AnswerDto dto);
    public int boardDelete(int boardno);

    public int answerProc(AnswerDto dto);
}
