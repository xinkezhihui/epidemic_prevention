package com.xinke.epidemic_prevention.service.hospital;

import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.bean.user.User;
import com.xinke.epidemic_prevention.dao.hospital.HospitalRepository;
import com.xinke.epidemic_prevention.dao.user.userRepository;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author:jlz
 * @Date: 2020/2/7
 * 路径： com.xinke.epidemic_prevention.service.hospital
 * 功能描述：医院部分的Service
 */
@Service
public class HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    private userRepository ur;
    /**
     * @author: jlz
     * 功能描述：查询
     */
    public List<Person> findAllHospInfo(){
        List<Person> List = hospitalRepository.findAll();
        if (List != null && List.size() != 0) {
            return List;
        }else{
            return null;
        }
    }
    /**
     * @author: jlz
     * 功能描述：通过id查询是否存在
     */
    public boolean AgrInfoIsExistsById(int id){
        boolean bl = hospitalRepository.existsById(id);
        if (bl) {
            return true;
        } else {
            return false;
        }
    }
    public Person addPerson(Person person){
        Person save = hospitalRepository.save(person);
        return save;
    }
    //查询用户是否存在
    public boolean numberExist(String Sfzmhm){
        boolean re = true;
        List<Person> personList = hospitalRepository.findAll();
        for(int i = 0 ;i < personList.size() ;i++){
            Person person = personList.get(i);
            if(Sfzmhm.equals(person.getSfzmhm())){
                re = false;
                break;
            }else {
                re = true;
            }
        }
        return re;
    }
    /**
     * @author: WRR
     * 功能描述：疑似病例信息修改
     */
    //修改密接人员信息
    public boolean updateYs(String sfzmhm, String xzsf, String xzdjs, String xzxq, String ssbsc, String rqfl, String xingming, String lxdh, String xxdz, Integer yq_sfcwwh, Integer yq_sfczqtsf, String yq_zhumingsf,String binganhao, Integer yq_sfmjfb, String mjren, Integer yq_sfzz,Integer yq_sfwzz) {
        Person person = hospitalRepository.findBySfzmhm(sfzmhm);
        person.setXzsf(xzsf);
        person.setXzdjs(xzdjs);
        person.setXzxq(xzxq);
        person.setSsbsc(ssbsc);
        person.setRqfl(rqfl);
        person.setXingming(xingming);
        person.setLxdh(lxdh);
        person.setXxdz(xxdz);
        person.setYq_sfcwwh(yq_sfcwwh);
        person.setYq_sfczqtsf(yq_sfczqtsf);
        person.setYq_zhumingsf(yq_zhumingsf);
        person.setBinganhao(binganhao);
        person.setYq_sfmjfb(yq_sfmjfb);
        person.setMjren(mjren);
        person.setYq_sfzz(yq_sfzz);
        person.setYq_sfwzz(yq_sfwzz);
        Person save = hospitalRepository.save(person);
        if (save != null) {
            return true;
        }else
            return false;
    }
    /**
     * @author: WRR
     * 功能描述：确诊疑似病例
     */
    public Boolean ysQueZhen(String sfzmhm){
        Person person = hospitalRepository.findBySfzmhm(sfzmhm);
        if(person!=null){
            person.setYq_sfys(0);
            person.setYq_sfqz(1);
            person.setQztj(0);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String yq_qzsj = df.format(new Date());
            person.setYq_qzsj(yq_qzsj);
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            User user1 = ur.findByNumber(user.getNumber());
            String qz_userID = String.valueOf(user1.getId());
            person.setQz_userID(qz_userID);
            hospitalRepository.flush();
            return true;
        }else
            return false;
    }
    /**
     * @author: WRR
     * 功能描述：排除疑似病例
     */
    public Boolean ysPaiChu(String sfzmhm){
        Person person = hospitalRepository.findBySfzmhm(sfzmhm);
        if(person!=null){
            person.setYq_sfys(0);
            hospitalRepository.flush();
            return true;
        }else
            return false;
    }
    /**
     * @author: WRR
     * 功能描述：提交疑似病例
     */
    public Boolean ysSubmit(String sfzmhm){
        Person person = hospitalRepository.findBySfzmhm(sfzmhm);
        if(person!=null){
            person.setYstj(1);
            hospitalRepository.flush();
            return true;
        }else
            return false;
    }
    /**
     * @author: WRR
     * 功能描述：根据sfzmhm返回person信息
     */
    public Person personInfo(String sfzmhm){
        return hospitalRepository.findBySfzmhm(sfzmhm);
    }
    /**
     * @author: WRR
     * 功能描述：查看所有已提交疑似人员
     */
    public List<Person> findAllSubmitYsInfoByYstj(){
        List<Person> ysPerson = hospitalRepository.findAllSubmitYsInfoByYstj();
        if(ysPerson != null && ysPerson.size() !=0 ){
            return ysPerson;
        }else {
            return null;
        }
    }
    /**
     * @author: WRR
     * 功能描述：查看所有未提交疑似人员
     */
    public List<Person> findAllYsInfoByYstj(){
        List<Person> ysPerson = hospitalRepository.findAllYsInfoByYstj();
        if(ysPerson != null && ysPerson.size() !=0 ){
            return ysPerson;
        }else {
            return null;
        }
    }
    /**
     * @author: WRR
     * 功能描述：添加疑似案例只改变ystj、yq_sfys
     */
    public boolean changeYs(String sfzmhm){
        Person person = personInfo(sfzmhm);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String yq_yszdrq = df.format(new Date());
        person.setYq_yszdrq(yq_yszdrq);
        person.setYstj(0);
        person.setYq_sfys(1);
        Person save = hospitalRepository.save(person);
        if(save != null) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * @author: WRR
     * 功能描述：已有数据变疑似病例
     */
    public boolean addChangeYiSi(String sfzmhm, String xzsf, String xzdjs, String xzxq, String ssbsc, String rqfl, String xingming, String lxdh, String xxdz, Integer yq_sfcwwh, Integer yq_sfczqtsf, String yq_zhumingsf,String binganhao, Integer yq_sfmjfb, String mjren, Integer yq_sfzz,Integer yq_sfwzz){
        Person save = null;
        try {
            Person person = personInfo(sfzmhm);
            person.setXzsf(xzsf);
            person.setXzdjs(xzdjs);
            person.setXzxq(xzxq);
            person.setSsbsc(ssbsc);
            person.setRqfl(rqfl);
            person.setXingming(xingming);
            person.setLxdh(lxdh);
            person.setXxdz(xxdz);
            person.setYq_sfcwwh(yq_sfcwwh);
            person.setYq_sfczqtsf(yq_sfczqtsf);
            person.setYq_zhumingsf(yq_zhumingsf);
            person.setBinganhao(binganhao);
            person.setYq_sfmjfb(yq_sfmjfb);
            person.setMjren(mjren);
            person.setYq_sfzz(yq_sfzz);
            person.setYq_sfwzz(yq_sfwzz);
            person.setYstj(0);
            person.setYq_sfys(1);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String yq_yszdrq = df.format(new Date());
            person.setYq_yszdrq(yq_yszdrq);
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            User user1 = ur.findByNumber(user.getNumber());
            String ys_userID = String.valueOf(user1.getId());
            person.setYs_userID(ys_userID);
            save = hospitalRepository.save(person);
        } catch (Exception e) {
            return false;
        }
        if(save != null) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * @author: WRR
     * 功能描述：添加新疑似病例
     */
    public boolean addYiSi(String sfzmhm, String xzsf, String xzdjs, String xzxq, String ssbsc, String rqfl, String xingming, String lxdh, String xxdz, Integer yq_sfcwwh, Integer yq_sfczqtsf, String yq_zhumingsf,String binganhao, Integer yq_sfmjfb, String mjren, Integer yq_sfzz,Integer yq_sfwzz){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String yq_yszdrq = df.format(new Date());
        int qztj = 0;
        int mjtj = 0;
        int ystj = 0;
        int yq_sfys = 1;
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        User user1 = ur.findByNumber(user.getNumber());
        String ys_userID = String.valueOf(user1.getId());
        Person person = new Person(sfzmhm,xzsf,xzdjs,xzxq,ssbsc,rqfl,xingming,lxdh,xxdz,yq_sfcwwh,yq_sfczqtsf,yq_zhumingsf,binganhao,yq_sfmjfb,mjren,yq_sfzz,yq_sfwzz,ystj,qztj,mjtj,ys_userID,yq_sfys,yq_yszdrq);
        Person save = hospitalRepository.save(person);
        if(save != null) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * @author: WRR
     * 功能描述：根据sfzmhm查询数据是否存在
     */
    public boolean infoIsExists(String sfzmhm){
        return hospitalRepository.existsBySfzmhm(sfzmhm);
    }
}
