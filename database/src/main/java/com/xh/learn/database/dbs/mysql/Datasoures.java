package com.xh.learn.database.dbs.mysql;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.xh.learn.database.properties.DatabaseProperties;

@Configuration
public class Datasoures {
	@Value("${db.mysql.learn.url}")
	String learnDbUrl;

	@Value("${db.mysql.learn.driver}")
	String learnDbDriver;

	@Value("${db.mysql.learn.username}")
	String learnDbUsername;

	@Value("${db.mysql.learn.password}")
	String learnDbPassword;

	@Bean(name = "learn-dataSource")
	public DataSource dataSource(DatabaseProperties databaseProperties) {
		DruidDataSource druidDataSource = new DruidDataSource();
		// 数据库URL
		druidDataSource.setUrl(learnDbUrl);
		// 用户名
		druidDataSource.setUsername(learnDbUsername);
		// 密码
		druidDataSource.setPassword(learnDbPassword);
		// 驱动
		druidDataSource.setDriverClassName(learnDbDriver);

		// 最大连接数
		druidDataSource.setMaxActive(databaseProperties.getMaxActive());
		// 初始化大小
		druidDataSource.setInitialSize(databaseProperties.getInitialSize());
		// 最小连接数
		druidDataSource.setMinIdle(databaseProperties.getMinIdle());
		// 配置获取连接等待超时的时间
		druidDataSource.setMaxWait(databaseProperties.getMaxWait());
		// 多久才进行一次检测，检测需要关闭的空闲连接
		druidDataSource.setTimeBetweenEvictionRunsMillis(databaseProperties.getTimeBetweenEvictionRunsMillis());

		// 超过时间限制是否回收
		druidDataSource.setRemoveAbandoned(databaseProperties.getRemoveAbandoned());
		// 超过时间限制多长
		druidDataSource.setRemoveAbandonedTimeout(databaseProperties.getRemoveAbandonedTimeout());
		// 连接在池中最小生存的时间，单位是毫秒
		druidDataSource.setMinEvictableIdleTimeMillis(databaseProperties.getMinEvictableIdleTimeMillis());

		/*
		用于测试
		 */
		// 用来检测连接是否有效的sql，sql自定义
		druidDataSource.setValidationQuery(databaseProperties.getValidationQuery());
		// 申请连接时执行validationQuery检测连接是否有效，配置为true会降低性能
		druidDataSource.setTestOnBorrow(databaseProperties.getTestOnBorrow());
		// 归还连接时执行validationQuery检测连接是否有效，配置为true会降低性能
		druidDataSource.setTestOnReturn(databaseProperties.getTestOnReturn());

		return druidDataSource;
	}
}
