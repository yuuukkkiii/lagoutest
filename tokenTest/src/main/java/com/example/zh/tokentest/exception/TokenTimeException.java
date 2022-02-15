package com.example.zh.tokentest.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhaih
 * @Date: 2022/2/15
 * @Time: 11:29
 * @Description: token超时错误
 */
@Data
@NoArgsConstructor
public class TokenTimeException extends RuntimeException {
    private int code;

    private String msg;

    public TokenTimeException(int code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
