package com.gl.website.web.controller;

import com.gl.website.entity.bo.*;
import com.gl.website.entity.dto.ResultDTOBuilder;
import com.gl.website.service.BookService;
import com.gl.website.service.InternationService;
import com.gl.website.util.JsonUtils;
import com.gl.website.util.ParamVerifyUtil;
import com.gl.website.util.UploadingUtil;
import com.gl.website.web.controller.base.BaseCotroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/backinternation")
public class BackInternationController extends BaseCotroller {


    @Resource
    private InternationService internationService;
    @Resource
    private UploadingUtil uploadingUtil;

    @RequestMapping("/query")//查询
    public void query(HttpServletResponse response, HttpServletRequest request) {
        AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
            safeTextPrint(response, json);
            return;
        }


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

    //首页模块一图片修改
    @RequestMapping("/updateonemodelpicture")
    public void model1ImageUp(HttpServletResponse  response,HttpServletRequest request, MultipartFile img) throws Exception {
        AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
            safeTextPrint(response, json);
            return;
        }

        String s = uploadingUtil.uploaDing(img);
        if(s==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000018"));
            safeTextPrint(response, json);
            return;
        }

        InternationFirstBO  firstBO=new InternationFirstBO();
        firstBO.setId(1);
        firstBO.setImage(s);
        internationService.updateInternationFirst(firstBO);


        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }



    //首页模块一住标题修改
    @RequestMapping("/updateonemodelandsoon")
    public void model1UpdateTitle(HttpServletResponse  response,HttpServletRequest request,String msg,Integer falg) {
        AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
            safeTextPrint(response, json);
            return;
        }
        boolean verification = ParamVerifyUtil.verification(msg,falg);
        if(!verification){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }

        InternationFirstBO  firstBO=new InternationFirstBO();
        firstBO.setId(1);
        if(falg==1)
            firstBO.setTitle(msg);
        if(falg==2)
            firstBO.setSubtitle(msg);
        if(falg==3)
            firstBO.setIntroduce(msg);

        internationService.updateInternationFirst(firstBO);

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }


    //首页模块2内容修改
    @RequestMapping("/updatetwomodelandsoon")
    public void model2Update(HttpServletResponse  response,HttpServletRequest request,String msg,Integer falg) {

        AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
            safeTextPrint(response, json);
            return;
        }
        boolean verification = ParamVerifyUtil.verification(msg,falg);
        if(!verification){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }

            InternationTwoBO  twoBO=new InternationTwoBO();
        twoBO.setId(1);
        if(falg==1)
            twoBO.setTitle(msg);
        if(falg==2)
            twoBO.setIntroduce(msg);

        internationService.updateInternationTwo(twoBO);

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }

}