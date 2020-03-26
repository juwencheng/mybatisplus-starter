package com.example.mybatisplus1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.mybatisplus1.api.dao")
public class Mybatisplus1Application {

    public static void main(String[] args) {
        SpringApplication.run(Mybatisplus1Application.class, args);
    }

}
