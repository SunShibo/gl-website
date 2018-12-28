package com.gl.website.dao;

import com.gl.website.entity.bo.AboutFirstBO;
import com.gl.website.entity.bo.HomepageFirstBO;

import java.util.List;

public interface HomepageFirstDAO {
    HomepageFirstBO getAllHomepageFirstMesg();
    //修改信息
    Integer updateHomepageFirst(HomepageFirstBO hfbo);
    //删除信息
    Integer deleteHomepageFirst(HomepageFirstBO hfbo);
    //增加信息
    Integer addHomepageFirst(HomepageFirstBO hfbo);
}
