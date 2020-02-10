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

//    /**
//     * @author: jlz
//     * 功能描述：查看所有疑似案例的信息
//     */
//    @GetMapping("showYiSiList")
//    public String showYiSiList() {
//        return "hospital/yisiList";
//    }
//
//    @ResponseBody
//    @GetMapping("showAgricultureInfo")
//    public String showAgricultureInfo(){
//        List<Person> allAgrInfo = hospitalService.findAllHospInfo();
//        Gson gson = new Gson();
//        String result = "";
//        if (allAgrInfo!=null && allAgrInfo.size()!=0){
//            result = gson.toJson(allAgrInfo);
//        }
//        return result;
//    }

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
