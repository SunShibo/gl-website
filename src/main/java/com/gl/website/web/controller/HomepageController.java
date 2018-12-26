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
    public void query(HttpServletResponse response, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        HomepageFirstBO homeModel1 = homepageService.getAllHomepageFirstMesg();
        HomepageTwoBO homeModel2 = homepageService.getAllHomepageTwoMesg();
        List<HomepageThreeBO> homeModel3 = homepageService.getAllHomepageThreeMesg();
        HomepageFourBO  homeModel4 = homepageService.getAllHomepageFourMesg();
        List<HomepageFiveBO> homeModel5 = homepageService.getAllHomepageFiveMesg();
        map.put("homeModel1", homeModel1);
        map.put("homeModel2", homeModel2);
        map.put("homeModel3", homeModel3);
        map.put("homeModel4", homeModel4);
        map.put("homeModel5", homeModel5);
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
        safeTextPrint(response, json);
    }

}
