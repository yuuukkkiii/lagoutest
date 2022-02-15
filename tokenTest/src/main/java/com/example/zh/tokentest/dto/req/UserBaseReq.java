package com.example.zh.tokentest.dto.req;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zhaih
 * @Date: 2022/1/25
 * @Time: 16:09
 * @Description:
 */
@Data
public class UserBaseReq implements Serializable {
    private Integer code;
    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 籍贯省份
     */
    private String proId;

    /**
     * 籍贯城市
     */
    private String cityId;

    /**
     * 手机号
     */
    private String phoneNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
