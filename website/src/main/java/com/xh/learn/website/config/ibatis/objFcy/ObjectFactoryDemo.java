package com.xh.learn.website.config.ibatis.objFcy;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class ObjectFactoryDemo extends DefaultObjectFactory {
	private static Logger logger = LoggerFactory.getLogger(ObjectFactoryDemo.class);
	
	private Properties properties;

	@Override
	public <T> T create(Class<T> type) {
		logger.info("OBJECT-FACTORY-PROPERTIES:{}", properties);
		return super.create(type);
	}

	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		return super.create(type, constructorArgTypes, constructorArgs);
	}

	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
		this.properties = properties;
	}

}
