package com.gl.website.dao;

import com.gl.website.entity.bo.CommunityTwoBO;
import com.gl.website.entity.bo.SilkroadFirstBO;
import com.gl.website.entity.bo.SilkroadTwoBO;

import java.util.List;

public interface CommunityTwoDAO {
    //查询单条信息
    List<CommunityTwoBO> getAllCommunityTwoMesg();
   //修改信息
    Integer updateCommunityTwo(CommunityTwoBO cytwobo);
    //删除信息
    Integer deleteCommunityTwo(CommunityTwoBO cytwobo);
    //增加信息
    Integer addCommunityTwo(CommunityTwoBO cytwobo);
}
