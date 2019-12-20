package com.xh.learn.website.config.servlet.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xh.learn.sdk.entity.Result;
import com.xh.learn.sdk.error.SdkError;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Result handException(Exception e) {
		e.printStackTrace();
		return new Result(SdkError.INTERNAL_ERROR);
	}
}
