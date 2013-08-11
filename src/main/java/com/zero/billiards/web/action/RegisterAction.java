package com.zero.billiards.web.action;

import javax.annotation.Resource;

import com.zero.billiards.dataobject.po.TUser;
import com.zero.billiards.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;


public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7527428835207918172L;
	@Resource(name = "userService")
	private IUserService userService;
	private TUser user; // 注册提交的用户对象
	
	public TUser getUser() {
		return user;
	}
	
	//,@RequiredStringValidator(fieldName = "user.password", message = "请输入密码!")
	public void setUser(TUser user) {
		this.user = user;
	}



	@Override
	@Validations(requiredStrings = {@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "user.username", message = "请输入用户名!")})  
	public String execute() throws Exception {
//		User user = new User();
		userService.save(user);
		return SUCCESS;
	}
}
