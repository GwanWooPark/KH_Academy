package com.muldel.dao;

import com.muldel.dto.MDBoardDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.muldel.db.JDBCTemplate.*;

public class MDBoardDaoImpl implements MDBoardDao{

    @Override
    public List<MDBoardDto> selectList() {

        // 1, 2.
        Connection con = getConnection();

        // 3.

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<MDBoardDto> list = new ArrayList<MDBoardDto>();

        try {
            pstm = con.prepareStatement(SELECT_LIST_SQL);
            rs = pstm.executeQuery();

            while (rs.next()) {
                MDBoardDto dto = new MDBoardDto();
                dto.setSeq(rs.getInt(1));
                dto.setWriter(rs.getString(2));
                dto.setTitle(rs.getString(3));
                dto.setContent(rs.getString(4));
                dto.setRegdate(rs.getDate(5));

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
    public MDBoardDto selectOne(int seq) {
        return null;
    }

    @Override
    public int insert(MDBoardDto dto) {
        return 0;
    }

    @Override
    public int update(MDBoardDto dto) {
        return 0;
    }

    @Override
    public int delete(int seq) {
        return 0;
    }

    @Override
    public int multiDelete(String[] seqs) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        int res = 0;
        int[] cnt = null;

        try {
            pstm = con.prepareStatement(DELETE_SQL);
            for (int i = 0; i < seqs.length; i++) {
                pstm.setString(1, seqs[i]);
                pstm.addBatch();                                // 메모리에 sql문을 적재 후, executeBatch() 메소드가 호출되면 한 번에 실행;
                System.out.println("삭제할 번호 : " + seqs[i]);
            }

            cnt = pstm.executeBatch();                         // 메모리에 적재되었던 모든 값을 가지고 와서, 실행한다. 리턴 : int[] 성공 -2 / 실패 -3
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] == -2) {
                    res++;
                }
            }

            if (seqs.length == res) {
                commit(con);
            } else {
                rollback(con);
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
