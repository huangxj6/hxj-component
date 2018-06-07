package com.hxj.acl.rpc.api.entity;

import java.util.Date;
import java.math.BigDecimal;

import com.hxj.common.api.base.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 角色用户表实体
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
public class SysRoleUser extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	/**
	 *角色id
	 */
	public static final String ROLE_ID = "roleId";
	/**
	 *用户id
	 */
	public static final String USER_ID = "userId";
	
	@ApiModelProperty(value = "角色id")
	private Integer roleId;
	@ApiModelProperty(value = "用户id")
	private Integer userId;
}
