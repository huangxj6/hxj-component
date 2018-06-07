package com.hxj.common.api.exception;

/**
 * 传参异常
 * 
 * @author huangxj 2018年4月30日 
 * 
 * @version v1.0
 */
public class ParamException extends CustomException {
	
	private static final long serialVersionUID = 1L;

	public ParamException() {
        super();
    }

    public ParamException(String message) {
        super(message);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamException(Throwable cause) {
        super(cause);
    }

    protected ParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
