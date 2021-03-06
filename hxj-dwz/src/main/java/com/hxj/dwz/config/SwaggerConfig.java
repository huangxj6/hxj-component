package com.hxj.dwz.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket all() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("全部接口")// 定义组
				.select() // 选择那些路径和api会生成document
				.apis(RequestHandlerSelectors.basePackage("com.hxj.dwz.controller")) // 拦截的包路径
				.paths(regex("/.*"))// 拦截的接口路径
				.build() // 创建
				.apiInfo(apiInfo())// 配置说明
		;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()//
				.title("")// 标题
				.description("")// 描述
				.termsOfServiceUrl("")//
				.contact(new Contact("hxj", "", ""))// 联系
				// 地址
				.version("1.0")// 版本
				.build();
	}
}