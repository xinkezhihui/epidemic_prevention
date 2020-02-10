package com.xinke.epidemic_prevention.dao.common;

import com.xinke.epidemic_prevention.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: WRR
 * @Date: 2020/2/10
 * 功能描述：
 * 路径：com.xinke.epidemic_prevention.dao.common
 */
public interface QzRepository extends JpaRepository<Person,Integer>, JpaSpecificationExecutor<Person> {
    //查询所有已提交确诊人员
    @Query(value = "select * from yq_bldjb where yq_sfqz = 1 and qztj = 1",nativeQuery=true)
    public List<Person> findAllYtjQueZhen();
    //查询所有未提交确诊人员
    @Query(value = "select * from yq_bldjb where yq_sfqz = 1 and qztj = 0",nativeQuery=true)
    public List<Person> findAllWtjQueZhen();
}
