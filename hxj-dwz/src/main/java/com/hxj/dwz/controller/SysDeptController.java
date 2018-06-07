package com.hxj.dwz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hxj.acl.rpc.api.dto.SysDeptDto;
import com.hxj.acl.rpc.api.service.SysDeptService;
import com.hxj.common.api.exception.CustomException;
import com.hxj.core.base.BaseController;
import com.hxj.core.bean.JsonData;
import com.hxj.dwz.vo.SysDeptVo;

import io.swagger.annotations.ApiOperation;

/**
 * 部门表控制类
 * 
 * @author huangxj
 *
 * @date 2018-05-12 15:44:28
 * 
 * @version v1.0
 */
@RestController
@RequestMapping("sysDept")
public class SysDeptController extends BaseController {

	@Lazy
	@Autowired
	@Qualifier("sysDeptService")
	private SysDeptService sysDeptService;

	@PostMapping("/create")
	@ApiOperation(value = "新增一个部门", notes = "新增一个部门")
	public JsonData<?> create(SysDeptVo sysDeptVo) throws CustomException {
		sysDeptService.create(sysDeptVo.voToDto());
		return JsonData.returnSuccessAndColseDialog("创建成功！");
	}

	@PostMapping("/delete/{id}")
	@ApiOperation(value = "根据部门id删除一个部门", notes = "根据部门id删除一个部门")
	public JsonData<?> delete(@PathVariable Integer id) throws CustomException {
		sysDeptService.delete(id);
		return JsonData.success("删除成功！","/dept/page.page");
	}

	@PostMapping("/modify")
	@ApiOperation(value = "修改部门消息", notes = "部门id一定要传，其他信息不传表示不修改")
	public JsonData<?> modify(SysDeptVo sysDeptVo) throws CustomException {
		sysDeptService.modify(sysDeptVo.voToDto());
		return JsonData.success();
	}
	
	@GetMapping("/get/{id}")
	@ApiOperation(value = "获取一个部门信息的详情", notes = "获取一个部门信息的详情")
	public SysDeptDto get(@PathVariable Integer id) {
		return sysDeptService.get(id);
	}

	@GetMapping("/listTree")
	@ApiOperation(value = "列出部门树", notes = "列出部门树")
	public List<SysDeptDto> listTree() {
		return sysDeptService.listDeptTree();
	}
}
