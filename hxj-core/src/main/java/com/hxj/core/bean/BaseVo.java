package com.hxj.core.bean;

import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hxj.common.api.base.BaseEntity;
import com.hxj.common.tools.BeanCopyTools;
import com.hxj.core.tool.WebTool;

public class BaseVo<D extends BaseEntity> {

	/**
	 * dto对应的class
	 */
	private Class<D> dtoClass;

	@SuppressWarnings("unchecked")
	public BaseVo() {
		dtoClass = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * 将vo转成dto
	 * 
	 * @author huangxj
	 *
	 * @date 2018年5月19日 下午3:10:58
	 * 
	 * @version v1.0
	 */
	public D voToDto() {
		D dto = BeanCopyTools.copy(this, dtoClass);

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		dto.setOperateIp(WebTool.getRequestIp(request));
		dto.setOperator("admin");
		return dto;
	}
}
