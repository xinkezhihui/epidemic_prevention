package com.xinke.epidemic_prevention.controller.hospital;

import com.google.gson.Gson;
import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.service.hospital.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
     * @author: jlz
     * 功能描述：查看所有疑似案例的信息
     */
    @GetMapping("showYiSiList")
    public String showYiSiList() {
        return "hospital/yisiList";
    }

    @ResponseBody
    @GetMapping("showAgricultureInfo")
    public String showAgricultureInfo(){
        List<Person> allAgrInfo = hospitalService.findAllHospInfo();
        Gson gson = new Gson();
        String result = "";
        if (allAgrInfo!=null && allAgrInfo.size()!=0){
            result = gson.toJson(allAgrInfo);
        }
        return result;
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
}
