package com.hxj.generate.gen.java;

import org.springframework.stereotype.Service;

@Service("serviceImplGen")
public class ServiceImplGen extends JavaAbstractGen{

	@Override
	protected String getPackage(String basePackage) {
		return basePackage + ".service";
	}

	@Override
	protected String getTemplatesPath() {
		return "serviceimpl.httl";
	}

	@Override
	protected String getFileName(String entityName) {
		return entityName + "ServiceImpl.java";
	}
}
