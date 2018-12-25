package com.gl.website.service;

import com.gl.website.dao.*;
import com.gl.website.entity.bo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("homepageService")
@Transactional
public class HomepageService {
    @Resource
    private HomepageFirstDAO hpfDAO;
    @Resource
    private HomepageTwoDAO hptwoDao;
    @Resource
    private HomepageThreeDAO hpthreeDao;
    @Resource
    private HomepageFourDAO hpfourDao;
    @Resource
    private HomepageFiveDAO hpfiveDao;
    //查询所有信息one
    public List<HomepageFirstBO> getAllHomepageFirstMesg(){
       List<HomepageFirstBO>list= hpfDAO.getAllHomepageFirstMesg();
       return  list;
    }
    //查询所有信息two
    public List<HomepageTwoBO> getAllHomepageTwoMesg(){
        List<HomepageTwoBO>list2= hptwoDao.getAllHomepageTwoMesgtwo();
        return  list2;
    }
    //查询所有信息three
    public List<HomepageThreeBO> getAllHomepageThreeMesg(){
        List<HomepageThreeBO>list3= hpthreeDao.getAllHomepageThreeMesgthree();
        return  list3;
    }
    //查询所有信息four
    public List<HomepageFourBO> getAllHomepageFourMesg(){
        List<HomepageFourBO>list4= hpfourDao.getAllHomepageFourMesgfour();
        return  list4;
    }
    //查询所有信息five
    public List<HomepageFiveBO> getAllHomepageFiveMesg(){
        List<HomepageFiveBO>list5= hpfiveDao.getAllHomepageFiveMesgfive();
        return  list5;
    }
}
