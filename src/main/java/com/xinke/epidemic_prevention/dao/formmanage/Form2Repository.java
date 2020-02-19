package com.xinke.epidemic_prevention.dao.formmanage;

import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.bean.form.FormOne;
import com.xinke.epidemic_prevention.bean.form.FormTwo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface Form2Repository extends JpaRepository<FormTwo,Integer>, JpaSpecificationExecutor<FormTwo> {
    //查询0-24时疑似——当日新增

    @Query(value = "SELECT  ifnull(COUNT(*),0) from yq_bldjb where yq_yszdrq> ?1'00:00:00' and yq_yszdrq< ?1'24:00:00' and xzxq='泰山区' ",nativeQuery=true)
    public int ysxz(String date);
    //累计疑似
    @Query(value = "SELECT  ifnull(COUNT(*),0) from yq_bldjb where  yq_sfqz=0 and yq_sfys=1 and xzxq='泰山区' ",nativeQuery=true)
    public int ljys();
    //前日累计确诊
    @Query(value = "SELECT  ifnull(COUNT(*),0) from yq_bldjb where yq_qzsj<?1'00:00:00' and xzxq='泰山区' ",nativeQuery=true)
    public int qrqz(String date);
    //当日新增确诊
    @Query(value = "SELECT  ifnull(COUNT(*),0) from yq_bldjb where yq_qzsj> ?1'00:00:00' and yq_qzsj< ?1'24:00:00' and xzxq='泰山区' ",nativeQuery=true)
    public int qzxz(String date);
    //累计确诊
    @Query(value = "SELECT  ifnull(COUNT(*),0) from yq_bldjb where yq_sfqz=1 and xzxq='泰山区' ",nativeQuery=true)
    public int ljqz();
    //确诊-在院治疗-总数
    @Query(value = "SELECT  ifnull(COUNT(*),0) from yq_bldjb where yq_sfqz=1 and yq_sfcy=0 and xzxq='泰山区' ",nativeQuery=true)
    public int zyzlzs();
    //确诊-在院治疗-重症
    @Query(value = "SELECT  ifnull(COUNT(*),0) from yq_bldjb where yq_sfqz=1 and yq_sfcy=0 and yq_sfzz=1 and xzxq='泰山区' ",nativeQuery=true)
    public int zz();
    //确诊-在院治疗-危重
    @Query(value = "SELECT  ifnull(COUNT(*),0) from yq_bldjb where yq_sfqz=1 and yq_sfcy=0 and yq_sfwzz=1 and xzxq='泰山区' ",nativeQuery=true)
    public int wz();
    //确诊-出院病例-前日累计
    @Query(value = "SELECT  ifnull(COUNT(*),0) from yq_bldjb where yq_sfqz=1 and yq_sfcy=1 and yq_chuysj<?1'00:00:00' and xzxq='泰山区' ",nativeQuery=true)
    public int cyqrlj(String date);
    //确诊-出院病例-当日新增
    @Query(value = "SELECT  ifnull(COUNT(*),0) from yq_bldjb where yq_sfqz=1 and yq_sfcy=1 and yq_chuysj>?1'00:00:00' and yq_chuysj<?1'24:00:00' and xzxq='泰山区' ",nativeQuery=true)
    public int cydrxz(String date);
    //确诊-出院病例-累计
    @Query(value = "SELECT  ifnull(COUNT(*),0) from yq_bldjb where yq_sfqz=1 and yq_sfcy=1  and xzxq='泰山区' ",nativeQuery=true)
    public int cylj();
    //确诊-死亡-前日累计
    @Query(value = "SELECT  ifnull(COUNT(*),0) from yq_bldjb where yq_sfqz=1 and yq_sfsw=1 and swsj<?1'00:00:00' and xzxq='泰山区' ",nativeQuery=true)
    public int swqrlj(String date);
    //确诊-死亡-当日新增
    @Query(value = "SELECT  ifnull(COUNT(*),0) from yq_bldjb where yq_sfqz=1 and yq_sfsw=1 and swsj>?1'00:00:00' and swsj<?1'24:00:00' and xzxq='泰山区' ",nativeQuery=true)
    public int swdrlj(String date);
    //确诊-死亡-累计
    @Query(value = "SELECT  ifnull(COUNT(*),0) from yq_bldjb where yq_sfqz=1 and yq_sfsw=1 and xzxq='泰山区' ",nativeQuery=true)
    public int swlj();
    //密接-尚在医学观察-医务人员
    @Query(value = "SELECT  ifnull(COUNT(*),0) from yq_bldjb where yq_sfywry=1 and qrmjsj!=null and xzxq='泰山区' ",nativeQuery=true)
    public int mjyw();
    //密接-尚在医学观察-非医务人员
    @Query(value = "SELECT  ifnull(COUNT(*),0) from yq_bldjb where yq_sfywry=0 and qrmjsj!=null and xzxq='泰山区' ",nativeQuery=true)
    public int mjfyw();
    //密接-当日解除
    @Query(value = "SELECT  ifnull(COUNT(*),0)  from yq_bldjb where  yq_sfpc=1 and qrmjsj>?1'00:00:00' and qrmjsj<?1'24:00:00'  and xzxq='泰山区' ",nativeQuery=true)
    public int drjc(String date);
    /*@Query(value = "SELECT  ifnull(COUNT(*),0)  from yq_bldjb where  yq_sfpc=1 and qrmjsj=now() and xzxq='泰山区' ",nativeQuery=true)
    public int ljmj();*/
    //密接-当日诊断为疑似或确诊
    @Query(value = "SELECT  ifnull(COUNT(*),0)  from yq_bldjb where qrmjsj>?1'00:00:00' and qrmjsj<?1'24:00:00'and xzxq='泰山区' and (yq_sfys=1 or yq_sfqz=1) ",nativeQuery=true)
    public int zdysqz(String date);
    //密接-累计
    @Query(value = "SELECT  ifnull(COUNT(*),0)  from yq_bldjb where  qrmjsj!=null  and xzxq='泰山区' ",nativeQuery=true)
    public int mjlj();
    //密接-前日累计解除
    @Query(value = "SELECT  ifnull(COUNT(*),0)  from yq_bldjb where  yq_sfpc=1 and qrmjsj<?1'00:00:00'  and xzxq='泰山区' ",nativeQuery=true)
    public int qrljjc(String date);

   /* //存入数据库
    public void save(FormOne formOne);*/
    //查询当日报表

    public List<FormTwo> findByNowdate(String date);

    //时间倒叙
    @Query(value = "SELECT  *  from All_Formtwo order by nowdate desc",nativeQuery=true)
    public List<FormTwo> find();

}
