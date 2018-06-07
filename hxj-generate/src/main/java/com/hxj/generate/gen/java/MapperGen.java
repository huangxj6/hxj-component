package com.hxj.generate.gen.java;

import org.springframework.stereotype.Service;

@Service("mapperGen")
public class MapperGen extends JavaAbstractGen{

	@Override
	protected String getPackage(String basePackage) {
		return basePackage + ".mapper";
	}

	@Override
	protected String getTemplatesPath() {
		return "mapper.httl";
	}

	@Override
	protected String getFileName(String entityName) {
		return entityName + "Mapper.java";
	}
}
