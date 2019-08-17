package com.atguigu.springboot04_webdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
public class FuncController {
//    如果要查询一些数据
    @RequestMapping("/roundDance")
    public String testThymeleaf(Map<String,Object> map){
        map.put("hello","<h1>game of throne</h1>");
        map.put("list", Arrays.asList("aks","question","conclusion"));
        return "roundDance";
    }
}
