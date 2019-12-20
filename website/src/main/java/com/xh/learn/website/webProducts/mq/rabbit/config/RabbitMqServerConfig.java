package com.xh.learn.website.webProducts.mq.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqServerConfig {

	/**
	 * 连接工厂
	 * 
	 * @return
	 */
	@Bean
	public CachingConnectionFactory cachingConnectionFactory() {
		CachingConnectionFactory factory = new CachingConnectionFactory();
		factory.setAddresses("127.0.0.1:5672");
		factory.setUsername("guest");
		factory.setPassword("guest");
		return factory;
	}

	/**
	 * EXCHANGE
	 * 
	 * @return
	 */
	@Bean
	public DirectExchange exchange() {
		return new DirectExchange("DEFAULT_EXCHANGE");
	}

	/**
	 * 队列
	 * 
	 * @return
	 */
	@Bean
	public Queue queue() {
		return new Queue("DEFAULT_RABBITMQ_QUEUE", true);
	}

	/**
	 * BINDING
	 * 
	 * @return
	 */
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with("DEFAULT_ROUTING_KEY");
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(cachingConnectionFactory());
		template.setExchange("DEFAULT_EXCHANGE");
		return template;
	}

}
