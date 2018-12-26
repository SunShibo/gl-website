package com.gl.website.dao;

import com.gl.website.entity.bo.CommunityFirstBO;
import com.gl.website.entity.bo.InternationTwoBO;

import java.util.List;

public interface InternationTwoDAO {
    //查询单条信息
    List<InternationTwoBO> getAllInternationTwoMesg();
   //修改信息
    Integer updateInternationTwo(InternationTwoBO intwobo);
    //删除信息
    Integer deleteInternationTwo(InternationTwoBO intwobo);
    //增加信息
    Integer addInternationTwo(InternationTwoBO intwobo);
}
