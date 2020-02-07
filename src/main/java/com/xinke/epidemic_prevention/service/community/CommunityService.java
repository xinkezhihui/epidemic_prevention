package com.xinke.epidemic_prevention.service.community;

import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.bean.community.Rqfl;
import com.xinke.epidemic_prevention.bean.community.Ssbsc;
import com.xinke.epidemic_prevention.dao.community.CommunityRepository;
import com.xinke.epidemic_prevention.dao.community.RqflRepository;
import com.xinke.epidemic_prevention.dao.community.SsbscRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: WRR
 * @Date: 2020/2/6
 * 功能描述：社区功能service
 * 路径：com.xinke.epidemic_prevention.service.community
 */
@Service
public class CommunityService {
    @Autowired
    private CommunityRepository communityRepository;
    @Autowired
    private RqflRepository rqflRepository;
    @Autowired
    private SsbscRepository ssbscRepository;
    //查询所有密接人员
    public List<Person> findAllMjtjPersonInfo(){
        List<Person> mjPerson = communityRepository.findByPersonMjtj();
        System.out.println(mjPerson.toString());
        if(mjPerson != null && mjPerson.size() !=0 ){
            return mjPerson;
        }else {
            return null;
        }
    }
    //跟据身份证查询该条数据是否存在
    public boolean personInfoIsExists(String sfzmhm){
        boolean bl = communityRepository.existsBySfzmhm(sfzmhm);
        if (bl) {
            return true;
        } else {
            return false;
        }
    }
    //添加密接人员
    public boolean addMijie(String sfzmhm,String xzsf,String xzdjs,String xzxq,String ssbsc,String rqfl,String xingming,String lxdh,String xxdz,Integer yq_sfcwwh,Integer yq_sfczqtsf,Integer yq_zhumingsf, String mjren, Integer yq_sfmjfb){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        String qrmjsj = df.format(new Date());
        int qztj = 0;
        int mjtj = 1;
        Person person = new Person(sfzmhm,xzsf,xzdjs,xzxq,ssbsc,rqfl,xingming,lxdh,xxdz,yq_sfcwwh,yq_sfczqtsf,yq_zhumingsf,mjren,yq_sfmjfb,qrmjsj,qztj,mjtj);
        Person save = communityRepository.save(person);
        if(save != null) {
            return true;
        } else {
            return false;
        }
    }
    //查询所有人群分类
    public List<Rqfl> findAllRqflInfo(){
        List<Rqfl> rqfls = rqflRepository.findAllByClassID();
        if(rqfls != null && rqfls.size() !=0 ){
            return rqfls;
        }else {
            return null;
        }
    }
    //查询所有所属办事处
    public List<Ssbsc> findAllSsbscInfo(){
        List<Ssbsc> ssbscs = ssbscRepository.findAll();
        if(ssbscs != null && ssbscs.size() !=0 ){
            return ssbscs;
        }else {
            return null;
        }
    }
}
