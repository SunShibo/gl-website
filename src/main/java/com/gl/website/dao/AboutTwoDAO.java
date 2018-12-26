package com.gl.website.dao;

import com.gl.website.entity.bo.AboutTwoBO;
import com.gl.website.entity.bo.DayFirstBO;

public interface AboutTwoDAO {
    //查询单条信息
    AboutTwoBO getAboutTwoMesg();
   //修改信息
    Integer updateAboutTwo(AboutTwoBO atwobo);
    //删除信息
    Integer deleteAboutTwo(AboutTwoBO atwobo);
    //增加信息
    Integer addAboutTwo(AboutTwoBO atwobo);
}
