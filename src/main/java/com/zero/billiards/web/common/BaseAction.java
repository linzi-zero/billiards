package com.zero.billiards.web.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements
		PageControlEnable, SpringControlEnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5253925797284538851L;
	private int pageNo;
	private int pageSize = 10;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 得到应用根的文件系统绝对目录
	 * 
	 * @return 如/usr/../app.war/
	 */
	protected String getWebApplicationAbsolutePath() {
		String realPath = getServletContext().getRealPath("/");
		if (realPath != null) {
			if (!realPath.endsWith("/"))
				return realPath + "/";
		}
		return realPath;
	}

	protected ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}

	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void requestPut(Object key, Object value) {
		Map req = (Map) ActionContext.getContext().get("request");
		req.put(key, value);
	}
	
	@SuppressWarnings({ "rawtypes" })
	protected Object requestGet(Object key) {
		Map req = (Map) ActionContext.getContext().get("request");

		return req.get(key);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void sessionPut(Object key, Object value) {
		Map sess = (Map) ActionContext.getContext().get("session");
		sess.put(key, value);
	}

	protected Object sessionGet(Object key) {
		Map sess = (Map) ActionContext.getContext().get("session");

		return sess.get(key);
	}

	protected String[] parametersGets(String key) {
		Map params = ActionContext.getContext().getParameters();

		return (String[]) params.get(key);
	}

	protected String parametersGet(String key) {
		Map params = ActionContext.getContext().getParameters();

		return ((String[]) params.get(key))[0];
	}

	protected void parametersPut(String key, String value) {
		Map params = ActionContext.getContext().getParameters();

		if (params.get(key) == null) {
			String[] param = new String[] { value };
			params.put(key, param);
		} else {
			String[] param = (String[]) params.get(key);
			param[0] = value;
		}
	}

	public String getLoginId() {
		String oper = (String)this.sessionGet(Constants.COOKIE_SESSION_UID_KEY);
		return oper;
	}

	/**
	 * 得到spring定义的bean
	 * 
	 * @param name
	 * @return
	 */
	public Object getBean(String name) {
		ServletContext servletContext = ServletActionContext
				.getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);
		return wac.getBean(name);
	}

	/**
	 * @return 返回 pageNo。
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo
	 *            要设置的 pageNo。
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	protected int getGlobalPageSize(String key) {
		String size = this.getText(key);
		return size == null ? 15 : Integer.parseInt(size);
	}

	/**
	 * 返回给客户端Javascript提示窗口
	 * 
	 * @param alertText
	 *            提示文本
	 * @param reqCloseWindow
	 *            是否需要关闭本窗口
	 * @param reqReloadOpnner
	 *            是否需要重载入父窗口
	 * @param isModelDialog
	 *            当前是否模态窗口
	 * @return
	 * @throws IOException
	 */
	public String returnScriptAlertWindow(String alertText,
			boolean reqCloseWindow, boolean reqReloadOpnner,
			boolean isModelDialog) throws IOException {
		StringBuffer str = new StringBuffer();
		str.append("<script>");
		str.append("alert('" + alertText + "');");

		if (reqReloadOpnner) {
			if (isModelDialog) {
				// str.append("window.dialogArguments.location.reload();");
				str.append("window.returnValue = 'true';");
			} else {
				str.append("window.opener.location.reload();");
			}
		}

		if (reqCloseWindow) {
			str.append("window.close();");
		}
		str.append("</script>");

		this.getResponse().setCharacterEncoding("GBK");
		this.getResponse().getWriter().println(str);
		return null;
	}

	/**
	 * 返回给客户端Javascript提示窗口
	 * 
	 * @param alertText
	 *            提示文本
	 * @return
	 * @throws IOException
	 */
	public String returnScriptAlertWindow(String alertText) throws IOException {
		StringBuffer str = new StringBuffer();
		str.append("<script>");
		str.append("alert('" + alertText + "');");
		str.append("window.history.back(-1);window.history.back(-1);");
		str.append("</script>");

		this.getResponse().setCharacterEncoding("GBK");
		this.getResponse().getWriter().println(str);
		return null;
	}

	/**
	 * 返回给客户端Javascript提示窗口
	 * 
	 * @param alertText
	 *            提示文本
	 * @param reqCloseWindow
	 * @param reqReloadOpnner
	 *            是否需要重载入父窗口
	 * @param isModelDialog
	 *            当前是否
	 * @return
	 * @throws IOException
	 */
	public String returnScriptAlertWindowWithReturnValue(String alertText,
			boolean reqCloseWindow, boolean reqReloadOpnner,
			boolean isModelDialog, String returnValue) throws IOException {
		StringBuffer str = new StringBuffer();
		str.append("<script>");
		str.append("alert('" + alertText + "');");

		if (reqReloadOpnner) {
			if (isModelDialog) {
				if (returnValue == null || returnValue.trim().length() == 0) {
					str.append("window.returnValue = 'refresh';");
				} else {
					str.append("window.returnValue = '" + returnValue + "';");
				}
			} else {
				str.append("window.opener.location.reload();");
			}
		}

		if (reqCloseWindow) {
			str.append("window.close();");
		}
		str.append("</script>");

		this.getResponse().setCharacterEncoding("GBK");
		this.getResponse().getWriter().println(str);
		return null;
	}
}
