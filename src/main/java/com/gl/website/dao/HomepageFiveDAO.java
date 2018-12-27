package com.gl.website.dao;

import com.gl.website.entity.bo.AboutFirstBO;
import com.gl.website.entity.bo.HomepageFirstBO;
import com.gl.website.entity.bo.HomepageFiveBO;

import java.util.List;

public interface HomepageFiveDAO {
    List<HomepageFiveBO> getAllHomepageFiveMesgfive();
    //修改信息
    Integer updateHomepageFive(HomepageFiveBO hfivebo);
    //删除信息
    Integer deleteHomepageFive(HomepageFiveBO hfivebo);
    //增加信息
    Integer addHomepageFive(HomepageFiveBO hfivebo);
}
