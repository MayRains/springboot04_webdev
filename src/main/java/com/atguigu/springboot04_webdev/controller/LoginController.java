package com.atguigu.springboot04_webdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    //    @RequestMapping(value = "/user/login",method = RequestMethod.POST
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("LoginUser", username);
            // 防止表单重复提交
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名密码错误");
// 不重定向的话就会路由重复404 http://localhost:8080/user/user/login || 重定向会使 map 的值丢失？ 怎么办 ？
            return "login";
        }
    }

}
