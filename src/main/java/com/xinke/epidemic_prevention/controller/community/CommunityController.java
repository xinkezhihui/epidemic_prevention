package com.xinke.epidemic_prevention.controller.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 王冉冉
 * @Date: 2020/2/6
 * 功能描述：社区部分controller
 * 路径：com.xinke.epidemic_prevention.controller.community
 */
@Controller
@RequestMapping("community")
public class CommunityController {
    @GetMapping("show")
    public String showIndex(){
        return "community/index2";
    }
    //跳转至添加密接人员界面
    @GetMapping("addmijie")
    public String showAddMiJie(){ return  "community/mijieAdd";}
    //跳转至添加密接人员界面
    @GetMapping("mijieShow")
    public String showMiJie(){ return  "community/mijieShow";}

}
