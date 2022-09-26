package com.example.jdbctemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TUser {
    private Integer id;

    private String userCard;

    private String name;

    private String gender;
}