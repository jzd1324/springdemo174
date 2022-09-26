package com.example.mvcTest.mvc02.dao.impl;

import com.example.mvcTest.mvc01.dto.User;
import com.example.mvcTest.mvc02.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static List<User> users;

    static {
        users = new ArrayList<>();
        User user01 = new User(1,"majian");
        User user02 = new User(2,"jason");
        users.add(user01);
        users.add(user02);
    }

    @Override
    public List<User> queryUserAll() {
        return users;
    }

}
