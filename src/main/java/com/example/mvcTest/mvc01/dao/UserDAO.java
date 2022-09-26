package com.example.mvcTest.mvc01.dao;

import com.example.mvcTest.mvc01.dto.User;

import java.util.List;

public interface UserDAO {
    /** 查看当前所有用户信息 */
    List<User> queryUserAll();
    /** 按照用户id查看 */
    User queryUserById(Integer id);
    /** 创建用户 */
    boolean insertUser(User user);

    /** 修改用户 */
    boolean updateUser(User user);

    /** 删除用户 */
    boolean deleteUser(Integer id);
}
