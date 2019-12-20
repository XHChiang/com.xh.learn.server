package com.xh.learn.website.webProducts.rpc.hessian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xh.learn.website.webProducts.rpc.hessian.service.IHessianUsrService;
import com.xh.learn.website.webProducts.usr.entity.Usr;
import com.xh.learn.website.webProducts.usr.mapper.UsrMapper;

@Service
public class IHessianUsrServiceImpl implements IHessianUsrService {

	@Autowired
	UsrMapper usrMapper;

	@Override
	public String queryUsrs() {
		List<Usr> usrs = usrMapper.selectAll();
		return JSON.toJSONString(usrs);
	}

	@Override
	public String sayHelloToSomeBody(String someBodyName) {
		return "你好，" + someBodyName + "!";
	}

}
