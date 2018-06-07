package com.hxj.common.api.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 实体基类
 * 
 * @author huangxj 2018年4月23日
 * 
 * @version v1.0
 */
@Getter
@Setter
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public final static String ID = "id";
	public final static String GMT_CREATE = "gmtCreate";
	public final static String GMT_MODIFIED = "gmtModified";
	public static final String SEQ = "seq";
	public static final String OPERATOR = "operator";
	public static final String OPERATOR_IP = "operateIp";

	@Id
	@GeneratedValue(generator = "JDBC")
	@ApiModelProperty(value = "主键id，由数据库自增")
	private Integer id;

	@OrderBy("DESC")
	@ApiModelProperty(value = "顺序，大的排前面")
	private Integer seq;

	@OrderBy("DESC")
	@ApiModelProperty(value = "修改时间")
	private Date gmtModified;

	@OrderBy("DESC")
	@ApiModelProperty(value = "创建时间")
	private Date gmtCreate;

	@ApiModelProperty(value = "操作者")
	private String operator;

	@ApiModelProperty(value = "最后一次更新操作者的ip地址")
	private String operateIp;

}
