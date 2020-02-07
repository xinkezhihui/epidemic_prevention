package com.xinke.epidemic_prevention.bean.community;

import javax.persistence.*;

/**
 * @Author: WRR
 * @Date: 2020/2/7
 * 功能描述：
 * 路径：com.xinke.epidemic_prevention.bean.community
 */
@Entity
@Table(name = "p_Organ")
public class Ssbsc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //序号
    private int id;
    //所属办事处名称
    private String OrganName;
}
