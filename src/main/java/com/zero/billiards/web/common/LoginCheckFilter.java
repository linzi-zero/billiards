package com.zero.billiards.web.common;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.LogFactory;

public class LoginCheckFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String uri = request.getRequestURI().replaceAll(
				request.getContextPath(), "");
		LogFactory.getLog(this.getClass()).info(uri);
		if (uri.startsWith(Constants.LOGIN_PAGE_PATH)) {
			chain.doFilter(request, resp);
			return;
		} else if (request.getSession(false) == null
				|| request.getSession().getAttribute(
						Constants.COOKIE_SESSION_UID_KEY) == null) {
			// server没有session的情况下判断Cookie
			Cookie[] cookies = request.getCookies();
			if(cookies == null){
				response.sendRedirect(request.getContextPath() + Constants.LOGIN_PAGE_PATH + ".jsp");
				return;
			}
			boolean isLogin = false;
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(Constants.COOKIE_SESSION_UID_KEY)) {
					String value = cookie.getValue();
					request.getSession().setAttribute(Constants.COOKIE_SESSION_UID_KEY, value);
					isLogin = true;
				} else if (cookie.getName().equals(Constants.COOKIE_SESSION_REALNAME_KEY)) {
					String value = cookie.getValue();
					request.getSession().setAttribute(Constants.COOKIE_SESSION_REALNAME_KEY, URLDecoder.decode(value, "utf-8"));
					isLogin = true;
				}
			}
			// 没有登录或没有的记住登录状态
			if (!isLogin) {
				response.sendRedirect(request.getContextPath()
						+ Constants.LOGIN_PAGE_PATH + ".jsp");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		String page = config.getInitParameter("loginPage");
		if (page != null) {
			Constants.LOGIN_PAGE_PATH = page;
		}
	}

}
