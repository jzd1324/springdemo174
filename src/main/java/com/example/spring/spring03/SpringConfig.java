package com.example.spring.spring03;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 实现一个配置类，来帮我们优先构建"xml"
 */
//1.需要加上这个注解，也是一个bean，并且在spring启动的时候优先被加载---spring的配置类
@Configuration
//2.既然是看成配置文件，这个时候我们需要实现组件扫描的功能
@ComponentScan(basePackages = "com.example.spring03")
public class SpringConfig {

}
