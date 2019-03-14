package com.imooc.sell.handler;

import com.imooc.sell.Utils.ResultVOUtil;
import com.imooc.sell.VO.ResultVO;
import com.imooc.sell.config.ProjectUrlConfig;
import com.imooc.sell.exception.ResponseBankException;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.exception.SellerAuthorizeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SellExceptionHandler {
    @Autowired
    private ProjectUrlConfig projectUrlConfig;
    //拦截登陆异常
    //127.0.0.1:8080/sell/wechat/qrAuthorize?returnUrl=127.0.0.1:8080/sell/seller/login
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getWechatOpenAuthorize())
                .concat("/sell/wechat/qrAuthorize")
                .concat("?returnUrl=")
                .concat(projectUrlConfig.getSell())
                .concat("/sell/seller/login"));
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }
    //该成403
    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleResponseBankException() {

    }

}
