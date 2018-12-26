package com.gl.website.web.controller;
import com.gl.website.entity.bo.AdminBO;
import com.gl.website.entity.bo.HomepageFirstBO;
import com.gl.website.entity.bo.HomepageThreeBO;
import com.gl.website.entity.bo.HomepageTwoBO;
import com.gl.website.entity.dto.ResultDTOBuilder;
import com.gl.website.service.HomepageService;
import com.gl.website.util.JsonUtils;
import com.gl.website.web.controller.base.BaseCotroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/backgroundHome")
public class BackgroundHomeController   extends BaseCotroller {


    @Resource
    private HomepageService  homepageService;


  /*  @RequestMapping("/query")//查询
    public void query(HttpServletResponse response, HttpServletRequest request) {
        AdminBO userBO = super.getLoginUser(request) ;
        if (userBO==null){
            String json= JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001","请登录"));
            safeTextPrint(response,json);
            return;
        }

        //查询首页头
        HomepageFirstBO allHomepageFirstMesg = homepageService.getAllHomepageFirstMesg();  //首页模块一
        HomepageTwoBO allHomepageTwoMesg = homepageService.getAllHomepageTwoMesg();      //首页 模块二
        List<HomepageThreeBO> allHomepageThreeMesg = homepageService.getAllHomepageThreeMesg(); //首页 模块二

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(allHomepageFirstMesg));
        safeTextPrint(response, json);
    }
*/


}
