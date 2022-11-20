package com.zhang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhangJiaHao
 * @date 2022/11/10 17:03
 *
 * **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.zhang.*"})
@MapperScan({"com.zhang.dao"})
public class ShardingSphereApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereApplication.class,args);
    }
}

