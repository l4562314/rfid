package com.juedui100.sns.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CommonFilter implements Filter {

	public void destroy() {
	}
 
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest requ=(HttpServletRequest)arg0;
		System.out.println("url:"+arg0.getLocalAddr()+"  "+arg0.getLocalName()+"  "+arg0.getLocalPort()+"  s: "+requ.getServletPath());
//		((HttpServletResponse) arg1).addHeader("P3P", "CP=CAO PSA OUR");
		
		
		//统计wap1访问量
//		HttpServletRequest request = (HttpServletRequest) arg0;
//		String url = request.getRequestURL() != null ? request.getRequestURL().toString() : "";
//        if(StringUtils.isNotBlank(url) && url.contains("app27571.qzoneapp.com/wap1")) {
//        	LogsService.log("000000000000000000", 28, 1, "", 1);
//        } 
//        if(StringUtils.isNotBlank(url) && url.contains("app27571-1.qzoneapp.com/wap1")) {
//        	LogsService.log("000000000000000000", 28, 2, "", 1);
//        }
		
		arg2.doFilter(arg0, arg1);
	}
 
	public void init(FilterConfig arg0) throws ServletException {
	}

}
