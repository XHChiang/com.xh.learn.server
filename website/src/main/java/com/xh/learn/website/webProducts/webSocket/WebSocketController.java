package com.xh.learn.website.webProducts.webSocket;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/websocket")
public class WebSocketController {

	@GetMapping("/index")
	public String index(Model model) {
		return "webSkt/index";
	}
}
