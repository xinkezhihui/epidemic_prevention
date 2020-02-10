package com.xinke.epidemic_prevention.dao.community;

import com.xinke.epidemic_prevention.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author: WRR
 * @Date: 2020/2/6
 * 功能描述：社区部分repository
 * 路径：com.xinke.epidemic_prevention.dao.community
 */
public interface CommunityRepository extends JpaRepository<Person,Integer>, JpaSpecificationExecutor<Person> {
    //查询所有未提交密接人员
    @Query(value = "select * from yq_bldjb where mjtj=0 and sfmjry = 1",nativeQuery=true)
    public List<Person> findByPersonMjtj();
    //查询密接人员是否存在
//    @Query(value = "select i from Person i where mjtj=0 and sfmjry = 1 and sfzmhm = ?1")
    public boolean existsBySfzmhm(String sfzmhm);
    //查询所有已提交密接人员
    @Query(value = "select * from yq_bldjb where mjtj=1 and sfmjry = 1",nativeQuery=true)
    public List<Person> findAllSubmit();
    //跟据身份证明号码查询
    public Person findBySfzmhm(String Sfzmhm);
    //根据身份证明号码删除
    @Modifying
    @Transactional
    @Query(value = "delete  from yq_bldjb where sfzmhm = ?1",nativeQuery=true)
    public int deleteMijieBySfzmhm(String sfzmhm);
}
