package com.hxj.acl.rpc.api.entity;

import java.util.Date;
import java.math.BigDecimal;

import com.hxj.common.api.base.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 日志表实体
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
public class SysLog extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	/**
	 *权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系
	 */
	public static final String TYPE = "type";
	/**
	 *基于type后指定的对象id，比如用户、权限、角色等表的主键
	 */
	public static final String TARGET_ID = "targetId";
	/**
	 *旧值
	 */
	public static final String OLD_VALUE = "oldValue";
	/**
	 *新值
	 */
	public static final String NEW_VALUE = "newValue";
	/**
	 *当前是否复原过，0：没有，1：复原过
	 */
	public static final String STATUS = "status";
	
	@ApiModelProperty(value = "权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系")
	private Integer type;
	@ApiModelProperty(value = "基于type后指定的对象id，比如用户、权限、角色等表的主键")
	private Integer targetId;
	@ApiModelProperty(value = "旧值")
	private String oldValue;
	@ApiModelProperty(value = "新值")
	private String newValue;
	@ApiModelProperty(value = "当前是否复原过，0：没有，1：复原过")
	private Integer status;
}
