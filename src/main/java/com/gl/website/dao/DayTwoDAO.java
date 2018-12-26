package com.gl.website.dao;

import com.gl.website.entity.bo.DayFirstBO;
import com.gl.website.entity.bo.DayTwoBO;
import com.gl.website.entity.bo.InternationTwoBO;

import java.util.List;

public interface DayTwoDAO {
    //查询单条信息
    List<DayTwoBO> getAllDayTwoMesg();
   //修改信息
    Integer updateDayTwo(DayTwoBO dtwobo);
    //删除信息
    Integer deleteDayTwo(DayTwoBO dtwobo);
    //增加信息
    Integer addDayTwo(DayTwoBO dtwobo);
}
