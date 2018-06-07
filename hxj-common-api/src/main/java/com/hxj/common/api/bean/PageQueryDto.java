package com.hxj.common.api.bean;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 分页查询dto
 * 
 * @author huangxj 2018年4月20日 
 * 
 * @version v1.0
 */
@Getter
@Setter
public class PageQueryDto<T> implements Serializable{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "查询第几页（从1开始）")
	private Integer pageNum = 1;

	@ApiModelProperty(value = "查询几条")
	private Integer pageSize = 10;

	@ApiModelProperty(value = "查询条件")
	private T queryConditions;
	
	@ApiModelProperty(value = "排序")
	private Order[] orders;
	
	@ApiModelProperty(value = "要检索的字段")
	private String[] properties;
}
