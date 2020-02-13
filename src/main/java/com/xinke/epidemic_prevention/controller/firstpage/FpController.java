package com.xinke.epidemic_prevention.controller.firstpage;

import com.google.gson.Gson;
import com.xinke.epidemic_prevention.bean.community.QzNum;
import com.xinke.epidemic_prevention.dao.common.QzNumRepository;
import com.xinke.epidemic_prevention.dao.firstpage.FpRepository;
import com.xinke.epidemic_prevention.service.common.QzService;
import com.xinke.epidemic_prevention.service.util.DateUtil;
import org.apache.commons.math3.optim.linear.SolutionCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("fp")
public class FpController {
    @Autowired
    FpRepository fpRepository;
    @Autowired
    private QzService qzService;
    @Autowired
    private QzNumRepository qzNumRepository;
    @GetMapping("tz")
    public String tz(){return "Main_sj";}

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
        //累计治愈
        int ljzyNum = qzNumRepository.zhiYuNum();

        model.addAttribute("ysxzNum",ysxzNum);
        model.addAttribute("qzxzNum",qzxzNum);
        model.addAttribute("mjxzNum",mjxzNum);
        model.addAttribute("ljysNum",ljysNum);
        model.addAttribute("ljqzNum",ljqzNum);
        model.addAttribute("ljmjNum",ljmjNum);
        model.addAttribute("ljzyNum",ljzyNum);

        //近七日确诊数量
        List<QzNum> qzNums = qzNumRepository.findAllQzNum();
        List<String> qzsj = new ArrayList<String>();
        List<Integer> qzNum = new ArrayList<Integer>();
        for (int i =0 ; i <= 6; i++) {
            String rq = getPastDate(i);
            qzsj.add(rq);
        }
        int j = 0;//确定某天是否有数据
        for (String rq:qzsj) {
            for (QzNum qzNum1:qzNums) {
                if (qzNum1.getQzrq().equals(rq)) {
                    qzNum.add(qzNum1.getQtNum());
                    j = 1;
                }
            }
            if (j == 0) {
                qzNum.add(0);
            }else j = 0;
        }
        model.addAttribute("qzsj",qzsj);
        model.addAttribute("qzNum",qzNum);
        return "Main_sj";
    }
    @GetMapping("echar")
    @ResponseBody
    public List<Integer> re(){
        List<Integer> list = fpRepository.Weekqz();

        return list;
    }
    /**
     * 获取过去第几天的日期
     * @Author Wrr
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String result = format.format(today);
        return result;
    }
}
