package com.hxj.generate.gen.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import com.hxj.common.tools.DateTools;
import com.hxj.generate.entity.Table;

import httl.Engine;
import httl.Template;

/**
 * 代码生成器抽象类
 * 
 * @author huangxj 2018年4月24日
 * 
 * @version v1.0
 */
public abstract class JavaAbstractGen {

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
			String packageName = getPackage(basePackage);
			parameters.put("packageName", packageName);
			
			parameters.put("time", DateTools.getNowTime());

			// 创建包
			String outPutPath = outputFolderPath;
			String[] packageNameArr = packageName.split("\\.");
			for (String name : packageNameArr) {
				outPutPath = outPutPath + File.separator + name;
			}
			File outFileFolder = new File(outPutPath);
			if (!outFileFolder.exists()) {
				outFileFolder.mkdirs();
			}

			// 得到文件
			Table table = (Table) parameters.get("table");
			File outFile = new File(outFileFolder, getFileName(table.getEntityName()));

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
	 * 获取package
	 * 
	 * @author huangxj 2018年4月24日
	 *
	 * @version v1.0
	 */
	protected abstract String getPackage(String basePackage);

	/**
	 * 获取模板路径
	 * 
	 * @author huangxj 2018年4月24日
	 *
	 * @version v1.0
	 */
	protected abstract String getTemplatesPath();

	/**
	 * 获取生成的类名
	 * 
	 * @param entityName
	 *            实体名称
	 * 
	 * @author huangxj 2018年4月24日
	 *
	 * @version v1.0
	 */
	protected abstract String getFileName(String entityName);

}
