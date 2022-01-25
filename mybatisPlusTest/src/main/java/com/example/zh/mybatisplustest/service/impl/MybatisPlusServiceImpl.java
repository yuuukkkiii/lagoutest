package com.example.zh.mybatisplustest.service.impl;

import com.example.zh.mybatisplustest.base.BaseResponse;
import com.example.zh.mybatisplustest.service.MybatisPlusService;
import org.springframework.stereotype.Service;

/**
 * @Author: zhaih
 * @Date: 2022/1/25
 * @Time: 16:05
 * @Description: mybatis的使用
 */
@Service
public class MybatisPlusServiceImpl implements MybatisPlusService {
    /**
     * @return mybatis-plus查询的使用结果
     */
    @Override
    public BaseResponse<String> selectResult() {
        return null;
    }
}
