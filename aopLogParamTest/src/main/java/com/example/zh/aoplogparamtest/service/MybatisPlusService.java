package com.example.zh.aoplogparamtest.service;

import com.example.zh.aoplogparamtest.base.BaseResponse;
import com.example.zh.aoplogparamtest.dto.req.UserBaseReq;

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
