package com.hxj.acl.rpc.service;

import com.hxj.acl.rpc.api.dto.SysAclDto;
import com.hxj.acl.rpc.api.entity.SysAcl;
import com.hxj.acl.rpc.api.service.SysAclService;
import com.hxj.acl.rpc.mapper.SysAclMapper;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.hxj.db.core.base.BaseServiceImpl;

/**
 * 权限表服务类实现
 * 
 * @author huangxj
 *
 * @date 2018-05-12 15:44:28
 * 
 * @version v1.0
 */
@Transactional
public class SysAclServiceImpl extends BaseServiceImpl<SysAcl, SysAclDto> implements SysAclService {

	@Autowired
	private SysAclMapper sysAclMapper;
}
