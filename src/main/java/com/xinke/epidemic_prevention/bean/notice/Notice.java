package com.xinke.epidemic_prevention.bean.notice;

import javax.persistence.*;

/**
 * @Author:Wening
 * @Date:2020/2/10
 * @Description:通知公告字段
 * @version:1.0
 */
@Entity
@Table(name = "All_Notice")
public class Notice {
    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增id
    private Integer id;
    //公告公示标题
    private String Notice_Title;
    //内容
    @Lob
    private String Notice_Content;
    //发布时间
    private String Notice_Time;
    //游览次数
    private Integer click;
    //其他
    private String qiTa;

    public Notice(Integer id,String notice_Title, String notice_Content, String notice_Time, Integer click, String qiTa) {
        this.id = id;
        Notice_Title = notice_Title;
        Notice_Content = notice_Content;
        Notice_Time = notice_Time;
        this.click = click;
        this.qiTa = qiTa;
    }

    public Notice() {
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", Notice_Title='" + Notice_Title + '\'' +
                ", Notice_Content='" + Notice_Content + '\'' +
                ", Notice_Time='" + Notice_Time + '\'' +
                ", click=" + click +
                ", qiTa='" + qiTa + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotice_Title() {
        return Notice_Title;
    }

    public void setNotice_Title(String notice_Title) {
        Notice_Title = notice_Title;
    }

    public String getNotice_Content() {
        return Notice_Content;
    }

    public void setNotice_Content(String notice_Content) {
        Notice_Content = notice_Content;
    }

    public String getNotice_Time() {
        return Notice_Time;
    }

    public void setNotice_Time(String notice_Time) {
        Notice_Time = notice_Time;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getQiTa() {
        return qiTa;
    }

    public void setQiTa(String qiTa) {
        this.qiTa = qiTa;
    }
}