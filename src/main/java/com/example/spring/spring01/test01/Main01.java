package com.example.spring.spring01.test01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean01.xml");

        Bean01 bean01 = classPathXmlApplicationContext.getBean("bean01",Bean01.class);
        Bean01 bean02 = classPathXmlApplicationContext.getBean("bean01", Bean01.class);
        bean01.aa(1);
        bean02.aa(2);

        String[] beanDefinitionNames = classPathXmlApplicationContext.getBeanDefinitionNames();
        for (String bean:beanDefinitionNames) {
            System.out.println(bean+"----");
        }
    }
}
