package com.xh.learn.website.webProducts.rpc.hessian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

import com.xh.learn.website.webProducts.rpc.hessian.service.IHessianUsrService;

@Configuration
public class HessianExportConfig {

	/**
	 * HESSIAN
	 * 
	 * @return
	 */
	@Bean("/hessian/usrservice")
	public HessianServiceExporter hessianExporterUsrService(IHessianUsrService iHessianUsrService) {
		HessianServiceExporter hessianExporter = new HessianServiceExporter();

		hessianExporter.setServiceInterface(IHessianUsrService.class);
		hessianExporter.setService(iHessianUsrService);

		return hessianExporter;
	}
}
