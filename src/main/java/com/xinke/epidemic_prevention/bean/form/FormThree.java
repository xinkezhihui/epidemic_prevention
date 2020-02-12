package com.xinke.epidemic_prevention.bean.form;

import javax.persistence.*;

@Entity
@Table(name="All_Formthree")
public class FormThree  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //自增id
    private Integer id;
    //姓名
    private String name;
    //性别
    private String sex;
    //证件号码
    private String zjhm;
    //病例号
    private String blh;
    //联系电话
    private String lxdh;
    //现住详细地址
    private String xxdz;
    //人群分类
    private String rqfl;
    //发病日期
    private String fbrq;
    //诊断时间
    private String zdsj;
    //出院/死亡时间
    private String cyswsj;
    //报告单位
    private String bgdw;
    //报告日期
    private String bgrq;
    //做出该诊断的医疗机构所在区县
    private String zdqx;
    //是否为密切接触者发病
    private String sfmjfb;
    //当前时间
    private String nowdate;

    public FormThree(String name, String sex, String zjhm, String blh, String lxdh, String xxdz, String rqfl, String fbrq, String zdsj, String cyswsj, String bgdw, String bgrq, String zdqx, String sfmjfb, String nowdate) {
        this.name = name;
        this.sex = sex;
        this.zjhm = zjhm;
        this.blh = blh;
        this.lxdh = lxdh;
        this.xxdz = xxdz;
        this.rqfl = rqfl;
        this.fbrq = fbrq;
        this.zdsj = zdsj;
        this.cyswsj = cyswsj;
        this.bgdw = bgdw;
        this.bgrq = bgrq;
        this.zdqx = zdqx;
        this.sfmjfb = sfmjfb;
        this.nowdate = nowdate;
    }

    public String getNowdate() {
        return nowdate;
    }

    public void setNowdate(String nowdate) {
        this.nowdate = nowdate;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    public String getBlh() {
        return blh;
    }

    public void setBlh(String blh) {
        this.blh = blh;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getXxdz() {
        return xxdz;
    }

    public void setXxdz(String xxdz) {
        this.xxdz = xxdz;
    }

    public String getRqfl() {
        return rqfl;
    }

    public void setRqfl(String rqfl) {
        this.rqfl = rqfl;
    }

    public String getFbrq() {
        return fbrq;
    }

    public void setFbrq(String fbrq) {
        this.fbrq = fbrq;
    }

    public String getZdsj() {
        return zdsj;
    }

    public void setZdsj(String zdsj) {
        this.zdsj = zdsj;
    }

    public String getCyswsj() {
        return cyswsj;
    }

    public void setCyswsj(String cyswsj) {
        this.cyswsj = cyswsj;
    }

    public String getBgdw() {
        return bgdw;
    }

    public void setBgdw(String bgdw) {
        this.bgdw = bgdw;
    }

    public String getBgrq() {
        return bgrq;
    }

    public void setBgrq(String bgrq) {
        this.bgrq = bgrq;
    }

    public String getZdqx() {
        return zdqx;
    }

    public void setZdqx(String zdqx) {
        this.zdqx = zdqx;
    }

    public String getSfmjfb() {
        return sfmjfb;
    }

    public void setSfmjfb(String sfmjfb) {
        this.sfmjfb = sfmjfb;
    }
}
