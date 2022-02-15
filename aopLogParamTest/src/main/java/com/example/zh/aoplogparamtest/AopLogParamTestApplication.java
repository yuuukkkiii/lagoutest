package com.example.zh.aoplogparamtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.zh.aoplogparamtest.mapper")
@SpringBootApplication
public class AopLogParamTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopLogParamTestApplication.class, args);
    }

}
