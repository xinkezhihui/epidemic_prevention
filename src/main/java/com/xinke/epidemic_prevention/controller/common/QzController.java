package com.xinke.epidemic_prevention.controller.common;

import com.google.gson.Gson;
import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.service.common.QzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: WRR
 * @Date: 2020/2/10
 * 功能描述：确诊功能Controller
 * 路径：com.xinke.epidemic_prevention.controller.common
 */
@Controller
@RequestMapping("quezhen")
public class QzController {
    @Autowired
    private QzService  qzService;
    //确诊病例出院
    @ResponseBody
    @GetMapping("qzChuYuan")
    public  String qzChuYuan(String sfzmhm){
        boolean bl = qzService.qzChuYuan(sfzmhm);
        if(bl){
            return "200";
        }
        return "400";
    }
    //确诊病例死亡
    @ResponseBody
    @GetMapping("qzDeath")
    public  String qzDeath(String sfzmhm){
        boolean bl = qzService.qzDeath(sfzmhm);
        if(bl){
            return "200";
        }
        return "400";
    }
    //提交确诊病例
    @ResponseBody
    @GetMapping("qzSubmit")
    public  String qzSubmit(String sfzmhm){
        boolean bl = qzService.qzSubmit(sfzmhm);
        if(bl){
            return "200";
        }
        return "400";
    }
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
    //组合查询已提交确诊人员
    @ResponseBody
    @RequestMapping("selectQzYtj")
    public String selectQzYtj(String sfzmhm,String xingming,String yq_qzsj){
        List<Person> persons = qzService.selectYtj(sfzmhm,xingming,yq_qzsj);
        Gson gson = new Gson();
        String result = "";
        if (persons!=null&&persons.size()!=0){
            result = gson.toJson(persons);
        }
        return result;
    }
    //组合查询未提交确诊人员
    @ResponseBody
    @RequestMapping("selectQzWtj")
    public String selectQzWtj(String sfzmhm,String xingming,String yq_qzsj){
        List<Person> persons = qzService.selectWtj(sfzmhm,xingming,yq_qzsj);
        Gson gson = new Gson();
        String result = "";
        if (persons!=null&&persons.size()!=0){
            result = gson.toJson(persons);
        }
        return result;
    }
}
