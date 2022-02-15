package com.example.zh.aoplogparamtest.contant;

/**
 * 返回编码枚举
 * @author SiminLi on 2020/11/9 11:00
 */
public enum ResponseEnum {

    /**
     * 操作成功
     */
    RESP_0(0, "操作成功！"),

    /**
     * 操作失败
     */
    RESP_1(1, "操作失败！");
    /**
     * 错误代码
     */
    private int code;
    /**
     * 错误信息
     *
     */
    private String msg;

    ResponseEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){
        return this.code;
    }


    public String getMsg(){
        return this.msg;
    }

}
