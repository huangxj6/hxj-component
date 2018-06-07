package com.hxj.acl.rpc.mapper;

import org.apache.ibatis.annotations.Param;

import com.hxj.acl.rpc.api.entity.SysDept;
import com.hxj.db.core.base.BaseMapper;

/**
 * 部门表mapper
 * 
 * @author huangxj
 *
 * @date 2018-05-12 15:44:28
 * 
 * @version v1.0
 */

public interface SysDeptMapper extends BaseMapper<SysDept> {

	/**
	 * 更新层级的前缀
	 * 
	 * @author huangxj
	 *
	 * @date 2018年5月19日 下午4:37:14
	 * 
	 * @version v1.0
	 */
	public void updateLevelPrefix(@Param("oldPrefix") String oldPrefix, @Param("newPrefix") String newPrefix);

}
