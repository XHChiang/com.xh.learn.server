package com.xh.learn.website.webProducts.mq.active.rpcJms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xh.learn.website.webProducts.mq.active.rpcJms.service.DemoJmsService;
import com.xh.learn.website.webProducts.usr.entity.Usr;
import com.xh.learn.website.webProducts.usr.mapper.UsrMapper;

@Service
public class DemoJmsServiceImpl implements DemoJmsService {

	@Autowired
	UsrMapper usrMapper;

	@Override
	public String queryUsrs() {
		List<Usr> usrs = usrMapper.queryUsrs();
		return JSON.toJSONString(usrs);
	}

}
