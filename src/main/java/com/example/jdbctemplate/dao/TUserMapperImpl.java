package com.example.jdbctemplate.dao;


import com.example.jdbctemplate.dto.TUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("tUserMapper")
public class TUserMapperImpl implements TUserMapper {

    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(TUser user) {
//       jdbcTemplate.execute("insert into t_user(user_card, name, gender)  values('"+user.getUserCard()
//               +"','"+user.getName()+"','"+user.getGender()+"')");
       return jdbcTemplate.update("insert into t_user(user_card, name, gender)  values(?,?,?)"
                ,user.getUserCard(),user.getName(),user.getGender());
    }

}
