package com.example.zh.aoplogparamtest.controller;

import com.example.zh.aoplogparamtest.base.BaseResponse;
import com.example.zh.aoplogparamtest.dto.req.UserBaseReq;
import com.example.zh.aoplogparamtest.service.MybatisPlusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/selectChain")
    public BaseResponse<String> selectChain(@RequestBody UserBaseReq req){
        return mybatisPlusService.selectChain(req);
    }

    @PostMapping("/selectWrapper")
    public BaseResponse<String> selectWrapper(@RequestBody UserBaseReq req){
        return mybatisPlusService.selectWrapper(req);
    }
}
