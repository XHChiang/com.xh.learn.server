package com.xh.learn.website.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.xh.learn.website.config.servlet.intercepter.GlobalIntercepter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private GlobalIntercepter globalIntercepter;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		WebMvcConfigurer.super.addCorsMappings(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(globalIntercepter);
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
