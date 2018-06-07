package com.hxj.generate.gen.xml;

import org.springframework.stereotype.Service;

@Service("consumersGen")
public class ConsumersGen extends XmlAbstractGen{

	@Override
	protected String getTemplatesPath() {
		return "consumers.httl";
	}

	@Override
	protected String getFileName() {
		return "consumers.xml";
	}

}
