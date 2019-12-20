package com.xh.learn.website.webProducts.mq.rabbit.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xh.learn.website.webProducts.mq.rabbit.service.RabbitMqService;

@Service
public class RabbitMqServiceImpl implements RabbitMqService {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Override
	public String receive() {
		Object message = rabbitTemplate.receiveAndConvert("DEFAULT_RABBITMQ_QUEUE");
		return JSON.toJSONString(message);
	}

	@Override
	public void send(String msg) {
		rabbitTemplate.convertAndSend("DEFAULT_EXCHANGE", "DEFAULT_ROUTING_KEY", msg);
	}

}
