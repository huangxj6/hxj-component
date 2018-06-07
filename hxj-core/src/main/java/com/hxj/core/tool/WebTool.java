package com.hxj.core.tool;

import javax.servlet.http.HttpServletRequest;

import com.hxj.common.tools.StringTools;

/**
 * web相关工具类
 * 
 * @author huangxj 2018年4月19日 
 * 
 * @version v1.0
 */
public class WebTool {

	/**
	 * 获取用户的ip地址
	 * 
	 * @author huangxj 2018年4月19日
	 *
	 * @version v1.0
	 */
	public static String getRequestIp(HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		if (ip.equals("0:0:0:0:0:0:0:1")) {
			ip = "127.0.0.1";
		}
		return ip;
	}

	/**
	 * 获取请求完整路径
	 * 
	 * @author huangxj 2018年4月19日 
	 *
	 * @version v1.0
	 */
	public static String getUrl(HttpServletRequest request) {
		String url = request.getRequestURI();
		String params = "";
		if (request.getQueryString() != null) {
			params = request.getQueryString().toString();
		}
		if (StringTools.isNotBlank(params)) {
			url = url + "?" + params;
		}
		return url;
	}
}
