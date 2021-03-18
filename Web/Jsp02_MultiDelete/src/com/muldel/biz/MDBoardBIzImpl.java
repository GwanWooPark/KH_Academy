package com.muldel.biz;

import com.muldel.dao.MDBoardDao;
import com.muldel.dao.MDBoardDaoImpl;
import com.muldel.dto.MDBoardDto;

import java.util.List;

public class MDBoardBIzImpl implements MDBoardBIz{

    private MDBoardDao dao = new MDBoardDaoImpl();

    @Override
    public List<MDBoardDto> selectList() {
        return dao.selectList();
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

        return dao.multiDelete(seqs);
    }
}
