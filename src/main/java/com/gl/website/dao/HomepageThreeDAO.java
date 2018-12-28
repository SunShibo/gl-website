package com.gl.website.dao;

import com.gl.website.entity.bo.AboutFirstBO;
import com.gl.website.entity.bo.HomepageFirstBO;
import com.gl.website.entity.bo.HomepageThreeBO;

import java.util.List;

public interface HomepageThreeDAO {
    List<HomepageThreeBO> getAllHomepageThreeMesgthree();
    //修改信息
    Integer updateHomepageThree(HomepageThreeBO hthreebo);
    //删除信息
    Integer deleteHomepageThree(HomepageThreeBO hthreebo);
    //增加信息
    Integer addHomepageThree(HomepageThreeBO hthreebo);
}
