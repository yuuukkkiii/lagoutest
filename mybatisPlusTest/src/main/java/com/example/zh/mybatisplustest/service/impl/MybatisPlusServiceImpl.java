package com.example.zh.mybatisplustest.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
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

import java.util.*;

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

    @Override
    public BaseResponse<String> selectChain(UserBaseReq req) {
        Integer code=req.getCode();
        UserInfoBase target=new UserInfoBase();
        BeanUtils.copyProperties(req,target);
        List<UserInfoBase> list=new ArrayList<>();
        JSONArray array =new JSONArray();
        if(code==null){/*失败的情况*/
            return BaseResponse.fail(ResponseEnum.RESP_1.getCode(),ResponseEnum.RESP_1.getMsg());
        }else if(code==0){/*query by ID*/
            list.add(userBaseService.query().eq("id",1).one());
            list.add(userBaseService.lambdaQuery().eq(UserInfoBase::getId,1).one());
            array.addAll(list);
            return BaseResponse.success(array.toJSONString());
        }
        return null;
    }

    @Override
    public BaseResponse<String> selectWrapper(UserBaseReq req) {
        Integer code=req.getCode();
        UserInfoBase target=new UserInfoBase();
        BeanUtils.copyProperties(req,target);
        Map<String,Object> map =new HashMap<>();
        JSONArray array =new JSONArray();
        map.put("user_name","小夫");
        map.put("age",12);
        map.put("pro_id",null);
        QueryWrapper<UserInfoBase> lambda = new QueryWrapper<>();
        LambdaQueryWrapper<UserInfoBase> trueLambda=new LambdaQueryWrapper<>();
        if(code==null){/*失败的情况*/
            return BaseResponse.fail(ResponseEnum.RESP_1.getCode(),ResponseEnum.RESP_1.getMsg());
        }else if(code==0){/*query by ID*/
            lambda.allEq(map);
            array.add(userInfoBaseMapper.selectOne(lambda));
            lambda.clear();
            lambda.allEq(map,false);
            array.add(userInfoBaseMapper.selectOne(lambda));
            lambda.clear();
            lambda.allEq((k,v)-> k.indexOf("a")>=1,map,false);
            array.add(userInfoBaseMapper.selectOne(lambda));
            return BaseResponse.success(array.toJSONString());
        }else if(code==1){/*query by ID*/
            trueLambda.eq(UserInfoBase::getUserName,"小夫").eq(UserInfoBase::getAge,12);
            array.add(userInfoBaseMapper.selectOne(trueLambda));
            trueLambda.clear();
            trueLambda.between(UserInfoBase::getAge,10,13);
            array.add(userInfoBaseMapper.selectList(trueLambda));
            trueLambda.clear();
            trueLambda.likeRight(UserInfoBase::getUserName,"小");
            array.add(userInfoBaseMapper.selectList(trueLambda));
            trueLambda.clear();
            trueLambda.in(UserInfoBase::getAge,Arrays.asList(10,11,12));
            array.add(userInfoBaseMapper.selectList(trueLambda));
            trueLambda.clear();
            trueLambda.in(UserInfoBase::getAge,10,11,12,13);
            array.add(userInfoBaseMapper.selectList(trueLambda));
            return BaseResponse.success(array.toJSONString());
        }else if(code==2){/*inSql函数*/
            trueLambda.inSql(UserInfoBase::getAge,"1,2,3,4,5,12");
            array.add(userInfoBaseMapper.selectOne(trueLambda));
            trueLambda.clear();
            trueLambda.inSql(UserInfoBase::getId,"select id from user_info_base where id>4");
            array.add(userInfoBaseMapper.selectList(trueLambda));
            return BaseResponse.success(array.toJSONString());
        }else if(code==3){/*order by 和 group by*/
            trueLambda.groupBy(UserInfoBase::getAge,UserInfoBase::getUserName).orderBy(true,true,UserInfoBase::getId);
            array.addAll(userInfoBaseMapper.selectList(trueLambda));
            trueLambda.clear();
            return BaseResponse.success(array.toJSONString());
        }else if(code==4){/*func函数*/
            trueLambda.func(i->{if(req.getProId()==null){
                i.eq(UserInfoBase::getId,1);
            }else{
                i.eq(UserInfoBase::getId,2);
            }
            });
            array.addAll(userInfoBaseMapper.selectList(trueLambda));
            trueLambda.clear();
            return BaseResponse.success(array.toJSONString());
        }else if(code==5){/*select（）函数*/
            trueLambda.select(UserInfoBase::getId,UserInfoBase::getAge,UserInfoBase::getUserName);
            array.addAll(userInfoBaseMapper.selectList(trueLambda));
            trueLambda.clear();
            return BaseResponse.success(array.toJSONString());
        }
        return null;
    }
}
