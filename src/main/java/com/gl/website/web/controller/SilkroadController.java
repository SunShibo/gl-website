package com.gl.website.web.controller;

import com.gl.website.entity.bo.*;
import com.gl.website.entity.dto.ResultDTOBuilder;
import com.gl.website.service.HomepageService;
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
@RequestMapping("/silkroad")
public class SilkroadController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(SilkroadController.class);
    @Resource
    private SilkroadService silkroadService;

    @RequestMapping("/query")//查询
    public void query(HttpServletResponse response, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        SilkroadFirstBO list1 = silkroadService.getSilkroadFirstMesg();
        List<SilkroadTwoBO> list2 = silkroadService.getAllSilkroadTwoMesg();
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
    public void updateone(HttpServletResponse response,SilkroadFirstBO srfbo) {
        if (srfbo==null||srfbo.getId() == null || srfbo.getId() == 0 ) {
            return;
        }
        if( srfbo.getContent()==null && srfbo.getCreateTime()==null && srfbo.getCreateUser()==null && srfbo.getImage()==null &&
                srfbo.getIntroduce()==null &&srfbo.getPictureSort()==null &&srfbo.getSource()==null &&srfbo.getSubtitle()==null &&
                srfbo.getTitle()==null &&srfbo.getUpdateTime()==null &&srfbo.getUpdateUser()==null &&srfbo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = silkroadService.updateSilkroadFirst(srfbo);
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
    public void deleteone(HttpServletResponse response,SilkroadFirstBO srfbo) {
        if (srfbo==null||srfbo.getId() == null || srfbo.getId() == 0 ) {
            return;
        }
        Integer count=silkroadService.deleteSilkroadFirst(srfbo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/addone")//增加one
    public void addtwo(HttpServletResponse response,SilkroadFirstBO srfbo) {
        if(srfbo==null){
            return;
        }
        if( srfbo.getContent()==null && srfbo.getCreateTime()==null && srfbo.getCreateUser()==null && srfbo.getImage()==null &&
                srfbo.getIntroduce()==null &&srfbo.getPictureSort()==null &&srfbo.getSource()==null &&srfbo.getSubtitle()==null &&
                srfbo.getTitle()==null &&srfbo.getUpdateTime()==null &&srfbo.getUpdateUser()==null &&srfbo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = silkroadService.addSilkroadFirst(srfbo);
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
    public void updatetwo(HttpServletResponse response,SilkroadTwoBO srtwobo) {
        if (srtwobo==null||srtwobo.getId() == null || srtwobo.getId() == 0 ) {
            return;
        }
        if( srtwobo.getContent()==null && srtwobo.getCreateTime()==null && srtwobo.getCreateUser()==null && srtwobo.getImage()==null &&
                srtwobo.getIntroduce()==null &&srtwobo.getPictureSort()==null &&srtwobo.getSource()==null &&srtwobo.getSubtitle()==null &&
                srtwobo.getTitle()==null &&srtwobo.getUpdateTime()==null &&srtwobo.getUpdateUser()==null &&srtwobo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = silkroadService.updateSilkroadTwo(srtwobo);
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
    public void deletetwo(HttpServletResponse response,SilkroadTwoBO srtwobo) {
        if (srtwobo==null||srtwobo.getId() == null || srtwobo.getId() == 0 ) {
            return;
        }
        Integer count=silkroadService.deleteSilkroadTwo(srtwobo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/addtwo")//增加two
    public void addone(HttpServletResponse response,SilkroadTwoBO srtwobo) {
        if(srtwobo==null){
            return;
        }
        if( srtwobo.getContent()==null && srtwobo.getCreateTime()==null && srtwobo.getCreateUser()==null && srtwobo.getImage()==null &&
                srtwobo.getIntroduce()==null &&srtwobo.getPictureSort()==null &&srtwobo.getSource()==null &&srtwobo.getSubtitle()==null &&
                srtwobo.getTitle()==null &&srtwobo.getUpdateTime()==null &&srtwobo.getUpdateUser()==null &&srtwobo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = silkroadService.addSilkroadTwo(srtwobo);
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
