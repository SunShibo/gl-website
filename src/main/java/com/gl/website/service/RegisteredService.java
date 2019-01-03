package com.gl.website.service;

import com.gl.website.dao.RegisteredDAO;
import com.gl.website.dao.SilkroadFirstDAO;
import com.gl.website.dao.SilkroadTwoDAO;
import com.gl.website.entity.bo.RegisteredBO;
import com.gl.website.entity.bo.SilkroadFirstBO;
import com.gl.website.entity.bo.SilkroadTwoBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("registeredService")
@Transactional
public class RegisteredService {
    @Resource
    private RegisteredDAO reDAO;



    //查询所有信息one
    public List<RegisteredBO> getAllRegisteredMesg(){
        List<RegisteredBO>list1= reDAO.getAllRegisteredMesg();
        return  list1;
    }
    //修改信息one
    public Integer updateRegistered(RegisteredBO rebo){
       return reDAO.updateRegistered(rebo);
    }
    //删除信息one
    public Integer deleteRegistered(RegisteredBO rebo){
        return reDAO.deleteRegistered(rebo);
    }
    //增加信息one
    public Integer addRegistered(RegisteredBO rebo){
        return reDAO.addRegistered(rebo);
    }



}