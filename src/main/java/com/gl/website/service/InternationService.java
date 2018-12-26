package com.gl.website.service;

import com.gl.website.dao.CommunityFirstDAO;
import com.gl.website.dao.CommunityTwoDAO;
import com.gl.website.dao.InternationFirstDAO;
import com.gl.website.dao.InternationTwoDAO;
import com.gl.website.entity.bo.CommunityFirstBO;
import com.gl.website.entity.bo.CommunityTwoBO;
import com.gl.website.entity.bo.InternationFirstBO;
import com.gl.website.entity.bo.InternationTwoBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("internationService")
@Transactional
public class InternationService {
    @Resource
    private InternationFirstDAO infDAO;
    @Resource
    private InternationTwoDAO intwoDao;

    //查询单条信息one
    public InternationFirstBO getInternationFirstMesg(){
        InternationFirstBO list1= infDAO.getInternationFirstMesg();
       return  list1;
    }
    //查询所有信息two
    public List<InternationTwoBO> getAllInternationTwoMesg(){
        List<InternationTwoBO>list2= intwoDao.getAllInternationTwoMesg();
        return  list2;
    }
    //修改信息one
    public Integer updateInternationFirst(InternationFirstBO infbo){
       return infDAO.updateInternationFirst(infbo);
    }
    //删除信息one
    public Integer deleteInternationFirst(InternationFirstBO infbo){
        return infDAO.deleteInternationFirst(infbo);
    }
    //增加信息one
    public Integer addInternationFirst(InternationFirstBO infbo){
        return infDAO.addInternationFirst(infbo);
    }


    //修改信息two
    public Integer updateInternationTwo(InternationTwoBO intwobo){
        return intwoDao.updateInternationTwo(intwobo);
    }
    //删除信息two
    public Integer deleteInternationTwo(InternationTwoBO intwobo){
        return intwoDao.deleteInternationTwo(intwobo);
    }
    //增加信息two
    public Integer addInternationTwo(InternationTwoBO intwobo){
        return intwoDao.addInternationTwo(intwobo);
    }

}
