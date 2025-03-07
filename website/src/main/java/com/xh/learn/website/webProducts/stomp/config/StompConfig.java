package com.xh.learn.website.webProducts.stomp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer {

	/**
	 * 将 "/stomp" 注册为一个 STOMP 端点。这个路径与之前发送和接收消息的目的地路径有所 不同。这是一个端点，客户端在订阅或发布消息到目的地路径前，要连接到该端点。
	 *
	 * @param registry
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/stomp").withSockJS();
	}

	/**
	 * 如果不重载它的话，将会自动配置一个简单的内存消息代理，用它来处理以"/topic"为前缀的消息
	 *
	 * @param registry
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//基于内存的STOMP消息代理
		registry.enableSimpleBroker("/queue", "/topic");

		//基于RabbitMQ 的STOMP消息代理
		/*registry.enableStompBrokerRelay("/queue", "/topic")
				.setRelayHost(host)
				.setRelayPort(port)
				.setClientLogin(userName)
				.setClientPasscode(password);*/

		registry.setApplicationDestinationPrefixes("/app");
		registry.setUserDestinationPrefix("/user");
	}
}