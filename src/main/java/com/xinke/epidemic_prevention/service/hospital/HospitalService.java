package com.xinke.epidemic_prevention.service.hospital;

import com.xinke.epidemic_prevention.bean.Person;
import com.xinke.epidemic_prevention.dao.hospital.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
