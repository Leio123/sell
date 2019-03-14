package com.imooc.sell.controller;

import com.imooc.sell.Utils.serializer.CookieUtil;
import com.imooc.sell.config.ProjectUrlConfig;
import com.imooc.sell.constant.CookieConstant;
import com.imooc.sell.constant.RedisConstant;
import com.imooc.sell.dataobject.SellerInfo;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/seller")
public class SellerUserController {
    @Autowired
    private SellerService sellerService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private ProjectUrlConfig projectUrlConfig;
    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              HttpServletResponse response,
                              Map<String, Object> map) {
        //1.openid去和数据库里的数据匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        if(sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error");
        }
        //2.设置token至redis
        //运行SellApplication后，刷新 http://127.0.0.1:8080/sell/seller/login?openid=abc 这个网址
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        //格式化token，设置微信id，设置过期时间，设置时间单位
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), openid, expire, TimeUnit.SECONDS);
//        redisTemplate.opsForValue().set("bbb","hhh");
        //3.设置token至cookie
//        Cookie cookie = new Cookie("token", token);
//        cookie.setPath("/");
//        cookie.setMaxAge(7200);
//        response.addCookie(cookie);
        //在Chrome浏览器中按下F12，打开开发者工具，查看当前网站的Cookie
        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);
        //redirect跳转地址,用绝对地址
        return new ModelAndView("redirect:"+projectUrlConfig.getSell()+"/sell/seller/order/list");
    }
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Map<String, Object> map) {
        //1.从cookie里面查询
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        if(cookie != null) {
        //2.清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        //3.清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN, null,0);
        }
        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }
}
