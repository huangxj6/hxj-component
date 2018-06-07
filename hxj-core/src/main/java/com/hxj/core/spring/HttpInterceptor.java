package com.hxj.core.spring;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

	private static final String START_TIME = "requestStartTime";

	/**
	 * 在请求处理之前进行调用（Controller方法调用之前）
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI().toString();
		Map<String, String[]> parameterMap = request.getParameterMap();
		log.info("request start. url:{}, params:{}", url, parameterMap);
		long start = System.currentTimeMillis();
		request.setAttribute(START_TIME, start);
		return true;
	}

	/**
	 * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String url = request.getRequestURI().toString();
		long start = (Long) request.getAttribute(START_TIME);
		long end = System.currentTimeMillis();
		log.info("request finished. url:{}, cost:{}", url, end - start);
	}

	/**
	 * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		String url = request.getRequestURI().toString();
		long start = (Long) request.getAttribute(START_TIME);
		long end = System.currentTimeMillis();
		log.info("request completed. url:{}, cost:{}", url, end - start);

	}
}
