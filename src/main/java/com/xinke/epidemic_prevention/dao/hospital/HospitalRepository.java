package com.xinke.epidemic_prevention.dao.hospital;

import com.xinke.epidemic_prevention.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

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
    //查询所有未提交疑似人员
    @Query(value = "select * from yq_bldjb where ystj= 0 and yq_sfys = 1",nativeQuery=true)
    public List<Person> findAllYsInfoByYstj();
    //查询所有已提交疑似人员
    @Query(value = "select * from yq_bldjb where ystj= 1 and yq_sfys = 1",nativeQuery=true)
    public List<Person> findAllSubmitYsInfoByYstj();
    //查询病例信息是否存在
    public boolean existsBySfzmhm(String sfzmhm);
    //根据sfzmhm返回一条数据
    public Person findBySfzmhm(String sfzmhm);
    //查询所有疑似排除人员
    @Query(value = "select * from yq_bldjb where ystj= 1 and yq_sfpc = 1",nativeQuery=true)
    public List<Person> findAllYsYPCInfo();
}
