package com.xinke.epidemic_prevention.controller.firstpage;

import com.xinke.epidemic_prevention.dao.firstpage.FpRepository;
import com.xinke.epidemic_prevention.service.util.DateUtil;
import org.apache.commons.math3.optim.linear.SolutionCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fp")
public class FpController {
    @Autowired
    FpRepository fpRepository;

    @GetMapping("tofp")
    public String tofp(Model model){
        DateUtil dateUtil = new DateUtil();
        String date = dateUtil.getDate();
        //疑似新增
        int ysxzNum = fpRepository.ysxz(date);
        //确诊新增
        int qzxzNum = fpRepository.qzxz(date);
        //密接新增
        int mjxzNum = fpRepository.xzmj(date);
        //累计疑似
        int ljysNum = fpRepository.ljys();
        //累计确诊
        int ljqzNum = fpRepository.ljqz();
        //累计密接
        int ljmjNum = fpRepository.ljmj();

        model.addAttribute("ysxzNum",ysxzNum);
        model.addAttribute("qzxzNum",qzxzNum);
        model.addAttribute("mjxzNum",mjxzNum);
        model.addAttribute("ljysNum",ljysNum);
        model.addAttribute("ljqzNum",ljqzNum);
        model.addAttribute("ljmjNum",ljmjNum);

        return "Main_sj";
    }
}
