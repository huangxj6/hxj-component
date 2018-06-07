package com.hxj.generate.gen.xml;

import org.springframework.stereotype.Service;

@Service("providersGen")
public class ProvidersGen extends XmlAbstractGen{

	@Override
	protected String getTemplatesPath() {
		return "providers.httl";
	}

	@Override
	protected String getFileName() {
		return "providers.xml";
	}

}
