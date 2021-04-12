package com.tjy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.tjy.dao")
@SpringBootApplication
public class Userlogin02Application {

    public static void main(String[] args) {
        SpringApplication.run(Userlogin02Application.class, args);
    }

}
