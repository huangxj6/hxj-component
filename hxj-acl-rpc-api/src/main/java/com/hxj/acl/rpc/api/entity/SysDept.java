package com.hxj.acl.rpc.api.entity;

import com.hxj.common.api.base.tree.BaseLevelEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 部门表实体
 * 
 * @author huangxj
 *
 * @date 2018-05-13 11:56:58
 * 
 * @version v1.0
 */
@Getter
@Setter
@ToString
public class SysDept extends BaseLevelEntity {

	private static final long serialVersionUID = 1L;
	
	/**
	 *部门名称
	 */
	public static final String NAME = "name";
	
	/**
	 *备注
	 */
	public static final String REMARK = "remark";
	
	@ApiModelProperty(value = "部门名称")
	private String name;
	@ApiModelProperty(value = "备注")
	private String remark;
}
