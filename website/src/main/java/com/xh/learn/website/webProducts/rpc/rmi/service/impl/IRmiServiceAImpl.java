package com.xh.learn.website.webProducts.rpc.rmi.service.impl;

import org.springframework.stereotype.Service;

import com.xh.learn.website.webProducts.rpc.rmi.service.IRmiServiceA;

@Service
public class IRmiServiceAImpl implements IRmiServiceA {

	@Override
	public String test_v1() {
		String msg = "class[IRmiServiceAImpl] function[test_v1] is invoked.";
		return msg;
	}

	@Override
	public String test_v2(String str) {
		String msg = "class[IRmiServiceAImpl] function[test_v2] is invoked.";
		msg += " args[" + str + "]";
		return msg;
	}

}
