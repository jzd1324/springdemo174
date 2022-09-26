package com.example.spring.spring02;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
public class Person {
    private Integer Id;
    private String name;
    private Car car;
}
