package com.xinke.epidemic_prevention.service.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
    //获取系统当前时间
    public String getDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
    public String getDatehms(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }
}
