package com.xh.learn.website.webProducts.rpc.httpInvoker.service;

import com.xh.learn.website.webProducts.rpc.httpInvoker.IHttpInvoker;

public interface IHttpInvokerUsrService extends IHttpInvoker {
	public String queryUsrs();

	public String sayHelloToSomeBody(String someBodyName);
}
