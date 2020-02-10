package com.xinke.epidemic_prevention.controller.common;

import com.google.gson.Gson;
import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.service.common.QzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: WRR
 * @Date: 2020/2/10
 * 功能描述：
 * 路径：com.xinke.epidemic_prevention.controller.common
 */
@Controller
@RequestMapping("quezhen")
public class QzController {
    @Autowired
    private QzService  qzService;
    //跳转至社区确诊人员查看界面
    @RequestMapping("sqQzShow")
    public String sqQzShow(){ return "community/quezhenShow"; }
    //跳转至医院未提交确诊人员查看界面
    @RequestMapping("wtjQzShow")
    public String wtjQzShow(){ return "hospital/wtjQzShow"; }
    //跳转至医院已提交确诊人员查看界面
    @RequestMapping("ytjQzShow")
    public String ytjQzShow(){ return "hospital/ytjQzShow"; }
    //已提交确诊人员数据
    @ResponseBody
    @RequestMapping("qzYtjInfo")
    public String qzYtjInfo(){
        List<Person> persons = qzService.findAllYtjQueZhen();
        Gson gson = new Gson();
        String result = "";
        if (persons!=null&&persons.size()!=0){
            result = gson.toJson(persons);
        }
        return result;
    }
    //未提交确诊人员数据
    @ResponseBody
    @RequestMapping("qzWtjInfo")
    public String qzWtjInfo(){
        List<Person> persons = qzService.findAllWtjQueZhen();
        Gson gson = new Gson();
        String result = "";
        if (persons!=null&&persons.size()!=0){
            result = gson.toJson(persons);
        }
        return result;
    }
}
