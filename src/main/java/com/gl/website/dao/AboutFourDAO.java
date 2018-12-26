package com.gl.website.dao;

import com.gl.website.entity.bo.AboutFourBO;
import com.gl.website.entity.bo.DayFirstBO;

public interface AboutFourDAO {
    //查询单条信息
    AboutFourBO getAboutFourMesg();
   //修改信息
    Integer updateAboutFour(AboutFourBO afourbo);
    //删除信息
    Integer deleteAboutFour(AboutFourBO afourbo);
    //增加信息
    Integer addAboutFour(AboutFourBO afourbo);
}
