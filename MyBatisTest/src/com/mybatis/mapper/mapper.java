package com.mybatis.mapper;

import com.mybatis.dto.MyBatisDto;

public interface mapper {

    MyBatisDto selectMember(String id);
}