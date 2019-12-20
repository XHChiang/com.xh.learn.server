package com.xh.learn.website.webProducts.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xh.learn.sdk.entity.Result;
import com.xh.learn.website.webProducts.email.service.MailService;

@RestController
@RequestMapping("/email")
public class MailController {

	@Autowired
	MailService mailService;

	@PostMapping("/send")
	public Result send(String to, String subject, String text) {
		Result result = mailService.send(to, subject, text);
		return result;
	}

	@PostMapping("/send/v2")
	public Result sendV2(String to, String subject, String text, String attachment) {
		Result result = mailService.sendV2(to, subject, text, attachment);
		return result;
	}

	@PostMapping("/send/v3")
	public Result sendV3(String to, String subject, String text, String attachment) {
		Result result = mailService.sendV3(to, subject, text, attachment);
		return result;
	}
}
