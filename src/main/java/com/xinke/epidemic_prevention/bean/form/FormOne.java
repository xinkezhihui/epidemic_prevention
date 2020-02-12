package com.xinke.epidemic_prevention.bean.form;

import javax.persistence.*;

@Entity
@Table(name="All_Form")
public class FormOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //自增id
    private Integer id;
    //地市
    private String city;
    //县区
    private String country;
    //当日新增疑似病例数
    private Integer ys_xz;
    //累计疑似病例数
    private Integer ys_lj;
    //确诊-前日报告累计
    private Integer qz_qrlj;
    //确诊-当日新增
    private Integer qz_xz;
    //确诊-累计
    private Integer qz_lj;
    //确诊-在院治疗-总数
    private Integer qz_zy_zs;
    //确诊-在院治疗-重症
    private Integer qz_zy_zz;
    //确诊-在院治疗-危重
    private Integer qz_zy_wz;
    //确诊-出院病例-前日报告累计
    private Integer qz_cy_qrlj;
    //确诊-出院病例-当日新增
    private Integer qz_cy_xz;
    //确诊-出院病例-累计
    private Integer qz_cy_lj;
    //确诊-死亡病例-前日报告统计
    private Integer qz_sw_qrlj;
    //确诊-死亡病例-当日新增
    private Integer qz_sw_xz;
    //确诊-死亡病例-累计
    private Integer qz_sw_lj;
    //密接-尚在医学观察-医务人员
    private Integer mj_gc_yw;
    //密接-尚在医学观察-非医务人员
    private Integer mj_gc_fyw;
    //密接-当日解除
    private Integer mj_jc;
    //密接-当日诊断为疑似或确诊
    private Integer mj_zd;
    //密接-累计
    private Integer mj_lj;
    //密接-前日累计解除
    private Integer mj_qrjc;
    //当前时间
    private String nowdate;

    public String getNowdate() {
        return nowdate;
    }

    public void setNowdate(String nowdate) {
        this.nowdate = nowdate;
    }

    public FormOne() {
    }

    public FormOne(String city, String country, Integer ys_xz, Integer ys_lj, Integer qz_qrlj, Integer qz_xz, Integer qz_lj, Integer qz_zy_zs, Integer qz_zy_zz, Integer qz_zy_wz, Integer qz_cy_qrlj, Integer qz_cy_xz, Integer qz_cy_lj, Integer qz_sw_qrlj, Integer qz_sw_xz, Integer qz_sw_lj, Integer mj_gc_yw, Integer mj_gc_fyw, Integer mj_jc, Integer mj_zd, Integer mj_lj, Integer mj_qrjc, String nowdate) {
        this.city = city;
        this.country = country;
        this.ys_xz = ys_xz;
        this.ys_lj = ys_lj;
        this.qz_qrlj = qz_qrlj;
        this.qz_xz = qz_xz;
        this.qz_lj = qz_lj;
        this.qz_zy_zs = qz_zy_zs;
        this.qz_zy_zz = qz_zy_zz;
        this.qz_zy_wz = qz_zy_wz;
        this.qz_cy_qrlj = qz_cy_qrlj;
        this.qz_cy_xz = qz_cy_xz;
        this.qz_cy_lj = qz_cy_lj;
        this.qz_sw_qrlj = qz_sw_qrlj;
        this.qz_sw_xz = qz_sw_xz;
        this.qz_sw_lj = qz_sw_lj;
        this.mj_gc_yw = mj_gc_yw;
        this.mj_gc_fyw = mj_gc_fyw;
        this.mj_jc = mj_jc;
        this.mj_zd = mj_zd;
        this.mj_lj = mj_lj;
        this.mj_qrjc = mj_qrjc;
        this.nowdate = nowdate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYs_xz() {
        return ys_xz;
    }

    public void setYs_xz(Integer ys_xz) {
        this.ys_xz = ys_xz;
    }

    public Integer getYs_lj() {
        return ys_lj;
    }

    public void setYs_lj(Integer ys_lj) {
        this.ys_lj = ys_lj;
    }

    public Integer getQz_qrlj() {
        return qz_qrlj;
    }

    public void setQz_qrlj(Integer qz_qrlj) {
        this.qz_qrlj = qz_qrlj;
    }

    public Integer getQz_xz() {
        return qz_xz;
    }

    public void setQz_xz(Integer qz_xz) {
        this.qz_xz = qz_xz;
    }

    public Integer getQz_lj() {
        return qz_lj;
    }

    public void setQz_lj(Integer qz_lj) {
        this.qz_lj = qz_lj;
    }

    public Integer getQz_zy_zs() {
        return qz_zy_zs;
    }

    public void setQz_zy_zs(Integer qz_zy_zs) {
        this.qz_zy_zs = qz_zy_zs;
    }

    public Integer getQz_zy_zz() {
        return qz_zy_zz;
    }

    public void setQz_zy_zz(Integer qz_zy_zz) {
        this.qz_zy_zz = qz_zy_zz;
    }

    public Integer getQz_zy_wz() {
        return qz_zy_wz;
    }

    public void setQz_zy_wz(Integer qz_zy_wz) {
        this.qz_zy_wz = qz_zy_wz;
    }

    public Integer getQz_cy_qrlj() {
        return qz_cy_qrlj;
    }

    public void setQz_cy_qrlj(Integer qz_cy_qrlj) {
        this.qz_cy_qrlj = qz_cy_qrlj;
    }

    public Integer getQz_cy_xz() {
        return qz_cy_xz;
    }

    public void setQz_cy_xz(Integer qz_cy_xz) {
        this.qz_cy_xz = qz_cy_xz;
    }

    public Integer getQz_cy_lj() {
        return qz_cy_lj;
    }

    public void setQz_cy_lj(Integer qz_cy_lj) {
        this.qz_cy_lj = qz_cy_lj;
    }

    public Integer getQz_sw_qrlj() {
        return qz_sw_qrlj;
    }

    public void setQz_sw_qrlj(Integer qz_sw_qrlj) {
        this.qz_sw_qrlj = qz_sw_qrlj;
    }

    public Integer getQz_sw_xz() {
        return qz_sw_xz;
    }

    public void setQz_sw_xz(Integer qz_sw_xz) {
        this.qz_sw_xz = qz_sw_xz;
    }

    public Integer getQz_sw_lj() {
        return qz_sw_lj;
    }

    public void setQz_sw_lj(Integer qz_sw_lj) {
        this.qz_sw_lj = qz_sw_lj;
    }

    public Integer getMj_gc_yw() {
        return mj_gc_yw;
    }

    public void setMj_gc_yw(Integer mj_gc_yw) {
        this.mj_gc_yw = mj_gc_yw;
    }

    public Integer getMj_gc_fyw() {
        return mj_gc_fyw;
    }

    public void setMj_gc_fyw(Integer mj_gc_fyw) {
        this.mj_gc_fyw = mj_gc_fyw;
    }

    public Integer getMj_jc() {
        return mj_jc;
    }

    public void setMj_jc(Integer mj_jc) {
        this.mj_jc = mj_jc;
    }

    public Integer getMj_zd() {
        return mj_zd;
    }

    public void setMj_zd(Integer mj_zd) {
        this.mj_zd = mj_zd;
    }

    public Integer getMj_lj() {
        return mj_lj;
    }

    public void setMj_lj(Integer mj_lj) {
        this.mj_lj = mj_lj;
    }

    public Integer getMj_qrjc() {
        return mj_qrjc;
    }

    public void setMj_qrjc(Integer mj_qrjc) {
        this.mj_qrjc = mj_qrjc;
    }

    @Override
    public String toString() {
        return "FormOne{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", ys_xz=" + ys_xz +
                ", ys_lj=" + ys_lj +
                ", qz_qrlj=" + qz_qrlj +
                ", qz_xz=" + qz_xz +
                ", qz_lj=" + qz_lj +
                ", qz_zy_zs=" + qz_zy_zs +
                ", qz_zy_zz=" + qz_zy_zz +
                ", qz_zy_wz=" + qz_zy_wz +
                ", qz_cy_qrlj=" + qz_cy_qrlj +
                ", qz_cy_xz=" + qz_cy_xz +
                ", qz_cy_lj=" + qz_cy_lj +
                ", qz_sw_qrlj=" + qz_sw_qrlj +
                ", qz_sw_xz=" + qz_sw_xz +
                ", qz_sw_lj=" + qz_sw_lj +
                ", mj_gc_yw=" + mj_gc_yw +
                ", mj_gc_fyw=" + mj_gc_fyw +
                ", mj_jc=" + mj_jc +
                ", mj_zd=" + mj_zd +
                ", mj_lj=" + mj_lj +
                ", mj_qrjc=" + mj_qrjc +
                ", nowdate='" + nowdate + '\'' +
                '}';
    }
}
