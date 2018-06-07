package com.hxj.dwz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxj.common.tools.StringTools;
import com.hxj.core.base.BaseController;

/**
 * 通用控制类
 * 
 * @author huangxj
 *
 * @date 2018年5月20日 上午10:14:35
 * 
 * @version v1.0
 */
@Controller
public class PageController extends BaseController {

	@Autowired
	private SysDeptController sysDeptController;

	/**
	 * 部门管理页面
	 * 
	 * @author huangxj
	 *
	 * @date 2018年5月30日 下午9:02:15
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/dept/page.page")
	public String sysDeptPage(Model model) {
		model.addAttribute("data", sysDeptController.listTree());
		return urlPage();
	}

	/**
	 * 所有后缀为page的均为页面上的跳转
	 * 
	 * @author huangxj
	 *
	 * @date 2018年5月20日 下午2:31:49
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/**/*.page")
	public String showPage(Integer id, Model model) {
		
		model.addAttribute("id", id);
		return urlPage();
	}

	private String urlPage() {
		String url = request.getRequestURI();
		url = StringTools.removeEnd(url, ".page");
		return url;
	}
}