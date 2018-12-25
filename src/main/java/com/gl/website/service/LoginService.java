package com.gl.website.service;

import com.gl.website.dao.LoginDAO;
import com.gl.website.entity.bo.AdminBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service("loginService")
@Transactional(rollbackFor=Exception.class)
public class LoginService {

    @Resource
    private LoginDAO loginDAO;


    public AdminBO  logion(String  userName){
        return  loginDAO.login(userName);
    }



}
