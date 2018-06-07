package com.hxj.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.hxj.core.aop.ControllerAop;
import com.hxj.core.spring.HttpInterceptor;
import com.hxj.core.spring.SpringExceptionResolver;
import com.hxj.core.tool.ApplicationContextTool;

import httl.web.springmvc.HttlViewResolver;

/**
 * 核心包配置
 * 
 * @author huangxj 2018年4月6日
 * 
 * @version v1.0
 */
@Configuration
public class AutoConfiguration implements WebMvcConfigurer {

	/**
	 * httl配置
	 * 
	 * @author huangxj 2018年4月6日
	 *
	 * @version v1.0
	 */
	@Bean
	public HttlViewResolver viewResolver() {

		HttlViewResolver resolver = new HttlViewResolver();
		resolver.setCache(false);
		resolver.setPrefix("");
		resolver.setSuffix(".httl");
		resolver.setContentType("text/html; charset=UTF-8");
		resolver.setExposeSessionAttributes(true);
		resolver.setOrder(1);
		return resolver;
	}

	@Bean
	public MappingJackson2JsonView jsonView() {
		return new MappingJackson2JsonView();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 指定拦截器类
		registry.addInterceptor(new HttpInterceptor());
	}
	
	@Bean
	public SpringExceptionResolver springExceptionResolver() {
		return new SpringExceptionResolver();
	}
	
	@Bean
	public ApplicationContextTool applicationContextTool() {
		return new ApplicationContextTool();
	}
	
	@Bean
	public ControllerAop controllerAop() {
		return new ControllerAop();
	}
}
