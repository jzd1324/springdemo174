package com.example.spring.spring01.test02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
//        ApplicationContext Context = new ClassPathXmlApplicationContext("bean02.xml");
//        Stu stu01 = Context.getBean("stu01", Stu.class);
//        System.out.println(stu01);

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean03.xml");
//        Stu stu = context.getBean("stu", Stu.class);
//        System.out.println(stu);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean04.xml");
        Clz clz = context.getBean("clz001", Clz.class);
        System.out.println(clz);
    }
}
