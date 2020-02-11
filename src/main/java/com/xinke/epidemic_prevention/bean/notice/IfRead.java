package com.xinke.epidemic_prevention.bean.notice;

import javax.persistence.*;

/**
 * @Author:Wening
 * @Date:2020/2/10
 * @Description:是否已读
 * @version:1.0
 */
@Entity
@Table(name = "All_IfRead")
public class IfRead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //user用户number
    private String userNumber;
    //通告id
    private String noticeInfo;
    //其他
    private String qiTa;

    public IfRead(String userNumber, String noticeInfo, String qiTa) {
        this.userNumber = userNumber;
        this.noticeInfo = noticeInfo;
        this.qiTa = qiTa;
    }

    public IfRead() {
    }

    @Override
    public String toString() {
        return "IfRead{" +
                "id=" + id +
                ", userNumber='" + userNumber + '\'' +
                ", noticeInfo='" + noticeInfo + '\'' +
                ", qiTa='" + qiTa + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getNoticeInfo() {
        return noticeInfo;
    }

    public void setNoticeInfo(String noticeInfo) {
        this.noticeInfo = noticeInfo;
    }

    public String getQiTa() {
        return qiTa;
    }

    public void setQiTa(String qiTa) {
        this.qiTa = qiTa;
    }
}
