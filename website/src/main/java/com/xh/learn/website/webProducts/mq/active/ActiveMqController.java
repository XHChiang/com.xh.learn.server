package com.xh.learn.website.webProducts.mq.active;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xh.learn.website.webProducts.mq.active.service.ActiveMqService;

@Controller
@RequestMapping("/mq/active")
public class ActiveMqController {
	@Autowired
	ActiveMqService mqService;

	@GetMapping("/receive/topic/v1")
	public ResponseEntity<?> receiveFromTopic() {
		ResponseEntity<String> re;
		try {
			String rcv = mqService.receiveFromTopic();
			re = new ResponseEntity<>(rcv, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return re;
	}

	@GetMapping("/receive/queue/v1")
	public ResponseEntity<?> receiveFromQueue() {
		ResponseEntity<String> re;
		try {
			String rcv = mqService.receiveFromQueue();
			re = new ResponseEntity<>(rcv, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return re;
	}

	@PostMapping("/send/topic/v1")
	public ResponseEntity<?> sendToTopic(String msg) {
		ResponseEntity<String> re;
		try {
			mqService.sendToTopic(msg);
		} catch (Exception e) {
			re = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		re = new ResponseEntity<>(HttpStatus.OK);
		return re;
	}

	@PostMapping("/send/queue/v1")
	public ResponseEntity<?> sendToQueue(String msg) {
		ResponseEntity<String> re;
		try {
			mqService.sendToQueue(msg);
		} catch (Exception e) {
			re = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		re = new ResponseEntity<>(HttpStatus.OK);
		return re;
	}
}
