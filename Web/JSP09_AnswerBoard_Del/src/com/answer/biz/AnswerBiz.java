package com.answer.biz;

import com.answer.dto.AnswerDto;

import java.util.List;

public interface AnswerBiz {

    public List<AnswerDto> selectList();
    public AnswerDto selectOne(int boardno);
    public boolean boardInsert(AnswerDto dto);
    public boolean boardUpdate(AnswerDto dto);
    public boolean boardDelete(int boardno);

    public boolean answerProc(AnswerDto dto);

    public int getCount();

    public List<AnswerDto> pageList(int startPageNum, int endPageNum);
}
