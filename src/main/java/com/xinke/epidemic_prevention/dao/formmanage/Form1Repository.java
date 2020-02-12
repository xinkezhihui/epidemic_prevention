package com.xinke.epidemic_prevention.dao.formmanage;

import com.xinke.epidemic_prevention.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface Form1Repository extends JpaRepository<Person,Integer>, JpaSpecificationExecutor<Person> {
    //查询0-12时疑似——当日新增
   /* @Modifying
    @Transactional
    @Query(value = "select count(*) from yq_bldjb where yq_yszdrq>?1"+" 00:00:00 and yq_yszdrq<?1"+" 12:00:00 and xzzq=''",nativeQuery=true)
    public int ysxz(String date);*/
}
