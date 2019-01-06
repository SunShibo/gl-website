package com.gl.website.dao;

import com.gl.website.entity.bo.AdminBO;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface LoginDAO {

    AdminBO login(@Param("userName") String userName) ;

    Integer  queryUserCount(Map<String,Object>  map);
    List<AdminBO> queryAll(Map<String,Object> map);

    List<AdminBO> queryUser(int id);

    Integer updateUser(AdminBO adminBO);

    Integer addUser(AdminBO  adminBO);

    Integer delUser(Integer id);
}
