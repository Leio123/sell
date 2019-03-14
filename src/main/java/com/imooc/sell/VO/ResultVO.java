package com.imooc.sell.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVO<T> {
//public class ResultVO<T> implements Serializable {
    //生成序列号id的快捷键：alt+insert（记得关NumLock）
//    private static final long serialVersionUID = 8848731630266574133L;
    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //具体内容
    private T data;
}
