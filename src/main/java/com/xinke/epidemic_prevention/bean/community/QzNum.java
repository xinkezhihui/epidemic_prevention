package com.xinke.epidemic_prevention.bean.community;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @Author: WRR
 * @Date: 2020/2/13
 * 功能描述：
 * 路径：com.xinke.epidemic_prevention.bean.community
 */
@Entity
public class QzNum {
    @Id
    private Integer qtNum;
    private String qzrq;

    public QzNum() {
    }

    public Integer getQtNum() {
        return qtNum;
    }

    public void setQtNum(Integer qtNum) {
        this.qtNum = qtNum;
    }

    public String getQzrq() {
        return qzrq;
    }

    public void setQzrq(String qzrq) {
        this.qzrq = qzrq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QzNum qzNum = (QzNum) o;
        return Objects.equals(qtNum, qzNum.qtNum) &&
                Objects.equals(qzrq, qzNum.qzrq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qtNum, qzrq);
    }
}
