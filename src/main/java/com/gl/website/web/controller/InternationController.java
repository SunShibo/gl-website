package com.gl.website.web.controller;

import com.gl.website.entity.bo.CommunityFirstBO;
import com.gl.website.entity.bo.CommunityTwoBO;
import com.gl.website.entity.bo.InternationFirstBO;
import com.gl.website.entity.bo.InternationTwoBO;
import com.gl.website.entity.dto.ResultDTOBuilder;
import com.gl.website.service.CommunityService;
import com.gl.website.service.InternationService;
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
@RequestMapping("/internation")
public class InternationController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(InternationController.class);
    @Resource
    private InternationService internationService;

    @RequestMapping("/query")//查询
    public void query(HttpServletResponse response, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        InternationFirstBO list1 = internationService.getInternationFirstMesg();
        List<InternationTwoBO> list2 = internationService.getAllInternationTwoMesg();
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
    public void updateone(HttpServletResponse response,InternationFirstBO infbo) {
        if (infbo==null||infbo.getId() == null || infbo.getId() == 0 ) {
            return;
        }
        if( infbo.getContent()==null && infbo.getCreateTime()==null && infbo.getCreateUser()==null && infbo.getImage()==null &&
                infbo.getIntroduce()==null &&infbo.getPictureSort()==null &&infbo.getSource()==null &&infbo.getSubtitle()==null &&
                infbo.getTitle()==null &&infbo.getUpdateTime()==null &&infbo.getUpdateUser()==null &&infbo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = internationService.updateInternationFirst(infbo);
            if (count == 0) {
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                safeTextPrint(response, json);
                return;
            }
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
            safeTextPrint(response, json);
        }
    }
    @RequestMapping("/deleteone")//删除one
    public void deleteone(HttpServletResponse response,InternationFirstBO infbo) {
        if (infbo==null||infbo.getId() == null || infbo.getId() == 0 ) {
            return;
        }
        Integer count=internationService.deleteInternationFirst(infbo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/addone")//增加one
    public void addtwo(HttpServletResponse response,InternationFirstBO infbo) {
        if(infbo==null){
            return;
        }
        if( infbo.getContent()==null && infbo.getCreateTime()==null && infbo.getCreateUser()==null && infbo.getImage()==null &&
                infbo.getIntroduce()==null &&infbo.getPictureSort()==null &&infbo.getSource()==null &&infbo.getSubtitle()==null &&
                infbo.getTitle()==null &&infbo.getUpdateTime()==null &&infbo.getUpdateUser()==null &&infbo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = internationService.addInternationFirst(infbo);
            if (count == 0) {
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                safeTextPrint(response, json);
                return;
            }
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
            safeTextPrint(response, json);
        }
    }


    @RequestMapping("/updatetwo")//修改two
    public void updatetwo(HttpServletResponse response,InternationTwoBO intwobo) {
        if (intwobo==null||intwobo.getId() == null || intwobo.getId() == 0 ) {
            return;
        }
        if( intwobo.getContent()==null && intwobo.getCreateTime()==null && intwobo.getCreateUser()==null && intwobo.getImage()==null &&
                intwobo.getIntroduce()==null &&intwobo.getPictureSort()==null &&intwobo.getSource()==null &&intwobo.getSubtitle()==null &&
                intwobo.getTitle()==null &&intwobo.getUpdateTime()==null &&intwobo.getUpdateUser()==null &&intwobo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = internationService.updateInternationTwo(intwobo);
            if (count == 0) {
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                safeTextPrint(response, json);
                return;
            }
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
            safeTextPrint(response, json);
        }
    }
    @RequestMapping("/deletetwo")//删除two
    public void deletetwo(HttpServletResponse response,InternationTwoBO intwobo) {
        if (intwobo==null||intwobo.getId() == null || intwobo.getId() == 0 ) {
            return;
        }
        Integer count=internationService.deleteInternationTwo(intwobo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/addtwo")//增加two
    public void addone(HttpServletResponse response,InternationTwoBO intwobo) {
        if(intwobo==null){
            return;
        }
        if( intwobo.getContent()==null && intwobo.getCreateTime()==null && intwobo.getCreateUser()==null && intwobo.getImage()==null &&
                intwobo.getIntroduce()==null &&intwobo.getPictureSort()==null &&intwobo.getSource()==null &&intwobo.getSubtitle()==null &&
                intwobo.getTitle()==null &&intwobo.getUpdateTime()==null &&intwobo.getUpdateUser()==null &&intwobo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = internationService.addInternationTwo(intwobo);
            if (count == 0) {
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                safeTextPrint(response, json);
                return;
            }
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
            safeTextPrint(response, json);
        }
    }
}
