package com.xh.learn.website.config.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {

	@Value("${mail.user}")
	private String mailUser;

	@Value("${mail.password}")
	private String mailPassword;

	@Value("${mail.smtp.host}")
	private String mailSmtpHost;

	@Value("${mail.smtp.port}")
	private Integer mailSmtpPort;

	@Bean(name = "mail_sender")
	public MailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost(mailSmtpHost);
		mailSender.setPort(mailSmtpPort);

		mailSender.setUsername(mailUser);
		mailSender.setPassword(mailPassword);

		return mailSender;
	}

}
