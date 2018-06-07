package com.hxj.common.tools;

import java.util.UUID;

/**
 * 各种id生成策略
 * 
 * @author huangxj 2017年6月11日
 * 
 * @version v1.0
 */
public class IDTools {

	/**
	 * 图片名生成
	 */
	public static String createImageName() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();

		// 加上三位随机数
		String end3 = StringTools.getRandom(3);

		// 生成
		String str = millis + end3;

		return str;
	}

	/**
	 * 生成UUID
	 * 
	 * @author huangxj 2017年6月11日
	 *
	 * @version v1.0
	 */
	public static String createUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 商品id生成
	 */
	public static long createItemId() {

		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();

		// 加上两位随机数
		String end2 = StringTools.getRandom(2);

		// 生成
		String str = millis + end2;

		long id = new Long(str);

		return id;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++)
			System.out.println(createItemId());
	}
}
