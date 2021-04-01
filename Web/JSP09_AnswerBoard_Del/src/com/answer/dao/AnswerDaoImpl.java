package com.answer.dao;

import com.answer.dto.AnswerDto;
import static com.answer.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerDaoImpl implements AnswerDao {

    @Override
    public List<AnswerDto> selectList() {
        Connection con = getConnection();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<AnswerDto> list = new ArrayList<AnswerDto>();

        try {
            pstm = con.prepareStatement(BOARD_LIST_SQL);
            rs = pstm.executeQuery();
            while (rs.next()) {
                AnswerDto dto = new AnswerDto();
                dto.setBoardno(rs.getInt(1));
                dto.setGroupno(rs.getInt(2));
                dto.setGroupseq(rs.getInt(3));
                dto.setTitletab(rs.getInt(4));
                dto.setDelflag(rs.getString(5));
                dto.setTitle(rs.getString(6));
                dto.setWriter(rs.getString(7));
                dto.setContent(rs.getString(8));
                dto.setRegdate(rs.getDate(9));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstm);
            close(con);
        }

        return list;
    }

    @Override
    public AnswerDto selectOne(int boardno) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        AnswerDto dto = new AnswerDto();

        try {
            pstm = con.prepareStatement(BOARD_SELECT_SQL);
            pstm.setInt(1, boardno);

            rs = pstm.executeQuery();

            while (rs.next()) {
                dto.setBoardno(rs.getInt(1));
                dto.setGroupno(rs.getInt(2));
                dto.setGroupseq(rs.getInt(3));
                dto.setTitletab(rs.getInt(4));
                dto.setDelflag(rs.getString(5));
                dto.setTitle(rs.getString(6));
                dto.setContent(rs.getString(7));
                dto.setWriter(rs.getString(8));
                dto.setRegdate(rs.getDate(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstm);
            close(con);
        }
        return dto;
    }

    @Override
    public boolean boardInsert(AnswerDto dto) {
        Connection con = getConnection();

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(BOARD_INSERT_SQL);
            pstm.setString(1, dto.getTitle());
            pstm.setString(2, dto.getContent());
            pstm.setString(3, dto.getWriter());

            res = pstm.executeUpdate();

            if (res > 0) {
                commit(con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstm);
            close(con);
        }
        return (res > 0) ? true : false;
    }

    @Override
    public boolean boardUpdate(AnswerDto dto) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(BOARD_UPDATE_SQL);
            pstm.setString(1, dto.getTitle());
            pstm.setString(2, dto.getContent());
            pstm.setInt(3, dto.getBoardno());

            res = pstm.executeUpdate();

            if (res > 0) {
                commit(con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstm);
            close(con);
        }
        return (res > 0) ? true : false;
    }

    @Override
    public boolean boardDelete(int boardno) {

        // DELFLAG를 Y로 바꾼다
        Connection con = getConnection();

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(BOARD_DELETE_SQL);
            pstm.setInt(1, boardno);
            res = pstm.executeUpdate();

            if (res > 0) {
                commit(con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstm);
            close(con);
        }
        return (res > 0) ? true : false;
    }

    @Override
    public boolean answerUpdate(int parentboardno) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(ANSWER_UPDATE_SQL);

            res = pstm.executeUpdate();

            if (res > 0) {
                commit(con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstm);
            close(con);
        }
        return (res > 0) ? true : false;
    }

    @Override
    public boolean answerInsert(AnswerDto dto) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(ANSWER_INSERT_SQL);


            res = pstm.executeUpdate();

            if (res > 0) {
                commit(con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstm);
            close(con);
        }
        return (res > 0) ? true : false;
    }
}
