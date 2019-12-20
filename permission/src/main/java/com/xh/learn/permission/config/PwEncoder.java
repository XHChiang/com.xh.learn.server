package com.xh.learn.permission.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PwEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		String pwd = rawPassword.toString();
		return pwd;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return true;
	}

}
