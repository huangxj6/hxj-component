package com.hxj.acl.rpc.api.entity;

import java.util.Date;
import java.math.BigDecimal;

import com.hxj.common.api.base.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 角色表实体
 * 
 * @author huangxj
 *
 * @date 2018-05-13 11:56:59
 * 
 * @version v1.0
 */
@Getter
@Setter
@ToString
public class SysRole extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	/**
	 *
	 */
	public static final String NAME = "name";
	/**
	 *角色的类型，1：管理员角色，2：其他
	 */
	public static final String TYPE = "type";
	/**
	 *状态，1：可用，0：冻结
	 */
	public static final String STATUS = "status";
	/**
	 *备注
	 */
	public static final String REMARK = "remark";
	
	@ApiModelProperty(value = "")
	private String name;
	@ApiModelProperty(value = "角色的类型，1：管理员角色，2：其他")
	private Integer type;
	@ApiModelProperty(value = "状态，1：可用，0：冻结")
	private Integer status;
	@ApiModelProperty(value = "备注")
	private String remark;
}
