package com.open.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuxiaowei
 * @date 2022年10月09日 15:04
 * @Description
 */
@SpringBootApplication
@MapperScan(basePackages = "com.open.sharding.mapper")
public class HelloShardingJdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloShardingJdbcApplication.class, args);
    }
}
