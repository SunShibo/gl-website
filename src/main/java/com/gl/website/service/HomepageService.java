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
    public HomepageFirstBO getAllHomepageFirstMesg() {
        HomepageFirstBO  list = hpfDAO.getAllHomepageFirstMesg();
        return list;
    }

    //查询所有信息two
    public HomepageTwoBO getAllHomepageTwoMesg() {
        HomepageTwoBO list2 = hptwoDao.getAllHomepageTwoMesgtwo();
        return list2;
    }

    //查询所有信息three
    public List<HomepageThreeBO> getAllHomepageThreeMesg() {
        List<HomepageThreeBO> list3 = hpthreeDao.getAllHomepageThreeMesgthree();
        return list3;
    }

    //查询所有信息four
    public HomepageFourBO getAllHomepageFourMesg() {

        return  hpfourDao.getAllHomepageFourMesgfour();
    }

    //查询所有信息five
    public List<HomepageFiveBO> getAllHomepageFiveMesg() {
        List<HomepageFiveBO> list5 = hpfiveDao.getAllHomepageFiveMesgfive();
        return list5;
    }




    //修改信息one
    public Integer updateHomepageFirst(HomepageFirstBO hfbo){
        return hpfDAO.updateHomepageFirst(hfbo);
    }
    //删除信息one
    public Integer deleteHomepageFirst(HomepageFirstBO hfbo){
        return hpfDAO.deleteHomepageFirst(hfbo);
    }
    //增加信息one
    public Integer addHomepageFirst(HomepageFirstBO hfbo){
        return hpfDAO.addHomepageFirst(hfbo);
    }


    //修改信息two
    public Integer updateHomepageTwo(HomepageTwoBO htwobo){
        return hptwoDao.updateHomepageTwo(htwobo);
    }
    //删除信息two
    public Integer deleteHomepageTwo(HomepageTwoBO htwobo){
        return hptwoDao.deleteHomepageTwo(htwobo);
    }
    //增加信息two
    public Integer addHomepageTwo(HomepageTwoBO htwobo){
        return hptwoDao.addHomepageTwo(htwobo);
    }

    //修改信息three
    public Integer updateHomepageThree(HomepageThreeBO hthreebo){
        return hpthreeDao.updateHomepageThree(hthreebo);
    }
    //删除信息three
    public Integer deleteHomepageThree(HomepageThreeBO hthreebo){
        return hpthreeDao.deleteHomepageThree(hthreebo);
    }
    //增加信息three
    public Integer addHomepageThree(HomepageThreeBO hthreebo){
        return hpthreeDao.addHomepageThree(hthreebo);
    }


    //修改信息four
    public Integer updateHomepageFour(HomepageFourBO hfourbo){
        return hpfourDao.updateHomepageFour(hfourbo);
    }
    //删除信息four
    public Integer deleteHomepageFour(HomepageFourBO hfourbo){
        return hpfourDao.deleteHomepageFour(hfourbo);
    }
    //增加信息four
    public Integer addHomepageFour(HomepageFourBO hfourbo){
        return hpfourDao.addHomepageFour(hfourbo);
    }


    //修改信息five
    public Integer updateHomepageFive(HomepageFiveBO hfivebo){
        return hpfiveDao.updateHomepageFive(hfivebo);
    }
    //删除信息five
    public Integer deleteHomepageFive(HomepageFiveBO hfivebo){
        return hpfiveDao.deleteHomepageFive(hfivebo);
    }
    //增加信息five
    public Integer addHomepageFive(HomepageFiveBO hfivebo){
        return hpfiveDao.addHomepageFive(hfivebo);
    }

}
