package com.xh.learn.website.webProducts.mq.rabbit.service;

public interface RabbitMqService {
	public String receive();

	public void send(String msg);

}
