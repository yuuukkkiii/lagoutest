package com.example.zh.userexceptiontest.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhaih
 * @Date: 2022/2/15
 * @Time: 11:29
 * @Description: 自定义错误1
 */
@Data
@NoArgsConstructor
public class MyException extends RuntimeException {
    private int code;

    private String msg;

    public MyException(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
