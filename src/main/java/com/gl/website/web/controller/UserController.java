package com.gl.website.web.controller;

import com.gl.website.entity.bo.AdminBO;
import com.gl.website.entity.dto.ResultDTOBuilder;
import com.gl.website.query.QueryInfo;
import com.gl.website.service.LoginService;
import com.gl.website.util.JsonUtils;
import com.gl.website.util.MD5Util;
import com.gl.website.util.ParamVerifyUtil;
import com.gl.website.web.controller.base.BaseCotroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("/user")
public class UserController extends BaseCotroller {

    @Resource
    private LoginService loginService;


    @RequestMapping("/query")
    public void query(HttpServletResponse response, HttpServletRequest  request,Integer pageNo,Integer pageSize) {

        AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000019", "Please login first"));
            safeTextPrint(response, json);
            return;
        }

        QueryInfo queryInfo = getQueryInfo(pageNo, pageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        if (queryInfo != null) {
            map.put("pageOffset", queryInfo.getPageOffset());
            map.put("pageSize", queryInfo.getPageSize());

        }


        if(userBO.getId().equals(1)){
            Integer count = loginService.queryUserCount(map);
            HashMap<String,Object>  hashMap=new HashMap<String, Object>();
            List<AdminBO> adminBOS = loginService.queryAll(map);
            hashMap.put("count",count);
            hashMap.put("data",adminBOS);

            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(hashMap));
            safeTextPrint(response, json);
            return;
        }else{
            Map<String,Object>  hashMap=new HashMap<String, Object>();
            List<AdminBO> adminBOS = loginService.queryUser(userBO.getId());
            hashMap.put("count",1);
            hashMap.put("data",adminBOS);
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(hashMap));
            safeTextPrint(response, json);
            return;
        }

    }




    @RequestMapping("/updateUser")
    public void updateUser(HttpServletResponse response, HttpServletRequest  request,Integer id,String userName,String passWord) {

        AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000019", "Please login first"));
            safeTextPrint(response, json);
            return;
        }

        boolean verification = ParamVerifyUtil.verification(id, userName, passWord);
        if(!verification){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }
        AdminBO logion = loginService.logion(userName);
        if(logion!=null){
            if(!logion.getId().equals(id)){
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000020"));
                safeTextPrint(response, json);
                return;
            }
        }

        try {

            AdminBO adminBO = new AdminBO();
            adminBO.setId(id);
            adminBO.setName(userName);
            String digest = MD5Util.digest(passWord);
            adminBO.setPassword(digest);
            loginService.updateUser(adminBO);
        }catch (Exception e){
            e.printStackTrace();
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;

    }





    @RequestMapping("/addUser")
    public void addUser(HttpServletResponse response, HttpServletRequest  request,String userName,String password) {

        AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000019", "Please login first"));
            safeTextPrint(response, json);
            return;
        }

        boolean verification = ParamVerifyUtil.verification( userName, password);
        if(!verification){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }
        AdminBO logion = loginService.logion(userName);
        if(logion!=null){
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000020"));
                safeTextPrint(response, json);
                return;
        }

        try {

            AdminBO adminBO = new AdminBO();
            adminBO.setName(userName);
            String digest = MD5Util.digest(password);
            adminBO.setPassword(digest);
            adminBO.setUuid(UUID.randomUUID().toString());
            adminBO.setStatus(0);
            loginService.addUser(adminBO);
        }catch (Exception e){
            e.printStackTrace();
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        safeTextPrint(response, json);
        return;

    }




    @RequestMapping("/delUser")
    public void addUser(HttpServletResponse response, HttpServletRequest  request,Integer id) {

        AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000019", "Please login first"));
            safeTextPrint(response, json);
            return;
        }

        boolean verification = ParamVerifyUtil.verification(id);
        if(!verification){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }

        if(id.equals(1)){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000020"));
            safeTextPrint(response, json);
            return;
        }

        try {

            loginService.delUser(id);
        }catch (Exception e){
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
