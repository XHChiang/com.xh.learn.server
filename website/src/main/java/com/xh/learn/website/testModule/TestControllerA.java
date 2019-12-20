package com.xh.learn.website.testModule;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xh.learn.website.webProducts.usr.entity.Usr;

/**
 * 
 * @Description: 传递参数的方式
 * @author: JiangXiaohang
 * @date: 2018年9月26日 上午10:06:31
 */
@RestController
@RequestMapping("/test-a")
public class TestControllerA {

	@GetMapping("/v1")
	public Object v1(@RequestParam Integer pageNum) {
		return pageNum;
	}

	@GetMapping("/v2")
	public Object v2(Usr usr) {
		return usr;
	}

	@GetMapping("/v3/{x}")
	public Object v3(@PathVariable("x") String x) {
		return x;
	}

	@PostMapping("/v4")
	public Object v4(@RequestParam Integer pageNum) {
		return pageNum;
	}

	@PostMapping("/v5")
	public Object v5(Usr usr) {
		return usr;
	}

	@PostMapping("/v6/{x}")
	public Object v2(@PathVariable("x") String x) {
		return x;
	}
}
