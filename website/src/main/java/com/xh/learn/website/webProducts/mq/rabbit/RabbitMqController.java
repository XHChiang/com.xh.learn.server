package com.xh.learn.website.webProducts.mq.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xh.learn.website.webProducts.mq.rabbit.service.RabbitMqService;

@Controller
@RequestMapping("/mq/rabbit")
public class RabbitMqController {
	@Autowired
	RabbitMqService rabbitService;

	@PostMapping("/send/v1")
	public ResponseEntity<?> sendMessageV1(String msg) {
		ResponseEntity<String> re;
		try {
			rabbitService.send(msg);
		} catch (Exception e) {
			re = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		re = new ResponseEntity<>(HttpStatus.OK);
		return re;
	}

	@GetMapping("/receive/v1")
	public ResponseEntity<?> receiveMessageV1() {
		ResponseEntity<String> re;
		try {
			String rcv = rabbitService.receive();
			re = new ResponseEntity<>(rcv, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return re;
	}
}
