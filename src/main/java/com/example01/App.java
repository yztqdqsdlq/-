package com.example01;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(value = "com.example01.filter")
@MapperScan("com.example01.mapper")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
