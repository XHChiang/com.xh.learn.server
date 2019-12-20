package com.xh.learn.website.webProducts.mq.active.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Service;

import com.xh.learn.website.webProducts.mq.active.service.ActiveMqService;

@Service
public class ActiveMqServiceImpl implements ActiveMqService {

	@Autowired
	@Qualifier("activeMQTopicTemplate")
	JmsOperations activeMQTopicTemplate;

	@Autowired
	@Qualifier("activeMQQueueTemplate")
	JmsOperations activeMQQueueTemplate;

	@Override
	public String receiveFromTopic() {
		String rcv = null;

		Message message = activeMQTopicTemplate.receive();
		ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
		try {
			rcv = textMessage.getText();
		} catch (JMSException e) {
			JmsUtils.convertJmsAccessException(e);
		}

		return rcv;
	}

	@Override
	public String receiveFromQueue() {
		String rcv = null;

		Message message = activeMQQueueTemplate.receive();
		ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
		try {
			rcv = textMessage.getText();
		} catch (JMSException e) {
			JmsUtils.convertJmsAccessException(e);
		}

		return rcv;
	}

	@Override
	public void sendToTopic(String message) {
		activeMQTopicTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message textMessage = session.createTextMessage(message);
				return textMessage;
			}
		});
	}

	@Override
	public void sendToQueue(String message) {
		activeMQQueueTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message textMessage = session.createTextMessage(message);
				return textMessage;
			}
		});
	}

}
