package com.hxj.generate.gen.java;

import org.springframework.stereotype.Service;

@Service("entityGen")
public class EntityGen extends JavaAbstractGen{

	@Override
	protected String getPackage(String basePackage) {
		return basePackage + ".api.entity";
	}

	@Override
	protected String getTemplatesPath() {
		return "entity.httl";
	}

	@Override
	protected String getFileName(String entityName) {
		return entityName + ".java";
	}
}
