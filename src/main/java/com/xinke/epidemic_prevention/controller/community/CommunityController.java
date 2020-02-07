package com.xinke.epidemic_prevention.controller.community;

import com.google.gson.Gson;
import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.bean.community.Rqfl;
import com.xinke.epidemic_prevention.bean.community.Ssbsc;
import com.xinke.epidemic_prevention.service.community.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 王冉冉
 * @Date: 2020/2/6
 * 功能描述：社区部分controller
 * 路径：com.xinke.epidemic_prevention.controller.community
 */
@Controller
@RequestMapping("community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @GetMapping("show")
    public String showIndex(){
        return "community/index2";
    }

    //跳转至密接人员管理界面
    @GetMapping("mijieList")
    public String showMiJie(){ return  "community/mijieList";}
    //密接人员数据接口
    @ResponseBody
    @GetMapping("mjryInfoList")
    public  String mjryInfoList(){
        List<Person> mjPersons = communityService.findAllMjtjPersonInfo();
        Gson gson = new Gson();
        String result = "";
        if (mjPersons!=null&&mjPersons.size()!=0){
            result = gson.toJson(mjPersons);
        }
        return result;
    }

    //跳转至添加密接人员界面
    @GetMapping("addmijie")
    public String showAddMiJie(){ return  "community/mijieAdd";}
    //添加密接人员信息
    @ResponseBody
    @PostMapping("add")
    public String addMijie(String sfzmhm,String xzsf,String xzdjs,String xzxq,String ssbsc,String rqfl,String xingming,String lxdh,String xxdz,Integer yq_sfcwwh,Integer yq_sfczqtsf,Integer yq_zhumingsf, String mjren, Integer yq_sfmjfb){
        System.out.println("===========");
        boolean bl =  communityService.addMijie(sfzmhm,xzsf,xzdjs,xzxq,ssbsc,rqfl,xingming,lxdh,xxdz,yq_sfcwwh,yq_sfczqtsf,yq_zhumingsf, mjren,yq_sfmjfb);
        if (bl) {
            return "200";
        }else {
            //返回失败信息
            return "400";
        }
    }
    //测试
    @ResponseBody
    @GetMapping("ceshi")
    public String add(String rqfl){
        System.out.println("===========");
        System.out.println(rqfl);
            return "200";

    }
    //查询人群分类
    @ResponseBody
    @GetMapping("selectRqfl")
    public  String SelectRqfl(){
        List<Rqfl> rqfls = communityService.findAllRqflInfo();
        Gson gson = new Gson();
        String result = "";
        if (rqfls!=null&&rqfls.size()!=0){
            result = gson.toJson(rqfls);
        }
        return result;
    }
    //查询所属办事处
    @ResponseBody
    @GetMapping("selectSsbsc")
    public  String SelectSsbsc(){
        List<Ssbsc> ssbscs = communityService.findAllSsbscInfo();
        Gson gson = new Gson();
        String result = "";
        if (ssbscs!=null&&ssbscs.size()!=0){
            result = gson.toJson(ssbscs);
        }
        return result;
    }
}
