package com.example.jdbctemplate;

import com.example.jdbctemplate.config.SpringConfig;
import com.example.jdbctemplate.dto.TUser;
import com.example.jdbctemplate.service.TUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main01 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        TUserService tUserService = applicationContext.getBean("tUserService", TUserService.class);

        TUser user =new TUser();
        user.setId(121);
        user.setUserCard("2461963779");
        user.setName("jzd");
        user.setGender("男");


        System.out.println(tUserService.createUser(user));



    }
}
