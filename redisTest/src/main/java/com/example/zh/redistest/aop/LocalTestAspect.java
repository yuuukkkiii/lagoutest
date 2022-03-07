package com.example.zh.redistest.aop;

import com.example.zh.redistest.base.Constant;
import com.example.zh.redistest.entity.UserInfoBase;
import com.example.zh.redistest.utils.RedisUtil;
import com.github.benmanes.caffeine.cache.Cache;
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
    ValueOperations<String,Object> valueOperations;

    @Autowired
    Cache<String,Object> caffeineCache;

    @Pointcut("@annotation(com.example.zh.redistest.aop.LocalTest)")
    private void localTest(){}

    @Around("localTest()")
    public Object localTestAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("===进入切面===");
        Object [] objects=joinPoint.getArgs();
        Integer id= (Integer) objects[0];
        String key= Constant.REDIS_PREFIX+id;
        UserInfoBase userInfoBase=(UserInfoBase) caffeineCache.getIfPresent(key);
        if(userInfoBase==null){
            return joinPoint.proceed(objects);
        }else{
            return userInfoBase;
        }
    }
}
