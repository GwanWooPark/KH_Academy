package com.answer.dao;

import com.answer.dto.AnswerDto;
import static com.answer.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerDaoImpl implements AnswerDao{

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
                dto.setTitle(rs.getString(5));
                dto.setContent(rs.getString(6));
                dto.setWriter(rs.getString(7));
                dto.setDate(rs.getDate(8));

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
            pstm = con.prepareStatement(BOARD_DETAIL_SQL);
            pstm.setInt(1, boardno);
            rs = pstm.executeQuery();
            while (rs.next()) {
                dto.setBoardno(rs.getInt(1));
                dto.setGroupno(rs.getInt(2));
                dto.setGroupseq(rs.getInt(3));
                dto.setTitletab(rs.getInt(4));
                dto.setTitle(rs.getString(5));
                dto.setContent(rs.getString(6));
                dto.setWriter(rs.getString(7));
                dto.setDate(rs.getDate(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstm);
            close(con);
        }

        return dto;
    }

    @Override
    public int boardInsert(AnswerDto dto) {

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
        return res;
    }

    @Override
    public int boardUpdate(AnswerDto dto) {

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
        return res;
    }

    @Override
    public int boardDelete(int boardno) {

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
        return res;
    }

    @Override
    public int answerUpdate(int parentboardno) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        int res = 0;
        try {
            pstm = con.prepareStatement(ANSWER_UPDATE_SQL);
            pstm.setInt(1, parentboardno);
            pstm.setInt(2, parentboardno);
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
        return res;
    }

    @Override
    public int answerInsert(AnswerDto dto) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        int res = 0;
        try {
            pstm = con.prepareStatement(ANSWER_INSERT_SQL);
            pstm.setInt(1, dto.getBoardno());
            pstm.setInt(2, dto.getBoardno());
            pstm.setInt(3, dto.getBoardno());
            pstm.setString(4, dto.getTitle());
            pstm.setString(5, dto.getContent());
            pstm.setString(6, dto.getWriter());
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
        return res;
    }
}
