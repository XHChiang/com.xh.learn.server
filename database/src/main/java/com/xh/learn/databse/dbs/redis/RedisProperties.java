package com.xh.learn.databse.dbs.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.xh.learn.sdk.entity.Entity;

@Component
@ConfigurationProperties(prefix = "db.redis")
public class RedisProperties extends Entity {
	private String nodes;
	private int maxRedirects;

	public String getNodes() {
		return nodes;
	}

	public void setNodes(String nodes) {
		this.nodes = nodes;
	}

	public int getMaxRedirects() {
		return maxRedirects;
	}

	public void setMaxRedirects(int maxRedirects) {
		this.maxRedirects = maxRedirects;
	}

}
