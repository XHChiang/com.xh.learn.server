package com.xh.learn.website.webProducts.jmx.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;

@Configuration
@EnableMBeanExport(registration=RegistrationPolicy.FAIL_ON_EXISTING)
public class JMXConfig {
	/**
	 * 启用RMI注册表
	 * 
	 * @param rmiPort
	 * @return
	 */
	@Bean
	public RmiRegistryFactoryBean rmiRegistryFactoryBean(@Value("${bs.port.rmi}") int rmiPort) {
		RmiRegistryFactoryBean rmiRegistryFactoryBean = new RmiRegistryFactoryBean();
		rmiRegistryFactoryBean.setPort(rmiPort);
		return rmiRegistryFactoryBean;
	}

	/**
	 * 暴露远程Bean：BS-SUPER
	 * 
	 * @param rmiPort
	 * @return
	 */
	@Bean
	public ConnectorServerFactoryBean connectorServerFactoryBean(@Value("${bs.host.local}") String localhost, @Value("${bs.port.rmi}") int rmiPort) {
		String urlformat = "service:jmx:rmi://127.0.0.1/jndi/rmi://127.0.0.1:%s/%s";
		String serviceurl = String.format(urlformat, rmiPort, "BS-SUPER");

		ConnectorServerFactoryBean csfb = new ConnectorServerFactoryBean();
		csfb.setServiceUrl(serviceurl);
		return csfb;
	}
	
}
