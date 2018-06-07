package com.hxj.acl.rpc.service;

import com.hxj.acl.rpc.api.dto.SysUserDto;
import com.hxj.acl.rpc.api.entity.SysUser;
import com.hxj.acl.rpc.api.service.SysUserService;
import com.hxj.acl.rpc.mapper.SysUserMapper;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.hxj.db.core.base.BaseServiceImpl;

/**
 * 用户表服务类实现
 * 
 * @author huangxj
 *
 * @date 2018-05-12 15:44:29
 * 
 * @version v1.0
 */
@Transactional
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, SysUserDto> implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;
}
