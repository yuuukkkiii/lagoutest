package com.example.zh.redistest.aop;

import com.example.zh.redistest.base.Constant;
import com.example.zh.redistest.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * @Author: zhaih
 * @Date: 2022/3/6
 * @Time: 16:05
 * @Description:
 */
@Component
@Aspect
@Slf4j
public class LocalTestAspect {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    ValueOperations valueOperations;

    @Pointcut("@annotation(com.example.zh.redistest.aop.LocalTest)")
    private void localTest(){}

    @Around("localTest()")
    public Object localTestAround(ProceedingJoinPoint joinPoint){
        log.info("===进入切面===");
        Object [] objects=joinPoint.getArgs();
        Integer id= (Integer) objects[0];
        String key= Constant.REDIS_PREFIX+id;
        return null;
    }
}
