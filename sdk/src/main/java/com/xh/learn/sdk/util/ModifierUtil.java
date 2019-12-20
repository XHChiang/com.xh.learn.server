package com.xh.learn.sdk.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 
 * @Description: 修饰符
 * @author: JiangXiaohang
 * @date: 2018年8月14日 下午6:21:04
 */
@SuppressWarnings("unused")
public class ModifierUtil {
	public int a;

	public static int b;

	public static final int c = 0;

	private int d;

	private static int e;

	public static void main(String[] args) {
		Class<?> clazz = ModifierUtil.class;
		Field[] fields = clazz.getDeclaredFields();// 获取这个类所有的成员变量

		for (Field field : fields) {
			// 判断哪个字段是 private 不是 static、final的
			if ((field.getModifiers() & (Modifier.PRIVATE | Modifier.STATIC | Modifier.FINAL)) == Modifier.PRIVATE) {
				System.out.println(field.getName());
			}
		}
	}
}
