package com.xinke.epidemic_prevention.service.common;

import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.dao.common.QzRepository;
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
 * @Date: 2020/2/10
 * 功能描述：
 * 路径：com.xinke.epidemic_prevention.service.common
 */
@Service
public class QzService {
    @Autowired
    private QzRepository qzRepository;
    //确诊人员出院
    public boolean qzChuYuan(String sfzmhm){
        Person person = qzRepository.findBySfzmhm(sfzmhm);
        if(person!=null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String yq_chuysj = df.format(new Date());
            person.setYq_chuysj(yq_chuysj);
            person.setYq_sfcy(1);
            person.setYq_sfqz(0);
            qzRepository.flush();
            return true;
        }else
            return false;
    }
    //确诊人员死亡
    public boolean qzDeath(String sfzmhm){
        Person person = qzRepository.findBySfzmhm(sfzmhm);
        if(person!=null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String swsj = df.format(new Date());
            person.setSwsj(swsj);
            person.setYq_sfsw(1);
            person.setYq_sfqz(0);
            qzRepository.flush();
            return true;
        }else
            return false;
    }
    //提交确诊人员
    public boolean qzSubmit(String sfzmhm){
        Person person = qzRepository.findBySfzmhm(sfzmhm);
        if(person!=null){
            person.setQztj(1);
            qzRepository.flush();
            return true;
        }else
            return false;
    }
    //已提交确诊人员组合查询
    public List<Person> selectYtj(String sfzmhm, String xingming, String yq_qzsj){
        List<Person> persons=new ArrayList<Person>();
        //jpa多条件多表查询，灵活 创建查询语句
        Specification<Person> specification=new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList();
                if (sfzmhm!= null && sfzmhm!= "") {
                    Path exp0 = root.get("sfzmhm");
                    predicates.add(criteriaBuilder.like(exp0, "%" + sfzmhm + "%"));
                }
                if (xingming!=null) {
                    Path exp1 = root.get("xingming");
                    predicates.add(criteriaBuilder.like(exp1,"%" + xingming + "%"));
                }
                if (yq_qzsj!=null) {
                    Path exp1 = root.get("yq_qzsj");
                    predicates.add(criteriaBuilder.like(exp1,"%" + yq_qzsj + "%"));
                }
                Path exp2 = root.get("qztj");
                predicates.add(criteriaBuilder.equal(exp2, 1));
                Path exp3 = root.get("yq_sfqz");
                predicates.add(criteriaBuilder.equal(exp3, 1));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        persons = qzRepository.findAll(specification);
        return persons;
    }
    //未提交确诊人员组合查询
    public List<Person> selectWtj(String sfzmhm, String xingming, String yq_qzsj){
        List<Person> persons=new ArrayList<Person>();
        //jpa多条件多表查询，灵活 创建查询语句
        Specification<Person> specification=new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList();
                if (sfzmhm!= null && sfzmhm!= "") {
                    Path exp0 = root.get("sfzmhm");
                    predicates.add(criteriaBuilder.like(exp0, "%" + sfzmhm + "%"));
                }
                if (xingming!=null) {
                    Path exp1 = root.get("xingming");
                    predicates.add(criteriaBuilder.like(exp1,"%" + xingming + "%"));
                }
                if (yq_qzsj!=null) {
                    Path exp1 = root.get("yq_qzsj");
                    predicates.add(criteriaBuilder.like(exp1,"%" + yq_qzsj + "%"));
                }
                Path exp2 = root.get("qztj");
                predicates.add(criteriaBuilder.equal(exp2, 0));
                Path exp3 = root.get("yq_sfqz");
                predicates.add(criteriaBuilder.equal(exp3, 1));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        persons = qzRepository.findAll(specification);
        return persons;
    }
    //查询所有已提交确诊人员
    public List<Person> findAllYtjQueZhen(){
        List<Person> persons = qzRepository.findAllYtjQueZhen();
        if(persons != null && persons.size() !=0 ){
            return persons;
        }else {
            return null;
        }
    }
    //查询所有未提交确诊人员
    public List<Person> findAllWtjQueZhen(){
        List<Person> persons = qzRepository.findAllWtjQueZhen();
        if(persons != null && persons.size() !=0 ){
            return persons;
        }else {
            return null;
        }
    }
}
