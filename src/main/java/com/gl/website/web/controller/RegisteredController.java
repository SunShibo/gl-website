package com.gl.website.web.controller;

import com.gl.website.entity.bo.AdminBO;
import com.gl.website.entity.bo.RegisteredBO;
import com.gl.website.entity.bo.SilkroadFirstBO;
import com.gl.website.entity.bo.SilkroadTwoBO;
import com.gl.website.entity.dto.ResultDTOBuilder;
import com.gl.website.service.RegisteredService;
import com.gl.website.service.SilkroadService;
import com.gl.website.util.JsonUtils;
import com.gl.website.web.controller.base.BaseCotroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/registered")
public class RegisteredController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(RegisteredController.class);
    @Resource
    private RegisteredService registeredService;

    @RequestMapping("/query")//查询
    public void query(HttpServletResponse response, HttpServletRequest request) {
        AdminBO userBO = super.getLoginUser(request);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "请登录"));
            safeTextPrint(response, json);
            return;
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        List<RegisteredBO> list1 = registeredService.getAllRegisteredMesg();
        if( list1==null||list1.size()<1 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        map.put("one", list1);
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
        safeTextPrint(response, json);
    }

    @RequestMapping("/addone")//增加one
    public void addtwo(HttpServletResponse response,RegisteredBO rebo) {
        if(rebo==null){
            return;
        }
        if( rebo.getAddress()==null && rebo.getApplicantBirthday()==null && rebo.getApplicantName()==null && rebo.getBalanceof()==null &&
                rebo.getChineseVisa()==null &&rebo.getConcerns()==null &&rebo.getEmail()==null &&rebo.getEmergencyContact()==null &&
                rebo.getEmergencyContactNumber()==null &&rebo.getFoodAllergy()==null &&rebo.getGender()==null &&rebo.getGuardianName()==null&&
                rebo.getPhone()==null && rebo.getPaymentAmount()==null && rebo.getPaymentTime()==null
                ){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response, json);
            return;
        }else {
            Integer count = registeredService.addRegistered(rebo);
            if (count == 0) {
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                safeTextPrint(response, json);
                return;
            }
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
            safeTextPrint(response, json);
        }
    }



}