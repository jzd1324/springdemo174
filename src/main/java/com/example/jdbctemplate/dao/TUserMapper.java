package com.example.jdbctemplate.dao;

import com.example.jdbctemplate.dto.TUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TUserMapper {

    int insert(TUser record);

}