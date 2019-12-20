package com.xh.learn.website.webProducts.rpc.hessian.service;

import com.xh.learn.website.webProducts.rpc.hessian.IHessian;

public interface IHessianUsrService extends IHessian {
	public String queryUsrs();

	public String sayHelloToSomeBody(String someBodyName);
}
