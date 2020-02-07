package com.xinke.epidemic_prevention.controller.user;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:jlz
 * @Date: 2020/2/6
 * 路径： com.xinke.epidemic_prevention.controller.user
 * 功能描述：
 */
@Controller
@RequestMapping("user")
public class UserController{
    @GetMapping("tz")
    public String tz(){return "login";}

    @PostMapping("login")
    public String Login( String number,String password, Model model){
        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject

        Subject subject = SecurityUtils.getSubject();


        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(number,password);

       /* *//*获取全部未读消息*//*System.out.println(number);
        if(number!=""&&userService.findByNumber(number)!=null){
            IfRead ifRead = ifReadService.queryById(number);
            model.addAttribute("count1",ifReadService.getCount(ifRead,1));
            model.addAttribute("count2",ifReadService.getCount(ifRead,2));
            model.addAttribute("count3",ifReadService.getCount(ifRead,3));
            model.addAttribute("allCount",ifReadService.getAllCount(ifRead));
        }
*/
        //3.执行登录方法
        try {
            subject.login(token);

            //登录成功
            //跳转到index.html
            return "index";
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败:用户名不存在
            model.addAttribute("msg", "用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e) {
            //e.printStackTrace();
            //登录失败:密码错误
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }

}
