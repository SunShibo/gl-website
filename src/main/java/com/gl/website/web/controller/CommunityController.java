package com.gl.website.web.controller;

import com.gl.website.entity.bo.CommunityFirstBO;
import com.gl.website.entity.bo.CommunityTwoBO;
import com.gl.website.entity.bo.SilkroadFirstBO;
import com.gl.website.entity.bo.SilkroadTwoBO;
import com.gl.website.entity.dto.ResultDTOBuilder;
import com.gl.website.service.CommunityService;
import com.gl.website.service.SilkroadService;
import com.gl.website.util.JsonUtils;
import com.gl.website.web.controller.base.BaseCotroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/community")
public class CommunityController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(CommunityController.class);
    @Resource
    private CommunityService communityService;

    @RequestMapping("/query")//查询
    public void query(HttpServletResponse response, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        CommunityFirstBO list1 = communityService.getCommunityFirstMesg();
        List<CommunityTwoBO> list2 = communityService.getAllCommunityTwoMesg();
        if( list1==null || list2==null||list2.size()<1 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        map.put("one", list1);
        map.put("two", list2);
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
        safeTextPrint(response, json);
    }
    @RequestMapping("/updateone")//修改one
    public void updateone(HttpServletResponse response,CommunityFirstBO cyfbo) {
        Integer count=communityService.updateCommunityFirst(cyfbo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/deleteone")//删除one
    public void deleteone(HttpServletResponse response,CommunityFirstBO cyfbo) {
        Integer count=communityService.deleteCommunityFirst(cyfbo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/addone")//增加one
    public void addtwo(HttpServletResponse response,CommunityFirstBO cyfbo) {
        Integer count=communityService.addCommunityFirst(cyfbo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }


    @RequestMapping("/updatetwo")//修改two
    public void updatetwo(HttpServletResponse response,CommunityTwoBO cytwobo) {
        Integer count=communityService.updateCommunityTwo(cytwobo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/deletetwo")//删除two
    public void deletetwo(HttpServletResponse response,CommunityTwoBO cytwobo) {
        Integer count=communityService.deleteCommunityTwo(cytwobo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/addtwo")//增加two
    public void addone(HttpServletResponse response,CommunityTwoBO cytwobo) {
        Integer count=communityService.addCommunityTwo(cytwobo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
}
