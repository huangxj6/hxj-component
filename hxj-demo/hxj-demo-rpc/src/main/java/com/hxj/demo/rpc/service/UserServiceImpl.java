package com.hxj.demo.rpc.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.hxj.db.core.base.BaseServiceImpl;
import com.hxj.demo.rpc.api.UserService;
import com.hxj.demo.rpc.api.dto.UserDto;
import com.hxj.demo.rpc.api.entity.User;

@Service(version = "1.0.0")
public class UserServiceImpl extends BaseServiceImpl<User, UserDto> implements UserService{
	
	
}
