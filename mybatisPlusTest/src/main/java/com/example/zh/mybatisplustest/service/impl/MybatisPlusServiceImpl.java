package com.example.zh.mybatisplustest.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.zh.mybatisplustest.base.BaseResponse;
import com.example.zh.mybatisplustest.contant.ResponseEnum;
import com.example.zh.mybatisplustest.entity.UserInfoBase;
import com.example.zh.mybatisplustest.service.UserBaseService;
import com.example.zh.mybatisplustest.dto.req.UserBaseReq;
import com.example.zh.mybatisplustest.mapper.UserInfoBaseMapper;
import com.example.zh.mybatisplustest.service.MybatisPlusService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhaih
 * @Date: 2022/1/25
 * @Time: 16:05
 * @Description: mybatis的使用
 */
@Service
public class MybatisPlusServiceImpl implements MybatisPlusService {
    @Autowired
    UserInfoBaseMapper userInfoBaseMapper;

    @Autowired
    UserBaseService userBaseService;
    /**
     * @return mybatis-plus查询的使用结果
     */
    @Override
    public BaseResponse<String> selectResult(UserBaseReq req) {
        Integer code=req.getCode();
        UserInfoBase target=new UserInfoBase();
        BeanUtils.copyProperties(req,target);
        if(code==null){
            return BaseResponse.fail(ResponseEnum.RESP_1.getCode(),ResponseEnum.RESP_1.getMsg());
        }else if(code==1){
            return BaseResponse.success(JSON.toJSONString(userInfoBaseMapper.selectById(1)));
        }else if(code==2){
            return BaseResponse.success(JSON.toJSONString(userBaseService.save(target)));
        }
        return null;
    }
}
