package com.gl.website.web.controller;
import com.gl.website.entity.bo.*;
import com.gl.website.entity.dto.ResultDTOBuilder;
import com.gl.website.service.AboutService;
import com.gl.website.service.HomepageService;
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
@RequestMapping("/backabout")
public class BackAboutController extends BaseCotroller {


    @Resource
    private AboutService aboutService;
    @Resource
    private UploadingUtil uploadingUtil;

    @RequestMapping("/query")//查询
    public void query(HttpServletResponse response, HttpServletRequest request) {
      /*  AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
            safeTextPrint(response, json);
            return;
        }*/


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
        return;
    }

    //首页模块一图片修改
    @RequestMapping("/editItemsSubmit")
    public void model1ImageUp(HttpServletResponse  response,HttpServletRequest request, MultipartFile file) throws Exception {
        /*AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
            safeTextPrint(response, json);
            return;
        }*/

        String s = uploadingUtil.uploaDing(file);
        if(s==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000018"));
            safeTextPrint(response, json);
            return;
        }

        AboutFirstBO  firstBO=new AboutFirstBO();
        firstBO.setId(1);
        firstBO.setImage(s);
       Integer count= aboutService.updateAboutFirst(firstBO);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }



    //首页模块一 标题  修改
    @RequestMapping("/mode1Update")
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

        AboutFirstBO  firstBO=new AboutFirstBO();
        firstBO.setId(1);
        if(falg==1)
            firstBO.setTitle(msg);
        if(falg==2)
            firstBO.setSubtitle(msg);
        if(falg==3)
            firstBO.setIntroduce(msg);

        Integer count=aboutService.updateAboutFirst(firstBO);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }


    //首页模块2内容修改
    @RequestMapping("/model2Update")
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

        AboutTwoBO  twoBO=new AboutTwoBO();
        twoBO.setId(1);
        if(falg==1)
            twoBO.setTitle(msg);
        if(falg==2)
            twoBO.setIntroduce(msg);

       Integer count= aboutService.updateAboutTwo(twoBO);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }


    //模块四 文字 修改
    @RequestMapping("/model4Update")
    public void model4Update(HttpServletResponse  response,HttpServletRequest request,String msg,Integer falg,Integer id) {

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

        AboutFourBO  FourBO=new AboutFourBO();
        FourBO.setId(id);
        if(falg==1)
            FourBO.setTitle(msg);
        if(falg==2)
            FourBO.setSubtitle(msg);
        if(falg==3)
            FourBO.setIntroduce(msg);

        aboutService.updateAboutFour(FourBO);

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }
    //首页模块3修改照片和内容等
    @RequestMapping("/update3modelall")
    public void model2UpdateAll(HttpServletResponse  response,HttpServletRequest request,String title,String introduce,String pictureaddress,Integer id) {

   /* AdminBO userBO = super.getLoginUser(request);
    if (userBO == null) {
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
        safeTextPrint(response, json);
        return;
    }*/

        if(title==null && pictureaddress==null && introduce==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }
        if(id==null ){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }

        AboutThreeBO  threeBO=new AboutThreeBO();
        if(id!=null){
            threeBO.setId(id);
        }
        if(title!=null) {
            threeBO.setTitle(title);
        }
        if(introduce!=null) {
            threeBO.setIntroduce(introduce);
        }
        if(pictureaddress!=null) {
            threeBO.setImage(pictureaddress);
        }
        Integer count=aboutService.updateAboutThree(threeBO);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }
    //首页模块3增加照片和内容等
    @RequestMapping("/add3modelall")
    public void model2AddAll(HttpServletResponse  response,HttpServletRequest request,String title,String introduce,String pictureaddress) {

   /* AdminBO userBO = super.getLoginUser(request);
    if (userBO == null) {
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
        safeTextPrint(response, json);
        return;
    }
*/
        if((title==null||title=="") && (pictureaddress==null||pictureaddress=="") && (introduce==null||introduce=="")){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }

        AboutThreeBO  threeBO=new AboutThreeBO();

        if(title!=null) {
            threeBO.setTitle(title);
        }
        if(introduce!=null) {
            threeBO.setIntroduce(introduce);
        }
        if(pictureaddress!=null) {
            threeBO.setImage(pictureaddress);
        }

        Integer count=aboutService.addAboutThree(threeBO);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }
    //首页模块3删除照片和内容等
    @RequestMapping("/delete3modelall")
    public void model2DeleteAll(HttpServletResponse  response,HttpServletRequest request,Integer id) {

  /*  AdminBO userBO = super.getLoginUser(request);
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

        AboutThreeBO  threeBO=new AboutThreeBO();
        if(id!=null) {
            threeBO.setId(id);
        }
        Integer count=aboutService.deleteAboutThree(threeBO);
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