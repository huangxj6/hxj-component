package com.hxj.core.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * 封装返回结果集
 * 
 * @author huangxj 2017年4月30日
 * 
 * @version v1.0
 */
public class JsonData<T> extends HashMap<String, Object> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 状态码
	 */
	public final static int SUCCESS = 200;
	public final static int FAIL = 300;

	private final static String CODE = "statusCode";
	private final static String MSG = "message";
	private final static String RESULT_LIST = "resultList";
	private final static String RESULT = "result";

	/**
	 * 指定dwz框架的回调方式
	 */
	private final static String CALLBACKTYPE = "callbackType";

	/**
	 * 设置状态码
	 * 
	 * @param code
	 */
	public void setCode(int code) {
		put(CODE, code);
	}

	/**
	 * 设置返回信息
	 * 
	 * @param msg
	 */
	public void setMessage(String msg) {
		put(MSG, msg);
	}

	/**
	 * 获取返回信息
	 */
	public String getMessage() {
		return (String) get(MSG);
	}

	/**
	 * 获取状态码
	 * 
	 * @return
	 */
	public int getCode() {
		return (Integer) get(CODE);
	}

	/**
	 * 判断是否成功
	 * 
	 * @return
	 */
	public boolean isSuccess() {
		return getCode() == SUCCESS ? true : false;
	}

	/**
	 * 设置结果集
	 */
	public void setResultList(List<T> resultList) {
		put(RESULT_LIST, resultList);
	}

	/**
	 * 取出结果集
	 */
	@SuppressWarnings("unchecked")
	public List<T> getResultList() {
		return (List<T>) get(RESULT_LIST);
	}

	/**
	 * 设置结果
	 */
	public void setResult(T result) {
		put(RESULT, result);
	}

	/**
	 * 取出结果
	 */
	@SuppressWarnings("unchecked")
	public T getResult() {
		return (T) get(RESULT);
	}

	/**
	 * 返回成功并通知dwz框架关闭当前对话框并刷新
	 */
	public static JsonData<?> returnSuccessAndColseDialog(String msg) {

		JsonData<?> jsonData = new JsonData<>();

		jsonData.setCode(SUCCESS);
		jsonData.setMessage(msg);
		jsonData.put(CALLBACKTYPE, "closeCurrentDialog");// 关闭对话框
		jsonData.put("reload", "reload");// 刷新

		return jsonData;
	}

	/**
	 * 返回成功
	 */
	public static JsonData<?> success() {
		return success("操作成功！");
	}

	/**
	 * 返回成功
	 */
	public static JsonData<?> success(String msg) {

		JsonData<?> jsonData = new JsonData<>();

		jsonData.setCode(SUCCESS);
		jsonData.setMessage(msg);

		return jsonData;
	}

	public static JsonData<?> success(String msg, String forwardUrl) {

		JsonData<?> jsonData = success(msg);
		jsonData.put(CALLBACKTYPE, "forward");
		jsonData.put("forwardUrl", forwardUrl);

		return jsonData;
	}

	/**
	 * 返回失败
	 * 
	 * @return
	 */
	public static JsonData<?> fail(String msg) {

		JsonData<?> jsonData = new JsonData<>();

		jsonData.setCode(FAIL);
		jsonData.setMessage(msg);
		return jsonData;
	}
}
