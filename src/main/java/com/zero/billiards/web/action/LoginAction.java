package com.zero.billiards.web.action;

import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import com.zero.billiards.dataobject.param.UserLoginParam;
import com.zero.billiards.dataobject.vo.UserLoginVO;
import com.zero.billiards.service.IUserService;
import com.zero.billiards.web.common.BaseAction;
import com.zero.billiards.web.common.Constants;

/**
 * 用户登录action
 * @author wanglinzi
 * @version 1.0
 */
@SuppressWarnings("serial")
public class LoginAction extends BaseAction {

	
	@Resource(name = "userService")
	private IUserService userService;
	/**
	 * parameter and DTO
	 */
	private UserLoginVO user; 
	private UserLoginParam param;
	
	public UserLoginParam getParam() {
		return param;
	}

	public void setParam(UserLoginParam param) {
		this.param = param;
	}

	public UserLoginVO getUser() {
		return user;
	}
	
	//,@RequiredStringValidator(fieldName = "user.password", message = "请输入密码!")
	public void UserLoginVO(UserLoginVO user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		try {
			this.user = userService.login(param.getUsername(), param.getPassword());
		} catch (Exception e) {
			setMessage(e.getMessage());
			return "input";
		}
		//put into session
		super.sessionPut(Constants.COOKIE_SESSION_UID_KEY, user.getUsername());
		super.sessionPut(Constants.COOKIE_SESSION_REALNAME_KEY, user.getRealName());
		
		//Keep the login
		if(param.getIsCookie() == 1){
			Cookie cookie1 = new Cookie(Constants.COOKIE_SESSION_UID_KEY, user.getUsername());
			cookie1.setMaxAge(30*24*60*60);//Keep the 30 days
			super.getResponse().addCookie(cookie1);
			
			Cookie cookie2 = new Cookie(Constants.COOKIE_SESSION_REALNAME_KEY,  URLEncoder.encode(user.getRealName(), "utf-8"));
			cookie2.setMaxAge(30*24*60*60);//Keep the 30 days
			super.getResponse().addCookie(cookie2);
		}
		return SUCCESS;
	}

}
