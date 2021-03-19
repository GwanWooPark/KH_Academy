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
        return dao.selectOne(seq);
    }

    @Override
    public int insert(MDBoardDto dto) {
        return dao.insert(dto);
    }

    @Override
    public int update(MDBoardDto dto) {
        return dao.update(dto);
    }

    @Override
    public int delete(int seq) {
        return dao.delete(seq);
    }

    @Override
    public int multiDelete(String[] seqs) {

        return dao.multiDelete(seqs);
    }
}
