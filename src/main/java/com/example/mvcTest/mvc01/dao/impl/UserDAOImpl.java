package com.example.mvcTest.mvc01.dao.impl;

import com.example.mvcTest.mvc01.dao.UserDAO;
import com.example.mvcTest.mvc01.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * spring提供了一个注解@Repository用于数据持久层
 */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

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

    @Override
    public User queryUserById(Integer id) {
        User user1 = null;
        for(User user : users){
            if(user.getId() == id){
               user1 = user;
               break;
            }
        }
        return user1;
    }

    @Override
    public boolean insertUser(User user) {
        if(user != null) {
            users.add(user);
            return  true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {

        for(User user1 : users){
            if(user1.getId() == user.getId()){
                users.remove(user1);
                users.add(user);
                break;
            }
        }
        return true;
    }

    @Override
    public boolean deleteUser(Integer id) {
        for(User user1 : users){
            if(user1.getId() == id){
                users.remove(user1);
                break;
            }
        }
        return true;
    }
}
