package com.example.aop.aop01;

import org.springframework.stereotype.Component;

@Component("doSth")
public class DoSth {
    public void add(int a,int b) throws InterruptedException {
        System.out.println(a+b);
    }
    public void exp(){
        int a = 2/1;
    }

    public int mult(int a,int b){
        int c = a * b;
        System.out.println(c);
        return c;
    }
}
