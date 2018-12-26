package com.gl.website.dao;

import com.gl.website.entity.bo.CommunityFirstBO;
import com.gl.website.entity.bo.InternationFirstBO;

public interface InternationFirstDAO {
    //查询单条信息
    InternationFirstBO getInternationFirstMesg();
   //修改信息
    Integer updateInternationFirst(InternationFirstBO infbo);
    //删除信息
    Integer deleteInternationFirst(InternationFirstBO infbo);
    //增加信息
    Integer addInternationFirst(InternationFirstBO infbo);
}
