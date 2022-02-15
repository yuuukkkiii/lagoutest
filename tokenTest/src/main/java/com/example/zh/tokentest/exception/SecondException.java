package com.example.zh.tokentest.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhaih
 * @Date: 2022/2/15
 * @Time: 11:39
 * @Description: 自定义错误2
 */
@Data
@NoArgsConstructor
public class SecondException extends RuntimeException{
    private int code;

    private String msg;

    public SecondException(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
