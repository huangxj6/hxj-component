package com.hxj.acl.rpc.api.entity;

import java.util.Date;
import java.math.BigDecimal;

import com.hxj.common.api.base.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户表实体
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
public class SysUser extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	/**
	 *用户名称
	 */
	public static final String USERNAME = "username";
	/**
	 *手机号
	 */
	public static final String TELEPHONE = "telephone";
	/**
	 *邮箱
	 */
	public static final String MAIL = "mail";
	/**
	 *加密后的密码
	 */
	public static final String PASSWORD = "password";
	/**
	 *用户所在部门的id
	 */
	public static final String DEPT_ID = "deptId";
	/**
	 *状态，1：正常，0：冻结状态，2：删除
	 */
	public static final String STATUS = "status";
	/**
	 *备注
	 */
	public static final String REMARK = "remark";
	
	@ApiModelProperty(value = "用户名称")
	private String username;
	@ApiModelProperty(value = "手机号")
	private String telephone;
	@ApiModelProperty(value = "邮箱")
	private String mail;
	@ApiModelProperty(value = "加密后的密码")
	private String password;
	@ApiModelProperty(value = "用户所在部门的id")
	private Integer deptId;
	@ApiModelProperty(value = "状态，1：正常，0：冻结状态，2：删除")
	private Integer status;
	@ApiModelProperty(value = "备注")
	private String remark;
}
