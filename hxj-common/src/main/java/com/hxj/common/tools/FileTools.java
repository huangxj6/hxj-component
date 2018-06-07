package com.hxj.common.tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileTools {

	/**
	 * 删除目录
	 * 
	 * @author huangxj 2018年4月16日
	 *
	 * @version v1.0
	 */
	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		return dir.delete();
	}

	/**
	 * 根据文件全路径名获取输入流
	 * 
	 * @param filePath
	 *            文件全路径名
	 * 
	 * @author huangxj 2018年4月23日
	 *
	 * @version v1.0
	 * @throws FileNotFoundException
	 */
	public static InputStream getFileAsStream(String filePath) throws FileNotFoundException {
		return new BufferedInputStream(new FileInputStream(filePath));
	}

	/**
	 * 将Resource包下的文件返回成输入流
	 * 
	 * @param filePath
	 *            文件名
	 *            
	 * @author huangxj 2018年4月23日
	 *
	 * @version v1.0
	 */
	public static InputStream getResourceAsStream(String fileName) {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + fileName);
	}

}