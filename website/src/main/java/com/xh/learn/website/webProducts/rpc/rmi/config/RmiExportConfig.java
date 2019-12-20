package com.xh.learn.website.webProducts.rpc.rmi.config;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.xh.learn.website.webProducts.rpc.rmi.service.IRmiServiceA;
import com.xh.learn.website.webProducts.rpc.rmi.service.IRmiServiceB;

@Configuration
public class RmiExportConfig {

	@Autowired
	IRmiServiceA iRmiServiceA;

	@Autowired
	IRmiServiceB iRmiServiceB;

	/**
	 * RMI
	 * 
	 * @return
	 * @throws RemoteException
	 */
	@Bean
	public RmiServiceExporter service1(@Value("${bs.port.rmi}") int rmiPort) throws RemoteException {
		RmiServiceExporter rmiExporter = new RmiServiceExporter();

		rmiExporter.setServiceInterface(IRmiServiceA.class);
		rmiExporter.setService(iRmiServiceA);

		rmiExporter.setRegistryPort(rmiPort);// rmi://host:PORT/name
		rmiExporter.setServiceName("irmiservicea");// rmi://host:port/NAME

		return rmiExporter;
	}

	@Bean
	public RmiServiceExporter service2(@Value("${bs.port.rmi}") int rmiPort) throws RemoteException {
		RmiServiceExporter rmiExporter = new RmiServiceExporter();

		rmiExporter.setServiceInterface(IRmiServiceB.class);
		rmiExporter.setService(iRmiServiceB);

		rmiExporter.setRegistryPort(rmiPort);// rmi://host:PORT/name
		rmiExporter.setServiceName("irmiserviceb");// rmi://host:port/NAME

		return rmiExporter;
	}
}
