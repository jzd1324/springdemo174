package com.example.aop.aop02;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.aop.aop02")
@EnableAspectJAutoProxy
public class SpringConfig {
}
