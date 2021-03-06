package com.gl.website.web.controller;

import com.gl.website.entity.bo.*;
import com.gl.website.service.HomepageService;
import com.gl.website.entity.dto.ResultDTOBuilder;
import com.gl.website.util.JsonUtils;
import com.gl.website.util.ParamVerifyUtil;
import com.gl.website.web.controller.base.BaseCotroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/homepage")
public class HomepageController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(HomepageController.class);
    @Resource
    private HomepageService homepageService;

    @RequestMapping("/query")//查询
    public void query(HttpServletResponse response, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        HomepageFirstBO homeModel1 = homepageService.getAllHomepageFirstMesg();
        HomepageTwoBO homeModel2 = homepageService.getAllHomepageTwoMesg();
        List<HomepageThreeBO> homeModel3 = homepageService.getAllHomepageThreeMesg();
        HomepageFourBO  homeModel4 = homepageService.getAllHomepageFourMesg();
        List<HomepageFiveBO> homeModel5 = homepageService.getAllHomepageFiveMesg();
        if( homeModel1==null || homeModel2==null||homeModel3==null ||homeModel3.size()<1 || homeModel4==null||homeModel5==null ||homeModel5.size()<1 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        map.put("homeModel1", homeModel1);
        map.put("homeModel2", homeModel2);
        map.put("homeModel3", homeModel3);
        map.put("homeModel4", homeModel4);
        map.put("homeModel5", homeModel5);
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
        safeTextPrint(response, json);
    }



    @RequestMapping("/updateone")//修改one
    public void updateone(HttpServletResponse response,HomepageFirstBO hfbo) {
        if (hfbo==null||hfbo.getId() == null || hfbo.getId() == 0 ) {
            return;
        }
        if( hfbo.getContent()==null && hfbo.getCreateTime()==null && hfbo.getCreateUser()==null && hfbo.getImage()==null &&
                hfbo.getIntroduce()==null &&hfbo.getPictureSort()==null &&hfbo.getSource()==null &&hfbo.getSubtitle()==null &&
                hfbo.getTitle()==null &&hfbo.getUpdateTime()==null &&hfbo.getUpdateUser()==null &&hfbo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = homepageService.updateHomepageFirst(hfbo);
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
    public void deleteone(HttpServletResponse response,HomepageFirstBO hfbo) {
        if (hfbo==null||hfbo.getId() == null || hfbo.getId() == 0 ) {
            return;
        }
            Integer count = homepageService.deleteHomepageFirst(hfbo);
            if (count == 0) {
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                safeTextPrint(response, json);
                return;
            }
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
            safeTextPrint(response, json);

    }
    @RequestMapping("/addone")//增加one
    public void addone(HttpServletResponse response,HomepageFirstBO hfbo) {
        if(hfbo==null){
            return;
        }
        if( hfbo.getContent()==null && hfbo.getCreateTime()==null && hfbo.getCreateUser()==null && hfbo.getImage()==null &&
              hfbo.getIntroduce()==null &&hfbo.getPictureSort()==null &&hfbo.getSource()==null &&hfbo.getSubtitle()==null &&
                hfbo.getTitle()==null &&hfbo.getUpdateTime()==null &&hfbo.getUpdateUser()==null &&hfbo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = homepageService.addHomepageFirst(hfbo);
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
    public void updatetwo(HttpServletResponse response,HomepageTwoBO htwobo) {
        if (htwobo==null||htwobo.getId() == null || htwobo.getId() == 0 ) {
            return;
        }
        if( htwobo.getContent()==null && htwobo.getCreateTime()==null && htwobo.getCreateUser()==null && htwobo.getImage()==null &&
                htwobo.getIntroduce()==null &&htwobo.getPictureSort()==null &&htwobo.getSource()==null &&htwobo.getSubtitle()==null &&
                htwobo.getTitle()==null &&htwobo.getUpdateTime()==null &&htwobo.getUpdateUser()==null &&htwobo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = homepageService.updateHomepageTwo(htwobo);
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
    public void deletetwo(HttpServletResponse response,HomepageTwoBO htwobo) {
        if (htwobo==null||htwobo.getId() == null || htwobo.getId() == 0 ) {
            return;
        }
        Integer count=homepageService.deleteHomepageTwo(htwobo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/addtwo")//增加two
    public void addtwo(HttpServletResponse response,HomepageTwoBO htwobo) {
        if(htwobo==null){
            return;
        }
        if( htwobo.getContent()==null && htwobo.getCreateTime()==null && htwobo.getCreateUser()==null && htwobo.getImage()==null &&
                htwobo.getIntroduce()==null &&htwobo.getPictureSort()==null &&htwobo.getSource()==null &&htwobo.getSubtitle()==null &&
                htwobo.getTitle()==null &&htwobo.getUpdateTime()==null &&htwobo.getUpdateUser()==null &&htwobo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = homepageService.addHomepageTwo(htwobo);
            if (count == 0) {
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                safeTextPrint(response, json);
                return;
            }
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
            safeTextPrint(response, json);
        }
    }



    @RequestMapping("/updatethree")//修改three
    public void updatethree(HttpServletResponse response,HomepageThreeBO hthreebo) {
        if (hthreebo==null||hthreebo.getId() == null || hthreebo.getId() == 0 ) {
            return;
        }
        if( hthreebo.getContent()==null && hthreebo.getCreateTime()==null && hthreebo.getCreateUser()==null && hthreebo.getImage()==null &&
                hthreebo.getIntroduce()==null &&hthreebo.getPictureSort()==null &&hthreebo.getSource()==null &&hthreebo.getSubtitle()==null &&
                hthreebo.getTitle()==null &&hthreebo.getUpdateTime()==null &&hthreebo.getUpdateUser()==null &&hthreebo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = homepageService.updateHomepageThree(hthreebo);
            if (count == 0) {
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                safeTextPrint(response, json);
                return;
            }
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
            safeTextPrint(response, json);
        }
    }
    @RequestMapping("/deletethree")//删除three
    public void deletethree(HttpServletResponse response,HomepageThreeBO hthreebo) {
        if (hthreebo==null||hthreebo.getId() == null || hthreebo.getId() == 0 ) {
            return;
        }
        Integer count=homepageService.deleteHomepageThree(hthreebo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/addthree")//增加three
    public void addthree(HttpServletResponse response,HomepageThreeBO hthreebo) {
        if(hthreebo==null){
            return;
        }
        if( hthreebo.getContent()==null && hthreebo.getCreateTime()==null && hthreebo.getCreateUser()==null && hthreebo.getImage()==null &&
                hthreebo.getIntroduce()==null &&hthreebo.getPictureSort()==null &&hthreebo.getSource()==null &&hthreebo.getSubtitle()==null &&
                hthreebo.getTitle()==null &&hthreebo.getUpdateTime()==null &&hthreebo.getUpdateUser()==null &&hthreebo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = homepageService.addHomepageThree(hthreebo);
            if (count == 0) {
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                safeTextPrint(response, json);
                return;
            }
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
            safeTextPrint(response, json);
        }
    }




    @RequestMapping("/updatefour")//修改four
    public void updatefour(HttpServletResponse response,HomepageFourBO hfourbo) {
        if (hfourbo==null||hfourbo.getId() == null || hfourbo.getId() == 0 ) {
            return;
        }
        if( hfourbo.getContent()==null && hfourbo.getCreateTime()==null && hfourbo.getCreateUser()==null && hfourbo.getImage()==null &&
                hfourbo.getIntroduce()==null &&hfourbo.getPictureSort()==null &&hfourbo.getSource()==null &&hfourbo.getSubtitle()==null &&
                hfourbo.getTitle()==null &&hfourbo.getUpdateTime()==null &&hfourbo.getUpdateUser()==null &&hfourbo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = homepageService.updateHomepageFour(hfourbo);
            if (count == 0) {
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                safeTextPrint(response, json);
                return;
            }
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
            safeTextPrint(response, json);
        }
    }
    @RequestMapping("/deletefour")//删除four
    public void deletefour(HttpServletResponse response,HomepageFourBO hfourbo) {
        if (hfourbo==null||hfourbo.getId() == null || hfourbo.getId() == 0 ) {
            return;
        }
        Integer count=homepageService.deleteHomepageFour(hfourbo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/addfour")//增加four
    public void addfour(HttpServletResponse response,HomepageFourBO hfourbo) {
        if(hfourbo==null){
            return;
        }
        if( hfourbo.getContent()==null && hfourbo.getCreateTime()==null && hfourbo.getCreateUser()==null && hfourbo.getImage()==null &&
                hfourbo.getIntroduce()==null &&hfourbo.getPictureSort()==null &&hfourbo.getSource()==null &&hfourbo.getSubtitle()==null &&
                hfourbo.getTitle()==null &&hfourbo.getUpdateTime()==null &&hfourbo.getUpdateUser()==null &&hfourbo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = homepageService.addHomepageFour(hfourbo);
            if (count == 0) {
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                safeTextPrint(response, json);
                return;
            }
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
            safeTextPrint(response, json);
        }
    }


    @RequestMapping("/updatefive")//修改five
    public void updatefive(HttpServletResponse response,HomepageFiveBO hfivebo) {
        if (hfivebo==null||hfivebo.getId() == null || hfivebo.getId() == 0 ) {
            return;
        }
        if( hfivebo.getContent()==null && hfivebo.getCreateTime()==null && hfivebo.getCreateUser()==null && hfivebo.getImage()==null &&
                hfivebo.getIntroduce()==null &&hfivebo.getPictureSort()==null &&hfivebo.getSource()==null &&hfivebo.getSubtitle()==null &&
                hfivebo.getTitle()==null &&hfivebo.getUpdateTime()==null &&hfivebo.getUpdateUser()==null &&hfivebo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = homepageService.updateHomepageFive(hfivebo);
            if (count == 0) {
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                safeTextPrint(response, json);
                return;
            }
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
            safeTextPrint(response, json);
        }
    }
    @RequestMapping("/deletefive")//删除five
    public void deletefive(HttpServletResponse response,HomepageFiveBO hfivebo) {
        if (hfivebo==null||hfivebo.getId() == null || hfivebo.getId() == 0 ) {
            return;
        }
        Integer count=homepageService.deleteHomepageFive(hfivebo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/addfive")//增加five
    public void addfive(HttpServletResponse response,HomepageFiveBO hfivebo) {
        if(hfivebo==null){
            return;
        }
        if( hfivebo.getContent()==null && hfivebo.getCreateTime()==null && hfivebo.getCreateUser()==null && hfivebo.getImage()==null &&
                hfivebo.getIntroduce()==null &&hfivebo.getPictureSort()==null &&hfivebo.getSource()==null &&hfivebo.getSubtitle()==null &&
                hfivebo.getTitle()==null &&hfivebo.getUpdateTime()==null &&hfivebo.getUpdateUser()==null &&hfivebo.getUrl()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = homepageService.addHomepageFive(hfivebo);
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
