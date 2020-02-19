package com.xinke.epidemic_prevention.controller.formmanager;

import com.google.gson.Gson;
import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.bean.form.FormOne;
import com.xinke.epidemic_prevention.bean.form.FormTwo;
import com.xinke.epidemic_prevention.bean.user.User;
import com.xinke.epidemic_prevention.dao.common.QzNumRepository;
import com.xinke.epidemic_prevention.dao.common.QzRepository;
import com.xinke.epidemic_prevention.dao.formmanage.Form1Repository;
import com.xinke.epidemic_prevention.dao.formmanage.Form2Repository;
import com.xinke.epidemic_prevention.dao.formmanage.Form3Reposity;
import com.xinke.epidemic_prevention.service.form.ZhcxService;
import com.xinke.epidemic_prevention.service.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("form")
public class FormManager {
    @Autowired
    Form1Repository form1Repository;
    @Autowired
    Form2Repository form2Repository;
    @Autowired
    Form3Reposity form3Reposity;
    @Autowired
    QzRepository qzRepository;

    @GetMapping("tz1")
    public String tz1(){return "formmanage/form1";}
    @GetMapping("tz2")
    public String tz2(){return "formmanage/form2";}
    @GetMapping("tz3")
    public String tz3(){return "formmanage/form3";}
    @GetMapping("tz4")
    public String tz4(){return "formmanage/zhcx";}

    @GetMapping("form1")
    @ResponseBody
    public String form1(){
        DateUtil dateUtil = new DateUtil();
        String date = dateUtil.getDate();
       // String date1 = String.valueOf(Integer.valueOf(date)-1);
        //新增疑似
        int ysxz = form1Repository.ysxz(date);
        //疑似现有
        int ljys = form1Repository.ljys();
        //前日累计确诊
        int qrqz = form1Repository.qrqz(date);
        //当日新增确诊
        int qzxz = form1Repository.qzxz(date);


        //确诊累计
        int ljqz = form1Repository.ljqz();
        //确诊在院治疗总数
        int zyzlzs = form1Repository.zyzlzs();
        //确诊在院治疗重症
        int zz = form1Repository.zz();
        //确诊在院治疗危重
        int wz = form1Repository.wz();
        //确诊-出院病例-前日累计
        int cyqrlj = form1Repository.cyqrlj(date);
        //确诊-出院病例-当日新增
        int cydrxz = form1Repository.cydrxz(date);
        //确诊-出院病例-累计
        int cylj = form1Repository.cylj();
        //确诊-死亡-前日累计
        int swqrlj = form1Repository.swqrlj(date);
        //确诊-死亡-当日新增
        int swdrlj = form1Repository.swdrlj(date);
        //确诊-死亡-累计
        int swlj = form1Repository.swlj();
        //密接-尚在医学观察-医务人员
        int mjyw = form1Repository.mjyw();
        //密接-尚在医学观察-非医务人员
        int mjfyw = form1Repository.mjfyw();
        //密接-当日解除
        int drjc = form1Repository.drjc(date);
        //密接-当日诊断为疑似或确诊
        int zdysqz = form1Repository.zdysqz(date);
        //密接-累计
        int mjlj = form1Repository.mjlj();
        //密接-前日累计解除
        int qrljjc = form1Repository.qrljjc(date);

        String nowdate = dateUtil.getDatehms();

        //存入数据库
        FormOne formOne = new FormOne("泰安市","泰山区",ysxz,ljys,qrqz,qzxz,ljqz,zyzlzs,zz,wz,cyqrlj,
                cydrxz,cylj,swqrlj,swdrlj,swlj,mjyw,mjfyw,drjc,zdysqz,mjlj,qrljjc,nowdate);


        if (formOne!=null){
            form1Repository.save(formOne);
        }
        List<FormOne> formOneList = form1Repository.findAll();

        Gson gson = new Gson();
        String result = "";
        if (formOneList!=null&&formOneList.size()!=0){
            result = gson.toJson(formOneList);
        }
        return result;
    }
    @GetMapping("form2")
    @ResponseBody
    public String form2(){
        DateUtil dateUtil = new DateUtil();
        String date = dateUtil.getDate();
        // String date1 = String.valueOf(Integer.valueOf(date)-1);
        //新增疑似
        int ysxz = form1Repository.ysxz(date);
        //疑似现有
        int ljys = form1Repository.ljys();
        //前日累计确诊
        int qrqz = form1Repository.qrqz(date);
        //当日新增确诊
        int qzxz = form1Repository.qzxz(date);


        //确诊累计
        int ljqz = form1Repository.ljqz();
        //确诊在院治疗总数
        int zyzlzs = form1Repository.zyzlzs();
        //确诊在院治疗重症
        int zz = form1Repository.zz();
        //确诊在院治疗危重
        int wz = form1Repository.wz();
        //确诊-出院病例-前日累计
        int cyqrlj = form1Repository.cyqrlj(date);
        //确诊-出院病例-当日新增
        int cydrxz = form1Repository.cydrxz(date);
        //确诊-出院病例-累计
        int cylj = form1Repository.cylj();
        //确诊-死亡-前日累计
        int swqrlj = form1Repository.swqrlj(date);
        //确诊-死亡-当日新增
        int swdrlj = form1Repository.swdrlj(date);
        //确诊-死亡-累计
        int swlj = form1Repository.swlj();
        //密接-尚在医学观察-医务人员
        int mjyw = form1Repository.mjyw();
        //密接-尚在医学观察-非医务人员
        int mjfyw = form1Repository.mjfyw();
        //密接-当日解除
        int drjc = form1Repository.drjc(date);
        //密接-当日诊断为疑似或确诊
        int zdysqz = form1Repository.zdysqz(date);
        //密接-累计
        int mjlj = form1Repository.mjlj();
        //密接-前日累计解除
        int qrljjc = form1Repository.qrljjc(date);

        String nowdate = dateUtil.getDatehms();

        //存入数据库
        FormTwo formTwo = new FormTwo("泰安市","泰山区",ysxz,ljys,qrqz,qzxz,ljqz,zyzlzs,zz,wz,cyqrlj,
                cydrxz,cylj,swqrlj,swdrlj,swlj,mjyw,mjfyw,drjc,zdysqz,mjlj,qrljjc,nowdate);


        if (formTwo!=null){
            form2Repository.save(formTwo);
        }
        List<FormTwo> formTwoList = form2Repository.findAll();

        Gson gson = new Gson();
        String result = "";
        if (formTwoList!=null&&formTwoList.size()!=0){
            result = gson.toJson(formTwoList);
        }
        return result;
    }
    @GetMapping("form3")
    @ResponseBody
    public String form3(){
        DateUtil dateUtil = new DateUtil();
        String date = dateUtil.getDate();
        List<Person> personList = form3Reposity.qzxz(date);
        Gson gson = new Gson();
        String result = "";
        if (personList!=null&&personList.size()!=0){
            result = gson.toJson(personList);
        }
        return result;
    }
    @Autowired
    private ZhcxService zhcxService;

    //组合查询
    @GetMapping("/check")
    @ResponseBody
    public String check(String xingming,String sfzmhm,String yq_sfqz,String ksqz,String jsqz,String szqy,String sfqwhb,String sfcy,String sfsw,String sfmj){

        List<Person>  personList = zhcxService.selectCheck(xingming,sfzmhm,yq_sfqz,ksqz,jsqz,szqy,sfqwhb,sfcy,sfsw,sfmj);
        Gson gson = new Gson();
        String result = "";
        if (personList!=null&&personList.size()!=0){
            result = gson.toJson(personList);
        }
        return result;
    }
    //查询全部
    @GetMapping("/findallbl")
    @ResponseBody
    public String findall(){
        List<Person> personList = qzRepository.findAll();
        Gson gson = new Gson();
        String result = "";
        if (personList!=null&&personList.size()!=0){
            result = gson.toJson(personList);
        }
        return result;
    }
}
