package com.xh.learn.website.webProducts.webSocket.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Component
public class MacroHandler extends AbstractWebSocketHandler {

	private static Logger logger = LoggerFactory.getLogger(MacroHandler.class);

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("received message: {}", message);

		Thread.sleep(2000);

		session.sendMessage(new TextMessage("Polo!"));
	}

}
