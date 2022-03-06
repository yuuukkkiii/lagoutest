package com.example.zh.redistest.controller;

import com.example.zh.redistest.base.Constant;
import com.example.zh.redistest.entity.UserInfoBase;
import com.example.zh.redistest.service.UserBaseService;
import com.example.zh.redistest.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @Author: zhaih
 * @Date: 2022/3/4
 * @Time: 14:38
 * @Description:
 */
@Slf4j
@RequestMapping("/redis/test")
@RestController
public class RedisController {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ValueOperations<String,Object> valueOperations;

    @Autowired
    private UserBaseService userBaseService;

    @GetMapping("/test/{id}")
    public UserInfoBase redisTest(@PathVariable("id") Integer id){
        String key=Constant.REDIS_PREFIX+id;
        UserInfoBase userInfoBase;
        if(redisUtil.hasKey(key)){
            long time=redisUtil.getExpire(key);
            log.info("过期时间还剩：{}",time);
            userInfoBase=(UserInfoBase) redisUtil.get(key);
            if(userInfoBase.getAliveTime()>=Constant.MAX_ALIVE){/*超过最长时长，需要重新登陆*/
                return null;
            }else{
                long l=userInfoBase.getAliveTime();
                l+=(120L-time);
                userInfoBase.setAliveTime(l);
                valueOperations.setIfPresent(key,userInfoBase,120L, TimeUnit.SECONDS);
                return userInfoBase;
            }
        }else{
            userInfoBase=userBaseService.getById(id);
            redisUtil.set(key,userInfoBase);
            redisUtil.expire(key,120L);
            return userInfoBase;
        }
    }

}
