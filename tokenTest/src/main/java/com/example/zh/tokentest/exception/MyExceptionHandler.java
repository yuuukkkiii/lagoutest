package com.example.zh.tokentest.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhaih
 * @Date: 2022/2/15
 * @Time: 11:32
 * @Description: 错误处理类
 */
@RestControllerAdvice
public class MyExceptionHandler {
    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder binder
     */
    @InitBinder
    public void initWebBinder(WebDataBinder binder){

    }

    @ModelAttribute
    public void addAttribute(Model model){
        model.addAttribute("id",111);
        model.addAttribute("name","大雄");
    }

    @ExceptionHandler({TokenTimeException.class})
    public Map<String,Object> myException(TokenTimeException e){
        Map<String,Object> map =new HashMap<>();
        map.put("code", e.getCode());
        map.put("msg",e.getMsg());
        map.put("exception",e.getClass());
        return map;
    }

    @ExceptionHandler({TokenException.class})
    public Map<String,Object> secondException(TokenException e){
        Map<String,Object> map =new HashMap<>();
        map.put("code", e.getCode());
        map.put("msg",e.getMsg());
        map.put("exception",e.getClass());
        return map;
    }
}
