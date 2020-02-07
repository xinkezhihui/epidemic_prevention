package com.xinke.epidemic_prevention.dao.community;

import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.bean.community.Rqfl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: WRR
 * @Date: 2020/2/7
 * 功能描述：
 * 路径：com.xinke.epidemic_prevention.controller.community
 */
public interface RqflRepository extends JpaRepository<Rqfl,Integer>, JpaSpecificationExecutor<Rqfl> {
    //查询人群分类
    @Query(value = "select * from p_ClassN where ClassID=1", nativeQuery = true)
    public List<Rqfl> findAllByClassID();

}
