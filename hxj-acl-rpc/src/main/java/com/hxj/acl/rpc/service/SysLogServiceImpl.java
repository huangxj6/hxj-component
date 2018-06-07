package com.hxj.acl.rpc.service;

import com.hxj.acl.rpc.api.dto.SysLogDto;
import com.hxj.acl.rpc.api.entity.SysLog;
import com.hxj.acl.rpc.api.service.SysLogService;
import com.hxj.acl.rpc.mapper.SysLogMapper;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.hxj.db.core.base.BaseServiceImpl;

/**
 * 日志表服务类实现
 * 
 * @author huangxj
 *
 * @date 2018-05-12 15:44:29
 * 
 * @version v1.0
 */
@Transactional
public class SysLogServiceImpl extends BaseServiceImpl<SysLog, SysLogDto> implements SysLogService {

	@Autowired
	private SysLogMapper sysLogMapper;
}
