package com.example.spring.spring03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanMain01 {
    public static void main(String[] args) {
        ApplicationContext context =  new AnnotationConfigApplicationContext(SpringConfig.class);
        Person p1 = context.getBean("person", Person.class);
        p1.setId(1);
        p1.setName("jason");
        Car car = context.getBean("car", Car.class);
        car.setId(2);
        car.setCarName("volvo");
        p1.setCar(car);
        System.out.println(p1);

        String[] beans = context.getBeanDefinitionNames();

        for(String bean : beans){
            System.out.println(bean);
        }
    }
}
