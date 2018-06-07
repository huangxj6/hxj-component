package com.hxj.common.api.base.tree;

import com.hxj.common.api.base.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 带有树状层级的基类
 * 
 * @author huangxj
 *
 * @date 2018年5月19日 上午11:43:25
 * 
 * @version v1.0
 */
@Getter
@Setter
public class BaseLevelEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 层级
	 */
	public static final String LEVEL = "level";

	/**
	 * 上级部门id
	 */
	public static final String PARENT_ID = "parentId";

	@ApiModelProperty(value = "上级id")
	private Integer parentId;
	@ApiModelProperty(value = "层级")
	private String level;
}
