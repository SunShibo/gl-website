package com.gl.website.dao;

import com.gl.website.entity.bo.AboutThreeBO;
import com.gl.website.entity.bo.DayTwoBO;

import java.util.List;

public interface AboutThreeDAO {
    //查询单条信息
    List<AboutThreeBO> getAllAboutThreeMesg();
   //修改信息
    Integer updateAboutThree(AboutThreeBO athreebo);
    //删除信息
    Integer deleteAboutThree(AboutThreeBO athreebo);
    //增加信息
    Integer addAboutThree(AboutThreeBO athreebo);
}
