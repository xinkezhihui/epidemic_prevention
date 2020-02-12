package com.xinke.epidemic_prevention.controller.formmanager;

import com.xinke.epidemic_prevention.bean.form.FormOne;
import com.xinke.epidemic_prevention.dao.formmanage.Form1Repository;
import com.xinke.epidemic_prevention.dao.formmanage.Form2Repository;
import com.xinke.epidemic_prevention.dao.formmanage.Form3Reposity;
import com.xinke.epidemic_prevention.service.util.DateUtil;
import com.xinke.epidemic_prevention.service.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("download")
public class DownloadController {
    @Autowired
    Form1Repository form1Repository;
    @Autowired
    Form2Repository form2Repository;
    @Autowired
    Form3Reposity form3Reposity;


    //下载
    @GetMapping("/downloadform1")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response, @RequestParam("name")String name, @RequestParam("number")String number, @RequestParam("type")String type, @RequestParam("code")String code, @RequestParam("emailcode")String emailcode) throws Exception {
        List<FormOne> list = new ArrayList<FormOne>();
        //jpa多条件多表查询，灵活 创建查询语句
        Specification<FormOne> specification = new Specification<FormOne>() {
            @Override
            public Predicate toPredicate(Root<FormOne> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (name != null && name != "") {
                    Path exp0 = root.get("name");
                    predicates.add(criteriaBuilder.like(exp0, "%" + name + "%"));
                }
                if (number != null && number != "") {
                    Path exp2 = root.get("number");
                    predicates.add(criteriaBuilder.like(exp2, "%" + number + "%"));
                }
                if (type != null && type != "") {
                    Path exp3 = root.get("type");
                    predicates.add(criteriaBuilder.like(exp3, "%" + type + "%"));
                }
                if (code != null && code != "") {
                    Path exp4 = root.get("code");
                    predicates.add(criteriaBuilder.like(exp4, "%" + code + "%"));
                }
                if (emailcode != null && emailcode != "") {
                    Path exp5 = root.get("emailcode");
                    predicates.add(criteriaBuilder.like(exp5, "%" + emailcode + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        list = form1Repository.findAll(specification);
        System.out.println(list);
        //excel标题
        String[] title = {"地市","县区","疑似-当日新增","单位类型","组织机构代码","联系人","联系电话","邮编","通讯地址","邮箱"};
        DateUtil dateUtil = new DateUtil();
        //excel文件名
        String fileName = dateUtil.getDate() +"取水户信息"+".xls";
        //sheet名
        String sheetName = "sheet1";

        String[][] content = new String[list.size()][];
        for(int i=0;i<list.size();i++){
            content[i] =new String[50];
            FormOne obj = list.get(i);
            content[i][0] = obj.getCity();
            content[i][1] = obj.getCountry();
            content[i][2] = String.valueOf(obj.getYs_xz()) ;
            content[i][3] = String.valueOf(obj.getYs_lj());
            content[i][4] = String.valueOf(obj.getQz_qrlj());
            content[i][5] = String.valueOf(obj.getQz_xz());
            content[i][6] = String.valueOf(obj.getQz_lj());
            content[i][7] = String.valueOf(obj.getQz_zy_zs());
            content[i][8] = String.valueOf(obj.getQz_zy_zz());
            content[i][9] = String.valueOf(obj.getQz_zy_wz());
            content[i][10] = String.valueOf(obj.getQz_cy_qrlj());
            content[i][11] = String.valueOf(obj.getQz_cy_xz());
            content[i][12] = String.valueOf(obj.getQz_cy_lj());
            content[i][13] = String.valueOf(obj.getQz_sw_qrlj());
            content[i][14] = String.valueOf(obj.getQz_sw_xz());
            content[i][15] = String.valueOf(obj.getQz_sw_lj());
            content[i][16] = String.valueOf(obj.getMj_gc_yw());
            content[i][17] = String.valueOf(obj.getMj_gc_fyw());
            content[i][18] = String.valueOf(obj.getMj_jc());
            content[i][19] = String.valueOf(obj.getMj_zd());
            content[i][20] = String.valueOf(obj.getMj_lj());
            content[i][21] = String.valueOf(obj.getMj_qrjc());
            content[i][22] = String.valueOf(obj.getNowdate());

        }
        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
