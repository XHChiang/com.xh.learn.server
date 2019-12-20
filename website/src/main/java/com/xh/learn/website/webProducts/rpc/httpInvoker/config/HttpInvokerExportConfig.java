package com.xh.learn.website.webProducts.rpc.httpInvoker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import com.xh.learn.website.webProducts.rpc.httpInvoker.service.IHttpInvokerUsrService;

@Configuration
public class HttpInvokerExportConfig {

	/**
	 * HttpInvoker
	 * 
	 * @return
	 */
	@Bean(name = "/http-invoker/usrservice")
	public HttpInvokerServiceExporter httpInvokerExporter(IHttpInvokerUsrService iHttpInvokerUsrService) {
		HttpInvokerServiceExporter httpInvokerExporter = new HttpInvokerServiceExporter();
		httpInvokerExporter.setServiceInterface(IHttpInvokerUsrService.class);
		httpInvokerExporter.setService(iHttpInvokerUsrService);
		return httpInvokerExporter;
	}

}
