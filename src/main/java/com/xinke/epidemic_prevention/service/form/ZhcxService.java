package com.xinke.epidemic_prevention.service.form;

import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.bean.user.User;
import com.xinke.epidemic_prevention.dao.common.QzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
@Service
public class ZhcxService {
    @Autowired
    QzRepository qzRepository;
    //组合查询
    public List<Person> selectCheck(String xingming,String sfzmhm,String yq_sfqz,String ksqz,String jsqz,String szqy,String sfqwhb,String sfcy,String sfsw,String sfmj){
        List<Person> userList=new ArrayList<Person>();
        //jpa多条件多表查询，灵活 创建查询语句
        Specification<Person> specification=new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList();

                if (xingming != null && xingming != "") {
                    Path exp1 = root.get("xingming");
                    predicates.add(criteriaBuilder.like(exp1, "%" + xingming + "%"));

                }
                if (sfzmhm != null && sfzmhm != "") {
                    Path exp1 = root.get("sfzmhm");
                    predicates.add(criteriaBuilder.like(exp1, "%" + sfzmhm + "%"));

                }
                if (yq_sfqz != null ) {

                    Path exp1 = root.get("yq_sfqz");

                    predicates.add(criteriaBuilder.equal(exp1,  yq_sfqz ));



                }
                if (ksqz != null && ksqz !=""&& jsqz!=null&&jsqz!="") {
                    Path exp1 = root.get("yq_qzsj");
                    predicates.add(criteriaBuilder.between(exp1,ksqz,jsqz));

                }
                if (szqy != null && szqy != "") {
                    Path exp1 = root.get("xzxq");
                    predicates.add(criteriaBuilder.like(exp1, "%" + szqy + "%"));

                }
                if (sfqwhb != null ) {
                    Path exp1 = root.get("yq_sfcwwh");
                    predicates.add(criteriaBuilder.equal(exp1,  sfqwhb ));

                }
                if (sfcy != null ) {
                    Path exp1 = root.get("yq_sfcy");
                    predicates.add(criteriaBuilder.equal(exp1,  sfcy));

                }
                if (sfsw != null ) {
                    Path exp1 = root.get("yq_sfsw");
                    predicates.add(criteriaBuilder.equal(exp1, sfsw ));

                }
                if (sfmj != null ) {
                    Path exp1 = root.get("sfmjry");
                    predicates.add(criteriaBuilder.equal(exp1,  sfmj ));

                }





                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        userList = qzRepository.findAll(specification);
        return userList;
    }
}
