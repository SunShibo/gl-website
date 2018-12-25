package com.gl.website.web.controller;

import com.gl.website.entity.bo.*;
import com.gl.website.service.HomepageService;
import com.gl.website.entity.dto.ResultDTOBuilder;
import com.gl.website.util.JsonUtils;
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
    public void  query(HttpServletResponse response,HttpServletRequest request) {
        HashMap<String,Object>map=new HashMap<String, Object>();
        List<HomepageFirstBO>list1= homepageService.getAllHomepageFirstMesg();
        List<HomepageTwoBO>list2= homepageService.getAllHomepageTwoMesg();
        List<HomepageThreeBO>list3= homepageService.getAllHomepageThreeMesg();
        List<HomepageFourBO>list4= homepageService.getAllHomepageFourMesg();
        List<HomepageFiveBO>list5= homepageService.getAllHomepageFiveMesg();
        map.put("one",list1);
        map.put("two",list2);
        map.put("three",list3);
        map.put("four",list4);
        map.put("five",list5);
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
        safeTextPrint(response, json);
    }

}
