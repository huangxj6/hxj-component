package com.hxj.dwz.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 引入spring的主配置文件
 * 
 * @author huangxj 2018年5月12日 
 * 
 * @version v1.0
 */
@Configuration
@ImportResource(value = { "classpath:spring-main.xml" })
public class SpringConfig {

}