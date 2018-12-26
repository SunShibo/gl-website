package com.gl.website.service;

import com.gl.website.dao.*;
import com.gl.website.entity.bo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("silkroadService")
@Transactional
public class SilkroadService {
    @Resource
    private SilkroadFirstDAO srfDAO;
    @Resource
    private SilkroadTwoDAO srtwoDao;

    //查询单条信息one
    public SilkroadFirstBO getSilkroadFirstMesg(){
        SilkroadFirstBO list1= srfDAO.getSilkroadFirstMesg();
       return  list1;
    }
    //查询所有信息two
    public List<SilkroadTwoBO> getAllSilkroadTwoMesg(){
        List<SilkroadTwoBO>list2= srtwoDao.getAllSilkroadTwoMesg();
        return  list2;
    }
    //修改信息one
    public Integer updateSilkroadFirst(SilkroadFirstBO srfbo){
       return srfDAO.updateSilkroadFirst(srfbo);
    }
    //删除信息one
    public Integer deleteSilkroadFirst(SilkroadFirstBO srfbo){
        return srfDAO.deleteSilkroadFirst(srfbo);
    }
    //增加信息one
    public Integer addSilkroadFirst(SilkroadFirstBO srfbo){
        return srfDAO.addSilkroadFirst(srfbo);
    }


    //修改信息two
    public Integer updateSilkroadTwo(SilkroadTwoBO srtwobo){
        return srtwoDao.updateSilkroadTwo(srtwobo);
    }
    //删除信息two
    public Integer deleteSilkroadTwo(SilkroadTwoBO srtwobo){
        return srtwoDao.deleteSilkroadTwo(srtwobo);
    }
    //增加信息two
    public Integer addSilkroadTwo(SilkroadTwoBO srtwobo){
        return srtwoDao.addSilkroadTwo(srtwobo);
    }

}
