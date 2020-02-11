package com.xinke.epidemic_prevention.dao.notice;

import com.xinke.epidemic_prevention.bean.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Auther:Wening
 * @Date:2019/11/14
 * @Description:公告公示Dao
 * @version:1.0
 */
public interface NoticeRepository extends JpaRepository<Notice, Integer>, JpaSpecificationExecutor<Notice> {
    @Query(value="select i from Notice i where i.id=?1")
    public Notice findByNoticeId(Integer id);

    @Query(value="delete from Notice i where i.id=?1")
    @Modifying
    public int deleteByNoticeId(Integer id);
}
