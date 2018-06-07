package com.hxj.common.tools;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常信息工具类
 * 
 * @author huangxj 2017年6月11日 
 * 
 * @version v1.0
 */
public class ExceptionTools {

	/**
	 * 获取异常的堆栈信息
	 * 
	 * @param t
	 * @return
	 */
	public static String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		try {
			t.printStackTrace(pw);
			return sw.toString();
		} finally {
			pw.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			System.out.println(getStackTrace(e));
		}
	}
}
