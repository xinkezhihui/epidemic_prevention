package com.xinke.epidemic_prevention.service.common;

import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.dao.common.QzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: WRR
 * @Date: 2020/2/10
 * 功能描述：
 * 路径：com.xinke.epidemic_prevention.service.common
 */
@Service
public class QzService {
    @Autowired
    private QzRepository qzRepository;
    //查询所有已提交确诊人员
    public List<Person> findAllYtjQueZhen(){
        List<Person> persons = qzRepository.findAllYtjQueZhen();
        if(persons != null && persons.size() !=0 ){
            return persons;
        }else {
            return null;
        }
    }
    //查询所有未提交确诊人员
    public List<Person> findAllWtjQueZhen(){
        List<Person> persons = qzRepository.findAllWtjQueZhen();
        if(persons != null && persons.size() !=0 ){
            return persons;
        }else {
            return null;
        }
    }
}
