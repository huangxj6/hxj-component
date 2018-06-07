package com.hxj.dwz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxj.acl.rpc.api.dto.SysUserDto;
import com.hxj.acl.rpc.api.service.SysRoleService;
import com.hxj.acl.rpc.api.service.SysUserService;
import com.hxj.common.api.bean.PageQueryDto;
import com.hxj.core.base.BaseController;

@Controller
public class SysUserController extends BaseController {

	@Lazy
	@Autowired
	@Qualifier("sysUserService")
	private SysUserService sysUserService;

	@Lazy
	@Autowired
	@Qualifier("sysRoleService")
	private SysRoleService sysRoleService;

	@ResponseBody
	@GetMapping("test")
	public Object test() {
		return sysUserService.listAll();
	}

	@ResponseBody
	@GetMapping("test1")
	public Object test1(Integer id, String[] properties) {
		return sysUserService.getById(id, properties);
	}

	@ResponseBody
	@GetMapping("test2")
	public Object test2() {
		return sysRoleService.listAll();
	}

	@GetMapping("test3")
	public String test3(Model model) {

		model.addAttribute("abc", 666);
		return "viewtest";
	}

	@ResponseBody
	@GetMapping("findByPage")
	public Object findByPage(PageQueryDto<SysUserDto> pageQueryDto) {

		return sysUserService.listByPage(pageQueryDto);
	}
}
