package com.xinke.epidemic_prevention.bean.community;

import javax.persistence.*;

/**
 * @Author: WRR
 * @Date: 2020/2/7
 * 功能描述：人群分类
 * 路径：com.xinke.epidemic_prevention.bean.community
 */
@Entity
@Table(name = "p_ClassN")
public class Rqfl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //序号
    private int id;

    private String ClassNName;

    private String ClassID;

    public Rqfl() {
    }

    @Override
    public String toString() {
        return "Rqfl{" +
                "id=" + id +
                ", ClassNName='" + ClassNName + '\'' +
                ", ClassID='" + ClassID + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassNName() {
        return ClassNName;
    }

    public void setClassNName(String classNName) {
        ClassNName = classNName;
    }

    public String getClassID() {
        return ClassID;
    }

    public void setClassID(String classID) {
        ClassID = classID;
    }
}
