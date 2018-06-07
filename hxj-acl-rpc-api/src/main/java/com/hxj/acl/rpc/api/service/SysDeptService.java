package com.hxj.acl.rpc.api.service;

import java.util.List;

import com.hxj.acl.rpc.api.dto.SysDeptDto;
import com.hxj.acl.rpc.api.entity.SysDept;
import com.hxj.common.api.base.BaseService;
import com.hxj.common.api.exception.CustomException;
import com.hxj.common.api.exception.ParamException;

/**
 * 部门表服务类接口
 * 
 * @author huangxj
 *
 * @date 2018-05-12 15:44:28
 * 
 * @version v1.0
 */
public interface SysDeptService extends BaseService<SysDept, SysDeptDto> {

	/**
	 * 创建一个新的部门
	 * 	1、设置层级
	 * 	2、保存进数据库
	 * 	3、若部门名称已经存在的话则抛ParamException异常
	 * 
	 * @author huangxj 
	 *
	 * @date 2018年5月20日 下午1:50:03
	 * 
	 * @version v1.0
	 */
	public void create(SysDeptDto sysDeptDto) throws ParamException;
	
	/**
	 * 获取部门树
	 * 	1、从数据库中查出所有的部门列表
	 * 	2、利用LevelTreeTool的buildTree方法将列表转换成一棵树
	 * 
	 * @author huangxj 
	 *
	 * @date 2018年5月12日 下午5:45:59
	 * 
	 * @version v1.0
	 */
	public List<SysDeptDto> listDeptTree();

	/**
	 * 修改一个部门
	 * 	1、传入部门的上级部门id，计算修改后的部门层级
	 * 	2、若部门的层级发生改变的话，则还需要同步修改该部门下面子部门的层级
	 * 
	 * @author huangxj 
	 *
	 * @date 2018年5月19日 下午3:47:05
	 * 
	 * @version v1.0
	 * @throws ParamException 
	 */
	public void modify(SysDeptDto sysDeptDto) throws ParamException;

	/**
	 * 删除一个部门
	 * 	1、如果该部门下面有子部门的话，则不给删除
	 * 	2、如果有用户属于该部门的话，则不给删除
	 * 
	 * @author huangxj 
	 *
	 * @date 2018年5月19日 下午5:29:38
	 * 
	 * @version v1.0
	 * @throws ParamException 
	 */
	public void delete(Integer id) throws ParamException;
	
}
