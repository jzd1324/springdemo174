package com.example.mvcTest.mvc02.dao;

import com.example.mvcTest.mvc01.dto.User;

import java.util.List;

public interface UserDao {
    List<User> queryUserAll();
}
