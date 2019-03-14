//package com.imooc.sell.aspect;
//
//import com.imooc.sell.Utils.serializer.CookieUtil;
//import com.imooc.sell.constant.CookieConstant;
//import com.imooc.sell.constant.RedisConstant;
//import com.imooc.sell.exception.SellerAuthorizeException;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.StringUtils;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
////利用AOP来设置登陆权限设置
//@Aspect
//@Component
//@Slf4j
//public class SellerAuthorizeAspect {
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    @Pointcut("execution(public * com.imooc.sell.controller.Seller*.*(..))" +
//            "&& !execution(public * com.imooc.sell.controller.SellerUserController.*(..))")
//    public void verify() {}
//
//    @Before("verify()")
//    public void deVerify() {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        //查询cookie
//        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
//        if(cookie == null) {
//            log.warn("【登陆校验】Cookie中查不到token");
//            throw new SellerAuthorizeException();
//        }
//
//        //去redis里面查询
//        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
//        if(StringUtils.isEmpty(tokenValue)) {
//            log.warn("【登陆校验】Redis中查不到token");
//            throw new SellerAuthorizeException();
//        }
//    }
//}
