package com.xinke.epidemic_prevention.dao.notice;

import com.xinke.epidemic_prevention.bean.notice.IfRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author:Wening
 * @Date:2019/12/9
 * @Description:是否已读Dao
 * @version:1.0
 */
public interface IfReadRepository extends JpaRepository<IfRead, Integer>, JpaSpecificationExecutor<IfRead> {
    //通过userNumber查找用户未读情况
    @Query(value="select i from IfRead i where i.userNumber=?1")
    public IfRead findByUserNumber(String userNumber);

    @Query(value="delete from IfRead i where i.userNumber=?1")
    @Modifying
    public int deleteByUserNumber(String userNumber);
}
