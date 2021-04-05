package com.answer.biz;

import com.answer.dao.AnswerDao;
import com.answer.dao.AnswerDaoImpl;
import com.answer.dto.AnswerDto;

import java.util.List;

public class AnswerBizImpl implements AnswerBiz{

    AnswerDao dao = new AnswerDaoImpl();
    @Override
    public List<AnswerDto> selectList() {
        return dao.selectList();
    }

    @Override
    public AnswerDto selectOne(int boardno) {
        return dao.selectOne(boardno);
    }

    @Override
    public boolean boardInsert(AnswerDto dto) {
        return dao.boardInsert(dto);
    }

    @Override
    public boolean boardUpdate(AnswerDto dto) {
        return dao.boardUpdate(dto);
    }

    @Override
    public boolean boardDelete(int boardno) {
        return dao.boardDelete(boardno);
    }

    @Override
    public boolean answerProc(AnswerDto dto) {

        boolean update = dao.answerUpdate(dto.getBoardno());
        boolean insert = dao.answerInsert(dto);

        return insert;
    }

    @Override
    public int getCount() {
        return dao.getCount();
    }

    @Override
    public List<AnswerDto> pageList(int startPageNum, int endPageNum) {
        return dao.pageList(startPageNum, endPageNum);
    }
}
