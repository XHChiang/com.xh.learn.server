package com.xh.learn.website.webProducts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页
 */
@Controller
public class IndexController {

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("name", "JiangXiaohang");
		return "index";
	}
}
