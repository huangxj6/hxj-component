package com.hxj.acl.rpc.service;

import com.hxj.acl.rpc.api.dto.SysRoleUserDto;
import com.hxj.acl.rpc.api.entity.SysRoleUser;
import com.hxj.acl.rpc.api.service.SysRoleUserService;
import com.hxj.acl.rpc.mapper.SysRoleUserMapper;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.hxj.db.core.base.BaseServiceImpl;

/**
 * 角色用户表服务类实现
 * 
 * @author huangxj
 *
 * @date 2018-05-12 15:44:29
 * 
 * @version v1.0
 */
@Transactional
public class SysRoleUserServiceImpl extends BaseServiceImpl<SysRoleUser, SysRoleUserDto> implements SysRoleUserService {

	@Autowired
	private SysRoleUserMapper sysRoleUserMapper;
}
