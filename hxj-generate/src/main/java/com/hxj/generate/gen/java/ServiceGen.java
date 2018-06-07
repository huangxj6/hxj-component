package com.hxj.generate.gen.java;

import org.springframework.stereotype.Service;

@Service("serviceGen")
public class ServiceGen extends JavaAbstractGen{

	@Override
	protected String getPackage(String basePackage) {
		return basePackage + ".api.service";
	}

	@Override
	protected String getTemplatesPath() {
		return "service.httl";
	}

	@Override
	protected String getFileName(String entityName) {
		return entityName + "Service.java";
	}
}
