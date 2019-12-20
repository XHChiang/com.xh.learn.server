package com.xh.learn.website.testModule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xh.learn.website.testModule.main.Main2;
import com.xh.learn.website.testModule.main.Main3;

@Configuration
public class TestConfig {

	@Bean
	public Main2 main2(Main3 main3) {
		return new Main2(main3);
	}
}
