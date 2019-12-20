package com.xh.learn.website.webProducts.rpc.jaxws.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xh.learn.website.webProducts.log.entity.BsLog;
import com.xh.learn.website.webProducts.log.mapper.LogMapper;
import com.xh.learn.website.webProducts.rpc.jaxws.IJaxWs;

@Service
@WebService(serviceName = "logService")
public class IJaxWsLogService implements IJaxWs {

	@Autowired
	LogMapper logMapper;

	public String queryLogs() {
		List<BsLog> logs = logMapper.selectAll();
		return JSON.toJSONString(logs);
	}

}
