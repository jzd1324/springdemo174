package com.example.springmybatis;

import com.example.springmybatis.config.SpringConfig;
import com.example.springmybatis.dto.TUser;
import com.example.springmybatis.service.TUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main01 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        TUserService tUserService = applicationContext.getBean("tUserService", TUserService.class);

//        TUser user =new TUser(4,"fghrfegerftre1231","cola","女");
//
//        tUserService.createUser(user);
        System.out.println(tUserService.queryUserById(4));


    }
}
