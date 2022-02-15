package com.example.zh.userexceptiontest.base;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zhaih
 * @Date: 2021/12/16
 * @Time: 15:00
 * @Description:
 */
@Data
public class MultiResp<T extends Serializable> implements Serializable {
    /**
     * 返回对象属性
     */
    private List<T> items;

    /**
     * 默认构造方法
     */
    public MultiResp(){}

    public MultiResp(List<T> items){
        this.items = items;
    }
}
