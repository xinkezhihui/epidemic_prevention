package com.xinke.epidemic_prevention.dao.hospital;

import com.xinke.epidemic_prevention.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @Author:jlz
 * @Date: 2020/2/7
 * 路径： com.xinke.epidemic_prevention.dao.hospital
 * 功能描述：医院部分的接口
 */
public interface HospitalRepository extends JpaRepository<Person,Integer>, JpaSpecificationExecutor<Person> {
    @Modifying
    @Transactional
    @Query(value = "delete from yq_bldjb where id=?1",nativeQuery=true)
    public int deleteByAgricultureId(int id);
    //根据id查询数据是否存在
    public boolean existsById(int id);
    //查询单条用户信息
    public Person findById(int id);
}
