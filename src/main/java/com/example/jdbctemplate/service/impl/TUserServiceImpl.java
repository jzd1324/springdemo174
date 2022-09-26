package com.example.jdbctemplate.service.impl;

import com.example.jdbctemplate.dao.TUserMapper;
import com.example.jdbctemplate.dto.TUser;
import com.example.jdbctemplate.service.TUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("tUserService")
public class TUserServiceImpl implements TUserService {
    //注入
    @Resource(name = "tUserMapper")
    private TUserMapper tUserMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createUser(TUser user) {
     int  i =    tUserMapper.insert(user);
//     i = 3/0;
//     if(i > 0 ) {
//         return true;
//     }else{
//         return false;
//     }
        return  true;

    }

    public void rollbackCreate(TUser user){
        System.out.println("出现问题，开始回滚");
    }
}