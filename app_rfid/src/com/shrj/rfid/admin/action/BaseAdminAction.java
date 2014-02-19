package com.shrj.rfid.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.Before;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.ValidationErrorHandler;

import com.shrj.rfid.admin.model.ManageUser;
import com.shrj.rfid.admin.action.LoginAction;

/**
 * User: chjp
 * Date: 11-10-11
 * Time: 下午4:15
 */
public class BaseAdminAction implements ActionBean{
    protected int manageid;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ActionBeanContext actionBeanContext;
    
    static String jspPath = "/WEB-INF/jsp";
    
    public void setContext(ActionBeanContext actionBeanContext) {
		this.actionBeanContext = actionBeanContext;
		this.request = actionBeanContext.getRequest();
		this.response = actionBeanContext.getResponse();
	}

	public ActionBeanContext getContext() {
		return actionBeanContext;
	}
    
    @Before
    public Resolution checklogin() {
    	if(request.getRequestURI().endsWith("/admin/login.do")){
    		return null;
    	}
    	
        ManageUser manageUser = (ManageUser) request.getSession().getAttribute("manageUser");
        if (manageUser != null) {
            manageid = (int) manageUser.getId();
            return null;
        } else {
            return new RedirectResolution(LoginAction.class);
        }
    }
    
    @DontValidate
	public static Resolution getResolution(String view) {
		return new ForwardResolution(jspPath + "/" + view + ".jsp");
	}
}
