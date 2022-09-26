package com.example.mvcTest.mvc01.service.impl;

import com.example.mvcTest.mvc01.dao.UserDAO;
import com.example.mvcTest.mvc01.dto.User;
import com.example.mvcTest.mvc01.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户的业务处理，需要调用dao
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    /**
     * byType
     */
//    @Autowired
//    //虽然  @Autowired是bytype，但是可以通过组合一个注解实现byName
//    @Qualifier("userDAO")
    //第二个注解，注意这个注解是javax所提供，所以脱离了spring管制，更加方便，而且遵循了byname的思路
    @Resource
    private UserDAO userDAO;

    @Override
    public List<User> queryUserAll() {
        return userDAO.queryUserAll();
    }

    @Override
    public User queryUserById(Integer id) {
        return userDAO.queryUserById(id);
    }

    @Override
    public boolean insertUser(User user) {
        return userDAO.insertUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Override
    public boolean deleteUser(Integer id) {
        return userDAO.deleteUser(id);
    }
}
