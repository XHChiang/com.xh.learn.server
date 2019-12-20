package com.xh.learn.databse.dbs.mysql;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.xh.learn.databse.properties.DatabaseProperties;

@Configuration
public class Database {
	@Value("${db.mysql.bs.url}")
	String dbUrl;

	@Value("${db.mysql.bs.driver}")
	String dbDriver;

	@Value("${db.mysql.bs.username}")
	String dbUsername;

	@Value("${db.mysql.bs.password}")
	String dbPassword;

	@Bean(name = "bs_dataSource")
	public DataSource dataSource(DatabaseProperties databaseProperties) {
		DruidDataSource druidDataSource = new DruidDataSource();
		// 基本属性 user、password、driverclass、url
		druidDataSource.setUrl(dbUrl);
		druidDataSource.setUsername(dbUsername);
		druidDataSource.setPassword(dbPassword);
		druidDataSource.setDriverClassName(dbDriver);

		druidDataSource.setMaxActive(databaseProperties.getMaxActive());// 最大连接数
		druidDataSource.setInitialSize(databaseProperties.getInitialSize());// 初始化大小
		druidDataSource.setMinIdle(databaseProperties.getMinIdle());// 最小连接数
		druidDataSource.setMaxWait(databaseProperties.getMaxWait());// 配置获取连接等待超时的时间
		druidDataSource.setTimeBetweenEvictionRunsMillis(databaseProperties.getTimeBetweenEvictionRunsMillis());// 多久才进行一次检测，检测需要关闭的空闲连接

		druidDataSource.setRemoveAbandoned(databaseProperties.getRemoveAbandoned());// 超过时间限制是否回收
		druidDataSource.setRemoveAbandonedTimeout(databaseProperties.getRemoveAbandonedTimeout());// 超过时间限制多长
		druidDataSource.setMinEvictableIdleTimeMillis(databaseProperties.getMinEvictableIdleTimeMillis());// 连接在池中最小生存的时间，单位是毫秒

		// 用于测试
		druidDataSource.setValidationQuery(databaseProperties.getValidationQuery());// 用来检测连接是否有效的sql，sql自定义
		druidDataSource.setTestOnBorrow(databaseProperties.getTestOnBorrow());// 申请连接时执行validationQuery检测连接是否有效，配置为true会降低性能
		druidDataSource.setTestOnReturn(databaseProperties.getTestOnReturn());// 归还连接时执行validationQuery检测连接是否有效，配置为true会降低性能

		return druidDataSource;
	}

}
