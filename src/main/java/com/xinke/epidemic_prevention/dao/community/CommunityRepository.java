package com.xinke.epidemic_prevention.dao.community;

import com.xinke.epidemic_prevention.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: WRR
 * @Date: 2020/2/6
 * 功能描述：社区部分repository
 * 路径：com.xinke.epidemic_prevention.dao.community
 */
public interface CommunityRepository extends JpaRepository<Person,Integer>, JpaSpecificationExecutor<Person> {
}
