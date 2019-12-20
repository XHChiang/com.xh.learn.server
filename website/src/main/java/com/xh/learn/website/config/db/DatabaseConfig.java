package com.xh.learn.website.config.db;

import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.xh.learn.sdk.util.ResourceUtil;

import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = { "com.xh.learn.website.webProducts.log.mapper", "com.xh.learn.website.webProducts.usr.mapper" })
public class DatabaseConfig {

	@Bean(name = "bs_sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("bs_dataSource") DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

		sqlSessionFactory.setMapperLocations(ResourceUtil.getResource("mapper", "bs/*.xml"));
		sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-conf.xml"));
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setFailFast(true);

		return sqlSessionFactory.getObject();
	}

	@Bean(name = "bs_sqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("bs_sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory, ExecutorType.SIMPLE);
		return sqlSessionTemplate;
	}

	@Bean(name = "bs_transactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("bs_dataSource") DataSource dataSource) {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource);
		return dataSourceTransactionManager;
	}

}
