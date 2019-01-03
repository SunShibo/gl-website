package com.gl.website.web.controller;

import com.gl.website.entity.bo.*;
import com.gl.website.entity.dto.ResultDTOBuilder;
import com.gl.website.service.InternationService;
import com.gl.website.service.SilkroadService;
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
@RequestMapping("/backsilkroad")
public class BackSilkRoadController extends BaseCotroller {


    @Resource
    private SilkroadService silkroadService;
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
        System.out.println("你好，李泽新"+s);
        if(s==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000018"));
            safeTextPrint(response, json);
            return;
        }

        SilkroadFirstBO  firstBO=new SilkroadFirstBO();
        firstBO.setId(1);
        firstBO.setImage(s);
        silkroadService.updateSilkroadFirst(firstBO);


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

        SilkroadFirstBO  firstBO=new SilkroadFirstBO();
        firstBO.setId(1);
        if(falg==1)
            firstBO.setTitle(msg);
        if(falg==2)
            firstBO.setSubtitle(msg);
        if(falg==3)
            firstBO.setIntroduce(msg);

        silkroadService.updateSilkroadFirst(firstBO);

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

            SilkroadTwoBO  twoBO=new SilkroadTwoBO();
        twoBO.setId(1);
        if(falg==1)
            twoBO.setTitle(msg);
        if(falg==2)
            twoBO.setIntroduce(msg);

        silkroadService.updateSilkroadTwo(twoBO);

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }

   /* public static void main(String[] args) {
        BackInternationController b=new BackInternationController();
        b.model1ImageUp(null,null,file:C:/Users/Administrator/Desktop/李泽新资料/毕业证.jpg);
    }*/
}