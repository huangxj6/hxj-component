package com.hxj.demo.rpc.mapper;

import java.util.List;

import com.hxj.db.core.base.BaseMapper;
import com.hxj.demo.rpc.api.entity.User;

public interface UserMapper extends BaseMapper<User> {
	
	List<User> findAll();
}
