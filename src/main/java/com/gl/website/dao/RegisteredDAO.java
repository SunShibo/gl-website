package com.gl.website.dao;

import com.gl.website.entity.bo.RegisteredBO;


import java.util.List;

public interface RegisteredDAO {
    List<RegisteredBO> getAllRegisteredMesg();
    //修改信息
    Integer updateRegistered(RegisteredBO rebo);
    //删除信息
    Integer deleteRegistered(RegisteredBO rebo);
    //增加信息
    Integer addRegistered(RegisteredBO rebo);

}
