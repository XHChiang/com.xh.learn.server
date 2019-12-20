package com.xh.learn.website.testModule;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 
 * @Description: 转发、重定向、参数传递
 * @author: JiangXiaohang
 * @date: 2018年9月26日 上午10:06:53
 */
@Controller
@RequestMapping("/test-b")
public class TestControllerB {

	@RequestMapping("/dst")
	public String testdst() {
		return "/index";
	}

	/**
	 * 重定向
	 * 
	 * @param name
	 * @param rAttributes
	 * @return
	 */
	@RequestMapping("/v1")
	public String test1(String name, RedirectAttributes rAttributes) {
		rAttributes.addFlashAttribute("name", name);
		return "redirect:/test-b/dst";
	}

	/**
	 * 转发
	 * 
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping("/v2")
	public String test2(String name, Model model) {
		model.addAttribute("name", name);
		return "forward:/test-b/dst";
	}
}
