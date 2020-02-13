package com.xinke.epidemic_prevention.dao.common;

import com.xinke.epidemic_prevention.bean.community.QzNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: WRR
 * @Date: 2020/2/13
 * 功能描述：
 * 路径：com.xinke.epidemic_prevention.dao.common
 */
public interface QzNumRepository extends JpaRepository<QzNum,Integer>, JpaSpecificationExecutor<QzNum> {
    //近七日确诊数量列表
    @Query(value = "SELECT  ifnull(COUNT(*),0) as qtNum, DATE_FORMAT(yq_qzsj,'%Y%m%d') as qzrq from yq_bldjb where yq_sfqz=1 and xzxq='泰山区' \n" +
            "and yq_qzsj>date_add(now(),interval -7 day) GROUP BY DATE_FORMAT(yq_qzsj,'%Y%m%d')",nativeQuery = true)
    public List<QzNum> findAllQzNum();
    //累计治愈人员
    @Query(value = "SELECT  ifnull(COUNT(*),0) as zzyNum from yq_bldjb where yq_sfcy=1 and xzxq='泰山区' ",nativeQuery = true)
    public int zhiYuNum();
}
