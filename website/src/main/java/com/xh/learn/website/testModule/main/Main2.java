package com.xh.learn.website.testModule.main;

import org.springframework.beans.factory.annotation.Value;

public class Main2 {
	private Main3 main3;

	public Main2(Main3 main3) {
		this.main3 = main3;
	}

	public Main3 getMain3() {
		return main3;
	}

	public void setMain3(Main3 main3) {
		this.main3 = main3;
	}

	@Value("#{T(System).currentTimeMillis()}")
	private Long time;

	public void showtime() {
		System.out.println(String.format("NOW-TIME: %d", time));
	}

	public static void main(String[] args) {
		int i = 1 | 2 | 3 | 4;
		System.out.println(i);
	}
}
