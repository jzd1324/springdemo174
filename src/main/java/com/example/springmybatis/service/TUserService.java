package com.example.springmybatis.service;

import com.example.springmybatis.dto.TUser;

public interface TUserService {
    boolean createUser(TUser user);

    TUser queryUserById(Integer id);
}
