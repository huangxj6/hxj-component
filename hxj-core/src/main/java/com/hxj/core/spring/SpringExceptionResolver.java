package com.hxj.core.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.hxj.common.api.exception.CustomException;
import com.hxj.common.tools.BeanCopyTools;
import com.hxj.core.bean.JsonData;

import lombok.extern.slf4j.Slf4j;

/**
 * spring mvc 全局异常处理
 * 
 * @author huangxj 2018年4月14日
 * 
 * @version v1.0
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		JsonData<?> result = JsonData.fail("服务器异常，请联系管理员！");

		// 自定义异常
		if (ex instanceof CustomException) {
			result = JsonData.fail(ex.getMessage());
		}

		// 这一步很重要，如果不是自定义异常的话则需要把异常打印出来，方便错误调试
		else {
			log.error("spring mvc访问异常！", ex);
		}

		String url = request.getRequestURL().toString();
		ModelAndView mv;

		// 这里我们要求项目中所有请求page页面，都使用.page结尾
		if (url.endsWith(".page")) {
			mv = new ModelAndView("exception", result);
		}

		// 其他
		else {
			mv = new ModelAndView("jsonView", result);
		}

		return mv;
	}
}
