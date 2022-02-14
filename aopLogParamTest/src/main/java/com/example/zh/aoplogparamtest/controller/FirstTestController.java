package com.example.zh.aoplogparamtest.controller;

import com.example.zh.aoplogparamtest.aop.JoinPointTest;
import com.example.zh.aoplogparamtest.aop.Payload;
import com.example.zh.aoplogparamtest.aop.PostParam;
import com.example.zh.aoplogparamtest.aop.ReqLog;
import com.example.zh.aoplogparamtest.base.BaseResponse;
import com.example.zh.aoplogparamtest.dto.req.UserBaseReq;
import com.example.zh.aoplogparamtest.service.MybatisPlusService;
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

    /**
     * @return post方法的简单验证
     */
    @PostMapping("/postSimple")
    public BaseResponse<String> postTest(){
        return BaseResponse.success("success_post");
    }

    /**
     * @return get方法的简单验证
     */
    @GetMapping("/getSimple")
    public BaseResponse<String> getTest(){
        return BaseResponse.success("success_get");
    }

    /**
     * @return 检查参数
     */
    @ReqLog
    @GetMapping("/getParam/{id}")
    public BaseResponse<String> getParam(@PathVariable("id") String id){
        System.out.println("id====="+ id);
        return BaseResponse.success("success_param");
    }

    /**
     * @param name 参数1
     * @param id 参数2
     * @return
     */
    @Payload
    @GetMapping("/getParam")
    public BaseResponse<String> getParamPayLoad(@RequestParam String name,
                                                @RequestParam Integer id){
        System.out.println("id====="+ id+"   ==name==   "+name);
        return BaseResponse.success("success_param");
    }

    /**
     * @param req post方式传递的参数
     * @return 对参数进行处理并再次传递
     */
    @PostParam
    @PostMapping("/postParam")
    public BaseResponse<String> postParam(@RequestBody UserBaseReq req){
        System.out.println(req.toString());
        return BaseResponse.success("success_postParam");
    }

    @JoinPointTest
    @GetMapping("/joinPointTest")
    public BaseResponse<String> joinPointTestController(@RequestParam String id){
        System.out.println("id====="+ id);
        return BaseResponse.success("success_param");
    }
}
