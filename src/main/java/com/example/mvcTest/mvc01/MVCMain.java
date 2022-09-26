package com.example.mvcTest.mvc01;

import com.example.mvcTest.mvc01.config.SpringConfig;
import com.example.mvcTest.mvc01.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MVCMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] beans = context.getBeanDefinitionNames();
        for(String bean : beans){
            System.out.println(bean);
        }
        System.out.println("------------------------");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService.queryUserAll());
    }
}
