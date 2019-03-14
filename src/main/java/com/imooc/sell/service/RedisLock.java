package com.imooc.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RedisLock {
    @Autowired
    private StringRedisTemplate redisTemplate;

    //加锁
    public boolean lock(String key, String value) {
        if(redisTemplate.opsForValue().setIfAbsent(key, value)) {
            //如果可以设置key，返回true，说明已经被锁住了
            return true;
        }

        String currentValue = redisTemplate.opsForValue().get(key);
        //如果锁过期
        if(!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //获取上一个锁的时间
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            if(!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }
        return false;
    }
    /**
     * @Author Leio
     * @Description 解锁
     * @Date 0:26 2019/1/12
     * @Param [key, value]
     * @return void
     **/
    public void unlock(String key, String value) {
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch(Exception e) {
            log.error("【redis分布式锁】解锁异常， {}", e);
        }
    }
}
