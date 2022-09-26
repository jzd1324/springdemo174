package com.example.springmybatis.service.impl;

import com.example.springmybatis.dao.TUserMapper;
import com.example.springmybatis.dto.TUser;
import com.example.springmybatis.service.TUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("tUserService")
public class TUserServiceImpl implements TUserService {
    //注入
    @Resource(name="TUserMapper")
    private TUserMapper tUserMapper;
    @Override
    public boolean createUser(TUser user) {
       int i  =  tUserMapper.insert(user);
       if(i > 0){
           return true;
       }else
        return false;
    }

    @Override
    public TUser queryUserById(Integer id) {
      return tUserMapper.selectByPrimaryKey(id);
    }
}
