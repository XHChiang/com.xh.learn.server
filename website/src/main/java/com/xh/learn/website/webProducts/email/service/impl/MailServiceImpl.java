package com.xh.learn.website.webProducts.email.service.impl;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.xh.learn.sdk.entity.Result;
import com.xh.learn.sdk.error.SdkError;
import com.xh.learn.sdk.util.ExceptionUtil;
import com.xh.learn.website.webProducts.email.service.MailService;

@Service
@DependsOn(value = "mail_sender")
public class MailServiceImpl implements MailService {
	private static Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

	@Value("${mail.user}")
	private String mailUser;

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	TemplateEngine templateEngine;

	@Override
	public Result send(String to, String subject, String text) {
		Result result = new Result(Result.SUCCESS);
		try {
			SimpleMailMessage message = new SimpleMailMessage();

			message.setFrom(mailUser);
			message.setTo(to);

			message.setSubject(subject);// 主题
			message.setText(text);// 内容

			mailSender.send(message);
		} catch (Exception e) {
			result.error(SdkError.INTERNAL_ERROR);
			logger.error(ExceptionUtil.eToString(e));
		}

		return result;
	}

	@Override
	public Result sendV2(String to, String subject, String text, String attachment) {
		Result result = new Result(Result.SUCCESS);
		try {
			MimeMessage message = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom(mailUser);
			helper.setTo(to);

			helper.setSubject(subject);// 主题
			String tm = "<html><body><h1>" + text + "</h1></br><img src=\"cid:testimg\" /></body></html>";
			helper.setText(tm, true);// 内容
			
			FileSystemResource image = new FileSystemResource("D:/C_TEMP/picture/20180412165848_304.jpg");
			helper.addInline("testimg", image);// 图片

			if (attachment != null && !"".equals(attachment)) {
				FileSystemResource fsr = new FileSystemResource(attachment);
				helper.addAttachment(fsr.getFilename(), fsr);// 附件
			}

			mailSender.send(message);
		} catch (Exception e) {
			result.error(SdkError.INTERNAL_ERROR);
			logger.error(ExceptionUtil.eToString(e));
		}

		return result;
	}

	@Override
	public Result sendV3(String to, String subject, String text, String attachment) {
		Result result = new Result(Result.SUCCESS);
		try {
			MimeMessage message = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom(mailUser);
			helper.setTo(to);
			
			helper.setSubject(subject);// 主题
			
			Context cxt = new Context();
			cxt.setVariable("text", text);
			String htmltext = templateEngine.process("email/template.html", cxt);// 渲染模板
			helper.setText(htmltext, true);
			
			FileSystemResource image = new FileSystemResource("D:/C_TEMP/picture/20180412165848_304.jpg");
			helper.addInline("testimg", image);

			mailSender.send(message);
		} catch (Exception e) {
			result.error(SdkError.INTERNAL_ERROR);
			logger.error(ExceptionUtil.eToString(e));
		}

		return result;
	}

}
