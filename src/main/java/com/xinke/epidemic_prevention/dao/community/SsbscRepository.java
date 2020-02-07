package com.xinke.epidemic_prevention.dao.community;

import com.xinke.epidemic_prevention.bean.community.Rqfl;
import com.xinke.epidemic_prevention.bean.community.Ssbsc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: WRR
 * @Date: 2020/2/7
 * 功能描述：
 * 路径：com.xinke.epidemic_prevention.dao.community
 */
public interface SsbscRepository extends JpaRepository<Ssbsc,Integer>, JpaSpecificationExecutor<Ssbsc> {
}
