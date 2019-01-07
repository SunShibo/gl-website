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
       /* AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
            safeTextPrint(response, json);
            return;
        }*/


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
    public void model1ImageUp(HttpServletResponse  response,HttpServletRequest request, MultipartFile file) throws Exception {
      /*  AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
            safeTextPrint(response, json);
            return;
        }*/

        String s = uploadingUtil.uploaDing(file);
        System.out.println("你好，李泽新"+s);
        if(s==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000018"));
            safeTextPrint(response, json);
            return;
        }

        InternationFirstBO  firstBO=new InternationFirstBO();
        firstBO.setId(1);
        firstBO.setImage(s);
        Integer count= internationService.updateInternationFirst(firstBO);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }



    //首页模块一住标题修改
    @RequestMapping("/updateonemodelandsoon")
    public void model1UpdateTitle(HttpServletResponse  response,HttpServletRequest request,String msg,Integer falg) {
       /* AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
            safeTextPrint(response, json);
            return;
        }*/
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

        Integer count=internationService.updateInternationFirst(firstBO);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }


    //首页模块2内容修改以前
    @RequestMapping("/updatetwomodelandsoon")
    public void model2Update(HttpServletResponse  response,HttpServletRequest request,String msg,Integer falg) {

       /* AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
            safeTextPrint(response, json);
            return;
        }*/
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

        Integer count=internationService.updateInternationTwo(twoBO);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }


   //首页模块2修改照片和内容等
   @RequestMapping("/update2modelall")
   public void model2UpdateAll(HttpServletResponse  response,HttpServletRequest request,String title,String pictureaddress,Integer id) {

      /* AdminBO userBO = super.getLoginUser(request);
       if (userBO == null) {
           String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
           safeTextPrint(response, json);
           return;
       }*/

       if(title==null && pictureaddress==null){
           String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
           safeTextPrint(response, json);
           return;
       }
       if(id==null ){
           String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
           safeTextPrint(response, json);
           return;
       }

       InternationTwoBO  twoBO=new InternationTwoBO();
       if(id!=null){
           twoBO.setId(id);
       }

       if(title!=null) {
           twoBO.setTitle(title);
       }
       if(pictureaddress!=null) {
           twoBO.setImage(pictureaddress);
       }
      Integer count= internationService.updateInternationTwo(twoBO);
       if( count==0 ){
           String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
           safeTextPrint(response,json);
           return;
       }
       String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
       safeTextPrint(response, json);
       return;
   }
    //首页模块2增加照片和内容等
    @RequestMapping("/add2modelall")
    public void model2AddAll(HttpServletResponse  response,HttpServletRequest request,String title,String pictureaddress) {

        /*AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
            safeTextPrint(response, json);
            return;
        }*/

        if((title==null||title=="") && (pictureaddress==null||pictureaddress=="")){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }

        InternationTwoBO  twoBO=new InternationTwoBO();

        if(title!=null) {
            twoBO.setTitle(title);
        }
        if(pictureaddress!=null) {
            twoBO.setImage(pictureaddress);
        }
       Integer count= internationService.addInternationTwo(twoBO);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }
    //首页模块2删除照片和内容等
    @RequestMapping("/delete2modelall")
    public void model2DeleteAll(HttpServletResponse  response,HttpServletRequest request,Integer id) {

        /*AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
            safeTextPrint(response, json);
            return;
        }*/
        if(id==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }

        InternationTwoBO  twoBO=new InternationTwoBO();
        if(id!=null) {
            twoBO.setId(id);
        }
        Integer count=internationService.deleteInternationTwo(twoBO);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }
}