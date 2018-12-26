package com.gl.website.service;

import com.gl.website.dao.CommunityFirstDAO;
import com.gl.website.dao.CommunityTwoDAO;
import com.gl.website.dao.SilkroadFirstDAO;
import com.gl.website.dao.SilkroadTwoDAO;
import com.gl.website.entity.bo.CommunityFirstBO;
import com.gl.website.entity.bo.CommunityTwoBO;
import com.gl.website.entity.bo.SilkroadFirstBO;
import com.gl.website.entity.bo.SilkroadTwoBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("communityService")
@Transactional
public class CommunityService {
    @Resource
    private CommunityFirstDAO cyfDAO;
    @Resource
    private CommunityTwoDAO cytwoDao;

    //查询单条信息one
    public CommunityFirstBO getCommunityFirstMesg(){
        CommunityFirstBO list1= cyfDAO.getCommunityFirstMesg();
       return  list1;
    }
    //查询所有信息two
    public List<CommunityTwoBO> getAllCommunityTwoMesg(){
        List<CommunityTwoBO>list2= cytwoDao.getAllCommunityTwoMesg();
        return  list2;
    }
    //修改信息one
    public Integer updateCommunityFirst(CommunityFirstBO cyfbo){
       return cyfDAO.updateCommunityFirst(cyfbo);
    }
    //删除信息one
    public Integer deleteCommunityFirst(CommunityFirstBO cyfbo){
        return cyfDAO.deleteCommunityFirst(cyfbo);
    }
    //增加信息one
    public Integer addCommunityFirst(CommunityFirstBO cyfbo){
        return cyfDAO.addCommunityFirst(cyfbo);
    }


    //修改信息two
    public Integer updateCommunityTwo(CommunityTwoBO cytwobo){
        return cytwoDao.updateCommunityTwo(cytwobo);
    }
    //删除信息two
    public Integer deleteCommunityTwo(CommunityTwoBO cytwobo){
        return cytwoDao.deleteCommunityTwo(cytwobo);
    }
    //增加信息two
    public Integer addCommunityTwo(CommunityTwoBO cytwobo){
        return cytwoDao.addCommunityTwo(cytwobo);
    }

}
