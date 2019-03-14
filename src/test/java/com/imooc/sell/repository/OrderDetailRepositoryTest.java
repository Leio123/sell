package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void testSave() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456780");
        orderDetail.setOrderId("11111111211");
        orderDetail.setProductId("1111112");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductName("皮皮虾");
        orderDetail.setProductPrice(new BigDecimal(10.5));
        orderDetail.setProductQuantity(2);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repository.findByOrderId("11111111211");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}