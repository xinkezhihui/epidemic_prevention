package com.xinke.epidemic_prevention.controller.hospital;

import com.google.gson.Gson;
import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.service.hospital.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:jlz
 * @Date: 2020/2/7
 * 路径： com.xinke.epidemic_prevention.controller.hospital
 * 功能描述：医院部分的Controller
 */
@Controller
@RequestMapping("hospital")
public class HospitalController {
    @Autowired
    HospitalService hospitalService;
    /**
     * @author: WRR
     * 功能描述：疑似已排除人员信息
     */
    @GetMapping("ysYPC")
    public String ysYPC(){
        return "hospital/ysYPC";
    }
    @ResponseBody
    @RequestMapping("ysYPCInfo")
    public String ysYPCInfo(){
        List<Person> persons = hospitalService.ysYPCAllInfo();
        Gson gson = new Gson();
        String result = "";
        if (persons!=null&&persons.size()!=0){
            result = gson.toJson(persons);
        }
        return result;
    }
    /**
     * @author: WRR
     * 功能描述：疑似已排除查询
     */
    @ResponseBody
    @RequestMapping("selectYsYPC")
    public String selectYsYPC(String sfzmhm,String xingming,String yq_yszdrq){
        List<Person> persons = hospitalService.selectYsYPC(sfzmhm, xingming, yq_yszdrq);
        Gson gson = new Gson();
        String result = "";
        if (persons!=null&&persons.size()!=0){
            result = gson.toJson(persons);
        }
        return result;
    }
    /**
     * @author: WRR
     * 功能描述：疑似未提交查询
     */
    @ResponseBody
    @RequestMapping("selectYsWtj")
    public String selectYsWtj(String sfzmhm,String xingming,String yq_yszdrq){
        List<Person> persons = hospitalService.selectYsWtj(sfzmhm, xingming, yq_yszdrq);
        Gson gson = new Gson();
        String result = "";
        if (persons!=null&&persons.size()!=0){
            result = gson.toJson(persons);
        }
        return result;
    }
    /**
     * @author: WRR
     * 功能描述：疑似已提交查询
     */
    @ResponseBody
    @RequestMapping("selectYsYtj")
    public String selectYsYtj(String sfzmhm,String xingming,String yq_yszdrq){
        List<Person> persons = hospitalService.selectYsYtj(sfzmhm, xingming, yq_yszdrq);
        Gson gson = new Gson();
        String result = "";
        if (persons!=null&&persons.size()!=0){
            result = gson.toJson(persons);
        }
        return result;
    }
    /**
     * @author: WRR
     * 功能描述：修改疑似案例信息
     */
    @GetMapping("update")
    public String update(String sfzmhm, Model model) {
        Person person = hospitalService.personInfo(sfzmhm);
        model.addAttribute("person", person);
        return "hospital/yisiUpdate";
    }
    @ResponseBody
    @PostMapping("updateYs")
    public String updateMj(String sfzmhm, String xzsf, String xzdjs, String xzxq, String ssbsc, String rqfl, String xingming, String lxdh, String xxdz, Integer yq_sfcwwh, Integer yq_sfczqtsf, String yq_zhumingsf,String binganhao, Integer yq_sfmjfb, String mjren, Integer yq_sfzz,Integer yq_sfwzz,String jiguansf, String jiguandjs, String jiguanxq){
        boolean bl =  hospitalService.updateYs(sfzmhm, xzsf, xzdjs, xzxq, ssbsc, rqfl, xingming, lxdh, xxdz, yq_sfcwwh, yq_sfczqtsf, yq_zhumingsf, binganhao, yq_sfmjfb, mjren, yq_sfzz, yq_sfwzz,jiguansf,jiguandjs,jiguanxq);
        if (bl) {
            return "200";
        }else {
            return "400";
        }
    }
    /**
     * @author: jlz
     * 功能描述：查看所有疑似案例的信息
     */
    @GetMapping("toAddYiSiInfo")
    public String toAddYiSiInfo(){
        return "hospital/yisiAdd";
    }

    @PostMapping("savePerson")
    public String savePerson(Person person, Model model){
        boolean b = hospitalService.numberExist(person.getSfzmhm());
        if (b){
            hospitalService.addPerson(person);
            model.addAttribute("msg","添加成功");
        }else {
            model.addAttribute("msg","该取水用户已存在");
        }
        return "hospital/yisiList";
    }
    /**
     * @author: WRR
     * 功能描述: 疑似病例确诊
     */
    @ResponseBody
    @GetMapping("ysQueZhen")
    public  String ysQueZhen(String sfzmhm){
        System.out.println(sfzmhm);
        boolean bl = hospitalService.ysQueZhen(sfzmhm);
        if(bl){
            return "200";
        }
        return "400";
    }
    /**
     * @author: WRR
     * 功能描述:疑似病例排除
     */
    @ResponseBody
    @GetMapping("ysPaiChu")
    public  String ysPaiChu(String sfzmhm){
        System.out.println(sfzmhm);
        boolean bl = hospitalService.ysPaiChu(sfzmhm);
        if(bl){
            return "200";
        }
        return "400";
    }
    /**
     * @author: WRR
     * 功能描述:查看所有已提交疑似病例
     */
    @GetMapping("ytjYiSiInfo")
    public String ysInfo(){ return  "hospital/yisiShow";}
    @ResponseBody
    @GetMapping("ytjYsInfo")
    public  String ytjYSInfo(){
        List<Person> ysPersons = hospitalService.findAllSubmitYsInfoByYstj();
        Gson gson = new Gson();
        String result = "";
        if (ysPersons!=null&&ysPersons.size()!=0){
            result = gson.toJson(ysPersons);
        }
        return result;
    }
    /**
     * @author: WRR
     * 功能描述:提交疑似病例
     */
    @ResponseBody
    @GetMapping("ysSubmit")
    public  String miJieSubmit(String sfzmhm){
        boolean bl = hospitalService.ysSubmit(sfzmhm);
        if(bl){
            return "200";
        }
        return "400";
    }
    /**
     * @author: WRR
     * 功能描述:查看所有未提交疑似病例
     */
    @GetMapping("showYiSiList")
    public String mijieList(){ return  "hospital/yisiList";}
    @ResponseBody
    @GetMapping("ysInfoList")
    public  String mjryInfoList(){
        List<Person> ysPersons = hospitalService.findAllYsInfoByYstj();
        Gson gson = new Gson();
        String result = "";
        if (ysPersons!=null&&ysPersons.size()!=0){
            result = gson.toJson(ysPersons);
        }
        return result;
    }
    /**
     * @author: WRR
     * 功能描述：添加疑似病例时进行验证
     */
    @ResponseBody
    @PostMapping("checke")
    public String checke(String sfzmhm){
        boolean bl = hospitalService.infoIsExists(sfzmhm);
        if (bl) {
            return "该条数据已存在";
        }
        return "ok!";
    }
    /**
     * @author: WRR
     * 功能描述：添加疑似案例只改变ystj、yq_sfys
     */
    @ResponseBody
    @PostMapping("changeYs")
    public Map<String,Integer> changeYs(String sfzmhm){
        boolean bl = hospitalService.changeYs(sfzmhm);
        Map<String,Integer> map = new HashMap<String, Integer>();
        if (bl) {
            map.put("result",1);
        }else {
            map.put("result", 0);
        }
        return map;
    }
    /**
     * @author: WRR
     * 功能描述：添加疑似案例
     */
    @ResponseBody
    @PostMapping("addYs")
    public String addYs(String sfzmhm, String xzsf, String xzdjs, String xzxq, String ssbsc, String rqfl, String xingming, String lxdh, String xxdz, Integer yq_sfcwwh, Integer yq_sfczqtsf, String yq_zhumingsf,String binganhao, Integer yq_sfmjfb, String mjren, Integer yq_sfzz,Integer yq_sfwzz){
        boolean bl = hospitalService.infoIsExists(sfzmhm);
        if(bl){
            boolean b = hospitalService.addChangeYiSi(sfzmhm, xzsf, xzdjs, xzxq, ssbsc, rqfl, xingming, lxdh, xxdz, yq_sfcwwh, yq_sfczqtsf, yq_zhumingsf, binganhao, yq_sfmjfb, mjren, yq_sfzz, yq_sfwzz);
            if (b) {
                return "200";
            }else {
                return "400";
            }
        }else {
            boolean b = hospitalService.addYiSi(sfzmhm, xzsf, xzdjs, xzxq, ssbsc, rqfl, xingming, lxdh, xxdz, yq_sfcwwh, yq_sfczqtsf, yq_zhumingsf, binganhao, yq_sfmjfb, mjren, yq_sfzz, yq_sfwzz);
            if (b) {
                return "200";
            }else {
                return "400";
            }
        }
    }
}
