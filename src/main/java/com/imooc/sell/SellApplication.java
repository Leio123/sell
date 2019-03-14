package com.imooc.sell;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
//配置扫描路径，mybatis操作数据库
@MapperScan(basePackages = "com.imooc.sell.dataobject.mapper")
public class SellApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellApplication.class, args);
    }


}

