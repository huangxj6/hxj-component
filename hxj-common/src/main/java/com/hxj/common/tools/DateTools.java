package com.hxj.common.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期处理工具类
 * 
 * @author huangxj 2017年4月30日
 * 
 * @version v1.0
 */
public class DateTools {

	public static final String PATTERN1 = "yyyy-MM-dd HH:mm:ss";
	public static final String PATTERN1_NO_TIME = "yyyy-MM-dd";

	public static final String PATTERN2 = "yyyy/MM/dd HH:mm:ss";
	public static final String PATTERN2_NO_TIME = "yyyy/MM/dd";

	private static SimpleDateFormat standardFormat;

	/**
	 * 静态代码块初始化
	 */
	static {

		standardFormat = new SimpleDateFormat(PATTERN1, Locale.SIMPLIFIED_CHINESE);
	}

	/**
	 * 获取当前时间，格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @author huangxj 2017年4月30日
	 *
	 * @version v1.0
	 */
	public static String getNowTime() {

		return dateToStr(new Date());
	}

	/**
	 * 将Date转成日期字符串，默认格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @author huangxj 2017年4月30日
	 *
	 * @version v1.0
	 */
	public static String dateToStr(Date date) {

		return standardFormat.format(date);
	}

	/**
	 * 字符串转date对象，可兼容以下格式的日期字符串
	 * 	1、yyyy-MM-dd HH:mm:ss
	 * 	2、yyyy-MM-dd 
	 * 	3、yyyy/MM/dd HH:mm:ss
	 * 	4、yyyy/MM/dd 
	 * 
	 * @author huangxj 2017年4月30日
	 *
	 * @version v1.0
	 */
	public static Date strToDate(String str) {

		Date date = null;

		if (str.contains("-")) {

			try {
				date = strToDate(str, PATTERN1);
			} catch (ParseException e) {

				try {
					date = strToDate(str, PATTERN1_NO_TIME);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}

		} else if (str.contains("/")) {

			try {
				date = strToDate(str, PATTERN2);
			} catch (ParseException e) {

				try {
					date = strToDate(str, PATTERN2_NO_TIME);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		}

		return date;
	}

	/**
	 * 字符串转date对象
	 * 
	 * @author huangxj 2017年4月30日
	 *
	 * @version v1.0
	 */
	public static Date strToDate(String str, String pattern) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = null;
		date = format.parse(str);
		return date;
	}

	/**
	 * 日期加减
	 * 
	 * @param date
	 *            要运算的日期
	 * @param num
	 *            10就是加10天，-10就是减10天
	 * @return
	 * 
	 * @author huangxj 2017年4月30日
	 *
	 * @version v1.0
	 */
	public static String dayPlus(Date date, int num) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, num);
		Date resultDate = calendar.getTime();

		return dateToStr(resultDate);
	}

	public static void main(String[] args) throws ParseException {

		System.out.println(dayPlus(new Date(), 1000));
	}
}
