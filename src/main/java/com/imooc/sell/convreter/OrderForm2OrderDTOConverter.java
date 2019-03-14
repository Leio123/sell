package com.imooc.sell.convreter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class OrderForm2OrderDTOConverter {
     public static OrderDTO convert(OrderForm orderForm) {
         Gson gson = new Gson();

         OrderDTO orderDTO = new OrderDTO();
         orderDTO.setBuyerName(orderForm.getName());
         orderDTO.setBuyerPhone(orderForm.getPhone());
         orderDTO.setBuyerAddress(orderForm.getAddress());
         orderDTO.setBuyerOpenid(orderForm.getOpenid());
         //从字符串转换成List
         List<OrderDetail> orderDetailList = new ArrayList<>();
         try {
             orderDetailList = gson.fromJson(orderForm.getItems(),
                     new TypeToken<List<OrderDetail>>() {
                     }.getType());
         } catch (Exception e) {
             log.error("【对象转换】错误，String={}", orderForm.getItems());
             throw new SellException(ResultEnum.PARAM_ERROR);
         }
         orderDTO.setOrderDetailList(orderDetailList);
//         BeanUtils.copyProperties();对象内属性名不一样不能转
         return orderDTO;
     }
}
