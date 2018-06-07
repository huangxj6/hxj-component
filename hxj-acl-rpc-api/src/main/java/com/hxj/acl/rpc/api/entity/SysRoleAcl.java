package com.hxj.acl.rpc.api.entity;

import java.util.Date;
import java.math.BigDecimal;

import com.hxj.common.api.base.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 角色权限表实体
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
public class SysRoleAcl extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	/**
	 *角色id
	 */
	public static final String ROLE_ID = "roleId";
	/**
	 *权限id
	 */
	public static final String ACL_ID = "aclId";
	
	@ApiModelProperty(value = "角色id")
	private Integer roleId;
	@ApiModelProperty(value = "权限id")
	private Integer aclId;
}
