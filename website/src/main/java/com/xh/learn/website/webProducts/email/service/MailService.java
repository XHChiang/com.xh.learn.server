package com.xh.learn.website.webProducts.email.service;

import com.xh.learn.sdk.entity.Result;

public interface MailService {
	public Result send(String to, String subject, String text);

	public Result sendV2(String to, String subject, String text, String attachment);

	public Result sendV3(String to, String subject, String text, String attachment);
}
