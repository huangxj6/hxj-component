package com.hxj.acl.rpc.api.dto;

import java.util.List;

import com.hxj.acl.rpc.api.entity.SysDept;
import com.hxj.common.api.base.tree.NextLevelListOperate;

/**
 * 部门表dto
 * 
 * @author huangxj
 *
 * @date 2018-05-12 15:44:28
 * 
 * @version v1.0
 */
public class SysDeptDto extends SysDept implements NextLevelListOperate<SysDeptDto>{

	private static final long serialVersionUID = 1L;

	private List<SysDeptDto> nextList;

	@Override
	public void setNextList(List<SysDeptDto> list) {
		this.nextList = list;
	}

	@Override
	public List<SysDeptDto> getNextList() {
		return nextList;
	}
}
