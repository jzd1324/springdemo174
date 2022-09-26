package com.example.aop.aop01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPMain01 {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DoSth doSth = context.getBean("doSth", DoSth.class);
        doSth.add(1,2);
       // doSth.exp();
//        int mult = doSth.mult(2, 6);
//        System.out.println(mult);
    }
}
