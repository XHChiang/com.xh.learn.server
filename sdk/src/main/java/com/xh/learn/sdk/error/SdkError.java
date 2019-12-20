package com.xh.learn.sdk.error;

public enum SdkError {
	// 系统内部错误，请稍后再试....
	INTERNAL_ERROR("API0000", "Internal server error, please try again later..."),

	;

	private String code;// 错误码
	private String message; // 错误信息

	private SdkError(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
