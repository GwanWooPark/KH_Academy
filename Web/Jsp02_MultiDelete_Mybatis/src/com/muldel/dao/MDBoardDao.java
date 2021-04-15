package com.muldel.dao;

import com.muldel.dto.MDBoardDto;

import java.util.List;

public interface MDBoardDao {


    public List<MDBoardDto> selectList();
    public MDBoardDto selectOne(int seq);
    public int insert(MDBoardDto dto);
    public int update(MDBoardDto dto);
    public int delete(int seq);

    public int multiDelete(String [] seqs);
}
