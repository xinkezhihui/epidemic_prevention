package com.xinke.epidemic_prevention.service.notice;

import com.xinke.epidemic_prevention.bean.notice.IfRead;
import com.xinke.epidemic_prevention.bean.notice.Notice;
import com.xinke.epidemic_prevention.dao.notice.IfReadRepository;
import com.xinke.epidemic_prevention.dao.notice.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author:Wening
 * @Date:2019/12/9
 * @Description:是否已读相关操作
 * @version:1.0
 */
@Service
public class IfReadService {
    @Autowired
    NoticeRepository noticeRepository;
    @Autowired
    IfReadRepository ifReadRepository;
    /*查询*/
    public IfRead queryById(String userNumber){
        IfRead byUserNumber = ifReadRepository.findByUserNumber(userNumber);
        return byUserNumber;
    }
    /*链接字符串（每新增一个user）,先获取此字符串添加进字段，再调用下面的添加操作完成功能*/
    public String setString(){
        String str = null;
        List strList = new ArrayList();
        List<Notice> byAllId = noticeRepository.findAll();  //查询全部消息
        for(Notice n:byAllId){
            strList.add(n.getId().toString());
        }
        if(strList!=null) {
            str = String.join("-", strList);    //链接所有消息id
        }
        return str;
    }
    /*添加（user添加时调用）*/
    public boolean registerInfo(IfRead info){
        IfRead save = ifReadRepository.save(info);
        if(save!=null){
            return true;
        } else {
            return false;
        }
    }
    /*删除（user删除时调用）*/
    @Transactional
    public boolean deleteById(String userNumber){
        int i = ifReadRepository.deleteByUserNumber(userNumber);
        if(i>0){
            return true;
        } else {
            return false;
        }
    }
    /*更新（暂未使用）*/
    public boolean updateById(IfRead info){
        IfRead save = ifReadRepository.save(info);
        if(save!=null) {
            return true;
        } else {
            return false;
        }
    }

    /*浏览删除未读*/
    public boolean setStringDeleteOne(String userNumber, String newNoticeId){    //获取当前用户number，删除该条未读
        IfRead ifRead = queryById(userNumber);
        if(ifRead.getNoticeInfo()!=null&&!ifRead.getNoticeInfo().equals("")) {
            String[] noticeId = ifRead.getNoticeInfo().split("-");    //以-作为分割标识,当前用户所有未读消息id
            List<String> list = Arrays.asList(noticeId);    //将数组转换为list
            List<String> arrList = new ArrayList<String>(list); //该方法含抛出异常方法（不写出错）
            if(arrList.indexOf(newNoticeId)>=0)arrList.remove(newNoticeId); //有则删除
            System.out.println(arrList);/*打印当前未读消息id*/
            String str = null;//初值
            if (arrList != null) {
                str = String.join("-", arrList);    //链接所有消息id
            }
            ifRead.setNoticeInfo(str);
            IfRead save = ifReadRepository.save(ifRead); //更新本条数据
            if (save != null) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
    /*提取（查询时使用）*/
    public List<Notice> getNoticeByInfo(String info, Integer flat){    //此info是查询当前用户的那一条记录（未读消息id串）
        List<Notice> unread =  new ArrayList(); //未读 初始化空
        List<Notice> read = noticeRepository.findAll();   //已读 初始化全部
        if(info!=null&&!info.equals("")) {    //非空则有未读消息
            String[] noticeId = info.split("-");    //以-作为分割标识,所有未读消息id
            for (String s : noticeId) {
                unread.add(noticeRepository.findByNoticeId(Integer.parseInt(s)));
                read.remove(noticeRepository.findByNoticeId(Integer.parseInt(s)));
            }
        }
        if(flat==1)return unread;
        else return read;
    }
    /*链接字符串（每新增一条消息notice）*/
    public boolean setStringAdd(Integer newNoticeId){    //新增消息的id号，对所有记录更新
        int count = 0;
        List<IfRead> byAllId = ifReadRepository.findAll();  //查询全部未读消息情况
        for(IfRead i:byAllId){
            if(i.getNoticeInfo()==null||i.getNoticeInfo().equals("")){ //没有任何未读
                i.setNoticeInfo(newNoticeId.toString());
                IfRead save = ifReadRepository.save(i); //更新本条数据
                if(save!=null) {
                    count++;
                }
                continue;
            }
            String[] noticeId = i.getNoticeInfo().split("-");    //以-作为分割标识,当前用户所有未读消息id
            List<String> list= Arrays.asList(noticeId);    //将数组转换为list
            List<String> arrList = new ArrayList<String>(list); //该方法含抛出异常方法（不写出错）
            arrList.add(newNoticeId.toString());    //逐条添加
            Collections.sort(arrList, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    Integer i1 = Integer.parseInt(s1);
                    Integer i2 = Integer.parseInt(s2);
                    if(i1 >= i2){
                        return 1;
                    }
                    else {
                        return -1;
                    }
                }
            });  //排序
            Set set = new LinkedHashSet();
            //set.addAll(arrList);   //set容器去重
            for (String s:arrList){
                set.add(s);
            }
            arrList.clear();
            arrList.addAll(set);    //清空并重赋值
            String str = String.join("-",arrList);    //链接所有消息id
            i.setNoticeInfo(str);
            IfRead save = ifReadRepository.save(i); //更新本条数据
            if(save!=null) {
                count++;
            }
        }
        if(count>=byAllId.size()){
            return true;
        } else {
            return false;
        }
    }
    /*链接字符串（每删除一条消息notice）*/
    public boolean setStringDelete(String newNoticeId){    //删除消息的id号，对所有记录更新
        int count = 0;
        List<IfRead> byAllId = ifReadRepository.findAll();  //查询全部未读消息情况
        for(IfRead i:byAllId){
            if(i.getNoticeInfo()==null||i.getNoticeInfo().equals(""))continue;    //没有任何未读
            String[] noticeId = i.getNoticeInfo().split("-");    //以-作为分割标识,当前用户所有未读消息id
            List<String> list= Arrays.asList(noticeId);    //将数组转换为list
            List<String> arrList = new ArrayList<String>(list); //该方法含抛出异常方法（不写出错）
            if(arrList.indexOf(newNoticeId)<0)continue; //没有该条未读
            arrList.remove(newNoticeId);
            System.out.println(arrList);/*打印当前未读消息id*/
            String str=null;//初值
            if(arrList!=null) {
                str = String.join("-", arrList);    //链接所有消息id
            }
            i.setNoticeInfo(str);
            IfRead save = ifReadRepository.save(i); //更新本条数据
            if(save!=null) {
                count++;
            }
        }
        if(count>=byAllId.size()){
            return true;
        } else {
            return false;
        }
    }
    /*获取当前用户当前类别未读消息数目*/
    public Integer getCount(IfRead ifRead){
        String info = ifRead.getNoticeInfo();
        if(info==null||info.equals(""))return 0;   //无未读
        String[] noticeId = info.split("-");
        List<String> list= Arrays.asList(noticeId);    //将数组转换为list
        List<String> arrList = new ArrayList<String>(list); //该方法含抛出异常方法（不写出错）
        Integer count = arrList.size();  //未读计数器
        return count;
    }
    /*获取当前用户所有未读消息*/
    public Integer getAllCount(IfRead ifRead){
        String info = ifRead.getNoticeInfo();
        if(info==null||info.equals(""))return 0;   //无未读
        String[] noticeId = info.split("-");
        List<String> list= Arrays.asList(noticeId);    //将数组转换为list
        List<String> arrList = new ArrayList<String>(list); //该方法含抛出异常方法（不写出错）
        Integer count = arrList.size();  //未读计数器
        return count;
    }
}