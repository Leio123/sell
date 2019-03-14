package com.imooc.sell.constant;
//redis常量
public interface RedisConstant {
    //设置固定前缀
    String TOKEN_PREFIX = "token_%s";
    //设置账号过期时间
    Integer EXPIRE = 7200;
}
