package com.gl.website.dao;

import com.gl.website.entity.bo.AboutFirstBO;
import com.gl.website.entity.bo.DayFirstBO;

public interface AboutFirstDAO {
    //查询单条信息
    AboutFirstBO getAboutFirstMesg();
   //修改信息
    Integer updateAboutFirst(AboutFirstBO afbo);
    //删除信息
    Integer deleteAboutFirst(AboutFirstBO afbo);
    //增加信息
    Integer addAboutFirst(AboutFirstBO afbo);
}
