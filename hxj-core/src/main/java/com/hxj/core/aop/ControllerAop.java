package com.hxj.core.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.hxj.common.tools.StringTools;
import com.hxj.core.bean.JsonData;

/**
 * 控制层切面
 * 
 * @author huangxj 2018年5月12日
 * 
 * @version v1.0
 */
@Aspect
public class ControllerAop {

	@Around("execution(* com.hxj.*.controller.*.*(..))")
	public Object handleValidateResult(ProceedingJoinPoint pjp) throws Throwable {

		// 得到所有参数
		Object[] args = pjp.getArgs();

		// 遍历参数
		for (Object arg : args) {

			// 找到类型为BindingResult的参数
			if (arg instanceof BindingResult) {

				BindingResult errors = (BindingResult) arg;

				// 有错误的话则返回错误信息
				if (errors.hasErrors()) {
					List<ObjectError> objectErrorList = errors.getAllErrors();
					String message = "";
					for (ObjectError objectError : objectErrorList) {
						message = message + objectError.getDefaultMessage() + "、";
					}
					return JsonData.fail(StringTools.removeEnd(message, "、"));
				}
			}
		}

		// 执行方法
		Object result = pjp.proceed();

		return result;
	}

}