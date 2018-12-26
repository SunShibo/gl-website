package com.gl.website.dao;

import com.gl.website.entity.bo.HomepageFirstBO;
import com.gl.website.entity.bo.SilkroadFirstBO;

import java.util.List;

public interface SilkroadFirstDAO {
    //查询单条信息
    SilkroadFirstBO getSilkroadFirstMesg();
   //修改信息
    Integer updateSilkroadFirst(SilkroadFirstBO srfbo);
    //删除信息
    Integer deleteSilkroadFirst(SilkroadFirstBO srfbo);
    //增加信息
    Integer addSilkroadFirst(SilkroadFirstBO srfbo);
}
