package com.ddup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ddup.mapper")
public class DdupApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdupApplication.class, args);
    }

}
