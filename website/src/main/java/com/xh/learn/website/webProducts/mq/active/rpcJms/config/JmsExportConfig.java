package com.xh.learn.website.webProducts.mq.active.rpcJms.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.jms.remoting.JmsInvokerServiceExporter;

import com.xh.learn.website.webProducts.mq.active.rpcJms.service.DemoJmsService;

@Configuration
public class JmsExportConfig {

	@Autowired
	DemoJmsService demoJmsService;

	/**
	 * 服务导出器
	 * 
	 * @return
	 */
	@Bean
	public JmsInvokerServiceExporter jmsInvokerExporter() {
		JmsInvokerServiceExporter jmsInvokerExporter = new JmsInvokerServiceExporter();
		jmsInvokerExporter.setServiceInterface(DemoJmsService.class);
		jmsInvokerExporter.setService(demoJmsService);
		return jmsInvokerExporter;
	}

	/**
	 * 基于消息的RPC
	 * 
	 * @param connectionFactory
	 * @param jmsInvokerExporter
	 * @return
	 */
	@Bean
	public SimpleMessageListenerContainer simpleMessageListenerContainer(ActiveMQConnectionFactory connectionFactory) {
		SimpleMessageListenerContainer dmlc = new SimpleMessageListenerContainer();
		dmlc.setDestination(new ActiveMQQueue("BS-RPC-QUEUE"));
		dmlc.setConnectionFactory(connectionFactory);
		// listener
		dmlc.setMessageListener(jmsInvokerExporter());
		return dmlc;
	}
}
