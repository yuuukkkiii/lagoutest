package com.example.zh.mybatisplustest.base;

import com.example.zh.mybatisplustest.contant.ResponseEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zhaih
 * @Date: 2022/1/25
 * @Time: 15:56
 * @Description:
 */
@Data
public class BaseResponse<T extends Serializable> implements Serializable {

    private int code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public BaseResponse(){

    }
    public BaseResponse(int code, String message){
        this(code, message, null);
    }

    public BaseResponse(int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 默认操作成功
     * @return DataResult
     */
    public static <V extends Serializable> BaseResponse<V> success(){
        return success(ResponseEnum.RESP_0.getMsg(), null);
    }

    /**
     * 操作成功
     * @param message 操作信息
     * @param data 返回数据
     * @return DataResult
     */
    public static <V extends Serializable> BaseResponse<V> success(String message, V data){
        return new BaseResponse<>(ResponseEnum.RESP_0.getCode(), message, data);
    }

    /**
     *操作成功
     * @param data 返回数据
     * @return DataResult
     */
    public static <V extends Serializable> BaseResponse<V> success(V data){
        return success(ResponseEnum.RESP_0.getMsg(), data);
    }

    /**
     * 操作失败
     * @return DataResult
     */
    public static <V extends Serializable> BaseResponse<V> fail(){
        return fail(ResponseEnum.RESP_1.getCode(), ResponseEnum.RESP_1.getMsg());
    }

    /**
     * 操作失败
     * @param status 错误响应码
     * @param message 错误说明
     * @return DataResult
     */
    public static <V extends Serializable> BaseResponse<V> fail(int status, String message){
        return fail(status, message, null);
    }

    /**
     * 操作失败
     * @param status 错误响应码
     * @param message 错误说明
     * @param data 返回数据
     * @return BaseResponse
     */
    public static <V extends Serializable> BaseResponse<V> fail(int status, String message, V data){
        return new BaseResponse<>(status, message, data);
    }
}