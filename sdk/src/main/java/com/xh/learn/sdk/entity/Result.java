package com.xh.learn.sdk.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.xh.learn.sdk.error.SdkError;

public class Result extends Entity implements Serializable {
	public static final Integer SUCCESS = Integer.valueOf(1);
	public static final Integer FAIL = Integer.valueOf(0);

	private static final long serialVersionUID = 1L;

	private Integer ret;
	private Object data;

	public Result() {
		super();
	}

	public Result(Integer ret) {
		this.ret = ret;
	}

	public Result(SdkError error) {
		this.ret = Result.FAIL;
		this.data = error;
	}

	public Result(Integer ret, Object data) {
		this.ret = ret;
		this.data = data;
	}

	/*-----------------------------------------------------------------------------------*/
	public Result error(SdkError error) {
		this.ret = Result.FAIL;

		Map<String, Object> map = new HashMap<>();
		map.put("message", error.getMessage());
		map.put("code", error.getCode());
		this.data = map;

		return this;
	}

	/*-----------------------------------------------------------------------------------*/
	public Integer getRet() {
		return ret;
	}

	public void setRet(Integer ret) {
		this.ret = ret;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
