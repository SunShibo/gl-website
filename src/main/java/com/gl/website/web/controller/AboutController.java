package com.gl.website.web.controller;

import com.gl.website.entity.bo.*;
import com.gl.website.entity.dto.ResultDTOBuilder;
import com.gl.website.service.AboutService;
import com.gl.website.service.DayService;
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
@RequestMapping("/about")
public class AboutController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(AboutController.class);
    @Resource
    private AboutService aboutService;

    @RequestMapping("/query")//查询
    public void query(HttpServletResponse response, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        AboutFirstBO list1 = aboutService.getAboutFirstMesg();
        AboutTwoBO list2=aboutService.getAboutTwoMesg();
        List<AboutThreeBO> list3 = aboutService.getAllAboutThreeMesg();
        AboutFourBO list4=aboutService.getAboutFourMesg();
        if( list1==null || list2==null||list3==null ||list3.size()<1 || list4==null){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        map.put("one", list1);
        map.put("two", list2);
        map.put("three", list3);
        map.put("four", list4);
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
        safeTextPrint(response, json);
    }
    @RequestMapping("/updateone")//修改one
    public void updateone(HttpServletResponse response,AboutFirstBO afbo) {
        Integer count=aboutService.updateAboutFirst(afbo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/deleteone")//删除one
    public void deleteone(HttpServletResponse response,AboutFirstBO afbo) {
        Integer count=aboutService.deleteAboutFirst(afbo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/addone")//增加one
    public void addone(HttpServletResponse response,AboutFirstBO afbo) {
        Integer count=aboutService.addAboutFirst(afbo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }


    @RequestMapping("/updatetwo")//修改two
    public void updatetwo(HttpServletResponse response,AboutTwoBO atwobo) {
        Integer count=aboutService.updateAboutTwo(atwobo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/deletetwo")//删除two
    public void deletetwo(HttpServletResponse response,AboutTwoBO atwobo) {
        Integer count=aboutService.deleteAboutTwo(atwobo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/addtwo")//增加two
    public void addtwo(HttpServletResponse response,AboutTwoBO atwobo) {
        Integer count=aboutService.addAboutTwo(atwobo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }



    @RequestMapping("/updatethree")//修改three
    public void updatethree(HttpServletResponse response,AboutThreeBO athreebo) {
        Integer count=aboutService.updateAboutThree(athreebo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/deletethree")//删除three
    public void deletethree(HttpServletResponse response,AboutThreeBO athreebo) {
        Integer count=aboutService.deleteAboutThree(athreebo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/addthree")//增加three
    public void addthree(HttpServletResponse response,AboutThreeBO athreebo) {
        Integer count=aboutService.addAboutThree(athreebo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }




    @RequestMapping("/updatefour")//修改four
    public void updatefour(HttpServletResponse response,AboutFourBO afourbo) {
        Integer count=aboutService.updateAboutFour(afourbo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/deletefour")//删除four
    public void deletefour(HttpServletResponse response,AboutFourBO afourbo) {
        Integer count=aboutService.deleteAboutFour(afourbo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/addfour")//增加four
    public void addfour(HttpServletResponse response,AboutFourBO afourbo) {
        Integer count=aboutService.addAboutFour(afourbo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
}
