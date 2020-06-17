package com.yellowgg.everyday;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "com.yellowgg.everyday.mapper")
public class EverydayApplication {

    public static void main(String[] args) {
        SpringApplication.run(EverydayApplication.class, args);
    }

}
