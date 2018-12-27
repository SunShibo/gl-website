package com.gl.website.dao;

import com.gl.website.entity.bo.AboutFirstBO;
import com.gl.website.entity.bo.HomepageFirstBO;
import com.gl.website.entity.bo.HomepageTwoBO;

import java.util.List;

public interface HomepageTwoDAO {
    HomepageTwoBO getAllHomepageTwoMesgtwo();
    //修改信息
    Integer updateHomepageTwo(HomepageTwoBO htwobo);
    //删除信息
    Integer deleteHomepageTwo(HomepageTwoBO htwobo);
    //增加信息
    Integer addHomepageTwo(HomepageTwoBO htwobo);
}
