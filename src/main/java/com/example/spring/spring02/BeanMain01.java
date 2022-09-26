package com.example.spring.spring02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanMain01 {
    public static void main(String[] args) {
        ApplicationContext context =  new ClassPathXmlApplicationContext("bean05.xml");
        Person p1 = context.getBean("person", Person.class);
        p1.setId(1);
        p1.setName("jason");

        Car car = context.getBean("car", Car.class);
        car.setId(2);
        car.setCarName("volvo");

        p1.setCar(car);
        System.out.println(p1);
    }
}
