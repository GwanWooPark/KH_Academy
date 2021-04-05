package com.bike.dao;
import com.bike.dto.BikeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.bike.db.JDBCTemplate.*;

public class BikeDao {

    public boolean insert(List<BikeDto> list) {

        Connection con = getConnection();

        String sql = " INSERT INTO KOREABIKE "
                   + " VALUES ( ?, ?, ?, ?, ?) ";

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(sql);
            for (BikeDto dto : list) {
                pstm.setString(1, dto.getName());
                pstm.setString(2, dto.getAddr());
                pstm.setDouble(3, dto.getLatitude());
                pstm.setDouble(4, dto.getLongitude());
                pstm.setInt(5, dto.getBike_count());
                res = pstm.executeUpdate();
                if (res > 0) {
                    commit(con);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstm);
            close(con);
        }
        return true;
    }

    public boolean delete() {

        Connection con = getConnection();

        String sql = " DELETE FROM KOREABIKE ";

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(sql);
            res = pstm.executeUpdate();
            if (res > 0) {
                con.commit();
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
