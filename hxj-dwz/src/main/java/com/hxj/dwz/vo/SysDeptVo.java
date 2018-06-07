package com.hxj.dwz.vo;

import com.hxj.acl.rpc.api.dto.SysDeptDto;
import com.hxj.core.bean.BaseVo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 部门vo
 * 
 * @author huangxj
 *
 * @date 2018年5月19日 下午2:58:00
 * 
 * @version v1.0
 */
@Getter
@Setter
public class SysDeptVo extends BaseVo<SysDeptDto>{

	@ApiModelProperty(value = "主键id，更新时需传入")
	private Integer id;
	
	@ApiModelProperty(value = "部门名称")
	private String name;

	@ApiModelProperty(value = "备注")
	private String remark;

	@ApiModelProperty(value = "上级id")
	private Integer parentId;
	
	@ApiModelProperty(value = "顺序，大的排前面")
	private Integer seq;
}
