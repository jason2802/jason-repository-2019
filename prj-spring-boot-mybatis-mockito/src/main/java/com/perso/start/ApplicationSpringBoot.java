package com.perso.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ( basePackages = "com.perso.service" )
@MapperScan("com.perso.mappers")
public class ApplicationSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationSpringBoot.class, args);
    }
}
