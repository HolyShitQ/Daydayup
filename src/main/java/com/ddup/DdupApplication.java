package com.ddup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.ddup.mapper")
@EnableScheduling
public class DdupApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdupApplication.class, args);
    }

}
