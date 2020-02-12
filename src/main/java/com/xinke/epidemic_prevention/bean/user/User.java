package com.xinke.epidemic_prevention.bean.user;

import javax.persistence.*;

@Entity
@Table(name = "ALL_USER_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //自增id
    private Integer id;
    //取水许可证编号
    private String number;
    //密码
    private String password;
    //登录状态
    private Integer state;
    //账号权限
    private String power;
    //真实姓名（管理员）
    private String realname;
    //职位(管理员)
    private String position;
    //联系方式（管理员）
    private String phone;

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    //工作地点
    private String workspace;


    public void setRealname(String realname) {
        this.realname = realname;
    }

    public User() {
    }

    public User(String number, String password, Integer state, String power, String realname, String position, String phone,String workspace) {
        this.number = number;
        this.password = password;
        this.state = state;
        this.power = power;
        this.realname = realname;
        this.position = position;
        this.phone = phone;
        this.workspace = workspace;
    }
    public User(Integer id, String number, String realname, String position, String phone, String power,String workspace){
        this.id = id;
        this.number = number;
        this.realname = realname;
        this.position = position;
        this.phone = phone;
        this.power = power;
        this.workspace = workspace;
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealname() {
        return realname;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                ", power='" + power + '\'' +
                ", realname='" + realname + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
