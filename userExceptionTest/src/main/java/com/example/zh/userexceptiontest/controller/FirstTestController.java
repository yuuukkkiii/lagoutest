package com.example.zh.userexceptiontest.controller;

import com.example.zh.userexceptiontest.exception.MyException;
import com.example.zh.userexceptiontest.exception.SecondException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhaih
 * @Date: 2022/1/25
 * @Time: 15:48
 * @Description: 首次尝试
 */
@Slf4j
@RestController
@RequestMapping("/daily/test")
public class FirstTestController {
    @GetMapping("/one")
    public String testError1(ModelMap modelMap){
        throw new MyException(511,"系统发生511异常: "+modelMap.get("name")+"   -   "+modelMap.get("id"));
    }

    @GetMapping("/two")
    public String testError2(@ModelAttribute("id")Integer id,
                             @ModelAttribute("name") String name){
        throw new SecondException(512,"系统发生512异常: "+id+"   -   "+name);
    }
}
