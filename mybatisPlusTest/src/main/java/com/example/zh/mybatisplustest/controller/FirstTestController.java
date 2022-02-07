package com.example.zh.mybatisplustest.controller;

import com.example.zh.mybatisplustest.base.BaseResponse;
import com.example.zh.mybatisplustest.dto.req.UserBaseReq;
import com.example.zh.mybatisplustest.service.MybatisPlusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhaih
 * @Date: 2022/1/25
 * @Time: 15:48
 * @Description: 首次尝试
 */
@Slf4j
@RestController
@RequestMapping("/daily/test")
public class FirstTestController {
    @Autowired
    MybatisPlusService mybatisPlusService;

    @PostMapping("/selectTest")
    public BaseResponse<String> selectTest(@RequestBody UserBaseReq req){
        return mybatisPlusService.selectResult(req);
    }

}
