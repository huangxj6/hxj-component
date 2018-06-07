package com.hxj.common.tools;

import com.google.gson.Gson;

public class JsonTools {

	/**
	 * 将对象转换为json字符串
	 * 
	 * @author huangxj 2017年5月27日 
	 *
	 * @version v1.0
	 */
	public static String objectToJson(Object obj) {
		
		Gson gson = new Gson();
		
		if(obj == null) {
			return "{}";
		}
		
		return gson.toJson(obj);
	}
	
	/**
	 * 将json字符串转换为指定对象
	 * 
	 * @author huangxj 2017年5月27日 
	 *
	 * @version v1.0
	 */
	public static <T> T jsonToObject(String json , Class<T> jsonClass) {
		
		if(StringTools.isBlank(json)) {
			return null;
		}
		
		Gson gson = new Gson();
		
		return gson.fromJson(json, jsonClass);
	}

}
