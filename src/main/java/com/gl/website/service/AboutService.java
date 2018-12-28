package com.gl.website.service;

import com.gl.website.dao.*;
import com.gl.website.entity.bo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("aboutService")
@Transactional
public class AboutService {
    @Resource
    private AboutFirstDAO afDAO;
    @Resource
    private AboutTwoDAO atwoDao;
    @Resource
    private AboutThreeDAO athreeDAO;
    @Resource
    private AboutFourDAO afourDao;

    //查询单条信息one
    public AboutFirstBO getAboutFirstMesg(){
        AboutFirstBO list1= afDAO.getAboutFirstMesg();
       return  list1;
    }
    //查询单条信息two
    public AboutTwoBO getAboutTwoMesg(){
        AboutTwoBO list2= atwoDao.getAboutTwoMesg();
        return  list2;
    }

    //查询所有信息three
    public List<AboutThreeBO> getAllAboutThreeMesg(){
        List<AboutThreeBO>list3= athreeDAO.getAllAboutThreeMesg();
        return  list3;
    }
    //查询单条信息foour
    public AboutFourBO getAboutFourMesg(){
        AboutFourBO list4= afourDao.getAboutFourMesg();
        return  list4;
    }
    //修改信息one
    public Integer updateAboutFirst(AboutFirstBO afbo){
       return afDAO.updateAboutFirst(afbo);
    }
    //删除信息one
    public Integer deleteAboutFirst(AboutFirstBO afbo){
        return afDAO.deleteAboutFirst(afbo);
    }
    //增加信息one
    public Integer addAboutFirst(AboutFirstBO afbo){
        return afDAO.addAboutFirst(afbo);
    }


    //修改信息two
    public Integer updateAboutTwo(AboutTwoBO atwobo){
        return atwoDao.updateAboutTwo(atwobo);
    }
    //删除信息two
    public Integer deleteAboutTwo(AboutTwoBO atwobo){
        return atwoDao.deleteAboutTwo(atwobo);
    }
    //增加信息two
    public Integer addAboutTwo(AboutTwoBO atwobo){
        return atwoDao.addAboutTwo(atwobo);
    }

    //修改信息three
    public Integer updateAboutThree(AboutThreeBO athreebo){
        return athreeDAO.updateAboutThree(athreebo);
    }
    //删除信息three
    public Integer deleteAboutThree(AboutThreeBO athreebo){
        return athreeDAO.deleteAboutThree(athreebo);
    }
    //增加信息three
    public Integer addAboutThree(AboutThreeBO athreebo){
        return athreeDAO.addAboutThree(athreebo);
    }


    //修改信息four
    public Integer updateAboutFour(AboutFourBO afourbo){
        return afourDao.updateAboutFour(afourbo);
    }
    //删除信息four
    public Integer deleteAboutFour(AboutFourBO afourbo){
        return afourDao.deleteAboutFour(afourbo);
    }
    //增加信息four
    public Integer addAboutFour(AboutFourBO afourbo){
        return afourDao.addAboutFour(afourbo);
    }


}
