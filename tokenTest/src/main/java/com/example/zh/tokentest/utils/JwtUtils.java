package com.example.zh.tokentest.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.zh.tokentest.dto.req.UserBaseReq;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Author: zhaih
 * @Date: 2022/2/15
 * @Time: 14:39
 * @Description:
 */
@Component
public class JwtUtils {
    @Value("${own.option.setting.expiresDate}")
    private static Integer EXPIRES_DATE;

    @Value("${own.option.setting.hmac256Secret}")
    private static String HMAC256_SECRET;

    public static Integer getExpiresDate() {
        return EXPIRES_DATE;
    }
    @Value("${own.option.setting.expiresDate}")
    public void setExpiresDate(Integer expiresDate) {
        EXPIRES_DATE = expiresDate;
    }

    public static String getHmac256Secret() {
        return HMAC256_SECRET;
    }
    @Value("${own.option.setting.hmac256Secret}")
    public  void setHmac256Secret(String hmac256Secret) {
        HMAC256_SECRET = hmac256Secret;
    }

    public static String createToken(UserBaseReq req){
        return JWT.create().withAudience(String.valueOf(req.getCode())) //签发对象
                .withIssuedAt(new Date())
                .withExpiresAt(Date.from(LocalDateTime.now().plusMinutes(EXPIRES_DATE).atZone(ZoneId.systemDefault()).toInstant()))
                .withClaim("userId",req.getCode())
                .withClaim("userName",req.getUserName())
                .withClaim("age",req.getAge())
                .withClaim("time", Instant.now().getEpochSecond())
                .sign(Algorithm.HMAC256(req.getCode()+HMAC256_SECRET));
    }
}
