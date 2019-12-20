package com.xh.learn.website.webProducts.mq.active.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ActiveMqServerConfig {

	/**
	 * 连接工厂
	 * 
	 * @return
	 */
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
//		activeMQConnectionFactory.setBrokerURL("http://localhost:61616");
		activeMQConnectionFactory.setTrustAllPackages(true);
		return activeMQConnectionFactory;
	}

	/**
	 * 发布订阅- 目的地：主题
	 * 
	 * @return
	 */
	@Bean
	public ActiveMQTopic activeMQTopic() {
		ActiveMQTopic activeMQTopic = new ActiveMQTopic();
		activeMQTopic.setPhysicalName("BS-MQ-TOPIC");
		return activeMQTopic;
	}

	/**
	 * JMS Template
	 * 
	 * @param connectionFactory
	 * @return
	 */
	@Bean("activeMQTopicTemplate")
	public JmsTemplate activeMQTopicTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate(activeMQConnectionFactory());
		jmsTemplate.setDefaultDestination(activeMQTopic());
		return jmsTemplate;
	}

	/**
	 * 点对点-目的地：消息队列
	 * 
	 * @return
	 */
	@Bean
	public ActiveMQQueue activeMQQueue() {
		ActiveMQQueue activeMQQueue = new ActiveMQQueue();
		activeMQQueue.setPhysicalName("BS-MQ-QUEUE");
		return activeMQQueue;
	}

	/**
	 * JMS Template
	 * 
	 * @param connectionFactory
	 * @return
	 */
	@Bean("activeMQQueueTemplate")
	public JmsTemplate activeMQQueueTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate(activeMQConnectionFactory());
		jmsTemplate.setDefaultDestination(activeMQQueue());
		return jmsTemplate;
	}

}
