package com.hxj.generate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hxj.generate.entity.Table;
import com.hxj.generate.gen.java.JavaAbstractGen;
import com.hxj.generate.gen.xml.XmlAbstractGen;
import com.hxj.generate.service.DbService;

@RestController
@SpringBootApplication
public class GenApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenApplication.class, args);
	}

	@Autowired
	private DbService dbService;

	@Autowired
	private ApplicationContext applicationContext;

	@GetMapping("/")
	public void gen() throws Exception {

		String basePackage = "com.hxj.acl.rpc";

		List<Table> tableList = dbService.listTables();

		for (Table table : tableList) {


			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("table", table);
			parameters.put("basePackage", basePackage);

			Set<Entry<String, JavaAbstractGen>> abstractGenBeans = applicationContext
					.getBeansOfType(JavaAbstractGen.class).entrySet();
			for (Entry<String, JavaAbstractGen> entry : abstractGenBeans) {
				entry.getValue().outputFile(basePackage, parameters);
			}
		}

		// 生成dubbo的xml
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("tableList", tableList);
		Set<Entry<String, XmlAbstractGen>> abstractGenBeans = applicationContext.getBeansOfType(XmlAbstractGen.class)
				.entrySet();
		for (Entry<String, XmlAbstractGen> entry : abstractGenBeans) {
			entry.getValue().outputFile(basePackage, parameters);
		}
	}
}