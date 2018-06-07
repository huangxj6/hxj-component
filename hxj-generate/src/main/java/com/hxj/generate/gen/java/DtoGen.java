package com.hxj.generate.gen.java;

import org.springframework.stereotype.Service;

@Service("dtoGen")
public class DtoGen extends JavaAbstractGen{

	@Override
	protected String getPackage(String basePackage) {
		return basePackage + ".api.dto";
	}

	@Override
	protected String getTemplatesPath() {
		return "dto.httl";
	}

	@Override
	protected String getFileName(String entityName) {
		return entityName + "Dto.java";
	}
}
