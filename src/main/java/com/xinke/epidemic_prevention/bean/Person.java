package com.xinke.epidemic_prevention.bean;

import org.apache.logging.log4j.message.StringFormattedMessage;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: WRR
 * @Date: 2020/2/6
 * 功能描述：person类
 * 路径：com.xinke.epidemic_prevention.bean
 */

@Entity
@Table(name = "yq_bldjb")
public class Person {
    @Id
    //身份证号码
    @Column(nullable = false,length = 18,unique = true)
    private String sfzmhm;
    //姓名
    private String xingming;
    //病案号
    @Column(length = 50)
    private  String binganhao;
    //联系电话
    @Column(length = 20)
    private String lxdh;
    //详细地址
    private String xxdz;
    // 所属街道办事处
    private String ssbsc;
    // 所属社区
    private  String sssq;
    //密接人身份证号码
    private String mjren;
    //人群分类
    private String  rqfl;
    //是否解除观察
    private Integer sfjc;
    //检测日期
    private String jcrq;
    //国籍
    private String guoji;
    //是否华人
    private Integer sfhr;
    //发病日期
    private String yq_fbrq;
    //是否疑似病例
    private Integer yq_sfys;
    //疑似诊断日期
    private String yq_yszdrq;
    //是否留院观察
    private Integer yq_sflg;
    //留院观察日期
    private String yq_lgrq;
    //出院时间
    private String yq_chuysj;
    //报告单位
    private String bgdw;
    //报告日期
    private String bgrq;
    //做出诊断区县
    private String szqx;
    //报告省份
    private String bgsf;
    //报告地级市
    private  String bgdjs;
    //报告医疗机构
    private String bgyljg;
    //报告时间
    private String bgsj;
    //报告人姓名
    private  String bgrxm;
    //报告人联系方式
    private String bgrlxfs;
    //籍贯省份
    private String jiguansf;
    //籍贯地级市
    private String jiguandjs;
    //籍贯县区
    private String jiguanxq;
    //现住省份
    private String xzsf;
    //现住地级市
    private String xzdjs;
    //现住县区
    private String xzxq;
    //是否确诊
    private Integer yq_sfqz;
    // 是否密切接触者发病       `
    private Integer yq_sfmjfb;
    //是否医务人员
    private Integer yq_sfywry;
    //2周内是否曾往武汉
    private Integer yq_sfcwwh;
    //是否曾至其他省份
    private Integer yq_sfczqtsf;
    //如曾至其他身份注明
    private  String yq_zhumingsf;
    //是否首例确诊
    private Integer yq_sfsl;
    //是否重症
    private Integer yq_sfzz;
    //是否危重症
    private  Integer yq_sfwzz;
    //是否排除病例
    private  Integer yq_sfpc;
    //是否出院
    private Integer yq_sfcy;
    //是否死亡
    private Integer yq_sfsw;
    //是否核酸检测
    private Integer yq_sfhsjc;
    //核酸检测级别
    private String yq_hsjcjb;
    //是否基因测序
    private  Integer yq_sfjycx;
    //汇总人姓名
    private String hzrxm;
    //汇总人联系方式
    private String hzrlx;
    //核对人姓名
    private String hdrxm;
    //核对人联系方式
    private String hdrlx;
    //核对统计时间
    private String sjtjsj;
    //密接提交状态
    private Integer mjtj;
    //确诊提交状态
    private Integer qztj;
    //确认密接时间
    private String qrmjsj;
    //是否密接人员
    private  Integer sfmjry;
    //确诊时间
    private String  yq_qzsj;
    //密接添加人userid
    private String mj_userID;
    //确诊添加人userid
    private String qz_userID;
    //疑似添加人userid
    private String ys_userID;
    //疑似提交状态
    private Integer ystj;
    //死亡时间
    private String swsj;

    @Override
    public String toString() {
        return "Person{" +
                "sfzmhm='" + sfzmhm + '\'' +
                ", xingming='" + xingming + '\'' +
                ", binganhao='" + binganhao + '\'' +
                ", lxdh='" + lxdh + '\'' +
                ", xxdz='" + xxdz + '\'' +
                ", ssbsc='" + ssbsc + '\'' +
                ", sssq='" + sssq + '\'' +
                ", mjren='" + mjren + '\'' +
                ", rqfl='" + rqfl + '\'' +
                ", sfjc=" + sfjc +
                ", jcrq='" + jcrq + '\'' +
                ", guoji='" + guoji + '\'' +
                ", sfhr=" + sfhr +
                ", yq_fbrq='" + yq_fbrq + '\'' +
                ", yq_sfys=" + yq_sfys +
                ", yq_yszdrq='" + yq_yszdrq + '\'' +
                ", yq_sflg=" + yq_sflg +
                ", yq_lgrq='" + yq_lgrq + '\'' +
                ", yq_chuysj='" + yq_chuysj + '\'' +
                ", bgdw='" + bgdw + '\'' +
                ", bgrq='" + bgrq + '\'' +
                ", szqx='" + szqx + '\'' +
                ", bgsf='" + bgsf + '\'' +
                ", bgdjs='" + bgdjs + '\'' +
                ", bgyljg='" + bgyljg + '\'' +
                ", bgsj='" + bgsj + '\'' +
                ", bgrxm='" + bgrxm + '\'' +
                ", bgrlxfs='" + bgrlxfs + '\'' +
                ", jiguansf='" + jiguansf + '\'' +
                ", jiguandjs='" + jiguandjs + '\'' +
                ", jiguanxq='" + jiguanxq + '\'' +
                ", xzsf='" + xzsf + '\'' +
                ", xzdjs='" + xzdjs + '\'' +
                ", xzxq='" + xzxq + '\'' +
                ", yq_sfqz=" + yq_sfqz +
                ", yq_sfmjfb=" + yq_sfmjfb +
                ", yq_sfywry=" + yq_sfywry +
                ", yq_sfcwwh=" + yq_sfcwwh +
                ", yq_sfczqtsf=" + yq_sfczqtsf +
                ", yq_zhumingsf='" + yq_zhumingsf + '\'' +
                ", yq_sfsl=" + yq_sfsl +
                ", yq_sfzz=" + yq_sfzz +
                ", yq_sfwzz=" + yq_sfwzz +
                ", yq_sfpc=" + yq_sfpc +
                ", yq_sfcy=" + yq_sfcy +
                ", yq_sfsw=" + yq_sfsw +
                ", yq_sfhsjc=" + yq_sfhsjc +
                ", yq_hsjcjb='" + yq_hsjcjb + '\'' +
                ", yq_sfjycx=" + yq_sfjycx +
                ", hzrxm='" + hzrxm + '\'' +
                ", hzrlx='" + hzrlx + '\'' +
                ", hdrxm='" + hdrxm + '\'' +
                ", hdrlx='" + hdrlx + '\'' +
                ", sjtjsj='" + sjtjsj + '\'' +
                ", mjtj=" + mjtj +
                ", qztj=" + qztj +
                ", qrmjsj='" + qrmjsj + '\'' +
                ", sfmjry=" + sfmjry +
                ", yq_qzsj='" + yq_qzsj + '\'' +
                ", mj_userID='" + mj_userID + '\'' +
                ", qz_userID='" + qz_userID + '\'' +
                ", ys_userID='" + ys_userID + '\'' +
                ", ystj=" + ystj +
                ", swsj='" + swsj + '\'' +
                '}';
    }

    //添加新密接人员所需构造方法
    public Person(String sfzmhm, String xzsf, String xzdjs, String xzxq, String ssbsc, String rqfl, String xingming, String lxdh, String xxdz, Integer yq_sfcwwh, Integer yq_sfczqtsf, String yq_zhumingsf, String mjren, Integer yq_sfmjfb, String qrmjsj, Integer qztj, Integer mjtj, Integer sfmjry, String mj_userID){
        this.sfzmhm = sfzmhm;
        this.xingming = xingming;
        this.lxdh = lxdh;
        this.xxdz = xxdz;
        this.ssbsc = ssbsc;
        this.mjren = mjren;
        this.rqfl = rqfl;
        this.xzsf = xzsf;
        this.xzdjs = xzdjs;
        this.xzxq = xzxq;
        this.yq_sfmjfb = yq_sfmjfb;
        this.yq_sfcwwh = yq_sfcwwh;
        this.yq_sfczqtsf = yq_sfczqtsf;
        this.qrmjsj = qrmjsj;
        this.qztj =qztj;
        this.mjtj =mjtj;
        this.sfmjry = sfmjry;
        this.mj_userID = mj_userID;
        this.yq_zhumingsf = yq_zhumingsf;
    }
    //添加新疑似人员所需构造方法
    public Person(String sfzmhm, String xzsf, String xzdjs, String xzxq, String ssbsc, String rqfl, String xingming, String lxdh, String xxdz, Integer yq_sfcwwh, Integer yq_sfczqtsf, String yq_zhumingsf,String binganhao, Integer yq_sfmjfb, String mjren, Integer yq_sfzz,Integer yq_sfwzz, Integer ystj, Integer qztj, Integer mjtj, String ys_userID,Integer yq_sfys,String yq_yszdrq){
        this.sfzmhm = sfzmhm;
        this.xingming = xingming;
        this.lxdh = lxdh;
        this.xxdz = xxdz;
        this.ssbsc = ssbsc;
        this.mjren = mjren;
        this.rqfl = rqfl;
        this.xzsf = xzsf;
        this.xzdjs = xzdjs;
        this.xzxq = xzxq;
        this.yq_sfmjfb = yq_sfmjfb;
        this.yq_sfcwwh = yq_sfcwwh;
        this.yq_sfczqtsf = yq_sfczqtsf;
        this.qztj = qztj;
        this.mjtj = mjtj;
        this.yq_zhumingsf = yq_zhumingsf;
        this.binganhao = binganhao;
        this.yq_sfzz = yq_sfzz;
        this.yq_sfwzz = yq_sfwzz;
        this.ystj = ystj;
        this.ys_userID = ys_userID;
        this.yq_sfys = yq_sfys;
        this.yq_yszdrq = yq_yszdrq;
    }
    public Person() {
    }

    public String getSwsj() {
        return swsj;
    }

    public void setSwsj(String swsj) {
        this.swsj = swsj;
    }

    public String getSfzmhm() {
        return sfzmhm;
    }

    public void setSfzmhm(String sfzmhm) {
        this.sfzmhm = sfzmhm;
    }

    public String getXingming() {
        return xingming;
    }

    public void setXingming(String xingming) {
        this.xingming = xingming;
    }

    public String getBinganhao() {
        return binganhao;
    }

    public void setBinganhao(String binganhao) {
        this.binganhao = binganhao;
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

    public String getSsbsc() {
        return ssbsc;
    }

    public void setSsbsc(String ssbsc) {
        this.ssbsc = ssbsc;
    }

    public String getSssq() {
        return sssq;
    }

    public void setSssq(String sssq) {
        this.sssq = sssq;
    }

    public String getMjren() {
        return mjren;
    }

    public void setMjren(String mjren) {
        this.mjren = mjren;
    }

    public String getRqfl() {
        return rqfl;
    }

    public void setRqfl(String rqfl) {
        this.rqfl = rqfl;
    }

    public Integer getSfjc() {
        return sfjc;
    }

    public void setSfjc(Integer sfjc) {
        this.sfjc = sfjc;
    }

    public String getJcrq() {
        return jcrq;
    }

    public void setJcrq(String jcrq) {
        this.jcrq = jcrq;
    }

    public String getGuoji() {
        return guoji;
    }

    public void setGuoji(String guoji) {
        this.guoji = guoji;
    }

    public Integer getSfhr() {
        return sfhr;
    }

    public void setSfhr(Integer sfhr) {
        this.sfhr = sfhr;
    }

    public String getYq_fbrq() {
        return yq_fbrq;
    }

    public void setYq_fbrq(String yq_fbrq) {
        this.yq_fbrq = yq_fbrq;
    }

    public Integer getYq_sfys() {
        return yq_sfys;
    }

    public void setYq_sfys(Integer yq_sfys) {
        this.yq_sfys = yq_sfys;
    }

    public String getYq_yszdrq() {
        return yq_yszdrq;
    }

    public void setYq_yszdrq(String yq_yszdrq) {
        this.yq_yszdrq = yq_yszdrq;
    }

    public Integer getYq_sflg() {
        return yq_sflg;
    }

    public void setYq_sflg(Integer yq_sflg) {
        this.yq_sflg = yq_sflg;
    }

    public String getYq_lgrq() {
        return yq_lgrq;
    }

    public void setYq_lgrq(String yq_lgrq) {
        this.yq_lgrq = yq_lgrq;
    }

    public String getYq_chuysj() {
        return yq_chuysj;
    }

    public void setYq_chuysj(String yq_chuysj) {
        this.yq_chuysj = yq_chuysj;
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

    public String getSzqx() {
        return szqx;
    }

    public void setSzqx(String szqx) {
        this.szqx = szqx;
    }

    public String getBgsf() {
        return bgsf;
    }

    public void setBgsf(String bgsf) {
        this.bgsf = bgsf;
    }

    public String getBgdjs() {
        return bgdjs;
    }

    public void setBgdjs(String bgdjs) {
        this.bgdjs = bgdjs;
    }

    public String getBgyljg() {
        return bgyljg;
    }

    public void setBgyljg(String bgyljg) {
        this.bgyljg = bgyljg;
    }

    public String getBgsj() {
        return bgsj;
    }

    public void setBgsj(String bgsj) {
        this.bgsj = bgsj;
    }

    public String getBgrxm() {
        return bgrxm;
    }

    public void setBgrxm(String bgrxm) {
        this.bgrxm = bgrxm;
    }

    public String getBgrlxfs() {
        return bgrlxfs;
    }

    public void setBgrlxfs(String bgrlxfs) {
        this.bgrlxfs = bgrlxfs;
    }

    public String getJiguansf() {
        return jiguansf;
    }

    public void setJiguansf(String jiguansf) {
        this.jiguansf = jiguansf;
    }

    public String getJiguandjs() {
        return jiguandjs;
    }

    public void setJiguandjs(String jiguandjs) {
        this.jiguandjs = jiguandjs;
    }

    public String getJiguanxq() {
        return jiguanxq;
    }

    public void setJiguanxq(String jiguanxq) {
        this.jiguanxq = jiguanxq;
    }

    public String getXzsf() {
        return xzsf;
    }

    public void setXzsf(String xzsf) {
        this.xzsf = xzsf;
    }

    public String getXzdjs() {
        return xzdjs;
    }

    public void setXzdjs(String xzdjs) {
        this.xzdjs = xzdjs;
    }

    public String getXzxq() {
        return xzxq;
    }

    public void setXzxq(String xzxq) {
        this.xzxq = xzxq;
    }

    public Integer getYq_sfqz() {
        return yq_sfqz;
    }

    public void setYq_sfqz(Integer yq_sfqz) {
        this.yq_sfqz = yq_sfqz;
    }

    public Integer getYq_sfmjfb() {
        return yq_sfmjfb;
    }

    public void setYq_sfmjfb(Integer yq_sfmjfb) {
        this.yq_sfmjfb = yq_sfmjfb;
    }

    public Integer getYq_sfywry() {
        return yq_sfywry;
    }

    public void setYq_sfywry(Integer yq_sfywry) {
        this.yq_sfywry = yq_sfywry;
    }

    public Integer getYq_sfcwwh() {
        return yq_sfcwwh;
    }

    public void setYq_sfcwwh(Integer yq_sfcwwh) {
        this.yq_sfcwwh = yq_sfcwwh;
    }

    public Integer getYq_sfczqtsf() {
        return yq_sfczqtsf;
    }

    public void setYq_sfczqtsf(Integer yq_sfczqtsf) {
        this.yq_sfczqtsf = yq_sfczqtsf;
    }

    public String getYq_zhumingsf() {
        return yq_zhumingsf;
    }

    public void setYq_zhumingsf(String yq_zhumingsf) {
        this.yq_zhumingsf = yq_zhumingsf;
    }

    public Integer getYq_sfsl() {
        return yq_sfsl;
    }

    public void setYq_sfsl(Integer yq_sfsl) {
        this.yq_sfsl = yq_sfsl;
    }

    public Integer getYq_sfzz() {
        return yq_sfzz;
    }

    public void setYq_sfzz(Integer yq_sfzz) {
        this.yq_sfzz = yq_sfzz;
    }

    public Integer getYq_sfwzz() {
        return yq_sfwzz;
    }

    public void setYq_sfwzz(Integer yq_sfwzz) {
        this.yq_sfwzz = yq_sfwzz;
    }

    public Integer getYq_sfpc() {
        return yq_sfpc;
    }

    public void setYq_sfpc(Integer yq_sfpc) {
        this.yq_sfpc = yq_sfpc;
    }

    public Integer getYq_sfcy() {
        return yq_sfcy;
    }

    public void setYq_sfcy(Integer yq_sfcy) {
        this.yq_sfcy = yq_sfcy;
    }

    public Integer getYq_sfsw() {
        return yq_sfsw;
    }

    public void setYq_sfsw(Integer yq_sfsw) {
        this.yq_sfsw = yq_sfsw;
    }

    public Integer getYq_sfhsjc() {
        return yq_sfhsjc;
    }

    public void setYq_sfhsjc(Integer yq_sfhsjc) {
        this.yq_sfhsjc = yq_sfhsjc;
    }

    public String getYq_hsjcjb() {
        return yq_hsjcjb;
    }

    public void setYq_hsjcjb(String yq_hsjcjb) {
        this.yq_hsjcjb = yq_hsjcjb;
    }

    public Integer getYq_sfjycx() {
        return yq_sfjycx;
    }

    public void setYq_sfjycx(Integer yq_sfjycx) {
        this.yq_sfjycx = yq_sfjycx;
    }

    public String getHzrxm() {
        return hzrxm;
    }

    public void setHzrxm(String hzrxm) {
        this.hzrxm = hzrxm;
    }

    public String getHzrlx() {
        return hzrlx;
    }

    public void setHzrlx(String hzrlx) {
        this.hzrlx = hzrlx;
    }

    public String getHdrxm() {
        return hdrxm;
    }

    public void setHdrxm(String hdrxm) {
        this.hdrxm = hdrxm;
    }

    public String getHdrlx() {
        return hdrlx;
    }

    public void setHdrlx(String hdrlx) {
        this.hdrlx = hdrlx;
    }

    public String getSjtjsj() {
        return sjtjsj;
    }

    public void setSjtjsj(String sjtjsj) {
        this.sjtjsj = sjtjsj;
    }

    public Integer getMjtj() {
        return mjtj;
    }

    public void setMjtj(Integer mjtj) {
        this.mjtj = mjtj;
    }

    public Integer getQztj() {
        return qztj;
    }

    public void setQztj(Integer qztj) {
        this.qztj = qztj;
    }

    public String getQrmjsj() {
        return qrmjsj;
    }

    public void setQrmjsj(String qrmjsj) {
        this.qrmjsj = qrmjsj;
    }

    public Integer getSfmjry() {
        return sfmjry;
    }

    public void setSfmjry(Integer sfmjry) {
        this.sfmjry = sfmjry;
    }

    public String getYq_qzsj() {
        return yq_qzsj;
    }

    public void setYq_qzsj(String yq_qzsj) {
        this.yq_qzsj = yq_qzsj;
    }

    public String getMj_userID() {
        return mj_userID;
    }

    public void setMj_userID(String mj_userID) {
        this.mj_userID = mj_userID;
    }

    public String getQz_userID() {
        return qz_userID;
    }

    public void setQz_userID(String qz_userID) {
        this.qz_userID = qz_userID;
    }

    public String getYs_userID() {
        return ys_userID;
    }

    public void setYs_userID(String ys_userID) {
        this.ys_userID = ys_userID;
    }

    public Integer getYstj() {
        return ystj;
    }

    public void setYstj(Integer ystj) {
        this.ystj = ystj;
    }
}
