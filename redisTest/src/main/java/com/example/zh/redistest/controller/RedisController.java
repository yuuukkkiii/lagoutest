package com.example.zh.redistest.controller;

import com.example.zh.redistest.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhaih
 * @Date: 2022/3/4
 * @Time: 14:38
 * @Description:
 */
@RequestMapping("/redis/test")
@RestController
public class RedisController {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/test/{id}")
    public String redisTest(@PathVariable("id") Integer id){
        return null;
    }

}
