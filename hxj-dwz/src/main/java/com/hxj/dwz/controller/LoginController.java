package com.hxj.dwz.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxj.common.tools.StringTools;
import com.hxj.core.base.BaseController;

/**
 * 登录控制类
 * 
 * @author huangxj
 *
 * @date 2018年5月22日 下午10:09:38
 * 
 * @version v1.0
 */
@Controller
public class LoginController extends BaseController{

	/**
	 * 登录请求
	 *  
	 * @author huangxj 
	 *
	 * @date 2018年5月22日 下午10:13:52
	 * 
	 * @version v1.0
	 */
	@PostMapping("login")
	public String login(String userName, String password, String checkcode, Model model) {

		return "redirect:/";
	}
	
	@GetMapping("/")
	public String index() {

		return "index";
	}
	
	@GetMapping("logout")
	public String logout() {
		
		return "redirect:login";
	}

	/**
	 * 创建验证码
	 * 
	 * @author huangxj 2017年3月17日
	 *
	 * @version v1.0
	 */
	@ResponseBody
	@GetMapping("getCode")
	public void getCode() throws IOException {
		
		int width = 48;
		int height = 20;
		// 禁止浏览器缓存图片
		response.setDateHeader("Expires", -1);
		response.setHeader("cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		// 通知客户端以图片的方式打开发送过去的数据
		response.setHeader("Content-Type", "image/jpeg");
		// 在内存中创建一副图片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		// 向图片中写数据
		Graphics g = image.getGraphics();
		// 设置背景色
		g.setColor(new Color(240, 247, 253));
		g.fillRect(0, 0, width, height);

		// 设置写入的数据颜色和字体
		g.setColor(new Color(14, 73, 71));
		g.setFont(new Font(null, Font.BOLD, 20));
		// 向图片上写数据
		String str = StringTools.getRandom(4);
		// 把随机数生成的数值保存到session
		session.setAttribute("checkcode", str);
		g.drawString(str, 2, 15);

		// 把写好的数据输出给浏览器
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

}
