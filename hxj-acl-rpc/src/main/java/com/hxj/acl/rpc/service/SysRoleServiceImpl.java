package com.hxj.acl.rpc.service;

import com.hxj.acl.rpc.api.dto.SysRoleDto;
import com.hxj.acl.rpc.api.entity.SysRole;
import com.hxj.acl.rpc.api.service.SysRoleService;
import com.hxj.acl.rpc.mapper.SysRoleMapper;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.hxj.db.core.base.BaseServiceImpl;

/**
 * 角色表服务类实现
 * 
 * @author huangxj
 *
 * @date 2018-05-12 15:44:29
 * 
 * @version v1.0
 */
@Transactional
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole, SysRoleDto> implements SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;
}
