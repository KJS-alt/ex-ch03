package com.example.demo.mybatis.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
public class Student {

    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
