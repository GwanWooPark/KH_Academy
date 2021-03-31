package com.answer.dao;

import com.answer.dto.AnswerDto;

import java.util.List;

public interface AnswerDao {

    String BOARD_LIST_SQL = " SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, TITLE, CONTENT, WRITER, REGDATE " +
                            " FROM ANSWERBOARD " +
                            " ORDER BY GROUPNO DESC, GROUPSEQ ";

    String BOARD_DETAIL_SQL = " SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, TITLE, CONTENT, WRITER, REGDATE " +
                              " FROM ANSWERBOARD " +
                              " WHERE BOARDNO = ? ";

    String BOARD_INSERT_SQL = " INSERT INTO ANSWERBOARD "
                            + " VALUES(BOARDNOSEQ.NEXTVAL, GROUPNOSEQ.NEXTVAL, 1, 0, ?, ?, ?, SYSDATE) ";

    String BOARD_UPDATE_SQL = " UPDATE ANSWERBOARD "
                            + " SET TITLE = ?, CONTENT = ?, REGDATE = SYSDATE "
                            + " WHERE BOARDNO = ? ";

    String BOARD_DELETE_SQL = " DELETE FROM ANSWERBOARD "
                            + " WHERE BOARDNO = ? ";

    String ANSWER_UPDATE_SQL = "";

    String ANSWER_INSERT_SQL = "";

    public List<AnswerDto> selectList();
    public AnswerDto selectOne(int boardno);
    public int boardInsert(AnswerDto dto);
    public int boardUpdate(AnswerDto dto);
    public int boardDelete(int boardno);

    public int answerUpdate(int parentboardno);
    public int answerInsert(AnswerDto dto);
}
