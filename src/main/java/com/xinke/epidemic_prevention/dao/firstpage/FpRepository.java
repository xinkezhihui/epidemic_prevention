package com.xinke.epidemic_prevention.dao.firstpage;

import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.bean.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface FpRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<Person> {
    //当日新增疑似
    /*@Modifying
    @Transactional*/
    @Query(value = "SELECT  COUNT(*) from yq_bldjb where yq_yszdrq> ?1'00:00:00' and yq_yszdrq< ?1'24:00:00' and xzxq='泰山区' ",nativeQuery=true)
    public int ysxz(String date1);
    //当日新增确诊
    @Query(value = "SELECT  COUNT(*) from yq_bldjb where yq_qzsj> ?1'00:00:00' and yq_qzsj< ?1'24:00:00' and xzxq='泰山区' ",nativeQuery=true)
    public int qzxz(String date1);
    //累计疑似
    @Query(value = "SELECT  COUNT(*) from yq_bldjb where  yq_sfqz=0 and yq_sfys=1 and xzxq='泰山区' ",nativeQuery=true)
    public int ljys();
    //累计确诊
    @Query(value = "SELECT  COUNT(*) from yq_bldjb where yq_sfqz=1 and xzxq='泰山区' ",nativeQuery=true)
    public int ljqz();
    //当日新增密接
    @Query(value = "SELECT  COUNT(*) from yq_bldjb where qrmjsj> ?1'00:00:00' and yq_yszdrq< ?1'24:00:00' and xzxq='泰山区' ",nativeQuery=true)
    public int xzmj(String date1);
    //累计密接病例
    @Query(value = "SELECT  COUNT(*) from yq_bldjb where  yq_sfmjfb=1 and xzxq='泰山区' ",nativeQuery=true)
    public int ljmj();
    /**
     * @author: 刘文文
     * 功能描述：查看近一周确诊数量
     */

    @Query(value = "SELECT  COUNT(*)as qznum, DATE_FORMAT(yq_qzsj,'%m%d') as riqi from yq_bldjb where  \n" +
            "yq_sfqz=1 and xzxq='泰山区' and yq_qzsj >date_add(now(), interval -7 Day) group by yq_qzsj",nativeQuery=true)
    public List<Integer> Weekqz();
    //累计治愈
    @Query(value = "SELECT  COUNT(*) from yq_bldjb where  yq_sfcy=1 and xzxq='泰山区' ",nativeQuery=true)
    public int ljzy();
}
