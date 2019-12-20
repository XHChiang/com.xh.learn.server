package com.xh.learn.sdk.util;

public class ReflectionUtil {
	/**
	 * 私有构造方法，禁止实例化
	 */
	private ReflectionUtil() {
		super();
	}

	/**
	 * 调用对象无参方法
	 * 
	 * @param object
	 * @param methodName
	 * @return
	 */
	public static Object invokeMethod(Object object, String methodName) {
		Object result = null;
		try {
			Class<?> cls = object.getClass();
			result = cls.getMethod(methodName).invoke(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 调用对象有参方法
	 * 
	 * @param object
	 * @param methodName
	 * @param args
	 * @return
	 */
	public static Object invokeMethod(Object object, String methodName, Object... args) {
		Object result = null;
		try {
			Class<?> cls = object.getClass();

			Class<?>[] classes = new Class[args.length];
			for (int i = 0; i < args.length; i++) {
				classes[i] = args[i].getClass();
			}

			result = cls.getMethod(methodName, classes).invoke(object, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}