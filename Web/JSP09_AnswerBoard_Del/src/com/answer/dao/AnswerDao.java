package com.answer.dao;

import com.answer.dto.AnswerDto;

import java.util.List;

public interface AnswerDao {

    String BOARD_LIST_SQL = " SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, DELFLAG ,TITLE, CONTENT, WRITER, REGDATE  "
                          + " FROM ANSWERBOARD "
                          + " ORDER BY GROUPNO DESC, GROUPSEQ ";

    String BOARD_SELECT_SQL = " SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, DELFLAG ,TITLE, CONTENT, WRITER, REGDATE "
                            + " FROM ANSWERBOARD "
                            + " WHERE BOARDNO = ? ";

    String BOARD_INSERT_SQL = " INSERT INTO ANSWERBOARD "
                            + " VALUES( BOARDNOSEQ.NEXTVAL, GROUPNOSEQ.NEXTVAL, 1, 0, 'N', ?, ?, ?, SYSDATE) ";

    String BOARD_UPDATE_SQL = " UPDATE ANSWERBOARD "
                            + " SET TITLE = ?, CONTENT = ? "
                            + " WHERE BOARDNO = ? ";

    String BOARD_DELETE_SQL = " UPDATE ANSWERBOARD "
                            + " SET DELFLAG = 'Y' "
                            + " WHERE BOARDNO = ? ";

    String ANSWER_UPDATE_SQL = " UPDATE ANSWERBOARD "
                             + " SET GROUPSEQ = GROUPSEQ + 1 "
                             + " WHERE  "
                             + "   GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = ?) "
                             + " AND "
                             + "   GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = ?) ";

    String ANSWER_INSERT_SQL =  " INSERT INTO ANSWERBOARD "
                             + " VALUES( "
                             + " BOARDNOSEQ.NEXTVAL, "
                             + " (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = ?), "
                             + " (SELECT GROUPSEQ + 1 FROM ANSWERBOARD WHERE BOARDNO = ?), "
                             + " (SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO = ?) + 1, "
                             + " 'N', "
                             + " ?, ?, ?, SYSDATE) ";

    String COUNT_SQL = " SELECT COUNT(*) FROM ANSWERBOARD ";

    String PAGING_SQL = " SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, DELFLAG ,TITLE, CONTENT, WRITER, REGDATE "
                      + " FROM (SELECT ROWNUM AS rnum, A.BOARDNO, A.GROUPNO, A.GROUPSEQ, A.TITLETAB, A.DELFLAG, A.TITLE, A.CONTENT, A.WRITER, A.REGDATE "
                      + "       FROM ( SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, DELFLAG ,TITLE, CONTENT, WRITER, REGDATE "
                      + "              FROM ANSWERBOARD "
                      + "              ORDER BY GROUPNO DESC, GROUPSEQ ) A ) "
                      + " WHERE rnum >= ? AND rnum <= ? ";

    public List<AnswerDto> selectList();
    public AnswerDto selectOne(int boardno);
    public boolean boardInsert(AnswerDto dto);
    public boolean boardUpdate(AnswerDto dto);
    public boolean boardDelete(int boardno);

    public boolean answerUpdate(int parentboardno);
    public boolean answerInsert(AnswerDto dto);

    public int getCount();

    public List<AnswerDto> pageList(int startPageNum, int endPageNum);
}
