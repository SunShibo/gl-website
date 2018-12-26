package com.gl.website.dao;

import com.gl.website.entity.bo.CommunityFirstBO;
import com.gl.website.entity.bo.SilkroadFirstBO;

public interface CommunityFirstDAO {
    //查询单条信息
    CommunityFirstBO getCommunityFirstMesg();
   //修改信息
    Integer updateCommunityFirst(CommunityFirstBO cyfbo);
    //删除信息
    Integer deleteCommunityFirst(CommunityFirstBO cyfbo);
    //增加信息
    Integer addCommunityFirst(CommunityFirstBO cyfbo);
}
