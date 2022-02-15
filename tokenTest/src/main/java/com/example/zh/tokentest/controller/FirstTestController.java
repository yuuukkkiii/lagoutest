package com.example.zh.tokentest.controller;

import com.example.zh.tokentest.base.BaseResponse;
import com.example.zh.tokentest.dto.req.UserBaseReq;
import com.example.zh.tokentest.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
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
    @PostMapping("/generateToken")
    public BaseResponse<String> generateToken(@RequestBody UserBaseReq req){
        return BaseResponse.success(TokenUtils.generateToken(req));
    }

}
