package com.example.zh.tokentest.aop;

import com.example.zh.tokentest.exception.TokenException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zhaih
 * @Date: 2022/2/15
 * @Time: 15:46
 * @Description: 鉴权验证
 */
@Component
@Aspect
public class TokenCheckAspect {
    @Pointcut("@annotation(com.example.zh.tokentest.aop.TokenCheck)")
    public void tokenCheckPointcut(){}

    @Around("tokenCheckPointcut()")
    public Object tokenCheckAdvice(ProceedingJoinPoint joinPoint){
        Object[] objects=joinPoint.getArgs();
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String token =request.getHeader("auth");
        if("".equals(token)){
            throw new TokenException(441,"token为空");
        }else{/*解码*/

        }
        return null;
    }
}
