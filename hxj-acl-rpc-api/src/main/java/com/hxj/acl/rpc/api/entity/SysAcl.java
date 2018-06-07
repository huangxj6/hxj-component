package com.hxj.acl.rpc.api.entity;

import com.hxj.common.api.base.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 权限表实体
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
public class SysAcl extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	/**
	 *权限码
	 */
	public static final String CODE = "code";
	/**
	 *权限名称
	 */
	public static final String NAME = "name";
	/**
	 *权限所在的权限模块id
	 */
	public static final String ACL_MODULE_ID = "aclModuleId";
	/**
	 *请求的url, 可以填正则表达式
	 */
	public static final String URL = "url";
	/**
	 *类型，1：菜单，2：按钮，3：其他
	 */
	public static final String TYPE = "type";
	/**
	 *状态，1：正常，0：冻结
	 */
	public static final String STATUS = "status";
	/**
	 *备注
	 */
	public static final String REMARK = "remark";
	
	@ApiModelProperty(value = "权限码")
	private String code;
	@ApiModelProperty(value = "权限名称")
	private String name;
	@ApiModelProperty(value = "权限所在的权限模块id")
	private Integer aclModuleId;
	@ApiModelProperty(value = "请求的url, 可以填正则表达式")
	private String url;
	@ApiModelProperty(value = "类型，1：菜单，2：按钮，3：其他")
	private Integer type;
	@ApiModelProperty(value = "状态，1：正常，0：冻结")
	private Integer status;
	@ApiModelProperty(value = "备注")
	private String remark;
}
