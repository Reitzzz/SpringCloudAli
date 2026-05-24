package com.example.springcloud_ali;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.example.book.mapper","com.example.user.mapper","com.example.borrow.mapper"})
@SpringBootApplication
public class SpringCloudAliApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAliApplication.class, args);
    }

}
