package com.xh.learn.databse.dbs.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.xh.learn.databse.properties.DatabaseProperties;

@Configuration
public class RedisConfig {
	@Autowired
	DatabaseProperties databaseProperties;

	@Autowired
	RedisProperties redisProperties;

//	@Bean
//	public JedisPoolConfig jedisPoolConfig() {
//		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//		jedisPoolConfig.setMinIdle(dbProperties.getMinIdle());
//		jedisPoolConfig.setMaxIdle(dbProperties.getMaxIdle());
//		jedisPoolConfig.setMaxTotal(dbProperties.getMaxTotal());
//		jedisPoolConfig.setMaxWaitMillis(dbProperties.getMaxWaitMillis());
//		jedisPoolConfig.setNumTestsPerEvictionRun(dbProperties.getNumTestsPerEvictionRun());
//		jedisPoolConfig.setMinEvictableIdleTimeMillis(dbProperties.getMinEvictableIdleTimeMillis());
//		jedisPoolConfig.setTimeBetweenEvictionRunsMillis(dbProperties.getTimeBetweenEvictionRunsMillis());
//
//		jedisPoolConfig.setTestOnReturn(dbProperties.getTestOnReturn());
//		jedisPoolConfig.setTestOnBorrow(dbProperties.getTestOnBorrow());
//		jedisPoolConfig.setTestWhileIdle(dbProperties.getTestWhileIdle());
//		jedisPoolConfig.setBlockWhenExhausted(dbProperties.getBlockWhenExhausted());
//
//		return jedisPoolConfig;
//	}
//
//	@Bean
//	public RedisClusterConfiguration redisClusterConfiguration() {
//		Map<String, Object> config = new HashMap<String, Object>();
//		config.put("spring.redis.cluster.nodes", redisProperties.getNodes().trim());
//		config.put("spring.redis.cluster.max-redirects", redisProperties.getMaxRedirects());
//
//		MapPropertySource mapPropertySource = new MapPropertySource("RedisClusterConfiguration", config);
//		RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(mapPropertySource);
//		return redisClusterConfiguration;
//	}
//
//	@Bean
//	public RedisConnectionFactory redisConnectionFactory(RedisClusterConfiguration redisClusterConfiguration,
//			JedisPoolConfig jedisPoolConfig) {
//		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration);
//		jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
//		jedisConnectionFactory.afterPropertiesSet();
//		jedisConnectionFactory.setUsePool(true);
//		return jedisConnectionFactory;
//	}
//
//	@Bean
//	public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//		RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
//		template.setConnectionFactory(redisConnectionFactory);
//		template.setKeySerializer(new StringRedisSerializer());
//		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//
//		template.setEnableTransactionSupport(true);// 开启事务
//		template.afterPropertiesSet();
//		return template;
//	}
}
