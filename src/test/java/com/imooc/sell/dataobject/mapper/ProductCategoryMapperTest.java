package com.imooc.sell.dataobject.mapper;

import com.imooc.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {
    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("category_name", "师兄最爱");
        map.put("category_type", 1);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void insertByObject() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("傻越最爱");
        productCategory.setCategoryType(520);
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findByCategoryType() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory = mapper.findByCategoryType(520);
        Assert.assertEquals(520,productCategory.getCategoryType().longValue());
    }

    @Test
    public void findByCategoryName() throws Exception {
        List<ProductCategory> result = mapper.findByCategoryName("傻越最爱");
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void updateByCategoryType() throws Exception {
        int result = mapper.updateByCategoryType("傻越最爱的呀", 521);
        Assert.assertEquals(1,result);
    }

    @Test
    public void updateByObject() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("傻越最爱");
        productCategory.setCategoryType(521);
        int result = mapper.updateByObject(productCategory);
        Assert.assertEquals(1,result);
    }

    @Test
    public void deleteByCategoryType() throws Exception {
        int result = mapper.deleteByCategoryType(521);
        Assert.assertEquals(1,result);
    }

    @Test
    public void selectByCategoryType() {
        ProductCategory productCategory = mapper.selectByCategoryType(520);
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void selectByCategoryId() {
        ProductCategory productCategory = mapper.selectByCategoryId(1);
        Assert.assertNotNull(productCategory);
    }
}