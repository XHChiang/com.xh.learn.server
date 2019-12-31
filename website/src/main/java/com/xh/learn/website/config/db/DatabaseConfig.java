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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = { "com.xh.learn.website.webProducts.log.mapper", "com.xh.learn.website.webProducts.usr.mapper" })
public class DatabaseConfig {

	@Bean(name = "bs_sqlSessionFactory")
	public SqlSessionFactory initSqlSessionFactory(@Qualifier("bs_dataSource") DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

		sqlSessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:mappers/**/*.xml"));
		sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-conf.xml"));
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setFailFast(true);

		return sqlSessionFactory.getObject();
	}

	@Bean(name = "bs_sqlSessionTemplate")
	public SqlSessionTemplate initSqlSessionTemplate(@Qualifier("bs_sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.SIMPLE);
	}

	@Bean(name = "bs_transactionManager")
	public PlatformTransactionManager initDataTransactionManager(@Qualifier("bs_dataSource") DataSource dataSource) {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource);
		return dataSourceTransactionManager;
	}

}
