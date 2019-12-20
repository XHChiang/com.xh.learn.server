package com.xh.learn.website.webProducts.rpc.jaxws.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xh.learn.website.webProducts.rpc.jaxws.IJaxWs;
import com.xh.learn.website.webProducts.usr.entity.Usr;
import com.xh.learn.website.webProducts.usr.mapper.UsrMapper;

@Service
@WebService(serviceName = "usrService")
public class IJaxWsUsrService implements IJaxWs {

	@Autowired
	UsrMapper usrMapper;

	public String queryUsrs() {
		List<Usr> usrs = usrMapper.selectAll();
		return JSON.toJSONString(usrs);
	}

}
