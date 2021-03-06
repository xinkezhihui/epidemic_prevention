package com.xinke.epidemic_prevention.controller.community;

import com.google.gson.Gson;
import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.bean.community.Rqfl;
import com.xinke.epidemic_prevention.bean.community.Ssbsc;
import com.xinke.epidemic_prevention.service.community.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    //已有确诊人员添加密接
    @GetMapping("qzAddMj")
    public String qzAddMj(String sfzmhm, Model model) {
        model.addAttribute("mjren",sfzmhm);
        return "community/mijieAdd";
    }
    //修改密接人员信息
    @GetMapping("update")
    public String update(String sfzmhm, Model model) {
        Person person = communityService.findOneMiJieInfo(sfzmhm);
        model.addAttribute("person", person);
        return "community/mijieUpdate";
    }
    @ResponseBody
    @PostMapping("updateMj")
    public String updateMj(String sfzmhm, String xzsf, String xzdjs, String xzxq, String ssbsc, String rqfl, String xingming, String lxdh, String xxdz, Integer yq_sfcwwh, Integer yq_sfczqtsf, String yq_zhumingsf, String mjren, Integer yq_sfmjfb){
        boolean bl =  communityService.updateMj(sfzmhm,xzsf,xzdjs,xzxq,ssbsc,rqfl,xingming,lxdh,xxdz,yq_sfcwwh,yq_sfczqtsf,yq_zhumingsf, mjren,yq_sfmjfb);
        if (bl) {
            return "200";
        }else {
            return "400";
        }
    }
    //删除密接未提交人员
    @ResponseBody
    @GetMapping("deleteMj")
    public Map<String,String> deleteMj(String sfzmhm){
        //map集合用来存放返回值
        Map<String,String> map = new HashMap<String, String>();
        int i = communityService.deleteMijieInfo(sfzmhm);
        if (i == 1) {
            map.put("result","删除成功！");
        } else if (i == 2) {
            map.put("result", "该人员已被删除");
        } else {
            map.put("result", "服务器正忙，请稍后重试！");
        }
        return map;
    }
    //密接管理界面组合查询
    @ResponseBody
    @GetMapping("check")
    public String mjCheck(String sfzmhm,String xingming,String qrmjsj){
        List<Person> mjPersons = communityService.selectCheck(sfzmhm,xingming,qrmjsj);
        Gson gson = new Gson();
        String result = "";
        if (mjPersons!=null&&mjPersons.size()!=0){
            result = gson.toJson(mjPersons);
        }
        return result;
    }
    //密接查看界面组合查询
    @ResponseBody
    @GetMapping("checkShow")
    public String mjCheckShow(String sfzmhm,String xingming,String qrmjsj){
        List<Person> mjPersons = communityService.selectCheckShow(sfzmhm,xingming,qrmjsj);
        Gson gson = new Gson();
        String result = "";
        if (mjPersons!=null&&mjPersons.size()!=0){
            result = gson.toJson(mjPersons);
        }
        return result;
    }
    //跳转至查看密接人员界面
    @GetMapping("mijieShow")
    public  String mijieShow(){ return "community/mijieShow"; }
    //查看密接人员数据接口
    @ResponseBody
    @GetMapping("mjInfoShow")
    public String mjInfo(){
        List<Person> mjPersons = communityService.findAllMjtjSubmitInfo();
        Gson gson = new Gson();
        String result = "";
        if (mjPersons!=null&&mjPersons.size()!=0){
            result = gson.toJson(mjPersons);
        }
        return result;
    }
    //跳转至密接人员管理界面
    @GetMapping("mijieList")
    public String mijieList(){ return  "community/mijieList";}
    //管理密接人员数据接口
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
    //提交密接人员提交状态
    @ResponseBody
    @GetMapping("mijieSubmit")
    public  String miJieSubmit(String sfzmhm){
        boolean bl = communityService.miJieSubmit(sfzmhm);
        if(bl){
            return "200";
        }
        return "400";
    }
    //跳转至添加密接人员界面
    @GetMapping("addmijie")
    public String showAddMiJie(){ return  "community/mijieAdd";}
    //添加密接人员信息
    @ResponseBody
    @PostMapping("add")
    public String addMijie(String sfzmhm, String xzsf, String xzdjs, String xzxq, String ssbsc, String rqfl, String xingming, String lxdh, String xxdz, Integer yq_sfcwwh, Integer yq_sfczqtsf, String yq_zhumingsf, String mjren, Integer yq_sfmjfb){
        boolean bl =  communityService.addMijie(sfzmhm,xzsf,xzdjs,xzxq,ssbsc,rqfl,xingming,lxdh,xxdz,yq_sfcwwh,yq_sfczqtsf,yq_zhumingsf, mjren,yq_sfmjfb);
        if (bl) {
            return "200";
        }else {
            //返回失败信息
            return "400";
        }
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
