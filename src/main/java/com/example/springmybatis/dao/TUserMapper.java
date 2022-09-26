package com.example.springmybatis.dao;

import com.example.springmybatis.dto.TUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TUserMapper {

    int insert(TUser record);

    TUser selectByPrimaryKey(Integer id);
}