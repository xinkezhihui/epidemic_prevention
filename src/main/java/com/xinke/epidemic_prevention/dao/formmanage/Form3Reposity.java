package com.xinke.epidemic_prevention.dao.formmanage;

import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.bean.form.FormThree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Form3Reposity extends JpaRepository<Person,Integer>, JpaSpecificationExecutor<Person> {

    //查询0-24新增确诊

    @Query(value = "SELECT * from yq_bldjb where yq_sfqz=1 and yq_qzsj> ?1'00:00:00' and yq_qzsj< ?1'24:00:00' and xzxq='泰山区' ",nativeQuery=true)
    public List<Person> qzxz(String date);
}
