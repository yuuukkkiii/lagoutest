package com.example.zh.mybatisplustest.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zh.mybatisplustest.base.BaseResponse;
import com.example.zh.mybatisplustest.base.MultiResp;
import com.example.zh.mybatisplustest.contant.ResponseEnum;
import com.example.zh.mybatisplustest.entity.UserInfoBase;
import com.example.zh.mybatisplustest.service.UserBaseService;
import com.example.zh.mybatisplustest.dto.req.UserBaseReq;
import com.example.zh.mybatisplustest.mapper.UserInfoBaseMapper;
import com.example.zh.mybatisplustest.service.MybatisPlusService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        if(code==null){/*失败的情况*/
            return BaseResponse.fail(ResponseEnum.RESP_1.getCode(),ResponseEnum.RESP_1.getMsg());
        }else if(code==1){/*byID*/
            return BaseResponse.success(JSON.toJSONString(userInfoBaseMapper.selectById(1)));
        }else if(code==2){/*增*/
            return BaseResponse.success(JSON.toJSONString(userBaseService.save(target)));
        }else if(code==3){/*增或改*/
            return BaseResponse.success(JSON.toJSONString(userBaseService.saveOrUpdate(target)));
        }else if(code==4){/*all1*/
            log.info(JSON.toJSONString(new MultiResp<>(userBaseService.list())));
            return BaseResponse.success(JSON.toJSONString(new MultiResp<>(userBaseService.list())));
        }else if(code==5){/*all2*/
            log.info(JSON.toJSONString(new MultiResp(userBaseService.listMaps())));
            return BaseResponse.success(JSON.toJSONString(new MultiResp(userBaseService.listMaps())));
        }else if(code==6){/*all3*/
            log.info(JSON.toJSONString(new MultiResp(userBaseService.listObjs())));
            return BaseResponse.success(JSON.toJSONString(new MultiResp(userBaseService.listObjs())));
        } else if(code==7){/*分页*/
            Page<UserInfoBase> page =new Page<>(1,2);
            return BaseResponse.success(JSON.toJSONString(userBaseService.page(page).getRecords()));
        }else if(code==8){/*计数*/
            return BaseResponse.success(String.valueOf(userBaseService.count()));
        }
        return null;
    }
}
