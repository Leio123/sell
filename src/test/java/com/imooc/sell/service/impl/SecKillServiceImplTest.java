package com.imooc.sell.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecKillServiceImplTest {
    @Autowired
    private SecKillServiceImpl secKillService;

    @Test
    public void orderProductMockDiffUser() {
        secKillService.orderProductMockDiffUser("123456");
        Assert.assertEquals(1,SecKillServiceImpl.orders.size());
    }
}