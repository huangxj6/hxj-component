package com.hxj.generate.gen.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import httl.Engine;
import httl.Template;

/**
 * 代码生成器抽象类
 * 
 * @author huangxj 2018年4月24日
 * 
 * @version v1.0
 */
public abstract class XmlAbstractGen {

	@Value(value = "${outputFolderPath}")
	private String outputFolderPath;

	/**
	 * 生成并输出
	 * 
	 * @author huangxj 2018年4月24日
	 *
	 * @version v1.0
	 */
	public void outputFile(String basePackage, Map<String, Object> parameters) {

		FileOutputStream outputStream = null;
		try {

			// 得到包路径
			String packageName = basePackage;
			parameters.put("packageName", packageName);

			// 创建包
			String outPutPath = outputFolderPath;
			File outFileFolder = new File(outPutPath);
			if (!outFileFolder.exists()) {
				outFileFolder.mkdirs();
			}

			// 得到文件
			File outFile = new File(outFileFolder, getFileName());

			// 模板渲染并生成文件
			Engine engine = Engine.getEngine();
			Template template = engine.getTemplate(getTemplatesPath());
			outputStream = new FileOutputStream(outFile);
			template.render(parameters, outputStream);

		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 获取模板路径
	 * 
	 * @author huangxj 2018年4月24日
	 *
	 * @version v1.0
	 */
	protected abstract String getTemplatesPath();

	/**
	 * 文件名
	 * 
	 * @author huangxj 2018年5月12日 
	 *
	 * @version v1.0
	 */
	protected abstract String getFileName();

}
