package com.xh.learn.website.webProducts.log;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xh.learn.sdk.entity.Result;

@RestController
@RequestMapping("/log")
public class LogController {

	@GetMapping("/query")
	public Result queryLogs() {
		Result result = new Result();
		return result;
	}
}
