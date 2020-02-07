package com.xinke.epidemic_prevention.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:jlz
 * @Date: 2020/2/6
 * 路径： com.xinke.epidemic_prevention.controller.user
 * 功能描述：
 */
@Controller

public class UserController{
    @RequestMapping("tz")
    public String tz(){return "index";}
}
