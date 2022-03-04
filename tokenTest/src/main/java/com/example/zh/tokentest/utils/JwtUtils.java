package com.example.zh.tokentest.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.zh.tokentest.dto.req.UserBaseReq;
import com.example.zh.tokentest.exception.TokenException;
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

    /**
     * @param req 传入参数
     * @return token
     */
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

    /**
     * @param token token内容
     * @param secret 密钥，暂时用传参表示
     */
    public static void verifyToken(String token,String secret) throws TokenException{
        DecodedJWT jwt=null;
        try {
            JWTVerifier verifier=JWT.require(Algorithm.HMAC256(secret+HMAC256_SECRET)).build();
            jwt=verifier.verify(token);
        }catch (Exception e){
            throw new TokenException(442,"token验证失败");
        }
    }

    /**
     * @param token  token
     * @return 获取签发对象
     * @throws TokenException token解析错误
     */
    public static String getAudience(String token)throws TokenException{
        String audience=null;
        try {
            audience=JWT.decode(token).getAudience().get(0);
        }catch (JWTDecodeException e){
            throw new TokenException(443,"token解析失败");
        }
        return audience;
    }

    public static Claim getClaimByName(String token,String name){
        return JWT.decode(token).getClaim(name);
    }

}
