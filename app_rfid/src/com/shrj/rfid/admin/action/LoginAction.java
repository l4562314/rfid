package com.shrj.rfid.admin.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import com.shrj.rfid.admin.model.ManageUser;
import com.shrj.rfid.admin.service.ManagerService;

/**
 * User: chjp
 * Date: 11-10-8
 * Time: 上午11:15
 */
@UrlBinding("/admin/login.do")
public class LoginAction extends BaseAdminAction{
    @SpringBean
    private ManagerService managerService;
    private String username;
    private String password;
    @DefaultHandler
    public Resolution form(){
        return getResolution("admin/login");
    }

    public Resolution submit(){
    	//sql注入
    	String ss="select insert delete from update create destory drop alter and or like exec count chr mid master truncate char declare ; - ' % < >";
    	String[] keys=ss.split(" ");
    	if(username!=null && password!=null){
    		int index1=username.indexOf(" ");
        	int index2=password.indexOf(" ");
        	if(index1!=-1||index2!=-1){
        		for (String s:keys) {
        			int num=username.indexOf(s);
        			int num2=password.indexOf(s);
        			if(num!=-1||num2!=-1){
        				  return actionBeanContext.getSourcePageResolution();
        			}
        		}
        	}
    	}
    	
        ManageUser manageUser=managerService.getManageUser(username,password);
        if(manageUser!=null){
            request.getSession().setAttribute("manageUser",manageUser);
//            OperatorLogsService.log((int)manageUser.getId(), "",5, 0, "","");
            return new RedirectResolution(DashboardAction.class);
        }else{
            return actionBeanContext.getSourcePageResolution();
        }
    }
    
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
