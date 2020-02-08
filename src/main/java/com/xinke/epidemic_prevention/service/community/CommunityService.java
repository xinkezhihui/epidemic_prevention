package com.xinke.epidemic_prevention.service.community;

import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.bean.community.Rqfl;
import com.xinke.epidemic_prevention.bean.community.Ssbsc;
import com.xinke.epidemic_prevention.bean.user.User;
import com.xinke.epidemic_prevention.dao.community.CommunityRepository;
import com.xinke.epidemic_prevention.dao.community.RqflRepository;
import com.xinke.epidemic_prevention.dao.community.SsbscRepository;
import com.xinke.epidemic_prevention.dao.user.userRepository;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    @Autowired
    private userRepository ur;

    //密接管理界面组合查询
    public List<Person> selectCheck(String sfzmhm, String xingming, String qrmjsj){
        List<Person> persons=new ArrayList<Person>();
        //jpa多条件多表查询，灵活 创建查询语句
        Specification<Person> specification=new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList();
                if (sfzmhm!= null && sfzmhm!= "") {
                    Path exp0 = root.get("sfzmhm");
                    predicates.add(criteriaBuilder.like(exp0, "%" + sfzmhm+ "%"));
                }
                if (xingming!=null) {
                    Path exp1 = root.get("xingming");
                    predicates.add(criteriaBuilder.like(exp1,"%" + xingming+ "%"));
                }
                if (qrmjsj!=null) {
                    Path exp1 = root.get("qrmjsj");
                    predicates.add(criteriaBuilder.like(exp1,"%" + qrmjsj+ "%"));
                }
                Path exp2 = root.get("mjtj");
                predicates.add(criteriaBuilder.equal(exp2, 0));
                Path exp3 = root.get("sfmjry");
                predicates.add(criteriaBuilder.equal(exp3, 1));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        persons = communityRepository.findAll(specification);
        return persons;
    }
    //密接查看界面组合查询
    public List<Person> selectCheckShow(String sfzmhm, String xingming, String qrmjsj){
        List<Person> persons=new ArrayList<Person>();
        //jpa多条件多表查询，灵活 创建查询语句
        Specification<Person> specification=new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList();
                if (sfzmhm!= null && sfzmhm!= "") {
                    Path exp0 = root.get("sfzmhm");
                    predicates.add(criteriaBuilder.like(exp0, "%" + sfzmhm+ "%"));
                }
                if (xingming!=null) {
                    Path exp1 = root.get("xingming");
                    predicates.add(criteriaBuilder.like(exp1,"%" + xingming+ "%"));
                }
                if (qrmjsj!=null) {
                    Path exp1 = root.get("qrmjsj");
                    predicates.add(criteriaBuilder.like(exp1,"%" + qrmjsj+ "%"));
                }
                Path exp2 = root.get("mjtj");
                predicates.add(criteriaBuilder.equal(exp2, 1));
                Path exp3 = root.get("sfmjry");
                predicates.add(criteriaBuilder.equal(exp3, 1));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        persons = communityRepository.findAll(specification);
        return persons;
    }
    //提交密接状态
    public Boolean miJieSubmit(String sfzmhm){
        Person person = communityRepository.findBySfzmhm(sfzmhm);
        System.out.println(person.toString());
        if(person!=null){
            person.setMjtj(1);
            communityRepository.flush();
            return true;
        }else
            return false;
    }
    //查询所有已提交密接人员
    public List<Person> findAllMjtjSubmitInfo(){
        List<Person> mjPerson = communityRepository.findAllSubmit();
        if(mjPerson != null && mjPerson.size() !=0 ){
            return mjPerson;
        }else {
            return null;
        }
    }
    //查询所有未提交密接人员
    public List<Person> findAllMjtjPersonInfo(){
        List<Person> mjPerson = communityRepository.findByPersonMjtj();
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
        String qrmjsj = df.format(new Date());
        int qztj = 0;
        int mjtj = 0;
        int sfmjry =1;
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        User user1 = ur.findByNumber(user.getNumber());
        String mj_userID = String.valueOf(user1.getId());
        Person person = new Person(sfzmhm,xzsf,xzdjs,xzxq,ssbsc,rqfl,xingming,lxdh,xxdz,yq_sfcwwh,yq_sfczqtsf,yq_zhumingsf,mjren,yq_sfmjfb,qrmjsj,qztj,mjtj,sfmjry,mj_userID);
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
