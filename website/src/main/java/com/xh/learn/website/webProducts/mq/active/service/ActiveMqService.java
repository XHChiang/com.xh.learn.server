package com.xh.learn.website.webProducts.mq.active.service;

public interface ActiveMqService {
	public String receiveFromTopic();

	public String receiveFromQueue();

	public void sendToTopic(String message);

	public void sendToQueue(String message);
}
