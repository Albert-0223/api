package com.ay.ayblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ay.ayblog.*")
@MapperScan("com.ay.ayblog.dao")
public class AyBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(AyBlogApplication.class, args);
    }

}
