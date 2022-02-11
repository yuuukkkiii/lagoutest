package com.example.zh.aoplogparamtest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zh.aoplogparamtest.entity.UserInfoBase;
import com.example.zh.aoplogparamtest.mapper.UserInfoBaseMapper;
import com.example.zh.aoplogparamtest.service.UserBaseService;
import org.springframework.stereotype.Service;

/**
 * @Author: zhaih
 * @Date: 2022/2/7
 * @Time: 11:19
 * @Description:
 */
@Service
public class UserBaseServiceImpl extends ServiceImpl<UserInfoBaseMapper, UserInfoBase> implements UserBaseService {
}
