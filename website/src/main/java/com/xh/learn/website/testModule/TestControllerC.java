package com.xh.learn.website.testModule;

import java.net.URI;
import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import com.xh.learn.website.webProducts.usr.service.UsrService;

@Controller
@RequestMapping("/test-c")
public class TestControllerC {

	@Autowired
	UsrService usrService;

	@GetMapping("/v1")
	public ResponseEntity<String> v1() throws RemoteException {
		String usrs = usrService.queryUsrs();
		ResponseEntity<String> re = new ResponseEntity<String>(usrs, HttpStatus.OK);

		return re;
	}

	@ResponseBody
	@GetMapping("/v2")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String v2() throws RemoteException {
		String usrs = usrService.queryUsrs();
		return usrs;
	}

	@GetMapping("/v3")
	public ResponseEntity<String> v3() throws RemoteException {
		String usrs = usrService.queryUsrs();

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("url", "http://127.0.0.1/test-c/v3");

		ResponseEntity<String> re = new ResponseEntity<String>(usrs, httpHeaders, HttpStatus.OK);

		return re;
	}

	@GetMapping("/v4")
	public ResponseEntity<String> v4(UriComponentsBuilder ucb) throws RemoteException {
		String usrs = usrService.queryUsrs();

		URI uri = ucb.path("/test-c").path("/v4/ok").build().toUri();

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(uri);

		ResponseEntity<String> re = new ResponseEntity<String>(usrs, httpHeaders, HttpStatus.OK);

		return re;
	}
}
