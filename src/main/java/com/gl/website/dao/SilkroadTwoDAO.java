package com.gl.website.dao;

import com.gl.website.entity.bo.HomepageFirstBO;
import com.gl.website.entity.bo.SilkroadFirstBO;
import com.gl.website.entity.bo.SilkroadTwoBO;

import java.util.List;

public interface SilkroadTwoDAO {
    List<SilkroadTwoBO> getAllSilkroadTwoMesg();
    //修改信息
    Integer updateSilkroadTwo(SilkroadTwoBO srtwobo);
    //删除信息
    Integer deleteSilkroadTwo(SilkroadTwoBO srtwobo);
    //增加信息
    Integer addSilkroadTwo(SilkroadTwoBO srtwobo);

}
