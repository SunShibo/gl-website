package com.gl.website.service;

import com.gl.website.dao.LoginDAO;
import com.gl.website.entity.bo.AdminBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("loginService")
@Transactional(rollbackFor=Exception.class)
public class LoginService {

    @Resource
    private LoginDAO loginDAO;


    public AdminBO  logion(String  userName){
        return  loginDAO.login(userName);
    }

    public Integer queryUserCount(Map<String,Object> map){
        return loginDAO.queryUserCount(map);
    }
    public  List<AdminBO> queryAll(Map<String,Object>  map){
        return loginDAO.queryAll(map);
    }

    public  List<AdminBO> queryUser(int id){
        return  loginDAO.queryUser(id);
    }

    public Integer updateUser(AdminBO  adminBO){
        return loginDAO.updateUser(adminBO);
    }

    public Integer addUser(AdminBO adminBO){
        return loginDAO.addUser(adminBO);
    }

    public Integer delUser(Integer id){
        return loginDAO.delUser(id);
    }
}
