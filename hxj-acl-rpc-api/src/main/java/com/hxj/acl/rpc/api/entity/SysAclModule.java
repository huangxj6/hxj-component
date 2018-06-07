package com.hxj.acl.rpc.api.entity;

import com.hxj.common.api.base.tree.BaseLevelEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 权限模块表实体
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
public class SysAclModule extends BaseLevelEntity {

	private static final long serialVersionUID = 1L;
	
	/**
	 *权限模块名称
	 */
	public static final String NAME = "name";
	/**
	 *状态，1：正常，0：冻结
	 */
	public static final String STATUS = "status";
	/**
	 *备注
	 */
	public static final String REMARK = "remark";
	
	@ApiModelProperty(value = "权限模块名称")
	private String name;
	@ApiModelProperty(value = "状态，1：正常，0：冻结")
	private Integer status;
	@ApiModelProperty(value = "备注")
	private String remark;
}
