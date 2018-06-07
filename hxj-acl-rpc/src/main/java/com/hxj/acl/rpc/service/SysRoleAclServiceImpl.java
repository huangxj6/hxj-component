package com.hxj.acl.rpc.service;

import com.hxj.acl.rpc.api.dto.SysRoleAclDto;
import com.hxj.acl.rpc.api.entity.SysRoleAcl;
import com.hxj.acl.rpc.api.service.SysRoleAclService;
import com.hxj.acl.rpc.mapper.SysRoleAclMapper;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.hxj.db.core.base.BaseServiceImpl;

/**
 * 角色权限表服务类实现
 * 
 * @author huangxj
 *
 * @date 2018-05-12 15:44:29
 * 
 * @version v1.0
 */
@Transactional
public class SysRoleAclServiceImpl extends BaseServiceImpl<SysRoleAcl, SysRoleAclDto> implements SysRoleAclService {

	@Autowired
	private SysRoleAclMapper sysRoleAclMapper;
}
