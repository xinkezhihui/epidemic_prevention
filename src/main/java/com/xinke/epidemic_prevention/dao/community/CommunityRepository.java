package com.xinke.epidemic_prevention.dao.community;

import com.xinke.epidemic_prevention.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: WRR
 * @Date: 2020/2/6
 * 功能描述：社区部分repository
 * 路径：com.xinke.epidemic_prevention.dao.community
 */
public interface CommunityRepository extends JpaRepository<Person,Integer>, JpaSpecificationExecutor<Person> {
    //查询所有密接人员
    @Query(value = "select * from yq_bldjb where mjtj=1",nativeQuery=true)
    public List<Person> findByPersonMjtj();
    //查询密接人员是否存在
//    @Query(value = "select i from Person i where sfzmhm = ?1")
//    public boolean existsBySfzmhm(String sfzmhm);
    public boolean existsBySfzmhm(String Sfzmhm);
}
