package com.xh.learn.sdk.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * @Description: JDK 动态代理
 * @author: JiangXiaohang
 * @date: 2018年8月14日 下午06:20:40
 */
public class JdkDynamicProxy {
	public interface IHello {
		void sayHello();

		default void test() {
			System.out.println("Hello DEFAULT!");
		}
	}

	static class Hello implements IHello {
		public void sayHello() {
			System.out.println("Hello world!");
		}
	}

	// 自定义InvocationHandler
	static class HWInvocationHandler implements InvocationHandler {
		// 目标对象
		private Object target;

		public HWInvocationHandler(Object target) {
			this.target = target;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (Object.class.equals(method.getDeclaringClass())) {
				return method.invoke(this, args);
			}

			System.out.println("------插入前置通知代码-------------");
			Object rs = method.invoke(target, args); // 执行相应的目标方法
			System.out.println("------插入后置处理代码-------------");
			return rs;
		}
	}

	public static void main(String[] args) throws Exception {
		Class<?>[] interfaces = new Class[] { IHello.class };
		HWInvocationHandler hwInvocationHandler = new HWInvocationHandler(new Hello());
		IHello iHello = (IHello) Proxy.newProxyInstance(Hello.class.getClassLoader(), interfaces, hwInvocationHandler);
		// 通过代理对象调用目标方法
		iHello.sayHello();
		// 调用Object对象方法时，直接调用
		//		iHello.toString();
		// JDK8新增默认接口
		//		iHello.test();
	}
}