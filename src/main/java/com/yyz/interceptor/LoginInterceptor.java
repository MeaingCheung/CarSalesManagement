package com.yyz.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yyz.enumerate.SessionKey;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version LoginInterceptor.java, v 0.1 2017年3月11日 下午5:54:52
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object obj = request.getSession().getAttribute(SessionKey.USER.value());
		System.out.println("拦截器执行了。。。。");
		if (obj == null) {
			response.sendRedirect("login");
		}
		return super.preHandle(request, response, handler);
	}

}
