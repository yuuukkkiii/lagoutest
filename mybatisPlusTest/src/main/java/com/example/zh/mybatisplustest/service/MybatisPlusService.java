package com.example.zh.mybatisplustest.service;

import com.example.zh.mybatisplustest.base.BaseResponse;
import com.example.zh.mybatisplustest.dto.req.UserBaseReq;

/**
 * @Author: zhaih
 * @Date: 2022/1/25
 * @Time: 16:04
 * @Description:
 */
public interface MybatisPlusService {
    public BaseResponse<String> selectResult(UserBaseReq req);
    public BaseResponse<String> selectChain(UserBaseReq req);
    public BaseResponse<String> selectWrapper(UserBaseReq req);
}
