package com.gl.website.dao;

import com.gl.website.entity.bo.DayFirstBO;
import com.gl.website.entity.bo.InternationFirstBO;

public interface DayFirstDAO {
    //查询单条信息
    DayFirstBO getDayFirstMesg();
   //修改信息
    Integer updateDayFirst(DayFirstBO dfbo);
    //删除信息
    Integer deleteDayFirst(DayFirstBO dfbo);
    //增加信息
    Integer addDayFirst(DayFirstBO dfbo);
}
