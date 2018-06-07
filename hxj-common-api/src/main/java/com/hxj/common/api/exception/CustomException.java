package com.hxj.common.api.exception;

/**
 * 自定义异常
 * 
 * @author huangxj 2018年4月16日 
 * 
 * @version v1.0
 */
public class CustomException extends Exception{

	private static final long serialVersionUID = 2606209171037838078L;

	public CustomException() {
		super();
	}

	public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomException(String message) {
		super(message);
	}

	public CustomException(Throwable cause) {
		super(cause);
	}
}
