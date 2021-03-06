package com.gl.website.web.controller;
import com.gl.website.entity.bo.*;
import com.gl.website.entity.dto.ResultDTOBuilder;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/backgroundHome")
public class BackgroundHomeController   extends BaseCotroller {


    @Resource
    private HomepageService homepageService;
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
        HomepageFirstBO homeModel1 = homepageService.getAllHomepageFirstMesg();
        HomepageTwoBO homeModel2 = homepageService.getAllHomepageTwoMesg();
        List<HomepageThreeBO> homeModel3 = homepageService.getAllHomepageThreeMesg();
        HomepageFourBO homeModel4 = homepageService.getAllHomepageFourMesg();
        List<HomepageFiveBO> homeModel5 = homepageService.getAllHomepageFiveMesg();
        map.put("homeModel1", homeModel1);
        map.put("homeModel2", homeModel2);
        map.put("homeModel3", homeModel3);
        map.put("homeModel4", homeModel4);
        map.put("homeModel5", homeModel5);
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
        safeTextPrint(response, json);
        return;
    }

    //首页模块一图片修改
    @RequestMapping("/editItemsSubmit")
    public void model1ImageUp(HttpServletResponse  response,HttpServletRequest request, MultipartFile file) throws Exception {
        AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
            safeTextPrint(response, json);
            return;
        }

        String s = uploadingUtil.uploaDing(file);
        if(s==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000018"));
            safeTextPrint(response, json);
            return;
        }

        HomepageFirstBO  firstBO=new HomepageFirstBO();
        firstBO.setId(1);
        firstBO.setImage(s);
        homepageService.updateHomepageFirst(firstBO);


        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }



    //首页模块一住标题修改
    @RequestMapping("/mode1Update")
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

        HomepageFirstBO  firstBO=new HomepageFirstBO();
        firstBO.setId(1);
        if(falg==1)
            firstBO.setTitle(msg);
        if(falg==2)
            firstBO.setSubtitle(msg);
        if(falg==3)
            firstBO.setIntroduce(msg);

        homepageService.updateHomepageFirst(firstBO);

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }


    //首页模块2内容修改
    @RequestMapping("/model2Update")
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

        HomepageTwoBO  firstBO=new HomepageTwoBO();
        firstBO.setId(1);
        if(falg==1)
            firstBO.setTitle(msg);
        if(falg==2)
            firstBO.setIntroduce(msg);

        homepageService.updateHomepageTwo(firstBO);

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }

    //模块三图片修改
    @RequestMapping("/model3ImageUpdate")
    public void model3ImageUpdate(HttpServletResponse  response,HttpServletRequest request,MultipartFile file,Integer falg) {
        AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
            safeTextPrint(response, json);
            return;
        }

        String s = uploadingUtil.uploaDing(file);
        if(s==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000018"));
            safeTextPrint(response, json);
            return;
        }


        HomepageThreeBO  firstBO=new HomepageThreeBO();
        firstBO.setId(falg);
        firstBO.setImage(s);
        homepageService.updateHomepageThree(firstBO);


        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;


    }
    //模块三 文字 修改
    @RequestMapping("/model3Update")
    public void model3Update(HttpServletResponse  response,HttpServletRequest request,String msg,Integer falg,Integer id) {

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

        HomepageThreeBO  threeBO=new HomepageThreeBO();
        threeBO.setId(id);
        if(falg==1)
            threeBO.setTitle(msg);
        if(falg==2)
            threeBO.setIntroduce(msg);

        homepageService.updateHomepageThree(threeBO);

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }
    //模块四 文字 修改
    @RequestMapping("/model4Update")
    public void model4Update(HttpServletResponse  response,HttpServletRequest request,String msg,Integer falg,Integer id) {

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

        HomepageFourBO  FourBO=new HomepageFourBO();
        FourBO.setId(id);
        if(falg==1)
            FourBO.setTitle(msg);
        if(falg==2)
            FourBO.setIntroduce(msg);

        homepageService.updateHomepageFour(FourBO);

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }



    //模块五  修改
    @RequestMapping("/model5")
    public void model5(HttpServletResponse  response,HttpServletRequest request,Integer falg,Integer id, MultipartFile file) {

        AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
            safeTextPrint(response, json);
            return;
        }
        boolean verification = ParamVerifyUtil.verification(id,falg);
        if(!verification){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }

        try {
            //修改
            if (falg == 1) {

                HomepageFiveBO  fiveBO=new HomepageFiveBO();
                fiveBO.setId(id);
                String s = uploadingUtil.uploaDing(file);
                if(s==null){
                    String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000018"));
                    safeTextPrint(response, json);
                    return;
                }
                fiveBO.setImage(s);
                fiveBO.setUpdateTime(new Date());
                homepageService.updateHomepageFive(fiveBO);

                //删除
            } else if (falg == 2) {
                HomepageFiveBO  fiveBO=new HomepageFiveBO();
                fiveBO.setId(id);
                homepageService.deleteHomepageFive(fiveBO);

                //添加
            } else if (falg == 3) {

                HomepageFiveBO  fiveBO=new HomepageFiveBO();
                String s = uploadingUtil.uploaDing(file);
                if(s==null){
                    String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000018"));
                    safeTextPrint(response, json);
                    return;
                }
                fiveBO.setImage(s);
                fiveBO.setCreateTime(new Date());
                homepageService.addHomepageFive(fiveBO);

            }
        }catch (Exception  e){
            e.printStackTrace();
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;
    }



}