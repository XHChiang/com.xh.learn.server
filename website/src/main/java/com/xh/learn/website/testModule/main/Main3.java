package com.xh.learn.website.testModule.main;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Main3 implements BeanNameAware {
	@Value("#{T(System).currentTimeMillis()}")
	private Long time;

	public void showtime() {
		System.out.println(String.format("NOW-TIME: %d", time));
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setBeanName(String name) {
		this.name = name;
	}

}
