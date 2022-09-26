package com.example.aop.aop01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.example.aop.aop01")
//开启aop
@EnableAspectJAutoProxy
public class SpringConfig {
}
