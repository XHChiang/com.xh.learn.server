package com.xh.learn.sdk.util;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibDynamicProxy implements MethodInterceptor {
	private Object target;

	public CglibDynamicProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("------插入前置通知代码-------------");
		Object result = method.invoke(target, args); // 执行相应的目标方法
		System.out.println("------插入后置处理代码-------------");
		return result;
	}

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(HelloService.class);
		enhancer.setCallback(new CglibDynamicProxy(new HelloService()));

		HelloService helloServiceProxy = (HelloService) enhancer.create();

		helloServiceProxy.sayHello();
	}
}

class HelloService {
	public void sayHello() {
		System.out.println("Hello CGLIB!");
	}
}
