package com.example.zh.tokentest.utils;

import com.example.zh.tokentest.dto.req.UserBaseReq;
import org.springframework.stereotype.Component;

import java.util.Map;

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

    /**
     * @param req 传入信息
     * @return
     */
    public static String generateToken(UserBaseReq req){
        return JwtUtils.createToken(req);
    }

    public static Map<String,Object>getTokenInfo(String secret,String token){
        JwtUtils.verifyToken(secret,token);
        String str=JwtUtils.getAudience(token);
        return JwtUtils.getClaimByName(token,str).asMap();
    }
}
