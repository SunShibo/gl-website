package com.gl.website.web.controller;

import com.gl.website.entity.bo.AdminBO;
import com.gl.website.entity.bo.CommunityFirstBO;
import com.gl.website.entity.bo.CommunityTwoBO;
import com.gl.website.entity.dto.ResultDTOBuilder;
import com.gl.website.service.CommunityService;
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
@RequestMapping("/backupload")
public class BGUploadController extends BaseCotroller {



    @Resource
    private UploadingUtil uploadingUtil;



    //上传图片
    @RequestMapping("/uploadpicture")
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


        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(s));
        safeTextPrint(response, json);
        return;
    }



}