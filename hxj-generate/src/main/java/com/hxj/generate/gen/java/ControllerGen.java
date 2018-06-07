package com.hxj.generate.gen.java;

import org.springframework.stereotype.Service;

@Service("controllerGen")
public class ControllerGen extends JavaAbstractGen{

	@Override
	protected String getPackage(String basePackage) {
		return basePackage + ".controller";
	}

	@Override
	protected String getTemplatesPath() {
		return "controller.httl";
	}

	@Override
	protected String getFileName(String entityName) {
		return entityName + "Controller.java";
	}
}
