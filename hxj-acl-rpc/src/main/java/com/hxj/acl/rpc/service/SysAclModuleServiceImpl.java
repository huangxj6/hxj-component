package com.hxj.acl.rpc.service;

import com.hxj.acl.rpc.api.dto.SysAclModuleDto;
import com.hxj.acl.rpc.api.entity.SysAclModule;
import com.hxj.acl.rpc.api.service.SysAclModuleService;
import com.hxj.acl.rpc.mapper.SysAclModuleMapper;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.hxj.db.core.base.BaseServiceImpl;

/**
 * 权限模块表服务类实现
 * 
 * @author huangxj
 *
 * @date 2018-05-12 15:44:28
 * 
 * @version v1.0
 */
@Transactional
public class SysAclModuleServiceImpl extends BaseServiceImpl<SysAclModule, SysAclModuleDto> implements SysAclModuleService {

	@Autowired
	private SysAclModuleMapper sysAclModuleMapper;
}
