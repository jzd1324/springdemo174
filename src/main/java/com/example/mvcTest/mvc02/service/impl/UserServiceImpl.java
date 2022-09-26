package com.example.mvcTest.mvc02.service.impl;

import com.example.mvcTest.mvc01.dto.User;
import com.example.mvcTest.mvc02.dao.UserDao;
import com.example.mvcTest.mvc02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDao")
//    @Resource
    private UserDao userDao;


    @Override
    public List<User> queryUserAll() {
        return userDao.queryUserAll();
    }
}
