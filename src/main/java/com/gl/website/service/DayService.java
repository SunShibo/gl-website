package com.gl.website.service;

import com.gl.website.dao.DayFirstDAO;
import com.gl.website.dao.DayTwoDAO;
import com.gl.website.dao.InternationFirstDAO;
import com.gl.website.dao.InternationTwoDAO;
import com.gl.website.entity.bo.DayFirstBO;
import com.gl.website.entity.bo.DayTwoBO;
import com.gl.website.entity.bo.InternationFirstBO;
import com.gl.website.entity.bo.InternationTwoBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("dayService")
@Transactional
public class DayService {
    @Resource
    private DayFirstDAO dfDAO;
    @Resource
    private DayTwoDAO dtwoDao;

    //查询单条信息one
    public DayFirstBO getDayFirstMesg(){
        DayFirstBO list1= dfDAO.getDayFirstMesg();
       return  list1;
    }
    //查询所有信息two
    public List<DayTwoBO> getAllInternationTwoMesg(){
        List<DayTwoBO>list2= dtwoDao.getAllDayTwoMesg();
        return  list2;
    }
    //修改信息one
    public Integer updateDayFirst(DayFirstBO dfbo){
       return dfDAO.updateDayFirst(dfbo);
    }
    //删除信息one
    public Integer deleteDayFirst(DayFirstBO dfbo){
        return dfDAO.deleteDayFirst(dfbo);
    }
    //增加信息one
    public Integer addDayFirst(DayFirstBO dfbo){
        return dfDAO.addDayFirst(dfbo);
    }


    //修改信息two
    public Integer updateDayTwo(DayTwoBO dtwobo){
        return dtwoDao.updateDayTwo(dtwobo);
    }
    //删除信息two
    public Integer deleteDayTwo(DayTwoBO dtwobo){
        return dtwoDao.deleteDayTwo(dtwobo);
    }
    //增加信息two
    public Integer addDayTwo(DayTwoBO dtwobo){
        return dtwoDao.addDayTwo(dtwobo);
    }

}
