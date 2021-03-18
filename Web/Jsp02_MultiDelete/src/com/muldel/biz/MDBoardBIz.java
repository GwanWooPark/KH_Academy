package com.muldel.biz;

import com.muldel.dto.MDBoardDto;

import java.util.List;

public interface MDBoardBIz {

    public List<MDBoardDto> selectList();
    public MDBoardDto selectOne(int seq);
    public int insert(MDBoardDto dto);
    public int update(MDBoardDto dto);
    public int delete(int seq);

    public int multiDelete(String [] seqs);

}
