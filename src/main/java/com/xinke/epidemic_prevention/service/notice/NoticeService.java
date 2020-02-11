package com.xinke.epidemic_prevention.service.notice;

import com.xinke.epidemic_prevention.bean.notice.Notice;
import com.xinke.epidemic_prevention.dao.notice.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:Wening
 * @Date:2019/11/21
 * @Description:公告增删改查
 * @version:1.0
 */
@Service
public class NoticeService {
    @Autowired
    NoticeRepository noticeRepository;

    /*查询*/
    public Notice queryById(Integer id){
        Notice byId = noticeRepository.findByNoticeId(id);
        return byId;
    }
    public List<Notice> query(){
        List<Notice> byAllId = noticeRepository.findAll();
        return byAllId;
    }
    /*添加*/
    public boolean registerInfo(Notice info){
        Notice save = noticeRepository.save(info);
        if(save!=null){
            return true;
        } else {
            return false;
        }
    }
    /*删除*/
    @Transactional
    public boolean deleteById(Integer id){
        int i = noticeRepository.deleteByNoticeId(id);
        if(i>0){
            return true;
        } else {
            return false;
        }
    }
    /*更新*/
    public boolean updateById(Notice info){
        Notice byNoticeId = noticeRepository.findByNoticeId(info.getId());
        Notice save = noticeRepository.save(info);
        if(save!=null) {
            return true;
        } else {
            return false;
        }
    }
    /*更新浏览次数*/
    public boolean updateClickById(Integer id){
        Notice byNoticeId = noticeRepository.findByNoticeId(id);
        if(byNoticeId.getClick()!=null) {
            byNoticeId.setClick(byNoticeId.getClick()+1);
        } else {
            byNoticeId.setClick(1);
        }
        Notice save = noticeRepository.save(byNoticeId);
        if(save!=null){
            return true;
        } else {
            return false;
        }
    }
}
