package com.gl.website.web.controller;

import com.gl.website.common.constants.SysConstants;
import com.gl.website.entity.bo.AdminBO;
import com.gl.website.entity.dto.ResultDTOBuilder;
import com.gl.website.service.LoginService;
import com.gl.website.util.DateUtils;
import com.gl.website.util.JsonUtils;
import com.gl.website.util.MD5Util;
import com.gl.website.util.ParamVerifyUtil;
import com.gl.website.util.redisUtils.RedissonHandler;
import com.gl.website.web.controller.base.BaseCotroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author Shibo Sun
 * 登录controller
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseCotroller {


	@Resource
	private LoginService loginService ;




    @RequestMapping( value = "/login" )
    public void signIn(HttpServletResponse response , String userName, String password){
		 //  参数验证
		if(!ParamVerifyUtil.queryTest(userName,password)){
			String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "参数异常！")) ;
			super.safeJsonPrint(response, result);
			return ;
		}

		//密码登录
			AdminBO userInfo = loginService.logion(userName);

			if(userInfo == null){
				String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000004" , "用户不存在！")) ;
				super.safeJsonPrint(response, result);
				return ;
			}
			if(userInfo.getStatus() == 1){
				String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000004" , "账号已被注销！")) ;
				super.safeJsonPrint(response, result);
				return ;
			}

			// 判断密码是否正确
			if(!MD5Util.digest(password).equals(userInfo.getPassword())){
				String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001" , "密码输入不正确！")) ;
				super.safeJsonPrint(response, result);
				return ;
			}


			// 登陆客户信息放入Redis缓存
			String uuid = UUID.randomUUID().toString();

			super.putLoginUser(uuid, userInfo);

			super.setCookie(response, SysConstants.CURRENT_LOGIN_CLIENT_ID, uuid, SysConstants.SEVEN_DAY_TIME);

			userInfo.setPassword("");
			String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(userInfo)) ;
			super.safeJsonPrint(response, result);


	}

	@RequestMapping( value = "/queryLoginStatus")
	public void queryLoginStatus (HttpServletResponse response, HttpServletRequest request ){



		/* 1. 找到对应的账户记录 */
		AdminBO userBO = super.getLoginUser(request) ;

		/* 2. 验证账户状态 */
		if (userBO == null ) {
			String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0010007" , "用户未登录！")) ;
			super.safeJsonPrint(response , result);
			return ;
		}

		/* 3. 返回用户信息 */
		userBO.setPassword("");
		String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(userBO), DateUtils.DATE_PATTERN) ;
		super.safeJsonPrint(response, result);
	}


	//登出
	@RequestMapping( value = "/logout")
	public void logout (HttpServletResponse response, HttpServletRequest request ){
		/* 1. 找到对应的账户记录 */
		AdminBO userBO = super.getLoginUser(request) ;

		/* 2. 验证账户状态 */
		if (userBO == null ) {
			String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0010007" , "用户未登录！")) ;
			super.safeJsonPrint(response , result);
			return ;
		}

		/* 1. 找到对应的id */
		String clientLoginID = super.getClientLoginID(request);

		if (com.gl.website.util.StringUtils.isEmpty(clientLoginID)) {
			String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("00000001" , "没有获取到clientLoginID！")) ;
				super.safeJsonPrint(response , result);
		return ;
	}

		String key = super.createKey(clientLoginID,SysConstants.CURRENT_LOGIN_USER);
		//从redis中删除用户信息
		RedissonHandler.getInstance().delete(key);

		String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("") , DateUtils.DATE_PATTERN) ;
		super.safeJsonPrint(response , result);
	}

	/*
	*/
/**
	 * 注册用户
	 * @param response,mobile,password,confirmPassword,authCode
	 *//*

	@RequestMapping( value = "/register")
	public void register (HttpServletResponse response, String mobile, String password, String confirmPassword,
								  String authCode,String financialManagerNumber){

		*/
/* 校验参数 *//*

		if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password) || StringUtils.isEmpty(confirmPassword)
				|| StringUtils.isEmpty(authCode)){
			String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001" , "参数异常")) ;
			super.safeJsonPrint(response , result);
			return ;
		}

		if(!password.equals(confirmPassword)){
			String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001" , "密码和确认密码不一致")) ;
			super.safeJsonPrint(response , result);
			return ;
		}

		*/
/* 判断手机号码是否注册过 *//*

		int count = loginService.selectCountByMobileCode(mobile);
		if(count > 0 ){
			String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000002" , "手机号码已注册")) ;
			super.safeJsonPrint(response , result);
			return ;
		}

		*/
/* 判断验证码输入是否正确 *//*

		String mobileAuthCode = RedissonHandler.getInstance().get(mobile + "_register");
		if(StringUtils.isEmpty(mobileAuthCode) || !mobileAuthCode.equals(authCode)){
			String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001" , "验证码错误")) ;
			super.safeJsonPrint(response , result);
			return ;
		}

		String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("")) ;
		super.safeJsonPrint(response, result);
	}
*/


}
