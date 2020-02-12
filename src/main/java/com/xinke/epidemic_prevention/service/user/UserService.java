package com.xinke.epidemic_prevention.service.user;

import com.xinke.epidemic_prevention.bean.user.User;
import com.xinke.epidemic_prevention.dao.user.userRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserService userService;
    @Autowired
    userRepository userRepository;
    //使用number查询单条数据
    public User findByNumber(String number){
        User user = userRepository.findByNumber(number);
        return user;
    }

    public List<User> queryAllAdmin(){
        List<User> list = new ArrayList<>();
        List<User> allByPowerEquals = userRepository.findAllByPowerEquals("admin");
        return allByPowerEquals;
    }
    //组合查询
    public List<User> selectCheck(String number){
        List<User> userList=new ArrayList<User>();
        //jpa多条件多表查询，灵活 创建查询语句
        Specification<User> specification=new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList();

                if (number != null && number != "") {
                    Path exp1 = root.get("number");
                    predicates.add(criteriaBuilder.like(exp1, "%" + number + "%"));

                }


                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        userList = userRepository.findAll(specification);
        return userList;
    }
    //判断用户是否存在
    public boolean userExist(String number){
        boolean re = false;
        List<User> userList = userRepository.findAll();
        for(int i =0 ;i<userList.size();i++){
            User user = userList.get(i);
            if(number.equals(user.getNumber())){
                re = false;
                break;
            }else{   re = true;   }
        }
        return re;
    }
    //更新个人信息
    public void updatePersonal(User user){
        System.out.println(user.getNumber());
        User user1 = userService.findByNumber(user.getNumber());
        System.out.println(user1);
        user1.setRealname(user.getRealname());
        user1.setNumber(user.getNumber());
        user1.setPosition(user.getPosition());
        user1.setPhone(user.getPhone());
        user1.setWorkspace(user.getWorkspace());
        userRepository.save(user1);

    }


}
