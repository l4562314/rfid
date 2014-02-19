package com.shrj.rfid.action;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.Before;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.ValidationError;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.apache.thrift.protocol.TType;

import com.juedui100.sns.util.CookieUtils;
//import com.juedui100.sns.util.DateUtils;
import com.juedui100.sns.util.DesCryptUtil;
//import com.juedui100.sns.util.Util;

/**
 * Action基类，所有action都应该继承此action，方便做权限控制，用户登录和值绑定的操作 User: cjp Date: 2010-11-8
 * Time: 16:04:16
 */
public abstract class BaseAction implements ActionBean, ValidationErrorHandler {

	private static Logger logger = Logger.getLogger("jd100.web");
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ActionBeanContext actionBeanContext;
	static String jspPath = "/WEB-INF/jsp";
	protected int pageNo = 1;
	protected String session_openid, session_openkey, session_pfkey,
			session_pf;

//	@SpringBean
//	private QqServiceV3 qqServiceV3;

	public void setContext(ActionBeanContext actionBeanContext) {
		this.actionBeanContext = actionBeanContext;
		this.request = actionBeanContext.getRequest();
		this.response = actionBeanContext.getResponse();
	}

	public ActionBeanContext getContext() {
		return actionBeanContext;
	}

	/**
	 * Converts errors to HTML and streams them back to the browser.
	 */
	public Resolution handleValidationErrors(ValidationErrors errors)
			throws Exception {
		// StringBuilder message = new StringBuilder();
		// return new StreamingResolution("text/javascript",
		// jsonObject.toString());
		return submitResolution(errors, null);
	}

	public Resolution submitResolution(ValidationErrors errors, String tourl) {
		flushBrowser();
		JSONObject result = new JSONObject();
		if (errors == null || errors.size() == 0) {
			result.put("result", "success");
			if (tourl != null) {
				result.put("tourl", tourl);
			}
		} else {
			JSONObject jsonObject = new JSONObject();
			result.put("result", "fail");
			for (List<ValidationError> fieldErrors : errors.values()) {
				for (ValidationError error : fieldErrors) {
					/*
					 * message.append("<div style=\"color: firebrick;\">");
					 * message
					 * .append(error.getMessage(getContext().getLocale()));
					 * message.append("</div>");
					 */
					jsonObject.put(error.getFieldName(),
							error.getMessage(getContext().getLocale()));
				}
			}
			result.put("errors", jsonObject.toString());
		}
		return new StreamingResolution("text/javascript", result.toString());
	}

	@DontValidate
	public static Resolution getResolution(String view) {
		return new ForwardResolution(jspPath + "/" + view + ".jsp");
	}

	public void putErrors(String error) {
		request.getSession().setAttribute("error", error);
	}

	public void putMsgs(String msg) {
		request.getSession().setAttribute("message", msg);
	}

	protected Resolution redirectTo(String url) {
		return new RedirectResolution(url);
	}

	/**
	 * 调用ajax的时候输出到客户端
	 */
	/*
	 * public void outClient(String result) {
	 * response.setContentType("text/plain;charset=UTF-8"); flushBrowser(); try
	 * { response.getWriter().print(result); } catch (IOException e) {r
	 * e.printStackTrace(); } }
	 */
	public void flushBrowser() {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
	}

//	@Before
//	public void toSession() {
//		Cookie idCookie = CookieUtils.getCookie(request, "jd_openid");// userid的加密串
//		Cookie keyCookie = CookieUtils.getCookie(request, "jd_openkey");// userid的加密串
//		Cookie pfKeyCookie = CookieUtils.getCookie(request, "jd_pfkey");
//		Cookie pfCookie = CookieUtils.getCookie(request, "jd_pf");
//
//		if (idCookie != null) {
//			session_openid = idCookie.getValue();
//			String temp = DesCryptUtil.decrypts(session_openid);
//			if (temp == null) {
//				if (DateUtils.afterEncryptCookie()) {
//					session_openid = null;
//				}
//			} else {
//				session_openid = temp;
//			}
//		}
//		if (keyCookie != null) {
//			session_openkey = keyCookie.getValue();
//		}
//		if (pfKeyCookie != null) {
//			session_pfkey = pfKeyCookie.getValue();
//		}
//		if (pfCookie != null) {
//			session_pf = pfCookie.getValue();
//		}
//
//	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageNo() {
		return pageNo;
	}

	public Object parseStringToValue(String value, byte type) {
		if (type == TType.I16 || type == TType.I32) {
			return NumberUtils.toInt(value, 0);
		} else if (type == TType.I64) {
			return NumberUtils.toLong(value, 0);
		} else {
			return value;
		}

	}

	public Resolution checkPermission() {
//		if ("simuser".equals(session_pfkey)) {
//			return null;
//		}
//
//		UserOpenIdKeyBean userOpenIdKeyBean = this.getUserOpenIdKeyService()
//				.getUserOpenIdKey(this.session_openid);
//
//		if (userOpenIdKeyBean == null) {
//			return new ForwardResolution("/error.jsp");
//		}
//
//		if (userOpenIdKeyBean.getOpenkey().equals(this.session_openkey)) {
//			long l = userOpenIdKeyBean.getInTime();
//			long now = System.currentTimeMillis();
//
//			logger.debug("action校验 session_openid:" + session_openid
//					+ " session_openkey:" + session_openkey);
//			if (now - l > 20 * 60 * 1000) {
//
//				boolean b = qqServiceV3.is_login(this.session_openid,
//						this.session_openkey, userOpenIdKeyBean.getPf());
//
//				logger.debug("超时接口校验 session_openid:" + session_openid
//						+ " session_openkey:" + session_openkey + " result:"
//						+ b);
//
//				userOpenIdKeyBean.setInTime(now);
//				this.getUserOpenIdKeyService().save(userOpenIdKeyBean);
//				if (b) {
//					return null;
//				} else {
//					return new ForwardResolution("/error.jsp");
//				}
//			} else {
//				return null;
//			}
//		} else {
//			logger.error("action校验 session_openid不成功:" + session_openid
//					+ " session_openkey:" + session_openkey);
//			return new ForwardResolution("/error.jsp");
//		}
//
		return null;
	}

//	public int getPfInt() {
//		return this.getPfInt(FunctionsTag.getPf(request));
//	}

//	public int getPfInt(String pf) {
//		return Util.getPfInt(pf);
//	}

//	public UserOpenIdKeyService getUserOpenIdKeyService() {
//		return userOpenIdKeyService;
//	}

//	public void setUserOpenIdKeyService(
//			UserOpenIdKeyService userOpenIdKeyService) {
//		this.userOpenIdKeyService = userOpenIdKeyService;
//	}

//	public QqServiceV3 getQqServiceV3() {
//		return qqServiceV3;
//	}
//
//	public void setQqServiceV3(QqServiceV3 qqServiceV3) {
//		this.qqServiceV3 = qqServiceV3;
//	}

	public String getSession_openid() {
		return session_openid;
	}

	public String getSession_openkey() {
		return session_openkey;
	}

	public String getSession_pfkey() {
		return session_pfkey;
	}

	public String getSession_pf() {
		return session_pf;
	}

}