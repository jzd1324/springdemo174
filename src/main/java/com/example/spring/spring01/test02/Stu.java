package com.example.spring.spring01.test02;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Stu {
    private Integer id;
    private String StuName;
    private Clz clz;

    private List<Tea> Tealist ;

}
