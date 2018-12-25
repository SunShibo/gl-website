package com.gl.website.dao;

import com.gl.website.entity.bo.AdminBO;
import org.apache.ibatis.annotations.Param;


public interface LoginDAO {

    AdminBO login(@Param("userName") String userName) ;


}
