package com.example.zh.redistest.controller;

import com.example.zh.redistest.entity.UserInfoBase;
import com.example.zh.redistest.service.UserBaseService;
import com.example.zh.redistest.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private UserBaseService userBaseService;

    @GetMapping("/test/{id}")
    public UserInfoBase redisTest(@PathVariable("id") Integer id){
        String key="redis_test:"+id;
        if(redisUtil.hasKey(key)){
            log.info("过期时间还剩：{}",redisUtil.getExpire(key));
            return (UserInfoBase)redisUtil.get(key);
        }else{
            UserInfoBase userInfoBase=userBaseService.getById(id);
            redisUtil.set(key,userInfoBase);
            redisUtil.expire(key,60L);
            return userInfoBase;
        }
    }

}
