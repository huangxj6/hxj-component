package com.hxj.common.tools;

import java.security.SecureRandom;
import java.text.MessageFormat;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 * 
 * @author huangxj 2017年3月19日
 * 
 * @version v1.0
 */
public class StringTools extends StringUtils {

	/**
	 * 生成随机数字
	 * 
	 * @param number
	 *            数字个数，不能小于等于0，否则返回空字符串
	 * 
	 * @author huangxj 2017年5月7日
	 *
	 * @version v1.0
	 */
	public static String getRandom(int number) {

		if (number <= 0) {
			return "";
		}

		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < number; i++) {
			// 生成一个个位数的随机数
			String randomNum = random.nextInt(9) + "";
			stringBuilder.append(randomNum);
		}

		return stringBuilder.toString();
	}

	/**
	 * 字符串格式化
	 * 
	 * @author huangxj 2017年6月5日
	 *
	 * @version v1.0
	 */
	public static String format(String str, Object... arguments) {

		str = MessageFormat.format(str, arguments);
		return str;
	}

	/**
	 * 转换为下划线
	 * 
	 * @param camelCaseName
	 * @return
	 */
	public static String underscoreName(String camelCaseName) {
		StringBuilder result = new StringBuilder();
		if (camelCaseName != null && camelCaseName.length() > 0) {
			result.append(camelCaseName.substring(0, 1).toLowerCase());
			for (int i = 1; i < camelCaseName.length(); i++) {
				char ch = camelCaseName.charAt(i);
				if (Character.isUpperCase(ch)) {
					result.append("_");
					result.append(Character.toLowerCase(ch));
				} else {
					result.append(ch);
				}
			}
		}
		return result.toString();
	}

	/**
	 * 转换为驼峰
	 * 
	 * @param underscoreName
	 * @return
	 */
	public static String camelCaseName(String underscoreName) {
		StringBuilder result = new StringBuilder();
		if (underscoreName != null && underscoreName.length() > 0) {
			boolean flag = false;
			for (int i = 0; i < underscoreName.length(); i++) {
				char ch = underscoreName.charAt(i);
				if ("_".charAt(0) == ch) {
					flag = true;
				} else {
					if (flag) {
						result.append(Character.toUpperCase(ch));
						flag = false;
					} else {
						result.append(ch);
					}
				}
			}
		}
		return result.toString();
	}

	/**
	 * 生产一个指定长度的随机字符串
	 * 
	 * @author huangxj 2018年4月20日
	 *
	 * @version v1.0
	 */
	public static String generateRandomString(int length) {

		String possibleChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		StringBuilder sb = new StringBuilder(length);
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < length; i++) {
			sb.append(possibleChars.charAt(random.nextInt(possibleChars.length())));
		}
		return sb.toString();
	}
}
