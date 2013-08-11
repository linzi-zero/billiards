package com.zero.billiards.web.action;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;

import com.zero.billiards.web.common.BaseAction;
import com.zero.billiards.web.common.Constants;

public class LogoutAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 922787336243972250L;

	@Override
	public String execute() throws Exception {
		super.getRequest().getSession().invalidate();
		Cookie cookie1 = new Cookie(Constants.COOKIE_SESSION_UID_KEY,
				"");
		cookie1.setMaxAge(0);
		super.getResponse().addCookie(cookie1);

		Cookie cookie2 = new Cookie(Constants.COOKIE_SESSION_REALNAME_KEY,"");
		cookie2.setMaxAge(0);
		super.getResponse().addCookie(cookie2);
		return SUCCESS;
	}

}
