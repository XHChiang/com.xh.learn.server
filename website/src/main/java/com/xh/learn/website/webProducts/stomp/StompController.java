package com.xh.learn.website.webProducts.stomp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xh.learn.website.webProducts.stomp.bean.Shout;

@Controller
public class StompController {

	@RequestMapping("/stomp/index")
	public String send(Model model) {
		return "stomp/index";
	}

	/*---------------------------------------------------------------------------------------*/

	@MessageMapping("/marco")
	@SendTo("/topic/marco")
	public Shout stompHandle(Shout shout) {
		System.out.println("接收到消息：" + shout.getMessage());
		Shout s = new Shout();
		s.setMessage("Polo!");
		return s;
	}

	@SubscribeMapping("/getShout")
	public Shout getShout() {
		Shout shout = new Shout();
		shout.setMessage("Hello STOMP");
		return shout;
	}

	/*---------------------------------------------------------------------------------------*/

	@Autowired
	private SimpMessageSendingOperations simpMessageSendingOperations;

	/**
	 * 广播消息，不指定用户，所有订阅此的用户都能收到消息
	 * 
	 * @param shout
	 */
	@MessageMapping("/broadcastShout")
	public void broadcast(Shout shout) {
		simpMessageSendingOperations.convertAndSend("/topic/shouts", shout);
	}

	/*---------------------------------------------------------------------------------------*/

	@MessageExceptionHandler(Exception.class)
	@SendToUser("/queue/errors")
	public Exception handleExceptions(Exception t) {
		t.printStackTrace();
		return t;
	}
}
