package com.gl.website.dao;

import com.gl.website.entity.bo.AboutFirstBO;
import com.gl.website.entity.bo.HomepageFirstBO;
import com.gl.website.entity.bo.HomepageFourBO;

import java.util.List;

public interface HomepageFourDAO {
    HomepageFourBO getAllHomepageFourMesgfour();
    //修改信息
    Integer updateHomepageFour(HomepageFourBO hfourbo);
    //删除信息
    Integer deleteHomepageFour(HomepageFourBO hfourbo);
    //增加信息
    Integer addHomepageFour(HomepageFourBO hfourbo);
}
