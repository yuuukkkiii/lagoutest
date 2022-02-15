package com.example.zh.tokentest.utils;

import com.example.zh.tokentest.dto.req.UserBaseReq;
import org.springframework.stereotype.Component;

/**
 * @Author: zhaih
 * @Date: 2022/2/15
 * @Time: 15:31
 * @Description:
 */
@Component
public class TokenUtils {
    private  TokenUtils(){

    }
    public static String generateToken(UserBaseReq req){
        return JwtUtils.createToken(req);
    }
}
