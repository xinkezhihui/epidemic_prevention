package com.xinke.epidemic_prevention.dao.user;

import com.xinke.epidemic_prevention.bean.user.User;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface userRepository extends JpaRepository<User,Integer> {
    //通过用户名查找用户信息
    public User findByNumber(String number);

    public List<User> findAllByPowerEquals(String power);
    //查询管理员
    @Query(value = "select * from ALL_USER_User where power='admin' or power='super'",nativeQuery=true)
    public List<User> findByPower();


    List<User> findAll(Specification<User> specification);
    //根据number删除账号
    @Modifying
    @Transactional
    @Query(value = "delete from ALL_USER_User where number=?1 ",nativeQuery=true)
    public void deleteByNumber(String number);
    //查找所有用户
    public List<User> findAll();




}
