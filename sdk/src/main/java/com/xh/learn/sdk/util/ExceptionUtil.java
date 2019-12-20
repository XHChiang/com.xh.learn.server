package com.xh.learn.sdk.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {

	/**
	 * 私有构造方法，禁止实例化
	 */
	private ExceptionUtil() {
		super();
	}

	/**
	 * 异常信息转字符串
	 * 
	 * @param e
	 * @return
	 */
	public static String eToString(Exception e) {
		StringWriter sw = new StringWriter();
		try {
			if (e != null) {
				e.printStackTrace(new PrintWriter(sw, true));
			} else {
				StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[1];
				sw.write("[" + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "]" + " Parameter(e) is null.");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return sw.toString();
	}
}