package com.hxj.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hxj.common.api.bean.PageQueryDto;
import com.hxj.demo.rpc.api.UserService;
import com.hxj.demo.rpc.api.dto.UserDto;

@Controller
public class TestController {

	@Reference(version = "1.0.0")
	private UserService userService;

	@ResponseBody
	@GetMapping("test1")
	public Object test1(Model model) {

		return userService.listAll();
	}

	@ResponseBody
	@GetMapping("test2")
	public Object test2(Model model) {

		PageQueryDto<UserDto> pageQueryDto = new PageQueryDto<>();
		pageQueryDto.setPageNum(2);
		pageQueryDto.setPageSize(3);

		return userService.listByPage(pageQueryDto);
	}
}
