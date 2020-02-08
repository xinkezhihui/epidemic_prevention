package com.xinke.epidemic_prevention.controller.formmanager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("form")
public class FormManager {
    @GetMapping("tz1")
    public String tz1(){return "formmanage/form1";}
    @GetMapping("tz2")
    public String tz2(){return "formmanage/form2";}
    @GetMapping("tz3")
    public String tz3(){return "formmanage/form3";}
}
