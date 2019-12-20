package com.xh.learn.website.webProducts.rpc.jaxws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class JaxWsExportConfig {

	/**
	 * JAX_WS
	 * 
	 * @return
	 */
	@Bean
	public SimpleJaxWsServiceExporter simpleJaxWsServiceExporter() {
		SimpleJaxWsServiceExporter sJaxWsServiceExporter = new SimpleJaxWsServiceExporter();
		return sJaxWsServiceExporter;
	}
}
